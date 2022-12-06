package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Image, Ingredient, Recipe, Tag}

case object BeetrootIceCream extends Recipe {
  val name = "Beetroot Ice Cream"

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent earthy ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    """You can substitute beetroot for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |I tend to double up this recipe to make enough for a few days.
        |
        |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/beetroot-ice-cream.jpg")
  )

  val ingredients = List(
    Ingredient("Mascarpone", "230g"),
    Ingredient("Eggs", "2"),
    Ingredient("Icing Sugar", "60g"),
    Ingredient("Beetroot Powder", "25g")
  )
  val method = List(
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
    "Add the mascarpone cheese and beetroot powder. Gently stir in the powder to avoid it going everywhere.",
    "Continue whisking until thoroughly mixed.",
    "Decant into a freezer suitable dish and freeze for at least 6 hours."
  )
}
