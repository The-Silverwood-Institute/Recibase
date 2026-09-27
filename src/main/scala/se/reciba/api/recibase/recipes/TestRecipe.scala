package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, IngredientsBlock, Permalink, Recipe, Tag}
import java.time.LocalDate

case object TestRecipe extends Recipe {
  val name = "Test Recipe"
  val createdAt = LocalDate.of(2026, 9, 27)
  override val permalink: Permalink = Permalink("test-recipe")

  override val description: Option[String] = "Description of recipe".some

  val tags = Set(Tag.Vegetarian, Tag.Stodge, Tag.Quick, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Test"),
    Ingredient("Test 2", "250g"),
    Ingredient("Test 3", None, "chop".some, "Notes".some)
  )

  val method = List(
    "Do the thing",
    "Then the other thing",
    "Haha"
  )
}
