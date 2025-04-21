package se.reciba.api.server

import cats.Applicative
import cats.implicits._
import se.reciba.api.model.{MenuEntry, Recipe, RecipeWithUsageData}

import scala.language.implicitConversions
import se.reciba.api.usage.UsageData

trait RecipeController[F[_]] {
  def recipe(recipeUrl: String): F[Option[RecipeWithUsageData]]
  def recipes(
      withIngredient: Option[String]
  ): F[Seq[MenuEntry]]
}

object RecipeController {
  implicit class RecipeList(recipes: Seq[Recipe]) {
    def toMenu: Seq[MenuEntry] =
      recipes.map(recipe => MenuEntry(recipe.name, recipe.permalink.value))
  }

  private val routing: Map[String, Recipe] =
    Recipe.recipes.map(recipe => recipe.permalink.value -> recipe).toMap

  def getRecipe[F[_]: Applicative](
      usageData: UsageData[F],
      recipeUrl: String
  ): F[Option[RecipeWithUsageData]] =
    usageData.mealNotes.map(notes =>
      routing
        .get(recipeUrl)
        .map(recipe =>
          RecipeWithUsageData(recipe, notes.getOrElse(recipe.name, List.empty))
        )
    )

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

  def impl[F[_]: Applicative](usageData: UsageData[F]): RecipeController[F] =
    new RecipeController[F] {
      def recipe(recipeUrl: String): F[Option[RecipeWithUsageData]] =
        getRecipe(usageData, recipeUrl)
      def recipes(
          withIngredient: Option[String]
      ): F[Seq[MenuEntry]] =
        listRecipes(withIngredient).pure[F]
    }
}
