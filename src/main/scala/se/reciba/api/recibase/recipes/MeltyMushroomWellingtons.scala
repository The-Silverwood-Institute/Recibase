package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object MeltyMushroomWellingtons extends Recipe {
  val name = "Melty Mushroom Wellingtons"

  override val notes: List[String] = List(
    "Take the pastry out of the fridge ten minutes before use.",
    "Makes two large pies."
  )
  val tags = Set(Tag.Slow, Tag.Vegetarian, Tag.Stodge, Tag.ColdWeather)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Chestnut mushrooms",
      Some("250g"),
      Some("half sliced, half diced")
    ),
    Ingredient("Spinach", None, Some("torn up")),
    Ingredient("Stilton", "220g", "finely chopped"),
    Ingredient("Garlic", None, Some("finely chopped")),
    Ingredient("Butter", "knob"),
    Ingredient("Black pepper"),
    Ingredient("Puff pastry", "1 sheet")
  )
  val method = List(
    s"Preheat the oven at ${200.celsius}.",
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
