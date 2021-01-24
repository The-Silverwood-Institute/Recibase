package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object ButternutChilli {
  val recipe = Recipe(
    "Butternut Chilli",
    "butternut-chilli",
    Some("Harry"),
    None,
    None,
    None,
    List.empty,
    None,
    List(
      Ingredient("Onion", Some("1"), Some("Chopped")),
      Ingredient("Butternut Squash", Some("1"), Some("Cubed")),
      Ingredient("Vine Tomatoes", "400g"),
      Ingredient("Red Wine", "150ml"),
      Ingredient("Vegetable stock cube", "1/4"),
      Ingredient("Black turtle beans", "400g tin"),
      Ingredient("Sour Cream", "2 tbsp"),
      Ingredient(
        "Piquillo peppers",
        Some("6"),
        Some("Chopped"),
        Some("or 1 roasted Romano pepper")
      ),
      Ingredient("Garlic", Some("1 large clove"), Some("chopped")),
      Ingredient("Cayenne Pepper", "1 tsp"),
      Ingredient("Oregano", "1 tsp"),
      Ingredient("Red chilli", Some("1"), Some("finely diced")),
      Ingredient("Pitted Green Olives", Some("6"), Some("Chopped")),
      Ingredient("Bay Leaf"),
      Ingredient("Chives"),
      Ingredient("Lemon Juice"),
      Ingredient("Olive Oil")
    ),
    List(
      "Cut the lemon into small pieces, each with skin.",
      "Pour boiling water over the tomatoes, count to 30, quarter, peel and chop.",
      "Soften the onion and garlic in olive oil in a heavy lidded pan.",
      "Stir chilli, cayenne, oregano and bay into onion then stir-fry for 1 minute.",
      "Add squash, olives, lemon and wine. Simmer, stirring, for 2 min.",
      "Add tomatoes, 150ml water and crumbled stock cube. Gently simmer, cover and cook for 20 min.",
      "Chop the peppers and add to the pan. Taste for salt, adding extra water if drying out.",
      "Cover and cook for a further 20 min until lemon is tender.",
      "Drain and rinse the beans. Add to the pot.",
      "Reheat now, later or tomorrow. Serve with sour cream and chives."
    )
  )
}
