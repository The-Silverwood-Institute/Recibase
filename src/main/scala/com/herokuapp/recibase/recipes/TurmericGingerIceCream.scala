package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Image, Ingredient, Recipe, Tag}

case object TurmericGingerIceCream extends Recipe {
  val name = "Turmeric & Ginger Ice Cream"

  override val source: Option[String] = Some(
    "https://www.sugarlovespices.com/turmeric-ginger-honey-no-churn-ice-cream/"
  )
  override val description: Option[String] = Some(
    "A rich, spicy and earthy ice cream. No churn needed."
  )
  override val notes: Option[String] = Some(
    """The spice mix isn't set in stone. Taste test the mixture before freezing and adjust according to preference.
      |
      |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/ice-cream.jpg")
  )

  val ingredients = List(
    Ingredient("Mascarpone", "460g"),
    Ingredient("Eggs", "4"),
    Ingredient("Icing Sugar", "120g"),
    Ingredient("Honey", "1-2 tbsp"),
    Ingredient("Turmeric", "1 1/2 tsp"),
    Ingredient("Fresh Ginger", "1 tsp", "minced"),
    Ingredient("Vanilla Extract", "1/2 tsp"),
    Ingredient("Cardamon", "1/2 tsp", "remove the pods and grind the seeds"),
    Ingredient("Cinnamon", "1 tsp"),
    Ingredient("Chilli Powder", "a pinch")
  )
  val method = List(
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
    "Add the mascarpone cheese then continue whisking.",
    "Gently stir in all the remaining ingredients, to avoid aerosolising the powdered spices.",
    "Whisk until thoroughly mixed.",
    "Decant into a freezer suitable dish and freeze for at least 6 hours."
  )
}
