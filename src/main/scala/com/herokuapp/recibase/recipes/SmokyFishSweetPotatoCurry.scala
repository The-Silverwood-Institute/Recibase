package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object SmokyFishSweetPotatoCurry extends Recipe {
  val name = "Smoky fish and sweet potato curry"
  override val permalink: Permalink =
    Permalink.fromRawString("smoky-fish-curry")

  override val tags = Set(Tag.Pescatarian, Tag.Spicy)

  val ingredients = List(
    Ingredient("Onion", "1", "diced"),
    Ingredient("Garlic", "1 clove", "finely chopped"),
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
    Ingredient("Sweet potato", "200g", "cut into bite-size pieces"),
    Ingredient("Water", "350ml", "boiling")
  )
  val method = List(
    "Soften the onion in a pan.",
    "Make the stock and add the creamed coconut.",
    "Add the garlic, ginger, ground coriander, ground turmeric, chilli and the sweet potato and mix well.",
    "Pour in the stock and cook for 15-20 mins or until the sweet potato is soft and the stock has thickened.",
    "Add the smoked fish and cook for 5 mins or until cooked through."
  )
}
