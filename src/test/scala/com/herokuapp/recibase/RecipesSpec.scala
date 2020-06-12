package com.herokuapp.recibase

import cats.effect.IO
import org.http4s._
import org.http4s.implicits._

class RecipesSpec extends org.specs2.mutable.Specification {

  "Recipes" >> {
    "list" >> {
      "return 200" >> {
        queryRecipe.status must beEqualTo(Status.Ok)
      }

      "return a link to a recipe" >> {
        queryRecipe.as[String].unsafeRunSync() must contain("{\"name\":\"Vegetable Primavera\",\"url\":\"vegetable-primavera\"}")
      }
    }
  }

  private[this] val queryRecipe: Response[IO] = {
    val getRecipes = Request[IO](Method.GET, uri"/recipes/")
    val recipeController = RecipeController.impl[IO]
    RecibaseRoutes.recipeRoutes(recipeController).orNotFound(getRecipes).unsafeRunSync()
  }
}
