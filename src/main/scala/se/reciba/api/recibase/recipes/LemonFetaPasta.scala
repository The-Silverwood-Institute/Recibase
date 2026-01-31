package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object LemonFetaPasta extends Recipe {
  val name = "Lemon Feta Pasta"

  val tags = Set(Tag.Quick, Tag.Pescatarian, Tag.LowEffort, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Pine nuts"),
    Ingredient("Cashew nuts"),
    Ingredient("Brazil nuts"),
    Ingredient(
      "Feta",
      "1 block, approx. 200g".some,
      "cut into 1cm cubes".some
    ),
    Ingredient(
      "Tuna",
      "1 80g tin".some,
      "drained".some,
      "Optional".some
    ),
    Ingredient("Olives", None, None, "Pimento or green preferred".some),
    Ingredient("Lemon juice", None, None, "Either fresh or bottled".some),
    Ingredient("Thyme", None, None, "Either fresh or dried".some),
    Ingredient(
      "Fusilli",
      None,
      None,
      "Spaghetti also works well here".some
    )
  )
  val method = List(
    "Boil water and cook the pasta until al dente or softer. Drain and set aside.",
    "Meanwhile, add oil to a large, deep pan along with the pine, cashew and brazil nuts and roast over a high heat until brown.",
    "Remove pan from the heat and allow to cool for a moment. Add half the feta to the pan and melt over a medium heat.",
    "Add the tuna (if used), thyme, olives and lemon juice to the pan and warm.",
    "Add the pasta and remaining feta and mix thoroughly.",
    "Serve hot."
  )
}
