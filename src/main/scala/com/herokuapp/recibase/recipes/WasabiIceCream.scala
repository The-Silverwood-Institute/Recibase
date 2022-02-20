package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Image, Ingredient, Recipe}

object WasabiIceCream extends Recipe {
  val name = "WasabiIceCream Ice Cream"
  val url = "wasabi-ice-cream"

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent spicy ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    """You can substitute wasabi for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |I tend to double up this recipe to make enough for a few days.""".stripMargin
  )
  override val tags = List("pudding")
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/wasabi-ice-cream.jpg")
  )

  val ingredients = List(
    Ingredient("Mascarpone", "230g"),
    Ingredient("Eggs", "2"),
    Ingredient("Icing Sugar", "60g"),
    Ingredient("WasabiIceCream paste", "2 tsp"),
    Ingredient(
      "Green food colouring",
      Some("1/2 tsp"),
      None,
      Some("optional")
    )
  )
  val method = List(
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
    "Add the mascarpone cheese and food colouring, then continue whisking.",
    "Add the wasabi, one teaspon at a time. Whisk thoroughly and taste each time. This makes for a hot flavour, so you may only need 1.",
    "Decant into a freezer suitable dish and freeze for at least 6 hours."
  )
}
