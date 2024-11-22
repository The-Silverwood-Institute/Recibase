package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock
}

case object PistachioIceCream extends Recipe {
  val name = "Pistachio Ice Cream"

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent Pistachio ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    """You can substitute pistachios for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |I tend to double up this recipe to make enough for a few days.
        |
        |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/pistachio-ice-cream.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Mascarpone", "230g"),
    Ingredient("Eggs", "2"),
    Ingredient("Icing Sugar", "60g"),
    Ingredient("Pistachios", "175g")
  )
  val method = List(
    "Crush or blend the pistachios to form a paste. Consider setting aside 3-4 pistachios as a garnish.",
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
    "Add the mascarpone cheese and pistachios, then continue whisking.",
    "Decant into a freezer suitable dish, garnish with the remaining pistachios, then freeze for at least 6 hours."
  )
}
