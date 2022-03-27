package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model._

case object BeetrootRisotto extends Recipe {
  val name =
    "Roast Beetroot Risotto"
  override val permalink: Permalink =
    Permalink("beetroot-risotto")

  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/beetroot-risotto.jpg")
  )
  override val tags = Set(Tag.Vegetarian, Tag.Slow, Tag.HotWeather)

  val ingredients = List(
    Ingredient(
      "Beetroot",
      Some("5"),
      Some("peeled and cut into 1-2cm pieces"),
      Some("Quantity is approximate")
    ),
    Ingredient("Arborio rice", "1 cup"),
    Ingredient("White wine", "A decent slosh"),
    Ingredient("Thyme"),
    Ingredient("Stock cube", "1"),
    Ingredient(
      "Water",
      Some("700ml"),
      Some("boiling"),
      Some("Might need to add more")
    ),
    Ingredient("Soft Goats Cheese")
  )
  val method = List(
    "Preheat the oven to 200C.",
    "Place the peeled beetroot on a baking tray, drizzle with oil and put in the oven for twenty minutes or until soft.",
    "If the beetroot came with stems and leaves, cut these into small pieces and set aside.",
    "Dissolve the stock cube in the boiling water and add the wine and thyme.",
    "Put the arborio rice in a pan over a medium heat and gradually stir in the stock, mixing often and not adding more until the previous lot of water has been absorbed.",
    "About half-way through making the rice, add the beetroot stalks and leaves to the rice pan.",
    "When the rice is tender, add the beetroot and mix thoroughly.",
    "Mix in the goats cheese."
  )
}
