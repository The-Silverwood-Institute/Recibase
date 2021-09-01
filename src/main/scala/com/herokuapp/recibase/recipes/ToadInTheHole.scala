package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object ToadInTheHole {
  val recipe = Recipe(
    "Toad in the Hole",
    "toad-in-the-hole",
    Some("Jeremy"),
    None,
    None,
    None,
    List.empty,
    None,
    List(
      Ingredient("Sausages", "6"),
      Ingredient("Flour", "150g"),
      Ingredient("Eggs", "2"),
      Ingredient("Milk", "125ml"),
      Ingredient("Water", "125ml"),
      Ingredient("Salt", "A pinch")
    ),
    List(
      "Cook the sausages. Then turn the oven up to 200C.",
      "Sift the flour into a mixing bowl.",
      "Add the salt, eggs, water and milk.",
      "Whisk the ingredients for a few minutes.",
      "Brush a [DIMENSIONS] baking tray with oil, then warm in the oven for [DURATION] minutes.",
      "Pour half the batter into the baking tray. Gently tilt the tray to ensure it reaches the corners.",
      "Place the sausages in the batter.",
      "Pour the remainder of the batter over the sausages.",
      "Bake in the oven for 25-30m. You MUST NOT open the oven while it is cooking."
    )
  )
}
