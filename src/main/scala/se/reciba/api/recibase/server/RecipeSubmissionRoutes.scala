package se.reciba.api.server

import cats.effect.Async
import cats.syntax.all._
import io.circe.Json
import io.circe.jawn
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Request, Response, Status}
import se.reciba.api.model.Recipe
import se.reciba.api.submit.{
  BranchAlreadyExists,
  ConflictingSubmission,
  GeneratedRecipe,
  GithubClient,
  GithubRejected,
  InvalidSubmission,
  Passcode,
  RecipePullRequests,
  RecipeSource,
  CloudflareTurnstile,
  RecipeSubmission,
  RecipeSubmissionConfig,
  Turnstile
}

import java.nio.charset.StandardCharsets
import java.time.{LocalDate, ZoneId}

object RecipeSubmissionRoutes {
  private val DefaultMaxBytes = 256 * 1024

  // The body contains the passcode. Do not log it. The server request logger
  // is constructed with headers and bodies disabled.
  def routes[F[_]: Async](
      config: Option[RecipeSubmissionConfig] = RecipeSubmissionConfig.fromEnv,
      pullRequests: Option[RecipePullRequests[F]] = None,
      existingRecipes: Seq[Recipe] = Recipe.recipes,
      clock: () => LocalDate = () => LocalDate.now(ZoneId.of("Europe/London")),
      maxBytes: Int = DefaultMaxBytes,
      turnstile: Option[Turnstile[F]] = None
  ): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    val client =
      pullRequests.orElse(config.map(cfg => new GithubClient[F](cfg.github)))
    val checker = turnstile.orElse(
      config.map(cfg => new CloudflareTurnstile[F](cfg.turnstile))
    )

    HttpRoutes.of[F] { case req @ POST -> Root / "recipe-submissions" =>
      (config, client) match {
        case (Some(cfg), Some(pulls)) =>
          submit[F](
            req,
            cfg,
            pulls,
            checker.get,
            existingRecipes,
            clock,
            maxBytes
          )
        case _ =>
          ServiceUnavailable(
            errorJson("recipe submission not configured")
          )
      }
    }
  }

  private def submit[F[_]: Async](
      req: Request[F],
      config: RecipeSubmissionConfig,
      client: RecipePullRequests[F],
      turnstile: Turnstile[F],
      existingRecipes: Seq[Recipe],
      clock: () => LocalDate,
      maxBytes: Int
  ): F[Response[F]] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    req.body.take(maxBytes.toLong + 1).compile.toVector.flatMap { bytes =>
      if (bytes.length > maxBytes)
        BadRequest(errorJson("submission is too large"))
      else {
        val text = new String(bytes.toArray, StandardCharsets.UTF_8)
        jawn.parse(text) match {
          case Left(_) =>
            BadRequest(errorJson("invalid json"))
          case Right(json) =>
            val token =
              json.hcursor.get[String]("cf-turnstile-response").getOrElse("")
            if (!Turnstile.tokenAccepted(token, config.turnstile.hostnames))
              forbidden
            else
              turnstile.allow(token).flatMap {
                case false => forbidden
                case true  =>
                  accept[F](
                    json,
                    config,
                    client,
                    existingRecipes,
                    clock
                  )
              }
        }
      }
    }
  }

  private def accept[F[_]: Async](
      json: Json,
      config: RecipeSubmissionConfig,
      client: RecipePullRequests[F],
      existingRecipes: Seq[Recipe],
      clock: () => LocalDate
  ): F[Response[F]] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    val passcode = json.hcursor.get[String]("passcode").getOrElse("")
    if (!Passcode.equal(config.passcode, passcode))
      Response[F](Status.Unauthorized)
        .withEntity(errorJson("invalid passcode"))
        .pure[F]
    else
      json.as[RecipeSubmission] match {
        case Left(_) =>
          BadRequest(errorJson("invalid json"))
        case Right(submission) =>
          RecipeSource.generate(
            submission,
            clock(),
            existingRecipes
          ) match {
            case Left(InvalidSubmission(message)) =>
              BadRequest(errorJson(message))
            case Left(ConflictingSubmission(message)) =>
              Conflict(errorJson(message))
            case Right(generated) =>
              openPullRequest[F](client, generated)
          }
      }
  }

  private def openPullRequest[F[_]: Async](
      client: RecipePullRequests[F],
      generated: GeneratedRecipe
  ): F[Response[F]] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    val title = s"Add ${generated.name}"
    client
      .open(
        generated,
        title,
        title,
        "Submitted from the contribute page."
      )
      .flatMap {
        case Left(BranchAlreadyExists) =>
          Conflict(
            errorJson("A submission for this recipe is already open")
          )
        case Left(GithubRejected(_)) =>
          BadGateway(errorJson("GitHub rejected the submission"))
        case Right(url) =>
          Ok(Json.obj("url" -> Json.fromString(url)))
      }
  }

  private def forbidden[F[_]: Async]: F[Response[F]] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    Forbidden(errorJson("forbidden"))
  }

  private def errorJson(message: String): Json =
    Json.obj("error" -> Json.fromString(message))
}
