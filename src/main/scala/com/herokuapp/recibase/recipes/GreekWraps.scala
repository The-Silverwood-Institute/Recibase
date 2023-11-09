package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model._

case object GreekWraps extends Recipe {
  val name =
    "Greek Kebab Wraps"
  override val permalink: Permalink =
    Permalink("greek-wraps")

  override val tags = Set(Tag.Lunch, Tag.Quick, Tag.Vegetarian)

  override val description: Option[String] =
    Some("Greek style vegetarian kebab wraps")

  override val notes: Option[String] = Some(
    """You can use up other vegetables like courgettes or red onions. Just fry them at the same time as the other veg""".stripMargin
  )

  val ingredients = List(
    Ingredient("Vivera Veggie Greek Kebab", "125g"),
    Ingredient("Red Pepper", "1", "sliced"),
    Ingredient("Spring Onions", "3", "chopped"),
    Ingredient("Tortilla Wraps", "4"),
    Ingredient("Cherry Tomatoes", None, Some("halved")),
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
