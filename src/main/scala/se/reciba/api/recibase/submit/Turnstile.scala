package se.reciba.api.submit

import cats.effect.Async
import io.circe.Json
import io.circe.jawn
import org.slf4j.LoggerFactory

import java.net.URI
import java.net.URLEncoder
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.nio.charset.StandardCharsets
import java.time.Duration
import scala.util.control.NonFatal

case class TurnstileSettings(secret: String, hostnames: Set[String])

trait Turnstile[F[_]] {
  def allow(token: String): F[Boolean]
}

object Turnstile {
  val ExpectedAction = "contribute"
  val SiteverifyUrl =
    "https://challenges.cloudflare.com/turnstile/v0/siteverify"

  def accepted(
      body: Json,
      hostnames: Set[String]
  ): Boolean = {
    val cursor = body.hcursor
    cursor.get[Boolean]("success").toOption.contains(true) &&
    cursor.get[String]("action").toOption.contains(ExpectedAction) &&
    cursor.get[String]("hostname").toOption.exists(hostnames.contains)
  }

  def tokenAccepted(token: String, hostnames: Set[String]): Boolean =
    token.nonEmpty && token.length <= 2048 && hostnames.nonEmpty
}

class CloudflareTurnstile[F[_]: Async](settings: TurnstileSettings)
    extends Turnstile[F] {
  private val logger = LoggerFactory.getLogger(getClass)

  def allow(token: String): F[Boolean] =
    Async[F].blocking {
      if (!Turnstile.tokenAccepted(token, settings.hostnames)) false
      else {
        val http = HttpClient
          .newBuilder()
          .followRedirects(HttpClient.Redirect.NEVER)
          .connectTimeout(Duration.ofSeconds(10))
          .build()
        try verify(http, token)
        catch {
          case NonFatal(error) =>
            logger.warn(
              s"turnstile siteverify failed: ${error.getClass.getSimpleName}"
            )
            false
        } finally
          try http.close()
          catch { case NonFatal(_) => () }
      }
    }

  private def verify(
      http: HttpClient,
      token: String
  ): Boolean = {
    val body = formBody(token)
    val request = HttpRequest
      .newBuilder(URI.create(Turnstile.SiteverifyUrl))
      .timeout(Duration.ofSeconds(10))
      .header("Content-Type", "application/x-www-form-urlencoded")
      .POST(HttpRequest.BodyPublishers.ofString(body))
      .build()
    val response =
      http.send(
        request,
        HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
      )
    if (response.statusCode() != 200) false
    else
      jawn.parse(response.body()).toOption match {
        case Some(json) => Turnstile.accepted(json, settings.hostnames)
        case None       => false
      }
  }

  private def formBody(token: String): String = {
    val fields = List(
      "secret" -> settings.secret,
      "response" -> token
    )
    fields
      .map { case (key, value) =>
        URLEncoder.encode(key, StandardCharsets.UTF_8) + "=" +
          URLEncoder.encode(value, StandardCharsets.UTF_8)
      }
      .mkString("&")
  }
}
