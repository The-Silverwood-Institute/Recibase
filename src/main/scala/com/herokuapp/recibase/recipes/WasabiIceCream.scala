package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Image, Ingredient, Recipe}

object Wasabi {
  val recipe = Recipe(
    "Wasabi Ice Cream",
    "wasabi-ice-cream",
    Some("Kit"),
    Some("A simple yet decadent hot ice cream recipe, no churn needed."),
    None,
    Some(
      """You can substitute wasabi for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |I tend to double up this recipe to make enough for a few days.""".stripMargin
    ),
    List("pudding"),
    Some(Image("https://i.reciba.se/ice-cream.jpg")),
    List(
      Ingredient("Mascarpone", "230g"),
      Ingredient("Eggs", "2"),
      Ingredient("Icing Sugar", "60g"),
      Ingredient("Wasabi paste", "2 tsp"),
      Ingredient(
        "Green food colouring",
        Some("1/2 tsp"),
        None,
        Some("optional")
      )
    ),
    List(
      "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
      "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
      "Add the mascarpone cheese and food colouring, then continue whisking.",
      "Add the wasabi, one teaspon at a time. Whisk thoroughly and taste each time. You may need more or less, depending on preference.",
      "Decant into a freezer suitable dish and freeze for at least 6 hours."
    )
  )
}
