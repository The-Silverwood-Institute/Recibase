package se.reciba.api

import cats.effect.{IO, MonadCancel}
import cats.effect.unsafe.implicits.global
import se.reciba.api.server.{
  MealsController,
  MetaController,
  RecibaseRoutes,
  RecipeController
}
import se.reciba.api.usage.UsageData
import org.http4s._
import org.http4s.implicits._
import org.specs2.matcher.JsonMatchers

class RecipesSpec extends org.specs2.mutable.Specification with JsonMatchers {
  "list" >> {
    "return 200" >> {
      recipesQuery.status must beEqualTo(Status.Ok)
    }

    "return a link to each recipe" >> {
      recipesQuery.as[String].unsafeRunSync() must contain(
        "{\"name\":\"Vegetable Primavera\",\"permalink\":\"vegetable-primavera\"}"
      )
    }
  }

  "filtered list" >> {
    "returns 200" >> {
      filteredRecipesQuery.status must beEqualTo(Status.Ok)
    }

    "returns a link to an ingredient containing thyme" >> {
      filteredRecipesQuery.as[String].unsafeRunSync() must contain(
        "beetroot-risotto"
      )
    }

    "doesn't return a link to a recipe without thyme" >> {
      filteredRecipesQuery
        .as[String]
        .unsafeRunSync() must not contain ("baked-rigatoni-aubergine")
    }
  }

  "single recipe" >> {
    "if recipe doesn't exist" >> {
      lazy val request = recipeQuery("i-do-not-exist")

      "returns 404" >> {
        request.status must beEqualTo(Status.NotFound)
      }

      "returns a useful error message" >> {
        request.as[String].unsafeRunSync() must beEqualTo("Recipe not found")
      }
    }

    "if a recipe exists" >> {
      lazy val request = recipeQuery("vegetable-primavera")

      "returns 200" >> {
        request.status must beEqualTo(Status.Ok)
      }

      "returns the Recipe as JSON" >> {
        request.as[String].unsafeRunSync() must /(
          "name" -> "Vegetable Primavera"
        )
      }
    }
  }

  private def recipeQuery(url: String): Response[IO] = {
    val getRecipe =
      Request[IO](Method.GET, Uri.unsafeFromString(s"/recipes/$url"))
    RecibaseRoutes
      .routes(
        RecipesSpec.recipeController,
        RecipesSpec.mealController,
        RecipesSpec.metaController
      )
      .orNotFound(getRecipe)
      .unsafeRunSync()
  }

  private lazy val recipesQuery: Response[IO] = {
    val getRecipes = Request[IO](Method.GET, uri"/recipes/")
    RecibaseRoutes
      .routes(
        RecipesSpec.recipeController,
        RecipesSpec.mealController,
        RecipesSpec.metaController
      )
      .orNotFound(getRecipes)
      .unsafeRunSync()
  }

  private lazy val filteredRecipesQuery: Response[IO] = {
    val getRecipes = Request[IO](Method.GET, uri"/recipes/?hasIngredient=Thyme")
    RecibaseRoutes
      .routes(
        RecipesSpec.recipeController,
        RecipesSpec.mealController,
        RecipesSpec.metaController
      )
      .orNotFound(getRecipes)
      .unsafeRunSync()
  }
}

object RecipesSpec {
  private val usageData = UsageData.apply[IO].unsafeRunSync()
  val recipeController: RecipeController[IO] = RecipeController.impl[IO]
  val mealController: MealsController[IO] = MealsController.impl[IO](usageData)
  val metaController: MetaController[IO] = MetaController.impl[IO]
}
