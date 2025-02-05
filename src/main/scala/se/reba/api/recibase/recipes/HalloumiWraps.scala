package se.reciba.api.recipes

import se.reciba.api.model._

case object HalloumiWraps extends Recipe {
  val name =
    "Halloumi Wraps"

  override val tags = Set(Tag.Lunch, Tag.Quick, Tag.Vegetarian)

  override val description: Option[String] =
    Some("Greek style halloumi wraps")

  override val notes: Option[String] = Some(
    """You can use up other vegetables like courgettes or red onions. Just fry them at the same time as the other veg.
      |
      |A single packet of halloumi is slightly too little but two is slightly too much. Ideally cook this for an odd number of people or find a recipe to use up the remainder.
      |""".stripMargin
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Halloumi", "225g", "sliced"),
    Ingredient("Red Pepper", "1", "sliced"),
    Ingredient("Spring Onions", "3", "chopped"),
    Ingredient("Tortilla Wraps", "4"),
    Ingredient("Cherry Tomatoes", None, Some("halved")),
    Ingredient("Yoghurt"),
    Ingredient("Garlic", None, Some("diced")),
    Ingredient("Oil")
  )
  val method = List(
    "Heat some oil on a griddle pan over a high heat.",
    "Fry the halloumi slices on the griddle until browned. Turn once.",
    "Mix together a few tablespoons of yoghurt and the garlic.",
    "Warm the tortillas in a microwave per packet instructions and spread with the garlic yoghurt.",
    "A few minutes before the halloumi is ready heat a small frying pan over a medium heat and cook the red pepper.",
    "Add the spring onions and cherry tomatoes to the pan and cook for a further 30 seconds.",
    "Divide up the halloumi and veg mixture equally among the tortillas."
  )
}
