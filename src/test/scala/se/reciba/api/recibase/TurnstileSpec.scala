package se.reciba.api

import io.circe.jawn
import se.reciba.api.submit.Turnstile

class TurnstileSpec extends org.specs2.mutable.Specification {
  private val hostnames = Set("recipes.example")

  "siteverify acceptance" >> {
    "requires success, the contribute action, and an allowed hostname" >> {
      val body = jawn
        .parse(
          """{"success":true,"action":"contribute","hostname":"recipes.example"}"""
        )
        .toOption
        .get
      Turnstile.accepted(body, hostnames) must beTrue
    }

    "rejects a different action or hostname" >> {
      val wrongAction = jawn
        .parse(
          """{"success":true,"action":"login","hostname":"recipes.example"}"""
        )
        .toOption
        .get
      val wrongHost = jawn
        .parse(
          """{"success":true,"action":"contribute","hostname":"evil.example"}"""
        )
        .toOption
        .get
      Turnstile.accepted(wrongAction, hostnames) must beFalse
      Turnstile.accepted(wrongHost, hostnames) must beFalse
    }
  }

  "token shape" >> {
    "rejects an empty or oversized token and an empty hostname list" >> {
      Turnstile.tokenAccepted("", hostnames) must beFalse
      Turnstile.tokenAccepted("x" * 2049, hostnames) must beFalse
      Turnstile.tokenAccepted("token", Set.empty) must beFalse
      Turnstile.tokenAccepted("token", hostnames) must beTrue
    }
  }
}
