package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model._

case object GreekWraps extends Recipe {
  val name =
    "Greek Kebab Wraps"
  override val permalink: Permalink =
    Permalink("greek-wraps")

  val tags = Set(Tag.Lunch, Tag.Quick, Tag.Vegetarian)

  override val description: Option[String] =
    "Greek style vegetarian kebab wraps".some

  override val notes: List[String] = List(
    "You can use up other vegetables like courgettes or red onions. Just fry them at the same time as the other veg"
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Vivera Veggie Greek Kebab", "125g"),
    Ingredient("Red Pepper", "1", "sliced"),
    Ingredient("Spring Onions", "3", "chopped"),
    Ingredient("Tortilla Wraps", "4"),
    Ingredient("Cherry Tomatoes", None, "halved".some),
    Ingredient("Sriracha"),
    Ingredient("Mayonnaise"),
    Ingredient("Oil")
  )
  val method = List(
    "Heat some oil in a large frying pan.",
    "Throw in the Greek kebab mixture and cook per packet instructions.",
    "Mix together a few tablespoons of mayonnaise and some Sriracha to make spicy mayo.",
    "Warm the tortillas in a microwave per packet instructions and spread with the spicy mayo",
    "A few minutes before the kebab mixture is ready throw in the peppers.",
    "Add the spring onions and cherry tomatoes to the pan and cook for a further 30 seconds.",
    "Divide up the mixture equally among the tortillas."
  )
}
