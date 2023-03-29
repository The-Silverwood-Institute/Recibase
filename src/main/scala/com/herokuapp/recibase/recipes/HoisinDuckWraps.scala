package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model._

case object HoisinDuckWraps extends Recipe {
  val name =
    "Hoisin Duck Wraps"
  override val permalink: Permalink =
    Permalink("duck-wraps")

  override val tags = Set(Tag.Lunch, Tag.Quick, Tag.Vegetarian)

  override val description: Option[String] =
    Some("To the tune of Top Cat: Duck Wraps! They're vegetarian, Duck Wraps!")

  override val notes: Option[String] = Some(
    """You can use up other vegetables like courgettes or red onions. Just fry them at the same time as the other veg.
      |
      |This tastes best with hoisin sauce but mayonnaise works as a decent substitute.""".stripMargin
  )

  val ingredients = List(
    Ingredient("Vegetarian Shredded Hoisin Duck", "200g"),
    Ingredient("Red Pepper", "1", "sliced"),
    Ingredient("Spring Onions", "3", "chopped"),
    Ingredient("Tortilla Wraps", "4"),
    Ingredient("Cherry Tomatoes", None, Some("halved")),
    Ingredient("Hoisin sauce", None, None, Some("Optional")),
    Ingredient("Oil")
  )
  val method = List(
    "Heat some oil in a large frying pan.",
    "Throw in the shredded hoisin duck and cook per packet instructions.",
    "Warm the tortillas in a microwave per packet instructions",
    "Add some oil to a small frying pan and cook the red pepper over a medium heat for a few minutes.",
    "Add the spring onions and cherry tomatoes to the small frying pan and cook for a further 30 seconds.",
    "Divide up the shredded hoisin duck and vegetables equally among the tortillas.",
    "Drizzle with hoisin sauce then wrap up and serve."
  )
}
