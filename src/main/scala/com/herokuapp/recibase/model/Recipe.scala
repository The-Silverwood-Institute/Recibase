package com.herokuapp.recibase.model

import com.herokuapp.recibase.utils.StringUtils._
import com.herokuapp.recibase.recipes._
import io.circe.Encoder
import io.circe.generic.JsonCodec
import org.reflections.Reflections

import scala.reflect.classTag
import scala.reflect.runtime.universe
import java.time.LocalDateTime

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
    IngredientsBlock(Some(name), ingredients)
  def simple(ingredients: Ingredient*): List[IngredientsBlock] = List(
    IngredientsBlock(None, ingredients.toList)
  )
}

trait Recipe extends Meal with Product {
  private val recipeDir =
    "https://github.com/The-Silverwood-Institute/Recibase/tree/master/src/main/scala/com/herokuapp/recibase/recipes"

  def permalink: Permalink = Permalink.fromRawString(name)
  def edit: String = s"$recipeDir/${this.productPrefix}.scala"
  def source: Option[String] = None
  def description: Option[String] = None
  def tagline: Option[String] = None
  def notes: Option[String] = None
  def tags: Set[Tag] = Set.empty
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

object Recipe {
  import scala.jdk.CollectionConverters._

  val recipes: Seq[Recipe] = new Reflections("com.herokuapp.recibase.recipes")
    .getSubTypesOf(classTag[Recipe].runtimeClass)
    .asScala
    .map(cls => {
      val mirror = universe.runtimeMirror(cls.getClassLoader)
      val moduleSymbol = mirror.moduleSymbol(cls)
      mirror.reflectModule(moduleSymbol).instance.asInstanceOf[Recipe]
    })
    .toSeq

  println(recipes)

  implicit val encodeRecipe: Encoder[Recipe] =
    Encoder.forProduct13(
      "name",
      "permalink",
      "edit",
      "source",
      "description",
      "tagline",
      "notes",
      "tags",
      "inherited_tags",
      "image",
      "ingredients_blocks",
      "method",
      "fetchedAt"
    )(r =>
      (
        r.name,
        r.permalink.value,
        r.edit,
        r.source,
        r.description,
        r.tagline,
        r.notes,
        r.tags,
        r.inheritedTags,
        r.image,
        r.ingredientsBlocks,
        r.method,
        LocalDateTime.now().toString()
      )
    )
}

object Ingredient {
  def apply(name: String, quantity: String): Ingredient =
    new Ingredient(name, Some(quantity))

  def apply(name: String, quantity: String, prep: String): Ingredient =
    new Ingredient(name, Some(quantity), Some(prep))
}
