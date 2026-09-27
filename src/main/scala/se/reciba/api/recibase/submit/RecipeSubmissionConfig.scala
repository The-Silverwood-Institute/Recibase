package se.reciba.api.submit

import org.slf4j.LoggerFactory

case class GithubSettings(
    token: String,
    repository: String,
    baseBranch: String
)

case class RecipeSubmissionConfig(
    passcode: String,
    github: GithubSettings,
    turnstile: TurnstileSettings
)

object RecipeSubmissionConfig {
  val DefaultRepository = "The-Silverwood-Institute/Recibase"
  val DefaultBranch = "master"

  private val logger = LoggerFactory.getLogger(getClass)
  private val RepositoryPattern = "^[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+$".r
  private val BranchPattern = "^[A-Za-z0-9._-]+$".r

  def fromEnv: Option[RecipeSubmissionConfig] = {
    val config = from(
      sys.env.get("RECIPE_SUBMIT_PASSCODE"),
      sys.env.get("GITHUB_TOKEN"),
      sys.env.get("GITHUB_REPOSITORY"),
      sys.env.get("GITHUB_BASE_BRANCH"),
      sys.env.get("TURNSTILE_SECRET"),
      sys.env.get("TURNSTILE_HOSTNAMES")
    )
    val tokenConfigured =
      sys.env.get("GITHUB_TOKEN").exists(_.nonEmpty) ||
        sys.env.get("RECIPE_SUBMIT_PASSCODE").exists(_.nonEmpty) ||
        sys.env.get("TURNSTILE_SECRET").exists(_.nonEmpty)
    if (tokenConfigured && config.isEmpty)
      logger.warn("recipe submission env is set but invalid")
    config
  }

  def from(
      passcode: Option[String],
      token: Option[String],
      repository: Option[String],
      baseBranch: Option[String],
      turnstileSecret: Option[String] = None,
      turnstileHostnames: Option[String] = None
  ): Option[RecipeSubmissionConfig] = {
    val hostnames = turnstileHostnames
      .getOrElse("")
      .split(",")
      .iterator
      .map(_.trim)
      .filter(_.nonEmpty)
      .toSet
    (
      passcode.filter(_.nonEmpty),
      token.filter(_.nonEmpty),
      turnstileSecret.filter(_.nonEmpty),
      Option(hostnames).filter(_.nonEmpty)
    ) match {
      case (Some(secret), Some(githubToken), Some(siteSecret), Some(names)) =>
        val repo = repository.filter(_.nonEmpty).getOrElse(DefaultRepository)
        val branch = baseBranch.filter(_.nonEmpty).getOrElse(DefaultBranch)
        if (RepositoryPattern.matches(repo) && BranchPattern.matches(branch))
          Some(
            RecipeSubmissionConfig(
              secret,
              GithubSettings(githubToken, repo, branch),
              TurnstileSettings(siteSecret, names)
            )
          )
        else None
      case _ => None
    }
  }
}
