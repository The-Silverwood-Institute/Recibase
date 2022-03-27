package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object BlueCheeseGnocchi extends Recipe {
  val name =
    "Blue Cheese Gnocchi"
  override val permalink: Permalink =
    Permalink.fromRawString("blue-cheese-gnocchi")

  override val description: Option[String] =
    Some(
      "Gnocchi with creme fraiche and spinach topped with grilled blue stilton."
    )
  override val tagline: Option[String] = Some("Fill the void with cheese")
  override val notes: Option[String] = Some(
    "You can also use fresh tagliatelle rather than gnocchi, although you'll need a lot more creme fraiche."
  )
  override val tags =
    Set(
      Tag.Stodge,
      Tag.Quick,
      Tag.VegetarianIsh,
      Tag.ColdWeather,
      Tag.LowEffort
    )

  val ingredients = List(
    Ingredient("Gnocchi", "500g"),
    Ingredient("Parmesan", Some("~70g"), Some("grated")),
    Ingredient("Creme Fraiche", "150ml"),
    Ingredient("Spinach", "200g"),
    Ingredient("Stilton", Some("200g"), Some("diced/crumbled")),
    Ingredient("Pimento Stuffed olives", None, None, Some("Optional")),
    Ingredient("Cherry Tomatoes", None, None, Some("Optional")),
    Ingredient("Fresh bread", None, None, Some("Optional"))
  )
  val method =
    List(
      "Tear up the spinach into a colander",
      "Place the ghocchi in a pan of boiling water and simmer until the gnocchi start to float to the surface",
      "Throw the torn spinach into the pan then drain immediately",
      "Empty the gnocchi/spinach into an ovenproof dish and mix in the parmesan and creme fraiche",
      "Sprinkle crumbled stilton over the top",
      "Grill on a medium/high heat until the stilton is bubbling and golden",
      "Serve on fresh bread with cherry tomatoes, olives, and anything else you can think of."
    )

}
