package se.reciba.api.recipes

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

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent earthy ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    s"""Consider adding a dash of lime to balance the beetroot flavour.
        |
        |You can substitute beetroot for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |$genericNotes""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/beetroot-ice-cream.jpg")
  )

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(Ingredient("Beetroot Powder", "25g"))
  )
  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and beetroot powder. Gently stir in the powder to avoid it going everywhere.",
    "Continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd
}
