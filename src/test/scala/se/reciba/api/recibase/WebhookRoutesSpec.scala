package se.reciba.api

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.http4s._
import org.http4s.implicits._
import se.reciba.api.server.WebhookRoutes

class WebhookRoutesSpec extends org.specs2.mutable.Specification {
  "unconfigured proxy" >> {
    "returns 503" >> {
      postHooks("secret").status must beEqualTo(Status.ServiceUnavailable)
    }
  }

  "configured proxy" >> {
    "rejects a missing token" >> {
      postHooksConfigured(uri"/hooks").status must beEqualTo(
        Status.Unauthorized
      )
    }

    "rejects a wrong token" >> {
      postHooksConfigured(uri"/hooks?k=nope").status must beEqualTo(
        Status.Unauthorized
      )
    }
  }

  private def postHooks(token: String): Response[IO] = {
    val request = Request[IO](Method.POST, Uri.unsafeFromString(s"/hooks?k=$token"))
    WebhookRoutes
      .routes[IO](expectedToken = None, forwardToUrl = None)
      .orNotFound(request)
      .unsafeRunSync()
  }

  private def postHooksConfigured(uri: Uri): Response[IO] = {
    val request = Request[IO](Method.POST, uri).withEntity("{}")
    WebhookRoutes
      .routes[IO](
        expectedToken = Some("secret"),
        forwardToUrl = Some("https://example.invalid")
      )
      .orNotFound(request)
      .unsafeRunSync()
  }
}
