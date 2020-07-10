package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object ParsnipGingerSoup {
  val recipe = Recipe(
    "Parsnip and Ginger Soup",
    "parsnip-and-ginger-soup",
    None,
    None,
    None,
    None,
    List.empty,
    List(
      Ingredient("Parnsips", Some("450g"), Some("Diced")),
      Ingredient("Onion", Some("1"), Some("Diced")),
      Ingredient(
        "Potato",
        Some("1"),
        None,
        Some("Optional, subtitute for flour")
      ),
      Ingredient("Orange", Some("1"), Some("Grate the rind and juice")),
      Ingredient("Fresh Ginger", Some("2.5cm"), Some("Grated")),
      Ingredient("Stock cube"),
      Ingredient("Butter"),
      Ingredient("Single Cream", Some("250ml"), None, Some("Optional"))
    ),
    List(
      "Melt the butter in a large pan then stir in the parsnips, onion, flour, ginger and orange rind.",
      "Dissolve the stock in 500ml - 1L of water then mix in and bring to the boil.",
      "Simmer for 20 minutes or so, until the parsnips are soft.",
      "Blend the mixture to your desired consistency.",
      "Stir in the orange juice and reheat, without boiling.",
      "Add cream, if desired."
    )
  )
}
