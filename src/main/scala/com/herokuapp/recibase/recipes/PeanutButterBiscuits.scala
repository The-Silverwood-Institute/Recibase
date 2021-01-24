package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Image, Ingredient, Recipe}

object PeanutButterBiscuits {
  val recipe = Recipe(
    "Peanut Butter Biscuits",
    "peanut-butter-biscuits",
    Some("Alex's Mum"),
    None,
    None,
    None,
    List("Baking"),
    Some(Image("https://i.reciba.se/peanut-butter-biscuits.jpg")),
    List(
      Ingredient("Crunchy peanut butter", "250g"),
      Ingredient("Light Brown soft sugar", "200g"),
      Ingredient("Egg", "1 medium")
    ),
    List(
      "Preheat oven 180C.",
      "Line 2 baking trays with parchment.",
      "Beat all the ingredients together in a bowl until well combined.",
      "Scoop out tablespoons and roll them into balls.",
      "Arrange on baking trays, well spaced out",
      "Flatten with a fork.",
      "Bake for 12 minutes. Leave to cool for 5 minutes.",
      "Transfer to a rack to cool completely."
    )
  )
}
