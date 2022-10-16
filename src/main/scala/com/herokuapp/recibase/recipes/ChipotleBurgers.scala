package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

case object ChipotleBurgers extends Recipe {
  val name = "Chipotle Burgers"

  override val source: Option[String] = Some(
    "https://www.honestburgers.co.uk/food/burgers/bacon-plant/"
  )
  override val tags = Set(Tag.Vegetarian, Tag.Spicy, Tag.Stodge, Tag.Quick)

  override val notes: Option[String] = Some(
    "This version is only vegetarian, though you could follow the original Honest Burger version and use vegan mayo/cheese"
  )

  val ingredients = List(
    Ingredient("Beyond Meat Burgers", "4"),
    Ingredient("Brioche buns", "4"),
    Ingredient("Applewood Smoked Cheddar", "185g"),
    Ingredient("Ketchup", None, None, Some("A premium brand like Sauce Shop")),
    Ingredient("Mayonnaise"),
    Ingredient("Chipotle paste"),
    Ingredient("Oil")
  )
  val method = List(
    "Lightly toast the brioche buns.",
    "Mix the chipotle paste and mayonnaise to taste.",
    "Spread the chipotle mayo on the bottom of each bun and ketchup on the top.",
    "Lightly brush a griddle pan with oil then heat on your hottest hob.",
    "Lay out the patties on the griddle and cook for a few minutes until almost browned. Open a window or two and be careful not to let the oil smoke.",
    "Turn over and brown the other side",
    "Turn over, again, and lay out a slice of smoked cheddar on top of each patty.",
    "Lay out the patties on the burger buns. If you fancy shortening your lifespan then drizzle the pan's oil over the patties before adding the bun top."
  )
}
