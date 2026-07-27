package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object TruffleBurgers extends Recipe {
  val name = "Truffle Burgers"
  val createdAt = LocalDate.of(2020, 4, 24)

  val tags = Set(Tag.Vegetarian, Tag.Stodge, Tag.Quick)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Beyond Meat Burgers", "4"),
    Ingredient("Brioche buns", "4"),
    Ingredient("Manchego", "4 slices"),
    Ingredient(
      "Jam",
      None,
      None,
      "Fig jam is best but strawberry or raspberry also works".some
    ),
    Ingredient("Mayonnaise"),
    Ingredient("Truffle oil"),
    Ingredient("Oil")
  )
  val method = List(
    "Lightly toast the brioche buns.",
    "Mix the truffle oil and mayonnaise to taste.",
    "Spread the truffle mayo on the bottom of each bun and jam on the top.",
    "Lightly brush a griddle pan with oil then heat on your hottest hob.",
    "Lay out the patties on the griddle and cook for a few minutes until almost browned. Open a window or two and be careful not to let the oil smoke.",
    "Turn over and brown the other side",
    "Turn over, again, and lay out a slice of Manchego on top of each patty.",
    "Lay out the patties on the burger buns. If you fancy shortening your lifespan then drizzle the pan's oil over the patties before adding the bun top."
  )
}
