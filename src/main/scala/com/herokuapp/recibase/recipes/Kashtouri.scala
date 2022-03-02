package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe, Tag}

object Kashtouri extends Recipe {
  val name = "Kashtouri"
  val permalink = "kashtouri"

  override val source: Option[String] = Some(
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  )
  override val description: Option[String] = Some(
    "An Egyptian dish of rice, macaroni and lentils in a spicy tomato sauce."
  )
  override val tags = Set(Tag.Vegan, Tag.Scales, Tag.HotWeather, Tag.LowEffort)

  val ingredients = List(
    Ingredient("Risotto rice", "150g"),
    Ingredient("Macaroni", "150g"),
    Ingredient(
      "Red lentils",
      Some("150g"),
      None,
      Some("Or 1 400g tin green lentils")
    ),
    Ingredient("Onion", Some("1"), Some("finely chopped")),
    Ingredient("Garlic", None, Some("finely chopped or crushed")),
    Ingredient("Chopped tomatoes", "1 400g tin"),
    Ingredient("Cayenne pepper", Some("1-2 tsp")),
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
