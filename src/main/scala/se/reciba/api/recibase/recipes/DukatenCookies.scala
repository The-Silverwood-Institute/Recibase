package se.reciba.api.recipes

import cats.syntax.all._
import se.reciba.api.utils.IntUtils.TemperatureUtils

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock, Image}

case object DukatenCookies extends Recipe {
  override val name: String = "Dukaten Cookies"

  override val source: Option[String] = Some(
    "Stephani"
  )

  override val description: Option[String] = Some(
    "Dukatenplätzchen, rum flavoured German Christmas cookies"
  )

  override val notes: List[String] = List(
    "If you don't have a small enough biscuit cutter you can use some wider shot glasses. The cookies should have a 4cm diameter."
  )

  val tags = Set(Tag.Pudding, Tag.Baking)

  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/dukaten-cookies.jpg")
  )

  val ingredientsBlocks = List(
    IngredientsBlock(
      "Biscuits".some,
      List(
        Ingredient("Plain Flour", "250g"),
        Ingredient("Baking Powder", "1tsp"),
        Ingredient("Sugar", "75g"),
        Ingredient("Vanilla Extract", "1/2 tsp"),
        Ingredient("Egg", "1"),
        Ingredient(
          "Milk",
          "1 tbsp".some,
          None,
          "or more if the mixture is too dry".some
        ),
        Ingredient("Butter", "125g".some, None, "or margarine".some)
      )
    ),
    IngredientsBlock(
      "Filling".some,
      List(
        Ingredient("Butter", "125g"),
        Ingredient("Icing Sugar", "130g"),
        Ingredient("Cocoa", "1 heaped tablespoon"),
        Ingredient("Rum flavouring", "1 top"),
        Ingredient("Egg", "1")
      )
    ),
    IngredientsBlock(
      "Frosting".some,
      List(
        Ingredient("Powdered Sugar", "100g"),
        Ingredient(
          "Cocoa",
          "1 heaped tablespoon".some,
          None,
          "not a measuring spoon"
        ),
        Ingredient("Water", "1-2 tbsp".some, "hot".some, None),
        Ingredient("Butter", "28g".some, "melted".some)
      )
    )
  )

  override val method: List[String] = List(
    s"Pre-heat the oven to ${190.celsius}",
    "Rub a large baking tray with butter or margarine.",
    "Combine all the biscuit ingredients in order.",
    "Mix together then knead until smooth. If the mixture is too soft then put it in the fridge or freezer for a moment.",
    "Roll out thin and cut into 4cm circles.",
    "Lay out on the baking tray and bake for 10 minutes or until a light golden colour.",
    "Put to one side to cool.",
    "While the biscuits are baking you can also make the filling and frosting:",
    "Make the filling by combining all the ingredients with a food mixer.",
    "Make the frosting by mixing all the ingredients until smooth",
    "Once the biscuits are cool lay out half of them on a sheet of baking paper. Leave room between the biscuits and the edge for the frosting to ooze.",
    "Place a drop of the filling on top of each biscuit then flatten the mixture by placing down another biscuit on top.",
    "Once all the biscuits are filled drizzle the frosting over one side of each biscuit.",
    "Transfer the biscuits to the fridge to set the frosting and filling."
  )
}
