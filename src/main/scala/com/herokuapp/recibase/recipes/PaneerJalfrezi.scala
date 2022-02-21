package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object PaneerJalfrezi extends Recipe {
  val name = "Paneer Jalfrezi"
  val permalink = "paneer-jalfrezi"

  override val source: Option[String] = Some("Gousto")

  val ingredients = List(
    Ingredient("Onion", "1", "sliced"),
    Ingredient("Green pepper", "1", "sliced"),
    Ingredient("Chilli flakes", "1/2 tsp"),
    Ingredient("Ginger", "15g", "finely chopped or grated"),
    Ingredient("Paneer", "1 block (225g)", "cut into bite-sized cubes"),
    Ingredient("Garlic", "2-3 cloves", "finely chopped or crushed"),
    Ingredient("Salad Tomatoes", "2", "chopped"),
    Ingredient("Curry powder", "1 tbsp"),
    Ingredient("Tomato purée", "32g"),
    Ingredient("Brown sugar", "2 tsp"),
    Ingredient("Stock cube", "1")
  )
  val method = List(
    "Fry the paneer until brown, turning to achieve an even colouring then set aside.",
    "Soften the onion in the pan with the sugar and a pich of salt until brown and starting to caramelise.",
    "Add the sliced pepper and cook for 5-8 mins.",
    "Disolve the stock cube in 300ml water.",
    "Add the garlic, tomatoes, tomato purée, ginger, chilli flakes, curry poweder, stock and paneer to the pan and stir.",
    "Cook for 5-10 mins on a medium heat until thickened."
  )
}
