package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object MushroomRisotto extends Recipe {
  val name = "Mushroom Risotto"

  val tags = Set(Tag.Vegetarian, Tag.LowEffort, Tag.Quick)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Chestnut mushrooms", "250g".some, "sliced".some),
    Ingredient(
      "Dried mushrooms",
      "handful".some,
      None,
      "Porcini, shiitake, wild, etc".some
    ),
    Ingredient("Arborio rice", "1 cup"),
    Ingredient("White wine", "A decent slosh"),
    Ingredient("Black pepper"),
    Ingredient("Stock cube", "1"),
    Ingredient(
      "Water",
      "700ml".some,
      "boiling".some,
      "Might need to add more".some
    ),
    Ingredient("Stilton", "100g"),
    Ingredient("Butter", "knob")
  )
  val method = List(
    "Dissolve the stock cube in the boiling water and add the dried mushrooms, wine and black pepper.",
    "Melt the butter in a wide pan and cook the mushrooms over a medium heat.",
    "Remove from the pan and set aside.",
    "Add the arborio rice to your pan with a small amount of butter and toast for 30 seconds.",
    "Gradually stir in the stock, mixing often. Only add more stock when the rice has absorbed the previous lot of stock.",
    "When the rice is tender, add the mushrooms and mix thoroughly.",
    "Mix in the stilton and allow it to melt through the risotto."
  )
}
