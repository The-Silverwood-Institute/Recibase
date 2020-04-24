package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object IndianPatties extends
Recipe(
  "Indian Patties",
  "indian-patties",
  Some("Vegetarian burger patties made with red lentils, spinach, mint and spices."),
  None,
  Some(
    """Work well served with sweet chilli sauce and/or mayonnaise.
Don't waste time finely chopping the ingredients as they're blended anyway.
Can take a long time."""
  ),
  List(
    Ingredient("Red lentils", Some("225g")),
    Ingredient("Whole cloves", Some("1-2")),
    Ingredient("Coriander seeds", Some("2 tsp"), None, Some("Or ground coriander")),
    Ingredient("Cumin seeds", Some("1-2 tsp")),
    Ingredient("Black peppercorns", Some("1 tsp")),
    Ingredient("Garlic", Some("2-3 cloves"), Some("chopped or crushed")),
    Ingredient("Ginger", Some("1cm piece"), Some("peeled and chopped/grated")),
    Ingredient("Onion", Some("1"), Some("diced")),
    Ingredient("Spinach", Some("225g")),
    Ingredient("Coriander leaves"),
    Ingredient("Mint leaves"),
    Ingredient("Chillies", Some("1-2"), Some("chopped, seeds removed if desired")),
    Ingredient("Ground cinnamon"),
    Ingredient("Egg", Some("1")),
    Ingredient("Salt")
  ),
  List(
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
)
