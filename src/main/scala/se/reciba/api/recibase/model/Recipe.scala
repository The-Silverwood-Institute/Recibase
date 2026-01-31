package se.reciba.api.model

import cats.syntax.all._
import se.reciba.api.utils.StringUtils._
import se.reciba.api.recipes._
import io.circe.Encoder
import io.circe.generic.JsonCodec
import org.reflections.Reflections

import scala.reflect.classTag
import scala.reflect.runtime.universe
import se.reciba.api.recibase.model.DatedNote

@JsonCodec
case class Ingredient(
    name: String,
    quantity: Option[String] = None,
    prep: Option[String] = None,
    notes: Option[String] = None
)

@JsonCodec
case class IngredientsBlock(
    name: Option[String],
    ingredients: List[Ingredient]
) {
  def prefixIngredients(additionalIngredients: Ingredient*): IngredientsBlock =
    copy(ingredients = additionalIngredients.toList ++ ingredients)
}

object IngredientsBlock {
  def apply(name: String, ingredients: List[Ingredient]): IngredientsBlock =
    IngredientsBlock(name.some, ingredients)
  def simple(ingredients: Ingredient*): List[IngredientsBlock] = List(
    IngredientsBlock(None, ingredients.toList)
  )
}

trait Recipe extends Meal with Product {
  private val recipeDir =
    "https://github.com/The-Silverwood-Institute/Recibase/tree/master/src/main/scala/se/reciba/api/recibase/recipes"

  def permalink: Permalink = Permalink.fromRawString(name)
  def edit: String = s"$recipeDir/${this.productPrefix}.scala"
  def source: Option[String] = None
  def description: Option[String] = None
  def tagline: Option[String] = None
  def notes: List[String] = List.empty
  def tags: Set[Tag]
  def image: Option[Image] = None
  def ingredientsBlocks: List[IngredientsBlock]
  def method: List[String]

  def hasIngredient(ingredient: String): Boolean = {
    val normalisedIngredient = ingredient.toLowerCase.unpluralise

    if (normalisedIngredient.startsWith("!")) {
      val filteredIngredient = normalisedIngredient.stripPrefix("!")
      !ingredientsBlocks
        .flatMap(_.ingredients)
        .exists(_.name.toLowerCase.contains(filteredIngredient))
    } else {
      ingredientsBlocks
        .flatMap(_.ingredients)
        .exists(_.name.toLowerCase.contains(normalisedIngredient))
    }
  }
}

case class RecipeWithUsageData(recipe: Recipe, datedNotes: List[DatedNote])

object Recipe {
  import scala.jdk.CollectionConverters._

  val recipes: Seq[Recipe] = new Reflections("se.reciba.api.recipes")
    .getSubTypesOf(classTag[Recipe].runtimeClass)
    .asScala
    .map(cls => {
      val mirror = universe.runtimeMirror(cls.getClassLoader)
      val moduleSymbol = mirror.moduleSymbol(cls)
      mirror.reflectModule(moduleSymbol).instance.asInstanceOf[Recipe]
    })
    .toSeq

  println(recipes)
}

object RecipeWithUsageData {
  implicit val encodeRecipe: Encoder[RecipeWithUsageData] =
    Encoder.forProduct13(
      "name",
      "permalink",
      "edit",
      "source",
      "description",
      "tagline",
      "notes",
      "dated_notes",
      "tags",
      "inherited_tags",
      "image",
      "ingredients_blocks",
      "method"
    )(r =>
      (
        r.recipe.name,
        r.recipe.permalink.value,
        r.recipe.edit,
        r.recipe.source,
        r.recipe.description,
        r.recipe.tagline,
        r.recipe.notes,
        r.datedNotes,
        r.recipe.tags,
        r.recipe.inheritedTags,
        r.recipe.image,
        r.recipe.ingredientsBlocks,
        r.recipe.method
      )
    )
}

object Ingredient {
  def apply(name: String, quantity: String): Ingredient =
    new Ingredient(name, quantity.some)

  def apply(name: String, quantity: String, prep: String): Ingredient =
    new Ingredient(name, quantity.some, prep.some)

  def apply(
      name: String,
      quantity: String,
      prep: String,
      notes: String
  ): Ingredient =
    new Ingredient(name, quantity.some, prep.some, notes.some)
}
