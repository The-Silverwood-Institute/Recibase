package se.reciba.api

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.circe.Json
import io.circe.jawn
import org.http4s._
import org.http4s.implicits._
import se.reciba.api.recipes.ChilliConCarne
import se.reciba.api.submit.{
  BranchAlreadyExists,
  GeneratedRecipe,
  GithubRejected,
  GithubSettings,
  PullRequestFailure,
  RecipePullRequests,
  RecipeSubmissionConfig,
  Turnstile,
  TurnstileSettings
}
import se.reciba.api.server.RecipeSubmissionRoutes

import java.time.LocalDate

class RecipeSubmissionRoutesSpec extends org.specs2.mutable.Specification {
  private val config = RecipeSubmissionConfig(
    "s3cret",
    GithubSettings("token", "The-Silverwood-Institute/Recibase", "master"),
    TurnstileSettings("turnstile-secret", Set("recipes.example"))
  )
  private val today = LocalDate.of(2026, 9, 7)

  "unconfigured submission" >> {
    "returns 503" >> {
      val response = post(
        RecipeSubmissionRoutes.routes[IO](
          config = None,
          existingRecipes = Seq.empty
        ),
        "{}"
      )
      response.status must beEqualTo(Status.ServiceUnavailable)
      errorOf(response) must beEqualTo("recipe submission not configured")
    }
  }

  "configured submission" >> {
    "rejects a missing passcode" >> {
      val client = recording(Right("https://github.com/example/pull/1"))
      val response = post(
        routes(client),
        """{"name":"Phone Test Soup","cf-turnstile-response":"token"}"""
      )
      response.status must beEqualTo(Status.Unauthorized)
      errorOf(response) must beEqualTo("invalid passcode")
      client.opened must beEmpty
    }

    "rejects a wrong passcode before checking the recipe" >> {
      val client = recording(Right("https://github.com/example/pull/1"))
      val response = post(
        routes(client, Seq(ChilliConCarne)),
        s"""{"passcode":"nope","cf-turnstile-response":"token","name":"${ChilliConCarne.name}"}"""
      )
      response.status must beEqualTo(Status.Unauthorized)
      client.opened must beEmpty
    }

    "rejects invalid json" >> {
      val response = post(routes(recording(Right(""))), "not json")
      response.status must beEqualTo(Status.BadRequest)
      errorOf(response) must beEqualTo("invalid json")
    }

    "rejects an empty name" >> {
      val response = post(routes(recording(Right(""))), recipeJson("  "))
      response.status must beEqualTo(Status.BadRequest)
      errorOf(response) must beEqualTo("Name is required")
    }

    "rejects a recipe that already exists" >> {
      val client = recording(Right("https://github.com/example/pull/1"))
      val response =
        post(
          routes(client, Seq(ChilliConCarne)),
          recipeJson(ChilliConCarne.name)
        )
      response.status must beEqualTo(Status.Conflict)
      errorOf(response) must beEqualTo(
        "A recipe named Chilli con Carne already exists"
      )
      client.opened must beEmpty
    }

    "opens a pull request and escapes the method" >> {
      val evil = "say \"" + "\\" + "u0022; evil"
      val client = recording(Right("https://github.com/example/pull/7"))
      val response = post(routes(client), recipeJson("Phone Test Soup", evil))
      response.status must beEqualTo(Status.Ok)
      jawn
        .parse(body(response))
        .toOption
        .get
        .hcursor
        .get[String]("url") must beRight(
        "https://github.com/example/pull/7"
      )
      client.opened.map(_.name) must beEqualTo(List("Phone Test Soup"))
      client.titles must beEqualTo(List("Add Phone Test Soup"))
      client.bodies must beEqualTo(List("Submitted from the contribute page."))
      val source = client.opened.head.source
      source must contain("LocalDate.of(2026, 9, 7)")
      source must contain(se.reciba.api.submit.ScalaLiteral.quote(evil))
      source must not contain "s3cret"
    }

    "reports an open submission" >> {
      val response =
        post(
          routes(recording(Left(BranchAlreadyExists))),
          recipeJson("Phone Test Soup")
        )
      response.status must beEqualTo(Status.Conflict)
      errorOf(response) must beEqualTo(
        "A submission for this recipe is already open"
      )
    }

    "reports a github failure" >> {
      val response = post(
        routes(recording(Left(GithubRejected("GitHub returned HTTP 401")))),
        recipeJson("Phone Test Soup")
      )
      response.status must beEqualTo(Status.BadGateway)
      errorOf(response) must beEqualTo("GitHub rejected the submission")
    }

    "rejects an oversized body" >> {
      val response = post(
        RecipeSubmissionRoutes.routes[IO](
          config = Some(config),
          pullRequests = Some(recording(Right(""))),
          existingRecipes = Seq.empty,
          clock = () => today,
          maxBytes = 32
        ),
        recipeJson("Phone Test Soup")
      )
      response.status must beEqualTo(Status.BadRequest)
      errorOf(response) must beEqualTo("submission is too large")
    }
  }

