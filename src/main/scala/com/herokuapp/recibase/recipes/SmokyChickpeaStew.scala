package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object SmokyChickpeaStew extends Recipe {
  val name = "Smoky Sweet potato and chickpea stew"
  override val permalink: Permalink =
    Permalink.fromRawString("smoky-sweet-potato-chickpea-stew")

  override val source: Option[String] = Some(
    "https://www.budgetbytes.com/smoky-potato-chickpea-stew/"
  )
  override val description: Option[String] = Some(
    "A simple yet hearty vegan stew"
  )
  override val tags = Set(Tag.Vegan, Tag.Scales, Tag.Freezes)

  val ingredients = List(
    Ingredient("Sweet Potatoes", "620g", "chopped in 1cm cubes"),
    Ingredient("Garlic Cloves", "4", "finely chopped or crushed"),
    Ingredient("Carrots", Some("2"), Some("diced"), Some("optional")),
    Ingredient("Onions", "2", "chopped"),
    Ingredient("Red pepper", "1", "sliced"),
    Ingredient("Fresh ginger", "2 tsp", "grated or finely chopped"),
    Ingredient(
      "Spinach",
      Some("a large handful"),
      Some("chopped"),
      Some("alternatively kale")
    ),
    Ingredient("Sundried tomatoes", "285g", "chopped"),
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
  )
  val method = List(
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
}
