package com.herokuapp.recibase.model

import com.herokuapp.recibase.StringUtils._
import com.herokuapp.recibase.recipes._
import io.circe.Encoder
import io.circe.generic.JsonCodec

@JsonCodec
case class Ingredient(
    name: String,
    quantity: Option[String] = None,
    prep: Option[String] = None,
    notes: Option[String] = None
)

trait Recipe extends Meal with Product {
  private val recipeDir =
    "https://github.com/The-Silverwood-Institute/Recibase/tree/master/src/main/scala/com/herokuapp/recibase/recipes"

  def permalink: String
  def edit: String = s"$recipeDir/${this.productPrefix}.scala"
  def source: Option[String] = None
  def description: Option[String] = None
  def tagline: Option[String] = None
  def notes: Option[String] = None
  def tags: Set[Tag] = Set.empty
  def image: Option[Image] = None
  def ingredients: List[Ingredient]
  def method: List[String]

  def hasIngredient(ingredient: String): Boolean = {
    val normalisedIngredient = ingredient.toLowerCase.unpluralise

    if (normalisedIngredient.startsWith("!")) {
      val filteredIngredient = normalisedIngredient.stripPrefix("!")
      !ingredients.exists(_.name.toLowerCase.contains(filteredIngredient))
    } else {
      ingredients.exists(_.name.toLowerCase.contains(normalisedIngredient))
    }
  }
}

object Recipe {
  val recipes: Seq[Recipe] = List(
    BakedRigatoniAubergine,
    BakedSalmonOlivesSpaghetti,
    BeetrootRisotto,
    BlueCheeseGnocchi,
    ButternutChilli,
    BroccoliSalmonQuiche,
    Brownies,
    CheesyCodSpinachGratin,
    ChilliConCarne,
    ChunkyVegetableCrumble,
    CoconutLimeDahl,
    CourgetteBroccoliPasta,
    CourgetteSpinachPasties,
    CranberryRelish,
    CreamyCauliflowerCheeseWalnuts,
    CreamySpinachLentilStew,
    CreamyMushroomStroganoff,
    Dahl,
    RedPepperSoup,
    IndianPatties,
    Kashtouri,
    LambAubergineDaube,
    LemonFetaPasta,
    LentilShepardsPie,
    NewYorkBagel,
    MarmaladeIceCream,
    Mead,
    MeltyMushroomWellingtons,
    MushroomQuiche,
    MushroomRisotto,
    PaneerJalfrezi,
    ParsnipGingerSoup,
    ParsnipLentilLasagne,
    PeanutButterBiscuits,
    RoastBeetrootDahl,
    RoastedVegetableMoroccanTagine,
    RoastedVegetableLasagne,
    RussianMushroomJulienne,
    SaagPaneer,
    ScrambledEggs,
    SeafoodLasagne,
    SmokyChickpeaStew,
    SmokyFishSweetPotatoCurry,
    SpicySmokedPaprikaChorizo,
    SweetChilliFetaPasta,
    ToadInTheHole,
    VegetablePrimavera,
    WasabiIceCream
  )

  implicit val encodeRecipe: Encoder[Recipe] =
    Encoder.forProduct11(
      "name",
      "permalink",
      "edit",
      "source",
      "description",
      "tagline",
      "notes",
      "tags",
      "image",
      "ingredients",
      "method"
    )(r =>
      (
        r.name,
        r.permalink,
        r.edit,
        r.source,
        r.description,
        r.tagline,
        r.notes,
        r.tags,
        r.image,
        r.ingredients,
        r.method
      )
    )
}

object Ingredient {
  def apply(name: String, quantity: String): Ingredient =
    new Ingredient(name, Some(quantity))

  def apply(name: String, quantity: String, prep: String): Ingredient =
    new Ingredient(name, Some(quantity), Some(prep))
}
