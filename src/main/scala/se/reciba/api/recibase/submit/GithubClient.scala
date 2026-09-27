package se.reciba.api.submit

import cats.effect.Async
import io.circe.Json
import io.circe.jawn
import org.slf4j.LoggerFactory

import java.net.{URI, URLEncoder}
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.util.Base64
import scala.util.control.NonFatal

class GithubClient[F[_]: Async](
    settings: GithubSettings,
    apiBase: String = "https://api.github.com"
) extends RecipePullRequests[F] {
  private val logger = LoggerFactory.getLogger(getClass)
  private val BranchPattern = "^recipe/[a-z0-9]+(-[a-z0-9]+)*$".r
  private val PathPattern =
    "^src/main/scala/se/reciba/api/recibase/recipes/[A-Z][A-Za-z0-9]*\\.scala$".r

  def open(
      recipe: GeneratedRecipe,
      commitMessage: String,
      pullTitle: String,
      pullBody: String
  ): F[Either[PullRequestFailure, String]] =
    Async[F].blocking {
      val http = HttpClient
        .newBuilder()
        .followRedirects(HttpClient.Redirect.NEVER)
        .connectTimeout(Duration.ofSeconds(15))
        .build()
      try
        openBlocking(http, recipe, commitMessage, pullTitle, pullBody)
      catch {
        case NonFatal(error) =>
          val message = sanitize(
            Option(error.getMessage).getOrElse(error.getClass.getSimpleName)
          )
          logger.warn(s"github recipe submission failed: $message")
          Left(GithubRejected(message))
      } finally
        try http.close()
        catch { case NonFatal(_) => () }
    }

  private def openBlocking(
      http: HttpClient,
      recipe: GeneratedRecipe,
      commitMessage: String,
      pullTitle: String,
      pullBody: String
  ): Either[PullRequestFailure, String] = {
    if (!BranchPattern.matches(recipe.branch))
      Left(GithubRejected("invalid branch"))
    else if (!PathPattern.matches(recipe.path))
      Left(GithubRejected("invalid path"))
    else
      baseSha(http) match {
        case Left(failure) => Left(failure)
        case Right(sha)    =>
          createBranch(http, recipe.branch, sha) match {
            case Left(failure) => Left(failure)
            case Right(_)      =>
              putFile(http, recipe, commitMessage) match {
                case Left(failure) =>
                  deleteBranch(http, recipe.branch)
                  Left(failure)
                case Right(_) =>
                  createPull(http, recipe.branch, pullTitle, pullBody) match {
                    case Left(failure) =>
                      deleteBranch(http, recipe.branch)
                      Left(failure)
                    case Right(url) =>
                      logger.info(s"opened recipe pull request $url")
                      Right(url)
                  }
              }
          }
      }
  }

  private def baseSha(
      http: HttpClient
  ): Either[PullRequestFailure, String] = {
    val (status, body) = get(
      http,
      s"/repos/${settings.repository}/git/ref/heads/${settings.baseBranch}"
    )
    if (status != 200) Left(rejected(status, body))
    else
      jawn
        .parse(body)
        .toOption
        .flatMap(
          _.hcursor.downField("object").get[String]("sha").toOption
        ) match {
        case Some(sha) => Right(sha)
        case None      =>
          Left(GithubRejected(s"GitHub returned HTTP $status without a sha"))
      }
  }

  private def createBranch(
      http: HttpClient,
      branch: String,
      sha: String
  ): Either[PullRequestFailure, Unit] = {
    val payload = Json.obj(
      "ref" -> Json.fromString(s"refs/heads/$branch"),
      "sha" -> Json.fromString(sha)
    )
    val (status, body) =
      post(http, s"/repos/${settings.repository}/git/refs", payload)
    if (status == 200 || status == 201) Right(())
    else if (
      status == 422 && githubMessage(body).toLowerCase.contains(
        "already exists"
      )
    ) {
      logger.info(s"recipe branch already exists: $branch")
      Left(BranchAlreadyExists)
    } else Left(rejected(status, body))
  }

  private def putFile(
      http: HttpClient,
      recipe: GeneratedRecipe,
      commitMessage: String
  ): Either[PullRequestFailure, Unit] = {
    val encoded = Base64.getEncoder.encodeToString(
      recipe.source.getBytes(StandardCharsets.UTF_8)
    )
    val payload = Json.obj(
      "message" -> Json.fromString(commitMessage),
      "content" -> Json.fromString(encoded),
      "branch" -> Json.fromString(recipe.branch)
    )
    val (status, body) = put(
      http,
      s"/repos/${settings.repository}/contents/${recipe.path}",
      payload
    )
    if (status == 200 || status == 201) Right(())
    else Left(rejected(status, body))
  }

  private def createPull(
      http: HttpClient,
      branch: String,
      title: String,
      pullBody: String
  ): Either[PullRequestFailure, String] = {
    val payload = Json.obj(
      "title" -> Json.fromString(title),
      "head" -> Json.fromString(branch),
      "base" -> Json.fromString(settings.baseBranch),
      "body" -> Json.fromString(pullBody),
      "draft" -> Json.True
    )
    val (status, body) =
      post(http, s"/repos/${settings.repository}/pulls", payload)
    if (status != 200 && status != 201) Left(rejected(status, body))
    else
      jawn
        .parse(body)
        .toOption
        .flatMap(_.hcursor.get[String]("html_url").toOption) match {
        case Some(url) => Right(url)
        case None      =>
          Left(
            GithubRejected(
              s"GitHub returned HTTP $status without a pull request url"
            )
          )
      }
  }

  private def deleteBranch(http: HttpClient, branch: String): Unit = {
    val encoded = URLEncoder.encode(branch, StandardCharsets.UTF_8)
    val (status, body) = delete(
      http,
      s"/repos/${settings.repository}/git/refs/heads/$encoded"
    )
    if (status != 204 && status != 200)
      logger.warn(
        s"failed to delete branch $branch: $status ${sanitize(githubMessage(body))}"
      )
  }

  private def rejected(status: Int, body: String): PullRequestFailure = {
    val detail = sanitize(githubMessage(body))
    val message =
      if (detail.isEmpty) s"GitHub returned HTTP $status"
      else s"GitHub returned HTTP $status: $detail"
    logger.warn(s"github recipe submission failed: $message")
    GithubRejected(message)
  }

  private def get(http: HttpClient, path: String): (Int, String) =
    send(http, "GET", path, None)

  private def delete(http: HttpClient, path: String): (Int, String) =
    send(http, "DELETE", path, None)

  private def post(
      http: HttpClient,
      path: String,
      payload: Json
  ): (Int, String) =
    send(http, "POST", path, Some(payload.noSpaces))

  private def put(
      http: HttpClient,
      path: String,
      payload: Json
  ): (Int, String) =
    send(http, "PUT", path, Some(payload.noSpaces))

  private def send(
      http: HttpClient,
      method: String,
      path: String,
      payload: Option[String]
  ): (Int, String) = {
    val builder = HttpRequest
      .newBuilder(URI.create(apiBase + path))
      .timeout(Duration.ofSeconds(30))
      .header("Authorization", s"Bearer ${settings.token}")
      .header("Accept", "application/vnd.github+json")
      .header("User-Agent", "recibase")
      .header("X-GitHub-Api-Version", "2022-11-28")
    val request = payload match {
      case Some(json) =>
        builder
          .header("Content-Type", "application/json")
          .method(method, HttpRequest.BodyPublishers.ofString(json))
          .build()
      case None =>
        builder.method(method, HttpRequest.BodyPublishers.noBody()).build()
    }
    val response =
      http.send(
        request,
        HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
      )
    (response.statusCode(), response.body())
  }

  private def githubMessage(body: String): String =
    jawn
      .parse(body)
      .toOption
      .flatMap(_.hcursor.get[String]("message").toOption)
      .getOrElse("")
      .take(200)

  private def sanitize(message: String): String =
    message.replace(settings.token, "***")
}
