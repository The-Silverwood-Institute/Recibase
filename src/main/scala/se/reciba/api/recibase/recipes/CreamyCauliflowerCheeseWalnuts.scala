package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object CreamyCauliflowerCheeseWalnuts extends Recipe {
  val name = "Creamy cauliflower cheese with walnuts"
  override val permalink: Permalink =
    Permalink("creamy-cauliflower-cheese")

  override val source: Option[String] = (
    "https://docs.google.com/document/d/1A0bgFOwirLW2mct8KNrxYdk4OEsGZtY23mFdgOljHFA"
  ).some
  val tags = Set(Tag.Vegetarian, Tag.Quick, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Cauliflower", "1".some, "cut into 1cm pieces".some),
    Ingredient(
      "Creme Fraiche",
      "300g".some,
      None,
      "or Cream Cheese".some
    ),
    Ingredient("Dijon Mustard", "1 tsp"),
    Ingredient("Blue Cheese", "125g".some, "crumbled".some),
    Ingredient("Walnuts", "25g".some, "roughly chopped".some),
    Ingredient("Cheddar Cheese", "50g".some, "grated".some),
    Ingredient("Salt"),
    Ingredient("Black pepper")
  )
  val method = List(
    "Steam the cauliflower until tender, drain, then place in a grill-suitable dish",
    "Mix the cream cheese and mustard with the cauliflower, then stir in the blue cheese. Season with a little salt if necessary and plenty of pepper.",
    "Scatter the walnuts on top, then cover with the cheddar (this helps to prevent the walnuts from burning).",
    "Place under a preheated hot grill for 10-15 minutes, or until the top is golden brown and the inside hot and bubbling."
  )
}
