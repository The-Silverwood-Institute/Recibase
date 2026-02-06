package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object SweetChilliPaneerNoodles extends Recipe {
  val name = "Sweet Chilli Paneer Noodles"

  override val permalink: Permalink = Permalink("sweet-chilli-paneer-noodles")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Pepper", "1"),
    Ingredient("Spring onions", "2"),
    Ingredient("Roasted peanuts", "1 bag (25g)"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Sriracha hot chilli sauce", "2 sachets (16ml)"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Rice vinegar", "1 sachet (15ml)"),
    Ingredient("Paneer cheese", "226g"),
    Ingredient("Medium egg noodles", "2 nests"),
    Ingredient("Cornflour", "3g"),
    Ingredient("Tomato ketchup", "1 sachet (10ml)"),
    Ingredient("Ginger & garlic paste", "1 sachet (15g)"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Boil a kettle.",
    "Cut the paneer into cubes.",
    "Heat a large, wide-based pan (preferably non-stick) with a generous drizzle of vegetable oil over a medium-high heat.",
    "Once the pan is hot, add the paneer with the ginger & garlic paste and soy sauce and cook for 2-3 minutes or until beginning to golden.",
    "Meanwhile, add the cornflour to a small bowl with 1 tbsp water.",
    "Stir until dissolved, then add the sriracha, tomato ketchup, rice wine vinegar and dried chilli flakes (can't handle the heat? Go easy!) with a pinch of salt and a generous pinch of sugar.",
    "Stir it all together — this is your chilli sauce.",
    "Add the medium egg noodles to a pot with plenty of boiled water and bring to the boil over a high heat for 4-5 minutes or until cooked with a slight bite.",
    "Once done, drain the noodles and red pepper, reserving a cup of the starchy noodle water.",
    "Once the paneer is golden, add the chopped spring onion to the pan and cook for a further 2-3 minutes or until softened.",
    "When the noodles are almost cooked, add the sliced pepper to the noodles and cook for 1-2 minutes further.",
    "Add the drained noodles to the paneer with the chilli sauce and give everything a good mix up — these are your spicy paneer chilli noodles.",
    "Crush the roasted peanuts in their bag with a rolling pin.",
    "Serve the spicy paneer chilli noodles and garnish with the crushed peanuts."
  )
}
