package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object ScrambledTofuNoodles extends Recipe {
  val name = "Scrambled Tofu Noodles"

  override val permalink: Permalink = Permalink("scrambled-tofu-noodles")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Lime", "1"),
    Ingredient("Spring onions", "2"),
    Ingredient("Roasted peanuts", "1 bag (25g)"),
    Ingredient("Chilli jam", "1 pot (25g)"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Wholewheat noodle nests", "2"),
    Ingredient("Sugar snap peas", "80g"),
    Ingredient("Plain tofu", "280g"),
    Ingredient("Sriracha hot chilli sauce", "2 sachets (16ml)"),
    Ingredient("Ginger & garlic paste", "1 sachet (15g)"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Boil a kettle.",
    "Heat a large, wide-based pan (preferably non-stick) with a generous drizzle of vegetable oil over a high heat.",
    "Drain the plain tofu, pat it dry with kitchen paper and crumble it into bite-sized pieces.",
    "Once the pan is hot, add the crumbled tofu with a generous pinch of salt and cook for 5-6 minutes or until golden and crispy.",
    "Meanwhile, add the wholewheat noodles and the sugar snap peas to a pot with plenty of boiled water and bring to the boil over a high heat for 4-5 minutes or until cooked with a slight bite.",
    "Once done, drain the noodles and sugar snap peas, reserving a cup of the starchy noodle water.",
    "Trim, then slice the spring onions roughly (bunch them up for speed!).",
    "Once the crumbled tofu is golden, add the ginger & garlic paste to the pan and cook for a further 1-2 minutes or until fragrant.",
    "Combine the soy sauce, dried chilli flakes (can't handle the heat? Go easy!), chilli jam and the juice of the lime in a bowl — this is your noodle sauce.",
    "Add the wholewheat noodles and sugar snap peas to the pan with the noodle sauce (and a splash of the reserved starchy noodle water) and give everything a good mix up.",
    "Crush the roasted peanuts in their bag with a rolling pin.",
    "Serve the scrambled tofu noodles and garnish with the crushed peanuts and sliced spring onions."
  )
}
