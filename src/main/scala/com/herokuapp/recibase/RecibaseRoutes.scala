package com.herokuapp.recibase

import cats.effect.Sync
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import io.circe.syntax._
import org.http4s.circe._
import org.http4s.dsl.impl.OptionalQueryParamDecoderMatcher

object OptionalIngredientQueryParamMatcher
    extends OptionalQueryParamDecoderMatcher[String]("hasIngredient")

object RecibaseRoutes {
  def routes[F[_]: Sync](
      H: RecipeController[F],
      J: MealsController[F]
  ): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "recipes" / "" :? OptionalIngredientQueryParamMatcher(
            maybeIngredient
          ) =>
        for {
          recipeMenu <- H.recipes(maybeIngredient)
          resp <- Ok(recipeMenu.asJson)
        } yield resp
      case GET -> Root / "recipes" / recipeUrl =>
        for {
          maybeRecipe <- H.recipe(recipeUrl)
          resp <- maybeRecipe.fold(NotFound("Recipe not found"))(recipe =>
            Ok(recipe.asJson)
          )
        } yield resp
      case GET -> Root / "meals" / "" =>
        Ok(J.meals.map(_.asJson))
      case GET -> Root / "meals" / "raw" =>
        Ok(J.mealNames)
      case GET -> Root / "manifest" =>
        Ok(Manifest(sys.env.getOrElse("HEROKU_SLUG_COMMIT", "latest")).asJson)
    }
  }
}
