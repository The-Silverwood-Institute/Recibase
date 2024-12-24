package com.herokuapp.recibase.recipes

import cats.syntax.all._
import com.herokuapp.recibase.IntUtils._

import com.herokuapp.recibase.model.{
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  Image
}

case object DukatenCookies extends Recipe {
  override val name: String = "Dukaten Cookies"

  override val source: Option[String] = Some(
    "Stephani"
  )

  override val description: Option[String] = Some(
    "Dukatenplätzchen, rum flavoured German Christmas cookies"
  )

  override val notes: Option[String] = Some(
    "If you don't have a small enough biscuit cutter you can use some wider shot glasses. The cookies should have a 4cm diameter."
  )

  override val tags = Set(Tag.Pudding, Tag.Baking)

  val ingredientsBlocks = List(
    IngredientsBlock(
      "Buscuits".some,
      List(
        Ingredient("Flour", "250g"),
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
        Ingredient(
          "Cocoa",
          "1 spoon".some,
          None,
          "use a large serving spoon".some
        ),
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
          "1 spoon".some,
          None,
          "use a large serving spoon".some
        ),
        Ingredient("Water", "1-2 tbsp".some, "hot".some, None),
        Ingredient("Butter", "1 tbsp".some, "melted".some)
      )
    )
  )

  override val method: List[String] = List(
    s"Pre-heat the oven to ${190.celius}",
    "Rub a large baking tray with butter or margarine.",
    "Combine all the buscuit ingredients in order.",
    "Mix together then knead until smooth.",
    "Roll out thin and cut into 4cm circles.",
    "Lay out on the baking tray and bake for 10 minutes or until a light golden colour.",
    "Put to one side to cool.",
    "While the buscuits are baking you can also make the filling and frosting:",
    "Make the filling by combining all the ingredients with a food mixer.",
    "Make the frosting by mixing all the ingredients until smooth",
    "Once the buscuits are cool lay out half of them on a sheet of baking paper. Leave room between the buscuits and the edge for the frosting to ooze.",
    "Place a drop of the filling on top of each buscuit then flatten the mixture by placing down another buscuit on top.",
    "Once all the buscuits are filled drizzle the frosting over one side of each biscuit.",
    "Transfer the buscuits to the fridge to set the frosting and filling."
  )
}
