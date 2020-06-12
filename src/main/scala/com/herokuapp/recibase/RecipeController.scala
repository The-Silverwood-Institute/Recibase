package com.herokuapp.recibase

import cats.Applicative
import cats.implicits._
import com.herokuapp.recibase.recipes._
import scala.language.implicitConversions

trait RecipeController[F[_]] {
  def recipe(recipeUrl: String): F[Option[Recipe]]
  def recipes(withIngredient: Option[String]): F[Seq[MenuEntry]]
}

object RecipeController {
  implicit class RecipeList(recipes: Seq[Recipe]) {
    def toMenu: Seq[MenuEntry] = recipes.map(recipe => MenuEntry(recipe.name, recipe.url))
  }

  private val recipes: Seq[Recipe] = List(
    BakedRigatoniAubergine.recipe,
    BakedSalmonOlivesSpaghetti.recipe,
    BeetrootRisotto.recipe,
    BlueCheeseGnocchi.recipe,
    BroccoliSalmonQuiche.recipe,
    CheesyCodSpinachGratin.recipe,
    ChilliConCarne.recipe,
    ChunkyVegetableCrumble.recipe,
    CourgetteBroccoliPasta.recipe,
    CourgetteSpinachPasties.recipe,
    CreamyCauliflowerCheeseWalnuts.recipe,
    CreamyMushroomStroganoff.recipe,
    Dahl.recipe,
    EasySoup.recipe,
    IndianPatties.recipe,
    Kashtouri.recipe,
    LambAubergineDaube.recipe,
    LemonFetaPasta.recipe,
    LentilShepardsPie.recipe,
    MeltyMushroomWellingtons.recipe,
    MushroomQuiche.recipe,
    MushroomRisotto.recipe,
    PaneerJalfrezi.recipe,
    ParsnipGingerSoup.recipe,
    ParsnipLentilLasagne.recipe,
    RoastedVegetableLasagne.recipe,
    RussianMushroomJulienne.recipe,
    SaagPaneer.recipe,
    ScrambledEggs.recipe,
    SeafoodLasagne.recipe,
    SmokyFishSweetPotatoCurry.recipe,
    SpicySmokedPaprikaChorizo.recipe,
    SweetChilliFetaPasta.recipe,
    VegetablePrimavera.recipe
  )

  val routing: Map[String, Recipe] =
    recipes.map(recipe => recipe.url -> recipe).toMap

  def listRecipes(hasIngredient: Option[String]): Seq[MenuEntry] = {
    hasIngredient match {
      case None => recipes.toMenu
      case Some(ingredient) => recipes.filter(recipe => recipe.hasIngredient(ingredient)).toMenu
    }
  }

  implicit def apply[F[_]](implicit
      ev: RecipeController[F]
  ): RecipeController[F] = ev

  def impl[F[_]: Applicative]: RecipeController[F] =
    new RecipeController[F] {
      def recipe(recipeUrl: String): F[Option[Recipe]] =
        routing.get(recipeUrl).pure[F]
      def recipes(withIngredient: Option[String]): F[Seq[MenuEntry]] = listRecipes(withIngredient).pure[F]
    }
}
