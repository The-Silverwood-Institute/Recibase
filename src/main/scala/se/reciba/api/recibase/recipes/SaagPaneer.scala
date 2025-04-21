package se.reciba.api.recipes

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
    Ingredient("Paneer", Some("1 block"), Some("cut into 2-3 cm cubes")),
    Ingredient("Ground turmeric", "2 tsp"),
    Ingredient("Chilli powder", Some("1/2 tsp")),
    Ingredient("Onion", Some("1"), Some("diced, but not too finely")),
    Ingredient(
      "Ground cumin",
      Some("1/2 tsp"),
      None,
      Some("Probably optional")
    ),
    Ingredient(
      "Ground cinnamon",
      Some("1/2 tsp"),
      None,
      Some("Can probably replace this and the cumin with garam masala")
    ),
    Ingredient(
      "Tomatoes",
      Some("2"),
      Some("diced"),
      Some(
        "Tins of chopped tomatoes are far too wet for this. Also optional."
      )
    ),
    Ingredient(
      "Spinach",
      Some("1 large bag minimum"),
      Some("torn up"),
      Some("Can also use frozen spinach. Either way, a lot is needed.")
    ),
    Ingredient("Peas", None, None, Some("Optional"))
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
