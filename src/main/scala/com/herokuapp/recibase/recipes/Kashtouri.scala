package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object Kashtouri extends
Recipe(
  "Kashtouri",
  "kashtouri",
  Some("An Egyptian dish of rice, macaroni and lentils in a spicy tomato sauce."),
  None,
  None,
  List(
    Ingredient("Risotto rice", Some("150g")),
    Ingredient("Macaroni", Some("150g")),
    Ingredient("Red lentils", Some("150g"), None, Some("Or 1 400g tin green lentils")),
    Ingredient("Onion", Some("1"), Some("finely chopped")),
    Ingredient("Garlic", None, Some("finely chopped or crushed")),
    Ingredient("Chopped tomatoes", Some("1 400g tin")),
    Ingredient("Cayenne pepper", Some("1-2 tsp")),
    Ingredient("Ground coriander", Some("1 tsp")),
    Ingredient("Lemon juice"),
    Ingredient("Salt"),
    Ingredient("Black pepper")
  ),
  List(
    "Bring water to a boil and fill a large saucepan. Add the rice and simmer for 5 minutes.",
    "Add the macaroni and lentils and simmer for 10 minutes or until rice, macaroni and lentils are tender.",
    "Drain and set aside.",
    "Meanwhile, heat some oil in a large saucepan and cook onions and garlic until softened. Stir in cayenne pepper, coriander, chopped tomatoes and lemon juice. Add salt and pepper to taste.",
    "Simmer for 5-10 minutes, stirring occasionally.",
    "Add rice, macaroni and lentils to the mixture.",
    "Serve hot."
  )
)
