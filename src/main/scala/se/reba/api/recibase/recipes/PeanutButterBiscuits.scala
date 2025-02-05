package se.reciba.api.recipes

import se.reciba.api.model.{Image, Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object PeanutButterBiscuits extends Recipe {
  val name = "Peanut Butter Biscuits"

  override val source: Option[String] = Some("Alex's Mum")
  override val tags = Set(Tag.Baking)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/peanut-butter-biscuits.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Crunchy peanut butter", "250g"),
    Ingredient("Light Brown soft sugar", "200g"),
    Ingredient("Egg", "1 medium")
  )
  val method = List(
    s"Preheat oven ${180.celsius}.",
    "Line 2 baking trays with parchment.",
    "Beat all the ingredients together in a bowl until well combined.",
    "Scoop out tablespoons and roll them into balls.",
    "Arrange on baking trays, well spaced out",
    "Flatten with a fork.",
    "Bake for 12 minutes. Leave to cool for 5 minutes.",
    "Transfer to a rack to cool completely."
  )
}
