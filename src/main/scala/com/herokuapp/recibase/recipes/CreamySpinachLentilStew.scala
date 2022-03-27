package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object CreamySpinachLentilStew extends Recipe {
  val name = "Creamy Spinach and Lentil Stew"
  override val permalink: Permalink =
    Permalink.fromRawString("spinach-lentil-stew")

  override val tags = Set(Tag.Vegan, Tag.Scales)

  val ingredients = List(
    Ingredient("Garlic", "1 clove", "diced"),
    Ingredient("Onion", "1", "roughly chopped"),
    Ingredient("Carrots", "2-3", "chopped"),
    Ingredient("Salad Tomatoes", None, Some("chopped")),
    Ingredient("Cream of coconut", None, Some("grated")),
    Ingredient("Frozen Spinach"),
    Ingredient("Lentils", "150g"),
    Ingredient("Water", "400ml"),
    Ingredient("Worcestershire Sauce"),
    Ingredient("Stock cube", "1"),
    Ingredient("Honey"),
    Ingredient("Chili flakes"),
    Ingredient("Cinnamon"),
    Ingredient("Nutmeg"),
    Ingredient("Olive Oil")
  )
  val method = List(
    "Put out frozen spinach so it can defrost.",
    "Boil the kettle and make stock.",
    "Heat the olive oil in a pan and cook the carrots and garlic with a little bit of honey for a few minutes.",
    "Add the onions and cook for a few more minutes.",
    "Add the tomatoes, stock, grated cream of coconut, a dash of Worcestershire sauce and the spices.",
    "Bring to simmer then add the lentils. You’ll need to possibly add a bit of water as the lentils simmer.",
    "Simmer with the lid on for however long lentils take (15-20 minutes?).",
    "Add frozen spinach."
  )
}
