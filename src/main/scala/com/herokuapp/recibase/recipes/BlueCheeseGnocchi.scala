package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object BlueCheeseGnocchi extends
Recipe(
  "Blue Cheese Gnocchi",
  "blue-cheese-gnocchi",
  Some("Gnocchi with creme fraiche and spinach topped with grilled blue stilton."),
  Some("Fill the void with cheese"),
  Some(
    "You can also use fresh tagliatelle rather than gnocchi, although you'll need a lot more creme fraiche."
  ),
  List(
    Ingredient("Gnocchi", Some("500g")),
    Ingredient("Parmesan", Some("~70g"), Some("grated")),
    Ingredient("Creme Fraiche", Some("150ml")),
    Ingredient("Spinach", Some("200g")),
    Ingredient("Stilton", Some("200g"), Some("diced/crumbled")),
    Ingredient("Pimento Stuffed olives", None, None, Some("Optional")),
    Ingredient("Cherry Tomatoes", None, None, Some("Optional")),
    Ingredient("Fresh bread", None, None, Some("Optional"))
  ),
  List(
    "Tear up the spinach into a colander",
    "Place the ghocchi in a pan of boiling water and simmer until the gnocchi start to float to the surface",
    "Throw the torn spinach into the pan then drain immediately",
    "Empty the gnocchi/spinach into an ovenproof dish and mix in the parmesan and creme fraiche",
    "Sprinkle crumbled stilton over the top",
    "Grill on a medium/high heat until the stilton is bubbling and golden",
    "Serve on fresh bread with cherry tomatoes, olives, and anything else you can think of."
  )
)
