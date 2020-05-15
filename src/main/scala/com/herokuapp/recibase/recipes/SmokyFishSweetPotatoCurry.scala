package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object SmokyFishSweetPotatoCurry {
  val recipe = Recipe(
    "Smoky fish and sweet potato curry",
    "smoky-fish-curry",
    None,
    None,
    None,
    None,
    List(
      Ingredient("Onion", Some("1"), Some("diced")),
      Ingredient("Garlic", Some("1 clove"), Some("finely chopped")),
      Ingredient(
        "Smoked fish",
        Some("200g"),
        Some("cut into bite-size pieces"),
        Some("Either haddock or basa")
      ),
      Ingredient("Coriander", Some("5g"), None, Some("Optional")),
      Ingredient(
        "Red chilli",
        Some("1"),
        Some("sliced"),
        Some("Replace with chilli flakes or powder")
      ),
      Ingredient(
        "Creamed coconut",
        Some("50g"),
        None,
        Some("More is better")
      ),
      Ingredient(
        "Ginger",
        Some("30g"),
        Some("finely chopped or grated"),
        Some("Use ground ginger for speed")
      ),
      Ingredient("Stock cube", "1"),
      Ingredient("Ground coriander", "1 tsp"),
      Ingredient("Ground turmeric", "1 tsp"),
      Ingredient(
        "Sweet potato",
        Some("200g"),
        Some("cut into bite-size pieces")
      ),
      Ingredient("Water", Some("350ml"), Some("boiling"))
    ),
    List(
      "Soften the onion in a pan.",
      "Make the stock and add the creamed coconut.",
      "Add the garlic, ginger, ground coriander, ground turmeric, chilli and the sweet potato and mix well.",
      "Pour in the stock and cook for 15-20 mins or until the sweet potato is soft and the stock has thickened.",
      "Add the smoked fish and cook for 5 mins or until cooked through."
    )
  )
}
