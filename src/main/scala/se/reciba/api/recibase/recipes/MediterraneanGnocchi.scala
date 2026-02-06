package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object MediterraneanGnocchi extends Recipe {
  val name = "Mediterranean Gnocchi"

  override val permalink: Permalink = Permalink("mediterranean-gnocchi")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Courgette", "1"),
    Ingredient("Cherry tomatoes", "125g"),
    Ingredient("Gnocchi", "350g"),
    Ingredient("Roasted garlic paste", "1 sachet (15g)"),
    Ingredient("Pitted black olives", "60g"),
    Ingredient("Can of tomato frito", "1"),
    Ingredient("Cheddar cheese", "40g"),
    Ingredient("Dried oregano", "1 tsp"),
    Ingredient("Pepper"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Boil a kettle, then heat a large, wide-based pan (preferably non-stick with a matching lid) with a generous drizzle of vegetable oil over a high heat.",
    "Cut the courgette into quarters lengthways then slice finely.",
    "Once the pan is hot, add the sliced courgettes with a pinch of salt and cook, covered, for 1-2 minutes or until starting to soften.",
    "Chop the cherry tomatoes in half.",
    "Once the courgettes are starting to soften, add the roasted garlic paste, dried oregano and halved cherry tomatoes.",
    "Cook for a further 2-3 minutes or until fragrant.",
    "Meanwhile, add the gnocchi to a pot of boiled water with a large pinch of salt and bring to the boil over a high heat.",
    "Cook the gnocchi for 3 minutes or until it begins to rise to the top of the pot.",
    "Once done, drain the gnocchi and reserve a cup of the starchy cooking water.",
    "Once the vegetables are fragrant, add the tomato frito and black olives with a generous pinch of black pepper and give everything a good mix up.",
    "Cook for 1-2 minutes or until the olives are warmed through.",
    "Add the drained gnocchi and a splash of the reserved starchy water and give everything a good mix up.",
    "Grate the cheddar cheese.",
    "Serve the Mediterranean gnocchi and top with the grated cheese."
  )
}
