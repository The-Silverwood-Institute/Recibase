package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object Pancakes extends Recipe {
  val name = "Pancakes"

  override val source: Option[String] = (
    "Eth"
  ).some

  val tags = Set(Tag.Vegetarian, Tag.Pudding, Tag.Quick, Tag.Scales)

  override val description: Option[String] = (
    "Incredibly simple crepe style pancakes"
  ).some
  val tags =
    Set(Tag.Vegetarian, Tag.Scales, Tag.Pudding, Tag.Quick, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Flour", "200g"),
    Ingredient("Milk", "400ml"),
    Ingredient("Butter")
  )
  val method = List(
    "Whisk together ingredients.",
    "Heat a large frying pan over a high flame.",
    "Throw in a small piece of butter. It should immediately start bubbling.",
    "Pour a small amount of the mixture into the pan. Just enough to go to cover the bottom.",
    "Flip once the underside is lightly browned and brown the remaining side.",
    "Serve with sweet toppings."
  )
}
