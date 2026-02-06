package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object TangyVegetablePadThai extends Recipe {
  val name = "Tangy Vegetable Pad Thai"

  override val permalink: Permalink = Permalink("tangy-vegetable-pad-thai")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red chilli", "1"),
    Ingredient("Red pepper", "1"),
    Ingredient("Lime", "1"),
    Ingredient("Garlic cloves", "2"),
    Ingredient("Roasted peanuts", "1 bag (25g)"),
    Ingredient("Basil", "5g"),
    Ingredient("Coriander", "5g"),
    Ingredient("Tamarind paste", "15g"),
    Ingredient("Mirin", "15ml"),
    Ingredient("Rice noodles", "150g"),
    Ingredient("Butternut squash cubes", "160g"),
    Ingredient("Courgette", "1"),
    Ingredient("Sriracha hot chilli sauce", "1 sachet (8ml)"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil"),
    Ingredient("Pepper")
  )

  val method = List(
    s"Preheat the oven to ${200.simpleFanInstruction}.",
    "Boil a full kettle.",
    "Add the butternut squash cubes to a tray with a pinch of salt and pepper and a drizzle of vegetable oil and give everything a good mix up.",
    s"Put the tray into the oven for 20-25 minutes or until cooked with a slight bite.",
    "Meanwhile, deseed the red pepper (scrape the seeds and pith out with a teaspoon) and cut into thin strips.",
    "Heat a large, wide-based pan (preferably non-stick) with a generous drizzle of vegetable oil over a medium heat.",
    "Once hot, add the pepper strips with a pinch of salt and cook for 3-4 minutes or until softened.",
    "Meanwhile, add the Thai rice noodles to a pot and cover with boiled water.",
    "Boil over a high heat for 4-5 minutes or until softened with a slight bite.",
    "Once softened, drain the noodles, run them under cold water then return to the pot with a drizzle of vegetable oil and set aside.",
    "Meanwhile, peel lengths off the courgette until you end up with a pile of courgette ribbons.",
    "Peel and finely slice the garlic.",
    "Add the tamarind paste to a bowl with the soy sauce, mirin, the juice of 1/2 lime and 1 tsp sugar and give it all a good mix up — this is your pad Thai sauce.",
    "Once the pepper has softened, add the courgette ribbons and sliced garlic to the pan and cook for 1-2 minutes until fragrant, then remove from the heat.",
    "Meanwhile, crush the peanuts in their bag with a rolling pin.",
    "Slice the red chilli finely (can't handle the heat? Take out the seeds!).",
    "Add the pad Thai sauce, drained noodles and butternut squash to the pan and give everything a good mix up.",
    "Serve the tangy vegetable pad Thai and garnish with the crushed peanuts, sliced chilli, chopped basil and coriander."
  )
}
