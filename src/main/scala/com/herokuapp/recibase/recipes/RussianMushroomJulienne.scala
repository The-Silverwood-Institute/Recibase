package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object RussianMushroomJulienne extends Recipe {
  val name = "Russian Mushroom Julienne"

  override val source: Option[String] = Some(
    "https://livelaughrowe.com/russian-dish-mushroom-julienne/"
  )
  override val tags = Set(Tag.Vegetarian, Tag.Stodge)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Mushrooms", Some("250g"), Some("thinly sliced")),
    Ingredient("Onion", None, Some("thinly sliced")),
    Ingredient("White wine"),
    Ingredient("Soured cream", "150ml"),
    Ingredient("Double cream", "120ml"),
    Ingredient("Mozzarella cheese", Some("240g"), Some("roughly chopped")),
    Ingredient("Butter")
  )
  val method = List(
    "Preheat the oven to 190\u00b0C.",
    "In a medium pan, melt the butter then saute the mushrooms and onions on a medium heat, until they've given off liquid.",
    "Transfer the mixture to a medium casserole dish.",
    "Using the same pan, melt a knob of butter and add a slosh of white wine.",
    "Simmer on a medium heat for a couple of minutes, then stir in the double cream and soured cream.",
    "Bring it to boil and pour over the mushrooms. Stir the mixture.",
    "Sprinkle generously with cheese and bake for about 10 minutes (until the cheese is melted and starts to golden)."
  )
}
