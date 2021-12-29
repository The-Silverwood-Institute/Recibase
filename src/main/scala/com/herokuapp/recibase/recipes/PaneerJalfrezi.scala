package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object PaneerJalfrezi {
  val recipe = Recipe(
    "Paneer Jalfrezi",
    "paneer-jalfrezi",
    Some("Gousto"),
    None,
    None,
    None,
    List.empty,
    None,
    List(
      Ingredient("Onion", Some("1"), Some("sliced")),
      Ingredient("Green pepper", Some("1"), Some("sliced")),
      Ingredient("Chilli flakes", Some("1/2 tsp")),
      Ingredient("Ginger", Some("15g"), Some("finely chopped or grated")),
      Ingredient(
        "Paneer",
        Some("1 block (225g)"),
        Some("cut into bite-sized cubes")
      ),
      Ingredient(
        "Garlic",
        Some("2-3 cloves"),
        Some("finely chopped or crushed")
      ),
      Ingredient("Salad Tomatoes", Some("2"), Some("chopped")),
      Ingredient("Curry powder", "1 tbsp"),
      Ingredient("Tomato purée", "32g"),
      Ingredient("Brown sugar", "2 tsp"),
      Ingredient("Stock cube", "1")
    ),
    List(
      "Fry the paneer until brown, turning to achieve an even colouring then set aside.",
      "Soften the onion in the pan with the sugar and a pich of salt until brown and starting to caramelise.",
      "Add the sliced pepper and cook for 5-8 mins.",
      "Disolve the stock cube in 300ml water.",
      "Add the garlic, tomatoes, tomato purée, ginger, chilli flakes, curry poweder, stock and paneer to the pan and stir.",
      "Cook for 5-10 mins on a medium heat until thickened."
    )
  )
}
