package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object SmokyChickpeaStew {
  val recipe = Recipe(
    "Smoky Sweet potato and chickpea stew",
    "smoky-sweet-potato-chickpea-stew",
    Some("https://www.budgetbytes.com/smoky-potato-chickpea-stew/"),
    Some("A simple yet hearty vegan stew"),
    None,
    None,
    List.empty,
    List(
      Ingredient("Sweet Potatoes", Some("620g"), Some("chopped in 1cm cubes")),
      Ingredient("Garlic Cloves", Some("4"), Some("finely chopped or crushed")),
      Ingredient("Carrots", Some("2"), Some("diced"), Some("optional")),
      Ingredient("Onions", Some("2"), Some("chopped")),
      Ingredient("Red pepper", Some("1"), Some("sliced")),
      Ingredient(
        "Fresh ginger",
        Some("2 tsp"),
        Some("grated or finely chopped")
      ),
      Ingredient(
        "Spinach",
        Some("a large handful"),
        Some("chopped"),
        Some("alternatively kale")
      ),
      Ingredient("Sundried tomatoes", Some("285g"), Some("chopped")),
      Ingredient(
        "Vegetarian chorizo sausages",
        Some("6"),
        None,
        Some("optional")
      ),
      Ingredient("Kidney Beans", "1 400g tin"),
      Ingredient("Chopped tomatoes", "1 400g tin"),
      Ingredient("Chickpeas", "2 400g tins"),
      Ingredient("Curry powder", "2 tsps"),
      Ingredient("Smoked paprika", "several teaspoons"),
      Ingredient("Stock cube"),
      Ingredient("Olive oil")
    ),
    List(
      "If you're adding the veggie chorizo sausages, preheat the oven per packet instructions.",
      "Add some olive oil to a large soup/stew pot.",
      "Add the onion, carrots, garlic and ginger to the pot and saute on a medium heat until soft.",
      "Meanwhile, disolve the stock cube in boiling water and drain the chickpeas.",
      "Add the smoked paprika and curry powder and cook the spices for a minute or two.",
      "Add the potatoes, chickpeas, red pepper, sundried tomatoes and chopped tomatoes.",
      "Turn up the heat to bring to a boil, then turn down to a light simmer for 45m, sturring occasionaly.",
      "Meanwhile, cook the veggie sausages and allow to cool, then slice into 2cm pieces.",
      "Add the sausages and kidney beans then simmer for a further 5-10m",
      "Throw in the spinach shortly before serving"
    )
  )
}
