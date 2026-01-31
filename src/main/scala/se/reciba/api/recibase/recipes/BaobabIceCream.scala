package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream
}

case object BaobabIceCream extends Recipe with IceCream {
  val name = "Baobab Ice Cream"

  override val source: Option[String] = "Kit".some
  override val description: Option[String] = (
    "A simple yet decadent zesty and tart ice cream recipe, no churn needed."
  ).some
  override val notes: List[String] = List(
    "It got very thick while mixing and was a bit flakey rather than soft so maybe try adding more egg yokes next time.",
    "You can substitute baobab for wasabi, marmalade or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.",
    genericNotes,
    "Tasting notes: Flavour is sweet with a sparkling sharpness that was zesty but with a starchy depth.",
    "Stephani says: It has a citrus type flavour but with a bready depth, like a very meaty fruit instead of normal citrus fruit texture."
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/baobab-ice-cream.jpg")
  ).some

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(Ingredient("Baobab powder", "20g"))
  )

  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and baobab powder. Gently stir in the powder to avoid it going everywhere.",
    "Continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd
}
