package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object PeruvianHaddockAndSweetPotatoStew extends Recipe {
  val name = "Peruvian Haddock & Sweet Potato Stew"

  override val permalink: Permalink = Permalink(
    "peruvian-haddock-and-sweet-potato-stew"
  )
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Sweet potato", "1"),
    Ingredient("Tomatoes", "2"),
    Ingredient("Garlic cloves", "2"),
    Ingredient("Haddock bites", "200g"),
    Ingredient("Knorr vegetable stock cube", "1"),
    Ingredient("Chipotle paste", "1 sachet (20g)"),
    Ingredient("Tomato paste", "1 sachet (16g)"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Ground coriander", "1 tsp"),
    Ingredient("Quinoa", "100g"),
    Ingredient("Coriander", "10g"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    "Peel and cut the sweet potato into bite-sized pieces.",
    "Dice the tomatoes.",
    "Peel and finely chop (or grate) the garlic.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil over a medium-high heat.",
    "Once hot, add the ground cumin and ground coriander and cook for 1 minute or until fragrant.",
    "Once fragrant, add the diced tomato and chopped garlic and cook for a further 1-2 minutes or until the tomato has broken down.",
    "Boil a kettle.",
    "Meanwhile, dissolve the Knorr vegetable stock cube, tomato paste and chipotle paste (can't handle the heat? Go easy!) in 800ml boiled water — this is your spicy stock.",
    "Add the chopped sweet potatoes, spicy stock and quinoa to the pan and cook for 15-20 minutes or until the quinoa and sweet potatoes are tender.",
    "While the sweet potato and quinoa are cooking, chop the coriander finely (including the stalks), saving a few whole leaves for garnish.",
    "Once the quinoa is cooked, add the haddock bites and the chopped coriander to the pan and cook for 3-4 minutes further or until the haddock is cooked through.",
    "Season with a pinch of salt and pepper — this is your haddock & sweet potato stew.",
    "Serve the haddock & sweet potato stew and garnish with the reserved coriander leaves."
  )
}
