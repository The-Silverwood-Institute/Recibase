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

case object PistachioIceCream extends Recipe with IceCream {
  val name = "Pistachio Ice Cream"

  override val source: Option[String] = "Kit".some
  override val description: Option[String] = (
    "A simple yet decadent Pistachio ice cream recipe, no churn needed."
  ).some
  override val notes: List[String] = List(
    "You can substitute pistachios for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.",
    genericNotes
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/pistachio-ice-cream.jpg")
  ).some

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(Ingredient("Pistachios", "175g"))
  )
  val method = List(
    "Crush or blend the pistachios to form a paste. Consider setting aside 3-4 pistachios as a garnish."
  ) ++ genericMethodStart ++ List(
    "Add the mascarpone cheese and pistachios, then continue whisking.",
    "Decant into a freezer suitable dish, garnish with the remaining pistachios, then freeze for at least 6 hours."
  )
}
