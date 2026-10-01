package se.reciba.api

import io.circe.syntax._
import se.reciba.api.model.Manifest

class ManifestSpec extends org.specs2.mutable.Specification {
  "manifest json" >> {
    val json = Manifest("cafeba6").asJson
    json.hcursor.get[String]("name") should beRight(Manifest.Name)
    json.hcursor.get[String]("source_url") should beRight(Manifest.SourceUrl)
    json.hcursor.get[String]("base_commit_url") should beRight(
      Manifest.BaseCommitUrl
    )
    json.hcursor.get[String]("version") should beRight("cafeba6")
  }

  "deployedVersion" >> {
    "prefer GIT_COMMIT over Coolify SOURCE_COMMIT" >> {
      val env = Map(
        "GIT_COMMIT" -> "abcdef1234567890",
        "SOURCE_COMMIT" -> "ffffffffffffffff"
      )
      Manifest.deployedVersion(env.get) should_== "abcdef1234567890"
    }

    "ignore HEAD and latest placeholders" >> {
      val env = Map(
        "SOURCE_COMMIT" -> "HEAD",
        "GIT_COMMIT" -> "latest",
        "GITHUB_SHA" -> "cafeba6"
      )
      Manifest.deployedVersion(env.get) should_== "cafeba6"
    }

    "fall back to latest when no commit is present" >> {
      Manifest.deployedVersion(_ => None) should_== "latest"
    }
  }
}
