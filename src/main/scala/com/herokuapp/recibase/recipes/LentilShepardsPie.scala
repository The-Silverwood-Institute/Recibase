package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object LentilShepardsPie {
  val recipe = Recipe(
    "Veggie Shepherd's Pie",
    "veggie-shepherds-pie",
    None,
    None,
    None,
    None,
    List(
      Ingredient("Onions", Some("1"), Some("Diced")),
      Ingredient("Carrots", Some("4"), Some("Diced")),
      Ingredient("Celery", Some("1 head"), Some("Chopped"), Some("Optional")),
      Ingredient("Garlic", Some("4 Cloves"), Some("Finely chopped")),
      Ingredient("Chestnut mushrooms", Some("200g"), Some("sliced")),
      Ingredient("Green Lentils", Some("500g"), None, Some("Dried")),
      Ingredient("Butter"),
      Ingredient("Bay Leaf", Some("2"), None, Some("Optional")),
      Ingredient("Thyme", "1 tbsp"),
      Ingredient("Red wine", Some("100ml"), None, Some("Optional")),
      Ingredient("Stock cube", "1"),
      Ingredient("Tomato purée", "3 tbsp"),
      Ingredient(
        "King Edwards Potatoes",
        Some("2kg"),
        None,
        Some("Other floury potatoes will do")
      ),
      Ingredient("Butter", "85g"),
      Ingredient("Milk", "100ml"),
      Ingredient("Cheddar", Some("50g"), Some("Grated"))
    ),
    List(
      "To make the sauce, heat the butter in a pan, then gently fry the onions, carrots, celery and garlic for 15 mins until soft and golden.",
      "Turn up the heat, add the mushrooms, then cook for 4 mins more.",
      "Add the herbs, lentils, wine and stock. It's important that you do not season with salt at this stage.",
      "Simmer for 40-50 mins until the lentils are very soft.",
      "Take off the heat and stir in the tomato pur\u00e9e. Season to taste.",
      "While the lentils are cooking, tip the potatoes into a pan of water, then boil for about 15 mins until tender.",
      "Drain the potatoes well, then mash with the butter and milk.",
      "Pour the lentil mixture into a casserole dish and top with the mash potatoes.",
      "Use a fork to rake the surface of the mash potatoes. This will help golden the dish.",
      "Scatter with grated cheddar then bake in a 190C/fan 170C oven for 30 minutes, until golden."
    )
  )
}
