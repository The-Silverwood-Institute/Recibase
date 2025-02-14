package se.reba.api.recibase.recipes

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

case object StrawberryBasilIceCream extends Recipe with IceCream {
  val name = "Strawberry, Basil & Black Pepper Ice Cream"

  override val permalink: Permalink =
    Permalink("strawberry-basil-ice-cream")

  override val source: Option[String] = Some("Kit")

  override val notes: Option[String] = Some(
    s"""$genericNotes
        |
        |I vibed the quantity of pepper. A few grinder twists wasn't enough so I added a healthy dose the second time. If I make this again I'll measure it in tsp.
        |
        |There was only 1/4tsp of vanilla essence left the first time I made this. I think 1/2-1tsp would work best.""".stripMargin
  )
  override val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/strawberry-basil-ice-cream.jpg")
  )

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient(
        "Strawberry powder",
        "12.5g".some,
        None,
        "freeze dried, no added sugar".some
      ),
      Ingredient("Fresh Basil", "15g"),
      Ingredient("Black pepper")
    )
  )

  val method = genericMethodStart ++ List(
    "Separate the basil leaves from their stems and put in a blender alongside a dollop of the mascarpone. Puree with a food blender.",
    "Add the basil puree and the remaining mascarpone to the whisked egg yolks. Grind in a large dose of black pepper.",
    "Mix in the strawberry powder enough that it won't spray everywhere, then whisk all the ingredients together."
  ) ++ genericMethodEnd
}
