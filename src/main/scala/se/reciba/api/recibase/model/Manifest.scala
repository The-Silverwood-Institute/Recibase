package se.reciba.api.model

import io.circe.Encoder

case class Manifest(
    version: String,
    name: String,
    sourceUrl: String,
    baseCommitUrl: String
)

object Manifest {
  val Name: String = "Recibase"
  val SourceUrl: String =
    "https://github.com/The-Silverwood-Institute/Recibase"
  val BaseCommitUrl: String = s"$SourceUrl/commit/"

  implicit val encodeManifest: Encoder[Manifest] =
    Encoder.forProduct4(
      "version",
      "name",
      "source_url",
      "base_commit_url"
    )(m => (m.version, m.name, m.sourceUrl, m.baseCommitUrl))

  def apply(version: String): Manifest =
    new Manifest(version, Name, SourceUrl, BaseCommitUrl)

  private val commitEnvKeys =
    Seq("GIT_COMMIT", "SOURCE_COMMIT", "GITHUB_SHA")

  def deployedVersion(
      env: String => Option[String] = sys.env.get
  ): String =
    commitEnvKeys.view
      .flatMap(env)
      .map(_.trim)
      .find(_.matches("[0-9a-fA-F]{7,40}"))
      .getOrElse("latest")
}
