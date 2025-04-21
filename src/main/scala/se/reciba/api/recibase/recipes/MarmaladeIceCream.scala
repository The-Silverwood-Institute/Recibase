package se.reciba.api.recipes

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

  override val source: Option[String] = Some("George")
  override val description: Option[String] = Some(
    "A sweet and tart ice cream recipe, no churn needed."
  )
  override val notes: List[String] = List(
    s"""You can substitute marmalade for blackberries, cinnamon or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |$genericNotes""".stripMargin
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/ice-cream.jpg")
  )

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient("Marmalade", Some("125g"), None, Some("any premium brand"))
    )
  )

  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and marmalade and continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd
}
