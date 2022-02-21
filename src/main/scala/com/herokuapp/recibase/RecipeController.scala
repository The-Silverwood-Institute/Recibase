package com.herokuapp.recibase

import cats.Applicative
import cats.implicits._

import scala.language.implicitConversions

trait RecipeController[F[_]] {
  def recipe(recipeUrl: String): F[Option[Recipe]]
  def recipes(
      withIngredient: Option[String]
  ): F[Seq[MenuEntry]]
}

object RecipeController {
  implicit class RecipeList(recipes: Seq[Recipe]) {
    def toMenu: Seq[MenuEntry] =
      recipes.map(recipe => MenuEntry(recipe.name, recipe.permalink))
  }

  val routing: Map[String, Recipe] =
    Recipe.recipes.map(recipe => recipe.permalink -> recipe).toMap

  def listRecipes(
      hasIngredient: Option[String]
  ): Seq[MenuEntry] = {
    val filteredRecipes = hasIngredient.fold(Recipe.recipes)(ingredient =>
      Recipe.recipes.filter(recipe => recipe.hasIngredient(ingredient))
    )

    filteredRecipes.toMenu
      .sortBy(_.name)
  }

  implicit def apply[F[_]](implicit
      ev: RecipeController[F]
  ): RecipeController[F] = ev

  def impl[F[_]: Applicative]: RecipeController[F] =
    new RecipeController[F] {
      def recipe(recipeUrl: String): F[Option[Recipe]] =
        routing.get(recipeUrl).pure[F]
      def recipes(
          withIngredient: Option[String]
      ): F[Seq[MenuEntry]] =
        listRecipes(withIngredient).pure[F]
    }
}
