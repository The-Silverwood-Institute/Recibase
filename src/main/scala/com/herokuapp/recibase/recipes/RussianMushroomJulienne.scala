package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object RussianMushroomJulienne extends Recipe {
  val name = "Russian Mushroom Julienne"
  override val permalink: Permalink =
    Permalink.fromRawString("russian-mushroom-julienne")

  override val source: Option[String] = Some(
    "https://livelaughrowe.com/russian-dish-mushroom-julienne/"
  )
  override val tags = Set(Tag.Vegetarian, Tag.Stodge)

  val ingredients = List(
    Ingredient("Mushrooms", Some("250g"), Some("thinly sliced")),
    Ingredient("Onion", None, Some("thinly sliced")),
    Ingredient("White wine"),
    Ingredient("Sour cream", "150ml"),
    Ingredient("Double cream", "120ml"),
    Ingredient("Mozzarella cheese", Some("240g"), Some("roughly chopped")),
    Ingredient("Butter")
  )
  val method = List(
    "Preheat the oven to 190\u00b0C.",
    "In a medium pan, melt the butter then saute the mushrooms and onions on a medium heat, until they've given off liquid.",
    "Transfer the mixture to a medium casserole dish.",
    "Using the same pan, melt a knob of butter and add a slosh of white wine.",
    "Simmer on a medium heat for a couple of minutes, then stir in the double cream and sour cream.",
    "Bring it to boil and pour over the mushrooms. Stir the mixture.",
    "Sprinkle generously with cheese and bake for about 10 minutes (until the cheese is melted and starts to golden)."
  )
}
