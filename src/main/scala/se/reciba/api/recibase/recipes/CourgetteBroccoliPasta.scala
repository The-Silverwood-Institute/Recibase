package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object CourgetteBroccoliPasta extends Recipe {
  val name = "Courgette & Broccoli Pasta"

  override val source: Option[String] = "Gousto".some
  override val notes: List[String] =
    List(
      "If tagliatelle is unavailable try spaghetti.",
      "You can use garlic paste instead if you add it to the stock, rather than cooking it with the courgettes.",
      "Try adding a tablespoon of creme fraiche or soured cream, for a richer sauce."
    )
  val tags = Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Courgette", "1".some, "roughly chopped".some),
    Ingredient("Tenderstem broccoli", "120g".some, "halved".some),
    Ingredient("Fresh tagliatelle", "190g"),
    Ingredient("Garlic", "3 cloves".some, "finely chopped".some),
    Ingredient("Baby spinach", "80g"),
    Ingredient("Parmesan", None, "grated".some),
    Ingredient("Lemon juice"),
    Ingredient("Dried chilli flakes"),
    Ingredient("Flaked almonds", "handful".some, None, "optional".some),
    Ingredient("Soured cream", "1 tbsp".some, None, "optional".some),
    Ingredient("Vegetable stock"),
    Ingredient("Olive oil")
  )
  val method = List(
    "Dissolve the stock in 200ml of boiling water",
    "Heat some olive oil on a medium/high heat in a wide pan",
    "Cook the courgettes and garlic for 4-5 minutes or until starting to soften, then turn off the heat",
    "Cook the tagliatelle and broccoli, in a pan of boiling water, for 3 minutes",
    "Drain the tagliatelle and broccoli then add it to the courgette pan",
    "Add the lemon juice, chilli flakes, parmesan, spinach, soured cream (optional) and stock",
    "Cook on a medium heat for 2 minutes until the sauce has thickened and the spinach wilted"
  )
}
