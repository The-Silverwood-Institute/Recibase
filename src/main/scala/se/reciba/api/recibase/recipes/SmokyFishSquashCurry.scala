package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object SmokyFishSquashCurry extends Recipe {
  val name = "Smoky fish and squash curry"
  override val permalink: Permalink =
    Permalink("smoky-fish-curry")

  val tags = Set(Tag.Pescatarian, Tag.Spicy)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Onion", "1", "diced"),
    Ingredient("Garlic", "1 clove", "finely chopped"),
    Ingredient(
      "Smoked fish",
      "200g".some,
      "cut into bite-size pieces".some,
      "Either haddock or basa".some
    ),
    Ingredient("Coriander", "5g".some, None, "Optional".some),
    Ingredient(
      "Red chilli",
      "1".some,
      "sliced".some,
      "Replace with chilli flakes or powder".some
    ),
    Ingredient(
      "Creamed coconut",
      "50g".some,
      None,
      "More is better".some
    ),
    Ingredient(
      "Ginger",
      "30g".some,
      "finely chopped or grated".some,
      "Use ground ginger for speed".some
    ),
    Ingredient("Stock cube", "1"),
    Ingredient("Ground coriander", "1 tsp"),
    Ingredient("Ground turmeric", "1 tsp"),
    Ingredient(
      "Squash",
      "200g",
      "peeled and cut into bite-size pieces",
      "alternatively use sweet potato"
    ),
    Ingredient("Water", "350ml", "boiling"),
    Ingredient("Naan Bread", None, None, "Optional".some)
  )
  val method = List(
    "Soften the onion in a pan.",
    "Make the stock and add the creamed coconut.",
    "Add the garlic, ginger, ground coriander, ground turmeric, chilli and the squash and mix well.",
    "Pour in the stock and cook for 15-20 mins or until the squash is soft and the stock has thickened.",
    "Add the smoked fish and cook for 5 mins or until cooked through.",
    "Serve and garnish with corriander."
  )
}
