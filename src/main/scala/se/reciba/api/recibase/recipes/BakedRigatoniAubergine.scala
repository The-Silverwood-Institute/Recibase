package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object BakedRigatoniAubergine extends Recipe {
  val name = "Baked Rigatoni with Aubergine"

  override val source: Option[String] = Some(
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  )
  override val notes: Option[String] = Some(
    "Traditional parmesan is not vegetarian"
  )
  val tags = Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Onion", "1", "chopped"),
    Ingredient("Garlic", "2-3 cloves", "finely chopped or crushed"),
    Ingredient("Red wine"),
    Ingredient("Chopped tomatoes", "2 400g tins"),
    Ingredient("Sun-dried tomatoes", "5", "drained and chopped."),
    Ingredient("Aubergine", "1", "cut into 1cm cubes"),
    Ingredient(
      "Oregano",
      Some("2 tbsp"),
      Some("chopped"),
      Some("Fresh or dried")
    ),
    Ingredient(
      "Rigatoni",
      Some("225g"),
      None,
      Some("Or penne or other chunky pasta tube")
    ),
    Ingredient("Breadcrumbs", "30g"),
    Ingredient(
      "Parmesan",
      Some("30g"),
      None,
      Some("Or a ball of mozzarella")
    ),
    Ingredient("Salt"),
    Ingredient("Pepper")
  )
  val method = List(
    s"Preheat the oven to ${200.celsius}.",
    "Heat oil or butter in a saucepan. Add the onion and garlic and cook until soft.",
    "Add the wine, followed by the tins of chopped tomatoes, the sun-dried tomatoes, aubergine, oregano, salt and pepper.",
    "Bring to the boil, cover and simmer for 15-20 minutes.",
    "Cook the pasta until al dente. Drain well.",
    "Tip the pasta and sauce into an suitable ovenproof dish. Mix together thoroughly.",
    "Cover with the breadcrumbs and parmesan (or mozzarella).",
    "Bake for 15-20 minutes until bubbling and the top is golden brown."
  )
}
