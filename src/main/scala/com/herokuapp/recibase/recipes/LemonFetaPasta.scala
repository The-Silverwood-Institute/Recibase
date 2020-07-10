package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object LemonFetaPasta {
  val recipe = Recipe(
    "Lemon Feta Pasta",
    "lemon-feta-pasta",
    None,
    None,
    None,
    None,
    List.empty,
    List(
      Ingredient("Pine nuts"),
      Ingredient("Cashew nuts"),
      Ingredient("Brazil nuts"),
      Ingredient(
        "Feta",
        Some("1 block, approx. 200g"),
        Some("cut into 1cm cubes")
      ),
      Ingredient(
        "Tuna",
        Some("1 80g tin"),
        Some("drained"),
        Some("Optional")
      ),
      Ingredient("Olives", None, None, Some("Pimento or green preferred")),
      Ingredient("Lemon juice", None, None, Some("Either fresh or bottled")),
      Ingredient("Thyme", None, None, Some("Either fresh or dried")),
      Ingredient(
        "Fusilli",
        None,
        None,
        Some("Spaghetti also works well here")
      )
    ),
    List(
      "Boil water and cook the pasta until al dente or softer. Drain and set aside.",
      "Meanwhile, add oil to a large, deep pan along with the pine, cashew and brazil nuts and roast over a high heat until brown.",
      "Remove pan from the heat and allow to cool for a moment. Add half the feta to the pan and melt over a medium heat.",
      "Add the tuna (if used), thyme, olives and lemon juice to the pan and warm.",
      "Add the pasta and remaining feta and mix thoroughly.",
      "Serve hot."
    )
  )
}
