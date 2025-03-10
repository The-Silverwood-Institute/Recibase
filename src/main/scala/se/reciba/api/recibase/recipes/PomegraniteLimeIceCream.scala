package se.reciba.api.recipes

import cats.implicits._
import se.reciba.api.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream,
  Permalink
}

case object PomegraniteLimeIceCream extends Recipe with IceCream {
  val name = "Pomegranite & Lime Ice Cream"

  override val permalink: Permalink =
    Permalink("pomegranite-lime-ice-cream")

  override val source: Option[String] = Some("Kit")

  override val notes: Option[String] = Some(
    s"""$genericNotes
        |
        |Kit tasting notes: A perfectly enjoyable but fairly tame flavour profile. At least compared to the weirder flavours I've made. I'm glad I added as much lime as I did because it provides a necessary punchy comparison to the subtler pomegranite. I should have used fresh lime juice and zest but I think I went shopping in a bit of a rush.""".stripMargin
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/pomegranite-lime-ice-cream.jpg")
  )

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient(
        "Pomegranite powder",
        "40g".some,
        None,
        "freeze dried, no added sugar".some
      ),
      Ingredient("Lime Juice", "2tsp")
    )
  )

  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese, pomegranite powder and lime juice. Gently stir in the powder to avoid it going everywhere.",
    "Continue whisking until thoroughly mixed."
  ) ++ genericMethodEnd
}
