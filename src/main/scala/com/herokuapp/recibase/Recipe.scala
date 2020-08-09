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
    image: Option[Image],
    ingredients: List[Ingredient],
    method: List[String]
) {
  def hasIngredient(ingredient: String): Boolean = {
    val normalisedIngredient = ingredient.toLowerCase.unpluralise

    if (normalisedIngredient.startsWith("!")) {
      val filteredIngredient = normalisedIngredient.stripPrefix("!")
      !ingredients.exists(_.name.toLowerCase.contains(filteredIngredient))
    } else {
      ingredients.exists(_.name.toLowerCase.contains(normalisedIngredient))
    }
  }

  def hasTag(tag: String): Boolean = {
    val normalisedTag = tag.toLowerCase.unpluralise

    if (normalisedTag.startsWith("!")) {
      val filteredTag = normalisedTag.stripPrefix("!")
      !tags.exists(_.toLowerCase.contains(filteredTag))
    } else {
      tags.exists(_.toLowerCase.contains(normalisedTag))
    }

  }
}

object Recipe {
  def apply(
      name: String,
      url: String,
      ingredients: List[Ingredient],
      method: List[String]
  ): Recipe =
    new Recipe(
      name,
      url,
      None,
      None,
      None,
      None,
      List.empty,
      None,
      ingredients,
      method
    )
}

object Ingredient {
  def apply(name: String, quantity: String): Ingredient =
    new Ingredient(name, Some(quantity))
}