  "config" >> {
    "requires both secrets" >> {
      RecipeSubmissionConfig.from(None, Some("token"), None, None) must beNone
      RecipeSubmissionConfig.from(Some("secret"), None, None, None) must beNone
    }

    "defaults the repository and branch" >> {
      RecipeSubmissionConfig.from(
        Some("secret"),
        Some("token"),
        None,
        None,
        Some("turnstile-secret"),
        Some("recipes.example, www.example")
      ) must beSome(
        RecipeSubmissionConfig(
          "secret",
          GithubSettings(
            "token",
            "The-Silverwood-Institute/Recibase",
            "master"
          ),
          TurnstileSettings(
            "turnstile-secret",
            Set("recipes.example", "www.example")
          )
        )
      )
    }

    "rejects a repository override that is not owner/name" >> {
      RecipeSubmissionConfig.from(
        Some("secret"),
        Some("token"),
        Some("not a repo"),
        None,
        Some("turnstile-secret"),
        Some("recipes.example")
      ) must beNone
    }

    "requires a turnstile secret and hostname" >> {
      RecipeSubmissionConfig.from(
        Some("secret"),
        Some("token"),
        None,
        None,
        None,
        Some("recipes.example")
      ) must beNone
      RecipeSubmissionConfig.from(
        Some("secret"),
        Some("token"),
        None,
        None,
        Some("turnstile-secret"),
        Some("  ")
      ) must beNone
    }
  }

  "turnstile" >> {
    "rejects a missing token before the passcode" >> {
      val client = recording(Right("https://github.com/example/pull/1"))
      val response = post(routes(client), """{"passcode":"s3cret"}""")
      response.status must beEqualTo(Status.Forbidden)
      errorOf(response) must beEqualTo("forbidden")
      client.opened must beEmpty
    }

    "rejects a token siteverify does not accept" >> {
      val client = recording(Right("https://github.com/example/pull/1"))
      val response = post(
        routes(client, turnstile = deny),
        recipeJson("Phone Test Soup")
      )
      response.status must beEqualTo(Status.Forbidden)
      client.opened must beEmpty
    }
  }

  private def routes(
      client: RecipePullRequests[IO],
      existing: Seq[se.reciba.api.model.Recipe] = Seq.empty,
      turnstile: Turnstile[IO] = allow
  ): HttpRoutes[IO] =
    RecipeSubmissionRoutes.routes[IO](
      config = Some(config),
      pullRequests = Some(client),
      existingRecipes = existing,
      clock = () => today,
      turnstile = Some(turnstile)
    )

  private val allow: Turnstile[IO] = new Turnstile[IO] {
    def allow(token: String, remoteIp: String): IO[Boolean] = IO.pure(true)
  }

  private val deny: Turnstile[IO] = new Turnstile[IO] {
    def allow(token: String, remoteIp: String): IO[Boolean] = IO.pure(false)
  }

  private def post(routes: HttpRoutes[IO], payload: String): Response[IO] =
    routes
      .orNotFound(
        Request[IO](Method.POST, uri"/recipe-submissions").withEntity(payload)
      )
      .unsafeRunSync()

  private def body(response: Response[IO]): String =
    response.bodyText.compile.string.unsafeRunSync()

  private def errorOf(response: Response[IO]): String =
    jawn
      .parse(body(response))
      .toOption
      .get
      .hcursor
      .get[String]("error")
      .toOption
      .get

  private def recipeJson(name: String, method: String = "Simmer."): String =
    s"""{
      |  "passcode": "s3cret",
      |  "cf-turnstile-response": "token",
      |  "name": ${Json.fromString(name).noSpaces},
      |  "tags": [],
      |  "ingredients": [{"name": "Onion", "quantity": "1"}],
      |  "method": [${Json.fromString(method).noSpaces}]
      |}""".stripMargin

  private def recording(
      result: Either[PullRequestFailure, String]
  ): RecordingPullRequests =
    new RecordingPullRequests(result)

  private final class RecordingPullRequests(
      result: Either[PullRequestFailure, String]
  ) extends RecipePullRequests[IO] {
    var opened: List[GeneratedRecipe] = Nil
    var titles: List[String] = Nil
    var bodies: List[String] = Nil

    def open(
        recipe: GeneratedRecipe,
        commitMessage: String,
        pullTitle: String,
        pullBody: String
    ): IO[Either[PullRequestFailure, String]] =
      IO {
        opened = opened :+ recipe
        titles = titles :+ pullTitle
        bodies = bodies :+ pullBody
        result
      }
  }
}
