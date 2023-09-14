package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object VegetarianMexican extends Recipe {
  val name = "Simple Vegetarian Mexican"
  override val permalink: Permalink =
    Permalink("vegetarian-mexican")

  override val description: Option[String] =
    Some("Low spoons vegetarian Mexican")

  override val tags = Set(Tag.Vegetarian, Tag.LowEffort, Tag.Stephani)

  val ingredients = List(
    Ingredient("Black Beans", Some("2 tins"), Some("drained")),
    Ingredient("Frozen sweetcorn", "260g"),
    Ingredient("Squash", "1"),
    Ingredient("Garlic", None, Some("finely chopped")),
    Ingredient("Tortillas"),
    Ingredient("Cinnamon"),
    Ingredient("Cumin"),
    Ingredient("Salt")
  )
  val method = List(
    "Preheat the oven to 200 C (400 F, gas mark 6).",
    "Peel the squash and chop into 2cm chunks.",
    "Spread on a baking tray and mix with oil, cinnamon and cumin. Roast for 35 minutes.",
    "Defrost the sweetcorn then combine in a large bowl with the black beans and garlic.",
    "Once roasted, add the squash to the bowl. Taste and add salt or more spices.",
    "Serve with tortillas"
  )
}
