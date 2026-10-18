package se.reciba.api

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.circe.jawn
import org.http4s._
import org.http4s.implicits._
import org.typelevel.ci._
import se.reciba.api.model.{MenuEntry, Tag}
import se.reciba.api.server.{
  ApiEndpoints,
  ManifestDoc,
  MealDetail,
  MealsController,
  MetaController,
  RecipeController,
  RecipeDetail,
  RecipeSubmissionDoc,
  TagCatalog,
  RecibaseRoutes,
  RedocRoutes
}
import se.reciba.api.usage.UsageData

class ApiDocsSpec extends org.specs2.mutable.Specification {
  private val docs = RedocRoutes.routes[IO](ApiEndpoints.all).orNotFound

  "redoc" >> {
    "redirects the API root to the docs page" >> {
      val response = docs(Request[IO](Method.GET, uri"/")).unsafeRunSync()
      response.status must beEqualTo(Status.PermanentRedirect)
      response.headers.get(ci"Location").map(_.head.value) must beSome(
        "/docs/"
      )
    }

    "redirects /docs to the trailing-slash page" >> {
      val response = docs(Request[IO](Method.GET, uri"/docs")).unsafeRunSync()
      response.status must beEqualTo(Status.PermanentRedirect)
      response.headers.get(ci"Location").map(_.head.value) must beSome(
        "/docs/"
      )
    }

    "serves the Redoc page" >> {
      val response = docs(Request[IO](Method.GET, uri"/docs/")).unsafeRunSync()
      response.status must beEqualTo(Status.Ok)
      response.contentType must beSome(
        headers.`Content-Type`(MediaType.text.html)
      )
      val page = body(response)
      page must contain("redoc.standalone.js")
      page must contain("./docs.yaml")
    }

    "serves the OpenAPI document" >> {
      val response =
        docs(Request[IO](Method.GET, uri"/docs/docs.yaml")).unsafeRunSync()
      response.status must beEqualTo(Status.Ok)
      val spec = body(response)
      spec must contain("/tags:")
      spec must contain("/recipes/:")
      spec must contain("/recipes/{permalink}:")
      spec must contain("/recipe-submissions:")
      spec must contain("hasIngredient")
      spec must contain("implied_tags")
      spec must contain("entry_name")
      spec must contain("ingredients_blocks")
      spec must contain("source_url")
      spec must contain("cf-turnstile-response")
      spec must contain("google_drive")
      spec must contain("bearer")
    }
  }

  "documented models" >> {
    "decode the recipe list" >> {
      decode[List[MenuEntry]](get("/recipes/")) must beRight
    }

    "decode a recipe" >> {
      decode[RecipeDetail](get("/recipes/vegetable-primavera")) must beRight
    }

    "decode meals" >> {
      decode[List[MealDetail]](get("/meals/")) must beRight
    }

    "decode the manifest" >> {
      decode[ManifestDoc](get("/manifest")) must beRight
    }

    "decode tags" >> {
      decode[TagCatalog](get("/tags")) must beRight.like { case catalog =>
        val vegan = catalog.tags.find(_.name == "Vegan")
        vegan must beSome.like { case tag =>
          tag.entryName must beEqualTo("Vegan")
          tag.category must beEqualTo("diet")
          tag.superset must beEqualTo(Some(Tag.VeganIsh): Option[Tag])
          tag.impliedTags must beEqualTo(
            Set(
              Tag.VeganIsh,
              Tag.Vegetarian,
              Tag.VegetarianIsh,
              Tag.Pescatarian
            )
          )
        }
        catalog.tags.find(_.name == "Popular").map(_.category) must beSome(
          "usage"
        )
        catalog.tags.find(_.entryName == "Vegan-ish").map(_.name) must beSome(
          "Vegan-ish"
        )
        catalog.tags.find(_.entryName == "Gluten-Free").map(_.name) must beSome(
          "Gluten-Free"
        )
        catalog.tags.find(_.entryName == "Cold Weather").map(_.name) must beSome(
          "Cold Weather"
        )
      }
    }

    "decode a recipe submission" >> {
      val json = """{
        "cf-turnstile-response": "token",
        "name": "Phone Test Soup",
        "ingredients": [{"name": "Onion", "quantity": "1"}],
        "method": ["Simmer."]
      }"""
      jawn.decode[RecipeSubmissionDoc](json) must beRight
    }
  }

  private val http = {
    val usageData = UsageData.apply[IO].unsafeRunSync()
    RecibaseRoutes
      .routes[IO](
        RecipeController.impl[IO](usageData),
        MealsController.impl[IO](usageData),
        MetaController.impl[IO]
      )
      .orNotFound
  }

  private def get(path: String): String =
    body(
      http(Request[IO](Method.GET, Uri.unsafeFromString(path))).unsafeRunSync()
    )

  private def body(response: Response[IO]): String =
    response.bodyText.compile.string.unsafeRunSync()

  private def decode[A: io.circe.Decoder](
      payload: String
  ): Either[io.circe.Error, A] =
    jawn.decode[A](payload)
}
