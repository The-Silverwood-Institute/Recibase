package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock
}

case object MarmaladeIceCream extends Recipe {
  val name = "Mascarpone Ice Cream"

  override val source: Option[String] = Some("George")
  override val description: Option[String] = Some(
    "A simple yet decadent ice cream recipe, no churn needed."
  )
  override val tagline: Option[String] = Some("Don't eat too much at once...")
  override val notes: Option[String] = Some(
    """You can substitute marmalade for blackberries, cinnamon or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |I tend to double up this recipe to make enough for a few days.
        |
        |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/ice-cream.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Mascarpone", "230g"),
    Ingredient("Eggs", "2"),
    Ingredient("Icing Sugar", "60g"),
    Ingredient("Marmalade", Some("125g"), None, Some("any premium brand")),
    Ingredient("Vanilla Essence", "1 tsp")
  )
  val method = List(
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
    "Add the mascarpone cheese and marmalade and continue whisking until thoroughly mixed.",
    "Decant into a freezer suitable dish and freeze for at least 6 hours."
  )
}
