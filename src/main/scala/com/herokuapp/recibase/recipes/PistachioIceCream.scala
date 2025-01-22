package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream
}

case object PistachioIceCream extends Recipe with IceCream {
  val name = "Pistachio Ice Cream"

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent Pistachio ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    s"""You can substitute pistachios for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |$genericNotes""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/pistachio-ice-cream.jpg")
  )

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
