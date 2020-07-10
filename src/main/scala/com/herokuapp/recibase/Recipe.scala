package com.herokuapp.recibase

import io.circe.generic.JsonCodec
import StringUtils._

@JsonCodec
case class Ingredient(
    name: String,
    quantity: Option[String] = None,
    prep: Option[String] = None,
    notes: Option[String] = None
)

@JsonCodec
case class Recipe(
    name: String,
    url: String,
    source: Option[String],
    description: Option[String],
    tagline: Option[String],
    notes: Option[String],
    tags: List[String] = List.empty,
    ingredients: List[Ingredient],
    method: List[String]
) {
  def hasIngredient(ingredient: String): Boolean = {
    val normalisedName = ingredient.toLowerCase.unpluralise
    ingredients.exists(_.name.toLowerCase.contains(normalisedName))
  }
}

object Ingredient {
  def apply(name: String, quantity: String): Ingredient =
    new Ingredient(name, Some(quantity))
}
