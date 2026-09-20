package se.reciba.api.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Manifest(version: String)

object Manifest {
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
