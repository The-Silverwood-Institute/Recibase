package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock
}

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
    "Preheat oven 180C.",
    "Line 2 baking trays with parchment.",
    "Beat all the ingredients together in a bowl until well combined.",
    "Scoop out tablespoons and roll them into balls.",
    "Arrange on baking trays, well spaced out",
    "Flatten with a fork.",
    "Bake for 12 minutes. Leave to cool for 5 minutes.",
    "Transfer to a rack to cool completely."
  )
}
