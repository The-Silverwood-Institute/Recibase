package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object BakedRigatoniAubergine extends
Recipe(
  "Baked Rigatoni with Aubergine",
  "baked-rigatoni-aubergine",
  None,
  None,
  Some("Traditional parmesan is not vegetarian"),
  List(
    Ingredient("Onion", Some("1"), Some("chopped")),
    Ingredient("Garlic", Some("2-3 cloves"), Some("finely chopped or crushed")),
    Ingredient("Red wine"),
    Ingredient("Chopped tomatoes", Some("2 400g tins")),
    Ingredient("Sun-dried tomatoes", Some("5"), Some("drained and chopped.")),
    Ingredient("Aubergine", Some("1"), Some("cut into 1cm cubes")),
    Ingredient("Oregano", Some("2 tbsp"), Some("chopped"), Some("Fresh or dried")),
    Ingredient("Rigatoni", Some("225g"), None, Some("Or penne or other chunky pasta tube")),
    Ingredient("Breadcrumbs", Some("30g")),
    Ingredient("Parmesan", Some("30g"), None, Some("Or a ball of mozzarella")),
    Ingredient("Salt"),
    Ingredient("Pepper")
  ),
  List(
    "Preheat the oven to 200 C (400 F, gas mark 6).",
    "Heat oil or butter in a saucepan. Add the onion and garlic and cook until soft.",
    "Add the wine, followed by the tins of chopped tomatoes, the sun-dried tomatoes, aubergine, oregano, salt and pepper.",
    "Bring to the boil, cover and simmer for 15-20 minutes.",
    "Cook the pasta until al dente. Drain well.",
    "Tip the pasta and sauce into an suitable ovenproof dish. Mix together thoroughly.",
    "Cover with the breadcrumbs and parmesan (or mozzarella).",
    "Bake for 15-20 minutes until bubbling and the top is golden brown."
  )
)
