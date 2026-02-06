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

case object RedPepperOrzo extends Recipe {
  val name = "Red Pepper Orzo"

  override val permalink: Permalink = Permalink("red-pepper-orzo")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red pepper", "1"),
    Ingredient("Red onions", "2"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Basil", "10g"),
    Ingredient("Red wine vinegar", "15ml"),
    Ingredient("Dried chilli flakes", "1 tsp"),
    Ingredient("Soft goats cheese", "75g"),
    Ingredient("Orzo pasta", "150g"),
    Ingredient("Vegetable stock mix", "1 sachet (11g)"),
    Ingredient("Tomato paste", "32g"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${200.simpleFanInstruction}.",
    "Deseed the red pepper (scrape the seeds and pith out with a teaspoon) and cut them into strips.",
    "Peel and cut the red onions into wedges.",
    "Add the pepper strips and onion wedges to a baking tray with a drizzle of olive oil and a pinch of salt.",
    "Give everything a good mix up and put the tray in the oven for 20-25 minutes or until softened and beginning to colour — this is your roasted veg.",
    "While the veg is in the oven, boil a kettle.",
    "Peel and finely chop (or grate) the garlic.",
    "Heat a large, wide-based pan (preferably non-stick, with a matching lid) with a drizzle of olive oil over a medium heat.",
    "Once hot, add the chopped garlic and chilli flakes (can't handle the heat? Go easy!) and cook for 30 seconds or until fragrant.",
    "Add the orzo pasta and tomato paste and cook for 1 minute further.",
    "Dissolve the vegetable stock mix in 500ml boiled water.",
    "Add the stock to the pan and bring to the boil.",
    "Once boiling, reduce the heat to medium-low and cook, covered, for 15 minutes or until the orzo is tender with a slight bite.",
    "While the orzo is cooking, chop the basil finely, including the stalks (saving a few leaves for garnish).",
    "Once the orzo is cooked, add the roasted veg to the pan with the red wine vinegar.",
    "Add the chopped basil (save the leaves for garnish) and give everything a good mix up — this is your roasted red pepper orzo.",
    "Serve the roasted red pepper orzo in bowls.",
    "Crumble the goats' cheese all over the top.",
    "Garnish with the reserved basil leaves, a grind of black pepper and a drizzle of olive oil."
  )
}
