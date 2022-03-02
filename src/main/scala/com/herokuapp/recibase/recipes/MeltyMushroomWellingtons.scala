package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

object MeltyMushroomWellingtons extends Recipe {
  val name = "Melty Mushroom Wellingtons"
  val permalink = "melty-mushroom-wellingtons"

  override val notes: Option[String] = Some(
    """Take the pastry out of the fridge ten minutes before use.
Makes two large pies."""
  )
  override val tags = Set(Tag.Slow, Tag.Vegetarian, Tag.Stodge, Tag.ColdWeather)

  val ingredients = List(
    Ingredient(
      "Chestnut mushrooms",
      Some("250g"),
      Some("half sliced, half diced")
    ),
    Ingredient("Spinach", None, Some("torn up")),
    Ingredient("Stilton", "250g", "finely chopped"),
    Ingredient("Garlic", None, Some("finely chopped")),
    Ingredient("Butter", "knob"),
    Ingredient("Black pepper"),
    Ingredient("Puff pastry", "1 sheet")
  )
  val method = List(
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
}
