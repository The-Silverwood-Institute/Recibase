package se.reciba.api.server

import cats.effect.Async
import cats.syntax.all._
import org.http4s.{HttpRoutes, Request, Response, Status}
import org.http4s.dsl.Http4sDsl
import org.http4s.dsl.impl.OptionalQueryParamDecoderMatcher
import org.slf4j.LoggerFactory

import java.net.{CookieManager, CookiePolicy, URI}
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.nio.charset.StandardCharsets
import java.time.Duration
import scala.annotation.tailrec

object OptionalWebhookTokenQueryParamMatcher
    extends OptionalQueryParamDecoderMatcher[String]("k")

/** Temporary Telegram → Google Apps Script proxy. Telegram does not follow Apps
  * Script's 302s; this endpoint POSTs once (which runs doPost) then GETs the
  * redirect so Telegram sees 200.
  */
object WebhookRoutes {
  private val logger = LoggerFactory.getLogger(getClass)

  private val httpClient: HttpClient = {
    val cookies = new CookieManager()
    cookies.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
    HttpClient
      .newBuilder()
      .followRedirects(HttpClient.Redirect.NEVER)
      .cookieHandler(cookies)
      .connectTimeout(Duration.ofSeconds(15))
      .build()
  }

  def routes[F[_]: Async](
      expectedToken: Option[String] = sys.env
        .get("WEBHOOK_TOKEN")
        .filter(_.nonEmpty),
      forwardToUrl: Option[String] = sys.env
        .get("FORWARD_TO_URL")
        .filter(_.nonEmpty)
  ): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    HttpRoutes.of[F] {
      case req @ POST -> Root / "hooks" :? OptionalWebhookTokenQueryParamMatcher(
            maybeToken
          ) =>
        (expectedToken, forwardToUrl, maybeToken) match {
          case (Some(expected), Some(forwardTo), Some(got))
              if expected == got =>
            forward[F](req, forwardTo).handleErrorWith { err =>
              InternalServerError(err.getMessage)
            }
          case (None, _, _) | (_, None, _) =>
            ServiceUnavailable("webhook proxy not configured")
          case _ =>
            Response[F](Status.Unauthorized)
              .withEntity("invalid token")
              .pure[F]
        }
    }
  }

  private def forward[F[_]: Async](
      req: Request[F],
      forwardTo: String
  ): F[Response[F]] =
    req.body.compile.toList.flatMap { bytes =>
      Async[F].blocking {
        val upstream = postThenFollowGets(forwardTo, bytes.toArray)
        if (upstream.statusCode() < 200 || upstream.statusCode() >= 300) {
          val snippet =
            new String(upstream.body(), StandardCharsets.UTF_8).take(500)
          logger.warn(
            s"webhook upstream ${upstream.statusCode()} ${upstream.uri()} $snippet"
          )
        }
        val status = Status
          .fromInt(upstream.statusCode())
          .getOrElse(Status.BadGateway)
        Response[F](status).withEntity(upstream.body())
      }
    }

  // GAS /exec runs doPost on the first POST, then 302s to googleusercontent
  // which only accepts GET. Re-POSTing the Telegram body there returns 400.
  private def postThenFollowGets(
      url: String,
      body: Array[Byte]
  ): HttpResponse[Array[Byte]] = {
    @tailrec
    def go(
        url: String,
        body: Option[Array[Byte]],
        remaining: Int
    ): HttpResponse[Array[Byte]] = {
      val builder =
        HttpRequest.newBuilder(URI.create(url)).timeout(Duration.ofSeconds(60))
      val request = body match {
        case Some(bytes) =>
          builder
            .header("Content-Type", "text/plain;charset=utf-8")
            .POST(HttpRequest.BodyPublishers.ofByteArray(bytes))
            .build()
        case None =>
          builder.GET().build()
      }
      val response =
        httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray())
      val redirected = response.statusCode() >= 300 && response
        .statusCode() < 400 && remaining > 0
      if (redirected) {
        val location = response.headers().firstValue("location")
        if (location.isPresent)
          go(
            URI.create(url).resolve(location.get()).toString,
            None,
            remaining - 1
          )
        else response
      } else response
    }
    go(url, Some(body), 10)
  }
}
