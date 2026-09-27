package se.reciba.api.submit

sealed trait PullRequestFailure
case object BranchAlreadyExists extends PullRequestFailure
final case class GithubRejected(message: String) extends PullRequestFailure

trait RecipePullRequests[F[_]] {
  def open(
      recipe: GeneratedRecipe,
      commitMessage: String,
      pullTitle: String,
      pullBody: String
  ): F[Either[PullRequestFailure, String]]
}
