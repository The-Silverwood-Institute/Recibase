package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object CodWithLentils extends Recipe {
  val name = "Cod with Lentils"
  val createdAt = LocalDate.of(2023, 3, 17)

  override val source: Option[String] = (
    "Sand Dollar Café, Aberdeen"
  ).some
  val tags = Set(Tag.Pescatarian, Tag.LowEffort, Tag.Quick)

  override val notes: List[String] = List(
    "The green lentils are an essential part of the dish, so don't substitute them for red lentils."
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red Onion", "1", "chopped"),
    Ingredient("Cod Fillets", "2"),
    Ingredient("Green Lentils", "2 400g tin"),
    Ingredient("Butter"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Lemon Juice")
  )
  val method = List(
    "Salt and pepper the cod. Wrap in tin foil then cook per packet instructions.",
    "Meanwhile, drain the tins of green lentils into a sieve. Rinse and set aside.",
    "Heat a knob of butter in a saucepan.",
    "Add the onion and cook over a medium heat until soft.",
    "Tip in the green lentils and gently heat up. Stir the lentils gently as it's important the lentils don't turn to mush.",
    "Season with salt, pepper and a dash of lemon juice. Add more butter if needed.",
    "Serve the lentil and onions with the cod on top."
  )
}
