package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe, Tag}

object BakedSalmonOlivesSpaghetti extends Recipe {
  val name = "Baked Salmon with Olives and Spaghetti"
  val permalink = "salmon-olive-spaghetti"

  override val description: Option[String] =
    Some("Baked salmon served on a bed of spaghetti, onions and olives.")
  override val notes: Option[String] =
    Some("Cover the baking tray in foil for easier cleaning later.")
  override val tags = Set(Tag.Pescatarian, Tag.HotWeather)

  val ingredients = List(
    Ingredient(
      "Salmon fillets",
      Some("1 per person"),
      None,
      Some("Approximately 1 inch wide")
    ),
    Ingredient("Capers", None, Some("finely chopped")),
    Ingredient("Olive oil"),
    Ingredient("Onion", "1", "sliced"),
    Ingredient("Pimento-stuffed olives"),
    Ingredient("Lemon juice"),
    Ingredient("Thyme", None, None, Some("Dried or fresh")),
    Ingredient("Spaghetti"),
    Ingredient("Cherry tomatoes", None, Some("halved"), Some("Optional"))
  )
  val method = List(
    "Preheat the oven at 160 C.",
    "Cook the spaghetti in a saucepan.",
    "Meanwhile, rub the salmon fillets with the olive oil, lemon juice and the chopped capers. Sprinkle with salt.",
    "Place in the oven and bake for 10-15 minutes or until cooked through. If you are unsure, check the thickest part of the salmon with a fork.",
    "Drain the spaghetti and set aside.",
    "In the same pan, heat a small amount of oil and cook the onions, leaving them softened but still crisp. Add the olives, tomatoes, thyme and lemon juice and warm.",
    "Add the spaghetti and toss. Keep warm.",
    "Serve the salmon fillets on top of the spaghetti mixture."
  )
}
