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

case object WasabiIceCream extends Recipe with IceCream {
  val name = "Wasabi Ice Cream"

  override val source: Option[String] = "Kit".some
  override val description: Option[String] = (
    "A simple yet decadent spicy ice cream recipe, no churn needed."
  ).some
  override val notes: List[String] = List(
    "You can substitute wasabi for blackberries or any ingredient you fancy. Just be careful not to choose anything too watery, or you'll get ice crystals forming. It's also lovely plain.",
    genericNotes
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/wasabi-ice-cream.jpg")
  ).some

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient("Wasabi paste", "2 tsp"),
      Ingredient(
        "Green food colouring",
        "1/2 tsp".some,
        None,
        "optional".some
      )
    )
  )
  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese and food colouring, then continue whisking.",
    "Add the wasabi, one teaspon at a time. Whisk thoroughly and taste each time. This makes for a hot flavour, so you may only need 1."
  ) ++ genericMethodEnd
}
