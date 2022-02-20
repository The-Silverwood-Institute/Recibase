package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object IndianPatties extends Recipe {
  val name = "Indian Patties"
  val url = "indian-patties"

  override val source: Option[String] = Some(
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  )
  override val description: Option[String] = Some(
    "Vegetarian burger patties made with red lentils, spinach, mint and spices."
  )
  override val notes: Option[String] = Some(
    """Work well served with sweet chilli sauce and/or mayonnaise.
Don't waste time finely chopping the ingredients as they're blended anyway.
If you don't have a blender you can chop the garlic, chilli and ginger finely then cook the onion at the same time.
Can take a long time."""
  )

  val ingredients = List(
    Ingredient("Red lentils", "225g"),
    Ingredient("Whole cloves", "1-2"),
    Ingredient(
      "Coriander seeds",
      Some("2 tsp"),
      None,
      Some("Or ground coriander")
    ),
    Ingredient("Cumin seeds", "1-2 tsp"),
    Ingredient("Black peppercorns", "1 tsp"),
    Ingredient("Garlic", "2-3 cloves", "chopped or crushed"),
    Ingredient("Ginger", "1cm piece", "peeled and chopped/grated"),
    Ingredient("Onion", "1", "diced"),
    Ingredient("Spinach", "225g"),
    Ingredient("Coriander leaves"),
    Ingredient("Mint leaves"),
    Ingredient("Chillies", "1-2", "chopped, seeds removed if desired"),
    Ingredient("Ground cinnamon"),
    Ingredient("Egg", "1"),
    Ingredient("Salt")
  )
  val method = List(
    "Set the lentils aside in boiling water to soften.",
    "Meanwhile, dry-roast the cloves, cumin seeds, coriander seeds and black peppercorns in a pan. Grid thoroughly with a mortar and pestle and set aside.",
    "Add the chillies, garlic and ginger to the pan with a little oil and soften. Add the (drained) lentils, along with the spinach, coriander and mint and cook for 5-10 minutes.",
    "Add the ground spices, cinnamon, egg and salt and mix.",
    "Blend the mixture thoroughly.",
    "Add the onion and pulse blender until finely chopped but not pureed.",
    "Form the mixture into ~5cm patties and brush with oil on both sides.",
    "Place them on a baking tray under the grill until brown and crisp on both sides, turning as necessary.",
    "Serve hot."
  )
}
