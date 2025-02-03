package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model._

case object BeefWraps extends Recipe {
  val name =
    "Beef Wraps"

  override val tags = Set(Tag.Lunch, Tag.Quick, Tag.Vegetarian)

  override val description: Option[String] =
    Some("Spiced vegetarian beef wraps with black beans")

  override val notes: Option[String] = Some(
    """You can use up other vegetables like courgettes or red onions. Just fry them at the same time as the other veg."""
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Vegetarian Beef Strips", "175g"),
    Ingredient("Red Pepper", "1", "sliced"),
    Ingredient("Spring Onions", "3", "chopped"),
    Ingredient("Tortilla Wraps", "4"),
    Ingredient("Cherry Tomatoes", None, Some("halved")),
    Ingredient("Black Beans", "1 400g tin"),
    Ingredient("Cayenne pepper"),
    Ingredient("Smoked Paprika"),
    Ingredient("Mayonnaise"),
    Ingredient("Oil")
  )
  val method = List(
    "Heat some oil in a large frying pan.",
    "Throw in the beef strips along with the cayenne pepper and paprika. Cook per packet instructions.",
    "Warm the tortillas in a microwave per packet instructions and spread with some mayonnaise",
    "A few minutes before the beef strips are ready throw in the peppers.",
    "Add the spring onions, cherry tomatoes and black beans to the pan and cook for a further 30 seconds.",
    "Divide up the mixture equally among the tortillas.",
    "Wrap up and serve."
  )
}
