package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object MeltyMushroomWellingtons extends
Recipe(
  "Melty Mushroom Wellingtons",
  "melty-mushroom-wellingtons",
  None,
  None,
  Some(
    """Take the pastry out of the fridge ten minutes before use.
Makes two large pies."""
  ),
  List(
    Ingredient("Chestnut mushrooms", Some("250g"), Some("half sliced, half diced")),
    Ingredient("Spinach", None, Some("torn up")),
    Ingredient("Stilton", Some("250g"), Some("finely chopped")),
    Ingredient("Garlic", None, Some("finely chopped")),
    Ingredient("Butter", Some("knob")),
    Ingredient("Black pepper"),
    Ingredient("Puff pastry", Some("1 sheet"))
  ),
  List(
    "Preheat the oven at 200C.",
    "Melt the butter in wide pan.",
    "Cook the garlic and black pepper.",
    "Add the mushrooms and cook over a medium heat until softened. Add the spinach and wilt.",
    "Mix in the stilton.",
    "Meanwhile place the puff pastry on a chopping board and cut it in half along the short axis. For each half, score it in the middle along the short axis.",
    "Place a large spoonful of the mushroom mixture on one side of the scored pastries.",
    "Fold over the other half of the pasty and seal with a fork.",
    "Cut a slit in the top to allow steam to escape.",
    "Place the pies on a baking tray in the oven for 20 minutes or until golden brown."
  )
)
