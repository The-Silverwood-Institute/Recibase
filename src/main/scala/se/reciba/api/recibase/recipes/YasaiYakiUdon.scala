package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object YasaiYakiUdon extends Recipe {
  val name = "Yasai Yaki Udon"

  override val permalink: Permalink = Permalink("yasai-yaki-udon")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Red pepper", "1"),
    Ingredient("Red onion", "1"),
    Ingredient("Spring onions", "4"),
    Ingredient("Henderson's Relish", "1 sachet (5ml)"),
    Ingredient("Black sesame seed", "1 sachet (5g)"),
    Ingredient("Toasted sesame seed", "1 sachet (5g)"),
    Ingredient("Fried onions", "15g"),
    Ingredient("Chestnut mushrooms", "160g"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Udon noodles", "400g"),
    Ingredient("Pickled ginger", "2 sachets (8g)"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Slice the chestnut mushrooms.",
    "Deseed the red pepper (scrape the seeds and pith out with a teaspoon) and cut into thin strips.",
    "Peel and finely slice the red onion.",
    "Peel (scrape the skin off with a teaspoon) and finely chop (or grate) the ginger.",
    "Trim, then slice the spring onions into large, bite-sized pieces.",
    "Heat a wide, large based pan (preferably non-stick) with a generous drizzle of vegetable oil over a high heat.",
    "Once hot, add the sliced mushrooms, red onion and red pepper with a pinch of salt and cook for 3-4 minutes or until starting to caramelise.",
    "Once caramelised, add the chopped spring onion and cook for 1 minute further.",
    "Add the chopped ginger and cook for 1 minute or until fragrant.",
    "Add the udon noodles and cook for 3-4 minutes or until warmed through.",
    "Add the soy sauce and Henderson's Relish and cook for 1-2 minutes further until the noodles are fully coated in the sauce.",
    "Season with a grind of black pepper — this is your yasai yaki udon.",
    "Serve the yasai yaki udon and garnish with the sesame seeds, fried onions and pickled ginger."
  )
}
