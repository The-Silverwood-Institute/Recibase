package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream
}

case object WasabiIceCream extends Recipe with IceCream {
  val name = "Wasabi Ice Cream"

  override val source: Option[String] = Some("Kit")
  override val description: Option[String] = Some(
    "A simple yet decadent spicy ice cream recipe, no churn needed."
  )
  override val notes: Option[String] = Some(
    s"""You can substitute wasabi for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.
        |
        |$genericNotes""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/wasabi-ice-cream.jpg")
  )

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient("Wasabi paste", "2 tsp"),
      Ingredient(
        "Green food colouring",
        Some("1/2 tsp"),
        None,
        Some("optional")
      )
    )
  )
  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and food colouring, then continue whisking.",
    "Add the wasabi, one teaspon at a time. Whisk thoroughly and taste each time. This makes for a hot flavour, so you may only need 1."
  ) ++ genericMethodEnd
}
