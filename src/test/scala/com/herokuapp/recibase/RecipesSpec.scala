package com.herokuapp.recibase

import cats.effect.IO
import com.herokuapp.recibase.recipes.VegetablePrimavera
import io.circe.Json
import io.circe.syntax._
import org.http4s._
import org.http4s.circe._
import org.http4s.implicits._

import cats.effect.unsafe.implicits.global

class RecipesSpec extends org.specs2.mutable.Specification {
  "list" >> {
    "return 200" >> {
      recipesQuery.status must beEqualTo(Status.Ok)
    }

    "return a link to each recipe" >> {
      recipesQuery.as[String].unsafeRunSync() must contain(
        "{\"name\":\"Vegetable Primavera\",\"url\":\"vegetable-primavera\"}"
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
        request.as[Json].unsafeRunSync() must beEqualTo(
          VegetablePrimavera.recipe.asJson
        )
      }
    }
  }

  private def recipeQuery(url: String): Response[IO] = {
    val getRecipe =
      Request[IO](Method.GET, Uri.unsafeFromString(s"/recipes/$url"))
    val recipeController = RecipeController.impl[IO]
    RecibaseRoutes
      .recipeRoutes(recipeController)
      .orNotFound(getRecipe)
      .unsafeRunSync()
  }

  private lazy val recipesQuery: Response[IO] = {
    val getRecipes = Request[IO](Method.GET, uri"/recipes/")
    val recipeController = RecipeController.impl[IO]
    RecibaseRoutes
      .recipeRoutes(recipeController)
      .orNotFound(getRecipes)
      .unsafeRunSync()
  }

  private lazy val filteredRecipesQuery: Response[IO] = {
    val getRecipes = Request[IO](Method.GET, uri"/recipes/?hasIngredient=Thyme")
    val recipeController = RecipeController.impl[IO]
    RecibaseRoutes
      .recipeRoutes(recipeController)
      .orNotFound(getRecipes)
      .unsafeRunSync()
  }
}
