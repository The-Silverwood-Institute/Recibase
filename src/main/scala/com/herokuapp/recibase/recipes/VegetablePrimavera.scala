package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object VegetablePrimavera extends Recipe {
  val name = "Vegetable Primavera"
  override val permalink: Permalink =
    Permalink.fromRawString("vegetable-primavera")

  override val source: Option[String] = Some(
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  )
  override val notes: Option[String] = Some(
    """The mustard is a key part of the dish, so the quantity here is only a suggestion. Alex likes to use a lot.
    Most combinations of small or baby vegetables work, as does e.g. tenderstem broccoli. Carrot sticks are a suitable replacement for baby carrots, too. Use whatever you have or can get. Aim for 3-4 types. Suggestions include: baby sweetcorn, green beans, baby carrots, mange tout.
    Many types or tortellini or ravioli work for this dish."""
  )
  override val tags =
    Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather, Tag.LowEffort)

  val ingredients = List(
    Ingredient(
      "Baby vegetables",
      Some("3-4 varieties"),
      None,
      Some("See notes for suggestions")
    ),
    Ingredient(
      "Tortellini or ravioli",
      Some("400g"),
      None,
      Some("Choose your own flavour")
    ),
    Ingredient(
      "Olive oil",
      Some("1 tbsp"),
      None,
      Some("Extra virgin preferred")
    ),
    Ingredient("Lemon", Some("1/2"), None, Some("Or use lemon juice")),
    Ingredient("Wholegrain mustard", Some("1-2 tbsp")),
    Ingredient("Salt"),
    Ingredient("Black pepper")
  )
  val method = List(
    "Prepare and steam the vegetables, in batches if necessary. Do not mix vegetables that cook quickly with those that cook slowly. Remove when still slightly crisp.",
    "Cook the pasta and drain.",
    "Heat the oil in the pan and add the lemon juice, mustard, salt and pepper.",
    "Mix in the vegetables followed by the pasta.",
    "Serve on warmed plates."
  )
}
