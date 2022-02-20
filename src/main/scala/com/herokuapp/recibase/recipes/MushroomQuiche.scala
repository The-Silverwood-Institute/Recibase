package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object MushroomQuiche extends Recipe {
  val name = "Mushroom Quiche"
  val url = "mushroom-quiche"

  override val notes: Option[String] = Some(
    "Take the pastry out of the fridge 40 mins before use!"
  )

  val ingredients = List(
    Ingredient("Chestnut mushrooms", "250g", "sliced"),
    Ingredient(
      "Dried mushrooms",
      Some("handful"),
      None,
      Some("Porcini, shiitake, wild, etc")
    ),
    Ingredient("Red onion", "1", "sliced"),
    Ingredient("Parmesan", None, Some("Grated")),
    Ingredient("Mascarpone", "2 tbsp"),
    Ingredient("Eggs", "2"),
    Ingredient("Salt"),
    Ingredient("Black pepper"),
    Ingredient("Wholegrain Mustard", "2 tsp"),
    Ingredient("Shortcrust pastry sheet", "230g")
  )
  val method = List(
    "Place the dried mushrooms in a small amount of boiling water to rehydrate.",
    "Add some oil to a wide pan and soften the onion.",
    "Add the mushrooms to the pan and cook until soft.",
    "Add the mascarpone, eggs, mustard, salt and black pepper to a mixing bowl and beat together.",
    "Add the mushroom mixture and dried mushrooms to the mixing bowl, including the water used to rehydrate the mushrooms if desired.",
    "Place the pastry in a 9 inch flan dish, rerolling it if necessary.",
    "Pour the mixture into the dish and top with the grated parmesan.",
    "Bake in the oven at 200C/gas 6 for 20 minutes."
  )
}
