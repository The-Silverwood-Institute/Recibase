package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object NewYorkBagel extends Recipe {
  val name = "New York Bagels"

  override val source: Option[String] = (
    "https://www.thevegspace.co.uk/recipe-four-fabulously-filling-bagel-toppings/"
  ).some
  override val description: Option[String] = (
    "A vegetarian take on the classic pastrami bagel"
  ).some

  val tags = Set(Tag.Lunch)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Bagels", "4"),
    Ingredient(
      "Squeaky Bean Deli Pastrami",
      "180g".some,
      None,
      "2 packets".some
    ),
    Ingredient(
      "Cooked Beetroot",
      "180g".some,
      None,
      "ideally pre-grated sweet & smoky".some
    ),
    Ingredient("Pickles"),
    Ingredient(
      "Cheese",
      None,
      None,
      "ideally something fancy like Comté".some
    ),
    Ingredient("Mayonnaise", None, None, "optional".some)
  )
  val method = List(
    "Halve and lightly toast the bagels.",
    "Slice the beetroot, pickles and cheese.",
    "Layer the bottom half of each bagel with mayo, pastrami, pickles, beetroot and then cheese. Make sure the cheese covers everything so it doesn't burn.",
    "Grill the bottom halves of the bagels until the cheese is bubbly.",
    "Optionally spread the top half of each bagel with mayo.",
    "Combine the top and bottom halves of the bagels and serve."
  )
}
