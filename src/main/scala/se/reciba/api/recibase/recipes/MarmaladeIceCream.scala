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

case object MarmaladeIceCream extends Recipe with IceCream {
  val name = "Marmalade Ice Cream"

  override val source: Option[String] = "George".some
  override val description: Option[String] = (
    "A sweet and tart ice cream recipe, no churn needed."
  ).some
  override val notes: List[String] = List(
    "You can substitute marmalade for blackberries, cinnamon or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.",
    genericNotes
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/ice-cream.jpg")
  ).some

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient("Marmalade", "125g".some, None, "any premium brand".some)
    )
  )

  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and marmalade and continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd
}
