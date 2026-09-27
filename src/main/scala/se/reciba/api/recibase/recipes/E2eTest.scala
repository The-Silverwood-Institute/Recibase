package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, IngredientsBlock, Permalink, Recipe, Tag}
import java.time.LocalDate

case object E2eTest extends Recipe {
  val name = "E2E test"
  val createdAt = LocalDate.of(2026, 9, 27)
  override val permalink: Permalink = Permalink("e2e-test")

  override val description: Option[String] = "Description".some

  val tags = Set(Tag.Lunch, Tag.Vegetarian, Tag.Scales, Tag.BetterNextDay)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Test"),
    Ingredient("Test 2", "5")
  )

  val method = List(
    "Step 1",
    "Step 2",
    "Step 3"
  )
}
