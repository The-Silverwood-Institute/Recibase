package se.reciba.api.recipes

import se.reciba.api.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream
}

case object MascarponeIceCream extends Recipe with IceCream {
  val name = "Mascarpone Ice Cream"

  override val tagline: Option[String] = Some("Don't eat too much at once...")

  override val source: Option[String] = Some("George")
  override val description: Option[String] = Some(
    "A simple yet decadent ice cream recipe, no churn needed."
  )

  override val notes: Option[String] = Some(
    s"""You can substitute marmalade for blackberries, cinnamon or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |$genericNotes""".stripMargin
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/ice-cream.jpg")
  )

  val ingredientsBlocks = List(
    genericIngredients.copy(ingredients =
      genericIngredients.ingredients :+ Ingredient("Vanilla Essence", "1 tsp")
    )
  )

  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd

}
