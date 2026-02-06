package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object PomegranatePersianHalloumi extends Recipe {
  val name = "Pomegranate Persian Halloumi"

  override val permalink: Permalink = Permalink("pomegranate-persian-halloumi")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Lemon", "1"),
    Ingredient("Red onions", "2"),
    Ingredient("Bulgur wheat", "130g"),
    Ingredient("Bag of sultanas", "1 (30g)"),
    Ingredient("Ras el hanout", "1 tsp"),
    Ingredient("Halloumi cheese", "200g"),
    Ingredient("Pomegranate molasses", "1 pot (15g)"),
    Ingredient("Mint", "10g"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    "Peel and finely slice the red onions.",
    "Heat a large, wide-based pan (preferably non-stick) with 1-2 tbsp olive oil over a medium-high heat.",
    "Once hot, add the sliced onion and cook for 4-5 minutes or until soft and lightly caramelised.",
    "Meanwhile, add the sultanas to a small bowl and add 100ml boiled water and set aside.",
    "Add the bulgur wheat to a pot with plenty of boiled water and a generous pinch of salt (the same as you would for pasta).",
    "Bring to the boil over a high heat and cook for 7-9 minutes or until tender with a slight bite.",
    "Once cooked, drain and return to the pot.",
    "Drain the sultanas and add them to the drained bulgur.",
    "Strip the mint leaves from the stems and chop finely, discard the stems.",
    "Zest 1/2 lemon.",
    "Add the chopped mint, lemon zest, pomegranate molasses, 1-2 tbsp olive oil, the remaining ras el hanout and give everything a good mix up.",
    "Season lightly with salt and pepper.",
    "Push the caramelised onion to one side of the pan and add 1-2 tbsp olive oil.",
    "Cut the halloumi into thick slices.",
    "Add the sliced halloumi and cook for 1-2 minutes on each side or until golden.",
    "Serve the cooked halloumi slices over the bulgur and caramelised onion."
  )
}
