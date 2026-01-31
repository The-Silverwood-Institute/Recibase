package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object VegetablePrimavera extends Recipe {
  val name = "Vegetable Primavera"

  override val source: Option[String] = (
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  ).some
  override val notes: List[String] = List(
    "The mustard is a key part of the dish, so the quantity here is only a suggestion. Alex likes to use a lot.",
    "Most combinations of small or baby vegetables work, as does e.g. tenderstem broccoli. Carrot sticks are a suitable replacement for baby carrots, too. Use whatever you have or can get. Aim for 3-4 types. Suggestions include: baby sweetcorn, green beans, baby carrots, mange tout.",
    "Many types or tortellini or ravioli work for this dish."
  )
  val tags =
    Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Baby vegetables",
      "3-4 varieties".some,
      None,
      "See notes for suggestions".some
    ),
    Ingredient(
      "Tortellini or ravioli",
      "400g".some,
      None,
      "Choose your own flavour".some
    ),
    Ingredient(
      "Olive oil",
      "1 tbsp".some,
      None,
      "Extra virgin preferred".some
    ),
    Ingredient("Lemon", "1/2".some, None, "Or use lemon juice".some),
    Ingredient("Wholegrain mustard", "1-2 tbsp".some),
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
