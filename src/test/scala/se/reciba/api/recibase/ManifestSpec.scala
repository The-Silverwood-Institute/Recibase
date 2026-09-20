package se.reciba.api

import se.reciba.api.model.Manifest

class ManifestSpec extends org.specs2.mutable.Specification {
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
