package se.reciba.api.recipes

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
      Some("200g"),
      Some("cut into bite-size pieces"),
      Some("Either haddock or basa")
    ),
    Ingredient("Coriander", Some("5g"), None, Some("Optional")),
    Ingredient(
      "Red chilli",
      Some("1"),
      Some("sliced"),
      Some("Replace with chilli flakes or powder")
    ),
    Ingredient(
      "Creamed coconut",
      Some("50g"),
      None,
      Some("More is better")
    ),
    Ingredient(
      "Ginger",
      Some("30g"),
      Some("finely chopped or grated"),
      Some("Use ground ginger for speed")
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
    Ingredient("Naan Bread", None, None, Some("Optional"))
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
