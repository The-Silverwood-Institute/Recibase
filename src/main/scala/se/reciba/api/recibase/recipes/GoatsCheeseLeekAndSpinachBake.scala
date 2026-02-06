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

case object GoatsCheeseLeekAndSpinachBake extends Recipe {
  val name = "Goats Cheese Leek and Spinach Bake"

  override val permalink: Permalink = Permalink(
    "goats-cheese-leek-and-spinach-bake"
  )
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Leek", "1"),
    Ingredient("Garlic cloves", "2"),
    Ingredient("Basil", "10g"),
    Ingredient("Baby leaf spinach", "80g"),
    Ingredient("Tortiglioni", "450g"),
    Ingredient("Cherry tomatoes", "125g"),
    Ingredient("Soft goats cheese", "75g"),
    Ingredient("Dried oregano", "1 tsp"),
    Ingredient("Vegetable stock mix", "1 sachet (11g)"),
    Ingredient("Pine nuts", "15g"),
    Ingredient("Butter"),
    Ingredient("Flour"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${240.simpleFanInstruction}.",
    "Boil a kettle.",
    "Chop the leek in half lengthways, then wash thoroughly to remove any grit from between the leaves.",
    "Top, tail and slice finely.",
    "Peel and finely chop (or grate) the garlic.",
    "Add the tortiglioni to a pot of boiled water with a pinch of salt, bring to the boil over a high heat and cook for 7-10 minutes or until cooked with a slight bite.",
    "Once done, drain the cooked tortiglioni and set it aside for later.",
    "Reboil half a kettle.",
    "While the pasta is cooking, heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil and a knob of butter over a medium-high heat.",
    "Once hot, add the chopped leek and chopped garlic with a pinch of salt and cook for 4-5 minutes or until beginning to soften.",
    "Meanwhile, dissolve the vegetable stock mix and most of the goats' cheese (you'll use the rest later!) in 200ml boiled water — this is your cheesy stock.",
    "Cut the cherry tomatoes in half.",
    "Once the leeks have slightly softened, add the dried oregano and halved cherry tomatoes to the pan and cook for 1-2 minutes.",
    "Meanwhile, chop the basil finely, including the stalks.",
    "Wash the spinach, then pat it dry with kitchen paper.",
    "Add 1 tbsp flour to the pan and give everything a good mix up.",
    "Gradually add the cheesy stock, stirring continuously until thickened.",
    "Add the spinach and cook for 1-2 minutes or until wilted.",
    "Add the drained tortiglioni to the pan and give everything a good mix up.",
    "Transfer to an oven-proof dish and top with the remaining goats' cheese and pine nuts.",
    "Put the dish in the oven for 10-15 minutes or until golden and bubbling."
  )
}
