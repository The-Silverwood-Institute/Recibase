package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object SweetChilliFetaPasta extends Recipe {
  val name = "Sweet chilli feta pasta"

  override val notes: Option[String] = Some(
    """Try to find large bottles of sweet chilli sauce. You can get about a litre for the same price as one of the tiny bottles. This recipe needs quite a bit.
There are basically no quantities. Add what seems right."""
  )
  val tags = Set(Tag.Quick, Tag.Vegetarian, Tag.Scales, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Pine nuts"),
    Ingredient("Cashew nuts"),
    Ingredient("Brazil nuts"),
    Ingredient(
      "Feta",
      Some("1 block, approx. 200g"),
      Some("cut into 1cm cubes")
    ),
    Ingredient(
      "Tuna chunks",
      Some("1 80g tin"),
      Some("drained"),
      Some("Optional")
    ),
    Ingredient("Sweet chilli sauce"),
    Ingredient("Black pepper"),
    Ingredient(
      "Fusilli",
      None,
      None,
      Some("Spaghetti also works well here")
    )
  )
  val method = List(
    "Boil water and cook the pasta until al dente or softer. Drain and set aside.",
    "Meanwhile, add oil to a large, deep pan along with the pine, cashew and brazil nuts and roast over a high heat until brown.",
    "Remove pan from the heat and allow to cool for a moment. Add half the feta to the pan and melt over a medium heat.",
    "Add the tuna (if used), black pepper and sweet chilli sauce to the pan and warm.",
    "Add the pasta and remaining feta and mix thoroughly.",
    "Serve hot."
  )
}
