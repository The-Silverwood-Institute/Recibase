package com.herokuapp.recibase

import cats.effect.Sync
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import io.circe.syntax._
import org.http4s.circe._

object RecibaseRoutes {
  def recipeRoutes[F[_]: Sync](H: RecipeController[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "recipes" / "" =>
        for {
          recipeMenu <- H.recipes()
          resp <- Ok(recipeMenu.asJson)
        } yield resp
      case GET -> Root / "recipes" / recipeUrl =>
        for {
          maybeRecipe <- H.recipe(recipeUrl)
          resp <- maybeRecipe.fold(NotFound("Recipe not found"))(recipe => Ok(recipe.asJson))
        } yield resp
    }
  }
}
