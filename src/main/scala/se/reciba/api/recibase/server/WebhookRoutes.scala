package se.reciba.api.server

import cats.effect.Async
import cats.syntax.all._
import org.http4s.{HttpRoutes, Request, Response, Status}
import org.http4s.dsl.Http4sDsl
import org.http4s.dsl.impl.OptionalQueryParamDecoderMatcher

import java.net.{CookieManager, CookiePolicy, URI}
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.time.Duration
import scala.annotation.tailrec

object OptionalWebhookTokenQueryParamMatcher
    extends OptionalQueryParamDecoderMatcher[String]("k")

/** Temporary Telegram → Google Apps Script proxy. Telegram does not follow Apps
  * Script's 302s as POST; this endpoint does.
  */
object WebhookRoutes {
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
        val contentType = req.contentType
          .map(_.mediaType.toString)
          .getOrElse("application/json")
        val upstream =
          postFollowingRedirects(forwardTo, bytes.toArray, contentType)
        val status = Status
          .fromInt(upstream.statusCode())
          .getOrElse(Status.BadGateway)
        Response[F](status).withEntity(upstream.body())
      }
    }

  private def postFollowingRedirects(
      url: String,
      body: Array[Byte],
      contentType: String
  ): HttpResponse[Array[Byte]] = {
    @tailrec
    def go(url: String, remaining: Int): HttpResponse[Array[Byte]] = {
      val request = HttpRequest
        .newBuilder(URI.create(url))
        .timeout(Duration.ofSeconds(60))
        .header("Content-Type", contentType)
        .POST(HttpRequest.BodyPublishers.ofByteArray(body))
        .build()
      val response =
        httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray())
      val redirected = response.statusCode() >= 300 && response
        .statusCode() < 400 && remaining > 0
      if (redirected) {
        val location = response.headers().firstValue("location")
        if (location.isPresent)
          go(URI.create(url).resolve(location.get()).toString, remaining - 1)
        else response
      } else response
    }
    go(url, 10)
  }
}
