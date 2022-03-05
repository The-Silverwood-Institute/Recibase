package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

case object Mead extends Recipe {
  val name = "Mead"
  val permalink = "mead"

  override val source: Option[String] = Some(
    "https://www.diynatural.com/homemade-mead-honey-mead-recipe/"
  )
  override val tagline: Option[String] = Some("A medieval classic")
  override val notes: Option[String] = Some(
    """This recipe requires a large pan, 2 ~1L flip top bottles, funnel, airlock and rubber bung.Sterilise all equipment before use to avoid comtaminating your mead.
        |
        |I'd recommend doubling or tripling the quantities to make this worth the effort.""".stripMargin
  )
  override val tags = Set(Tag.NonMeal)

  val ingredients = List(
    Ingredient(
      "Honey",
      Some("340g"),
      None,
      Some("A premium, ideally local, brand")
    ),
    Ingredient("Tap Water", "416ml"),
    Ingredient("Boiling Water", "630ml"),
    Ingredient("Champagne Yeast", "1/3 tsp")
  )
  val method = List(
    "Pour the honey and boiling water into a large pan. Use some of the water to carefully rinse out the jar.",
    "Turn up the heat and bring to just below boiling.",
    "Turn down the heat and simmer for 30 minutes, stirring frequently. Skim off any scum that forms.",
    "Turn off the heat and leave to cool until it reaches 40C.",
    "Pour into your bottle using the funnel then leave to cool until 32C.",
    "Add the yeast, cap the bottle, and shake thoroughly.",
    "Top up the bottle with tap water, leaving a few inches headroom to allow for bubbling.",
    "Fix the bung and airlock to the bottle, then add some water to the airlock.",
    "Leave in a cool, dark, location for 6 weeks.",
    "Remove the airlock and bung then refrigerate for one week. This will settle out the yeast.",
    "Transfer to another bottle, pouring carefully as to leave behind the yeasty sediment."
  )
}
