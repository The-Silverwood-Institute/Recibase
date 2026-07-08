package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object Macaroni extends Recipe {
  val name = "Macaroni"
  val createdAt = LocalDate.of(2020, 4, 24)

  override val notes: List[String] = List(
    "We largely vibe the ingredients for this recipe."
  )

  val tags = Set(Tag.Scales, Tag.Vegetarian, Tag.ColdWeather, Tag.Stodge)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butter", "25g"),
    Ingredient("Plain Flour", "2 tbsp"),
    Ingredient("Milk", "1/2 pint (or more)"),
    Ingredient("Medium Cheddar Cheese"),
    Ingredient("Macaroni Pasta", "275g")
  )

  val method = List(
    "Grate the cheese.",
    "Melt the butter then stir in the flour a tablespoon at a time until you have a paste.",
    "Cook the flour paste for a few minutes, stirring constantly.",
    "Add milk a dribble at a time until it's fairly runny again.",
    "Add in the grated cheese and bring up to the simmer then turn the heat right down.",
    "In a second pan, boil slightly salted water then add and cook the macaroni.",
    "Check texture then drain thoroughly and add to the sauce and mix. Serve."
  )
}
