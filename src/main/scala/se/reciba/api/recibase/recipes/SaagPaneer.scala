package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object SaagPaneer extends Recipe {
  val name = "Saag Paneer"

  override val notes: List[String] = List(
    "All quantities are very approximate. Some ingredients are probably also missing as I really just make this up as I go...",
    "For frying the paneer, the goal is something like a very shallow shallow fry, with more oil than would be used for pan frying but less than most shallow frying. A sautee pan is ideal for this."
  )
  val tags =
    Set(Tag.Vegetarian, Tag.HotWeather, Tag.Spicy, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Paneer", "1 block".some, "cut into 2-3 cm cubes".some),
    Ingredient("Ground turmeric", "2 tsp"),
    Ingredient("Chilli powder", "1/2 tsp".some),
    Ingredient("Onion", "1".some, "diced, but not too finely".some),
    Ingredient(
      "Ground cumin",
      "1/2 tsp".some,
      None,
      "Probably optional".some
    ),
    Ingredient(
      "Ground cinnamon",
      "1/2 tsp".some,
      None,
      "Can probably replace this and the cumin with garam masala".some
    ),
    Ingredient(
      "Tomatoes",
      "2".some,
      "diced".some,
      (
        "Tins of chopped tomatoes are far too wet for this. Also optional."
      ).some
    ),
    Ingredient(
      "Spinach",
      "1 large bag minimum".some,
      "torn up".some,
      "Can also use frozen spinach. Either way, a lot is needed.".some
    ),
    Ingredient("Peas", None, None, "Optional".some)
  )
  val method = List(
    "Add oil, turmeric and chilli powder to a wide, deep pan.",
    "Add the paneer and fry on a high heat, turning occasionally until crispy and brown on multiple sides. Remove and set aside.",
    "Add the onions, cumin and cinnamon and cook in the remaining oil until very soft. At some point also add the tomatoes.",
    "Add the spinach (in batches if necessary) and wilt.",
    "Add peas if used.",
    "Add the fried paneer to the pan and heat, stirring carefully so as not to break the paneer.",
    "Serve with rice or naan bread."
  )
}
