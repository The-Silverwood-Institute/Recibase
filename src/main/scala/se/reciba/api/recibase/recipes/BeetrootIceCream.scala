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

case object BeetrootIceCream extends Recipe with IceCream {
  val name = "Beetroot Ice Cream"

  override val source: Option[String] = "Kit".some
  override val description: Option[String] = (
    "A simple yet decadent earthy ice cream recipe, no churn needed."
  ).some
  override val notes: List[String] = List(
    "Consider adding a dash of lime to balance the beetroot flavour.",
    "You can substitute beetroot for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.",
    genericNotes
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/beetroot-ice-cream.jpg")
  ).some

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(Ingredient("Beetroot Powder", "25g"))
  )
  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and beetroot powder. Gently stir in the powder to avoid it going everywhere.",
    "Continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd
}
