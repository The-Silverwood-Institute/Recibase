package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Image, Ingredient, Recipe}

object MarmaladeIceCream {
  val recipe = Recipe(
    "Mascarpone Ice Cream",
    "mascarpone-ice-cream",
    Some("George"),
    Some("A simple yet decadent ice cream recipe, no churn needed."),
    Some("Don't eat too much at once..."),
    Some(
      "You can substitute marmalade for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain."
    ),
    List("pudding"),
    Some(Image("https://i.reciba.se/ice-cream.jpg")),
    List(
      Ingredient("Mascarpone", "230g"),
      Ingredient("Eggs", "2"),
      Ingredient("Icing Sugar", "60g"),
      Ingredient("Marmalade", Some("125g"), None, Some("any premium brand")),
      Ingredient("Vanilla Essence", "1 tsp")
    ),
    List(
      "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
      "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
      "Add the mascarpone cheese and marmalade and continue whisking until thoroughly mixed.",
      "Decant into a freezer suitable dish and freeze for at least 6 hours."
    )
  )
}
