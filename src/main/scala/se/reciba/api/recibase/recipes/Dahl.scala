package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object Dahl extends Recipe {
  val name = "Dahl"

  override val source: Option[String] = (
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  ).some
  override val description: Option[String] = (
    "An Indian dish of lentils infused with spices."
  ).some
  override val notes: List[String] = List(
    "Roasted nuts can also be added. Cook them until brown with a little oil in the small pan before adding the butter, cumin and onion."
  )
  val tags = Set(Tag.Vegan, Tag.Scales, Tag.Spicy, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red lentils", "350g"),
    Ingredient(
      "Water",
      "800ml".some,
      "boiling".some,
      "Quantity is important!".some
    ),
    Ingredient(
      "Ground turmeric",
      "1 tsp".some,
      None,
      "Use 2-3 tsp instead".some
    ),
    Ingredient("Chilli powder", "1/2 tsp"),
    Ingredient(
      "Ginger",
      "1 cm piece".some,
      "peeled and finely chopped".some,
      "Replace with ground ginger if necessary".some
    ),
    Ingredient("Garlic", "2 cloves", "finely chopped"),
    Ingredient(
      "Garam masala",
      "1/2 tsp".some,
      None,
      "Use at least 1 tsp".some
    ),
    Ingredient("Salt"),
    Ingredient("Butter", "25g approx"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Onion", "1", "diced")
  )
  val method = List(
    "Boil the kettle and rinse the lentils.",
    "Put the lentils in a saucepan and cover with the boiling water.",
    "Add turmeric and chilli powder then bring the pan to the boil.",
    "Add the garlic and ginger to the pan.",
    "Cook the lentils for approx. 10 minutes.",
    "Add the garam masala.",
    "Heat the butter and cumin in a small pan and add the onions. Cook until soft.",
    "Mix the onions into the dahl and serve."
  )
}
