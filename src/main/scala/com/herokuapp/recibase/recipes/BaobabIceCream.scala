package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Image, Ingredient, Recipe, Tag}

case object BaobabIceCream extends Recipe {
  val name = "Baobab Ice Cream"

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent zesty and tart ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    """It got very thick while mixing and was a bit flakey rather than soft so maybe try adding more egg yokes next time.
        |
        |You can substitute baobab for wasabi, marmalade or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |I tend to double up this recipe to make enough for a few days.
        |
        |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.
        |
        |Tasting notes: Flavour is sweet with a sparkling sharpness that was zesty but with a starchy depth.
        |
        |Stephani says: It has a citrus type flavour but with a bready depth, like a very meaty fruit instead of normal citrus fruit texture.""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/baobab-ice-cream.jpg")
  )

  val ingredients = List(
    Ingredient("Mascarpone", "230g"),
    Ingredient("Eggs", "2"),
    Ingredient("Icing Sugar", "60g"),
    Ingredient("Baobab powder", "20g")
  )
  val method = List(
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour.",
    "Add the mascarpone cheese and baobab powder. Gently stir in the powder to avoid it going everywhere.",
    "Continue whisking until thoroughly mixed.",
    "Decant into a freezer suitable dish and freeze for at least 6 hours."
  )
}
