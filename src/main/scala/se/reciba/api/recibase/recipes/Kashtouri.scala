package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object Kashtouri extends Recipe {
  val name = "Kashtouri"

  override val source: Option[String] = (
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  ).some
  override val description: Option[String] = (
    "An Egyptian dish of rice, macaroni and lentils in a spicy tomato sauce."
  ).some
  val tags = Set(Tag.Vegan, Tag.Scales, Tag.HotWeather, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Risotto rice", "150g"),
    Ingredient("Macaroni", "150g"),
    Ingredient(
      "Red lentils",
      "150g".some,
      None,
      "Or 1 400g tin green lentils".some
    ),
    Ingredient("Onion", "1".some, "finely chopped".some),
    Ingredient("Garlic", None, "finely chopped or crushed".some),
    Ingredient("Chopped tomatoes", "1 400g tin"),
    Ingredient("Cayenne pepper", "1-2 tsp".some),
    Ingredient("Ground coriander", "1 tsp"),
    Ingredient("Lemon juice"),
    Ingredient("Salt"),
    Ingredient("Black pepper")
  )
  val method = List(
    "Bring water to a boil and fill a large saucepan. Add the rice and simmer for 5 minutes.",
    "Add the macaroni and lentils and simmer for 10 minutes or until rice, macaroni and lentils are tender.",
    "Drain and set aside.",
    "Meanwhile, heat some oil in a large saucepan and cook onions and garlic until softened. Stir in cayenne pepper, coriander, chopped tomatoes and lemon juice. Add salt and pepper to taste.",
    "Simmer for 5-10 minutes, stirring occasionally.",
    "Add rice, macaroni and lentils to the mixture.",
    "Serve hot."
  )
}
