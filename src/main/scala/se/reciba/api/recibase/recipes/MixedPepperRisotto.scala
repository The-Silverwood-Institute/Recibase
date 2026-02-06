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

case object MixedPepperRisotto extends Recipe {
  val name = "Mixed Pepper Risotto"

  override val permalink: Permalink = Permalink("mixed-pepper-risotto")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red pepper", "1"),
    Ingredient("Yellow pepper", "1"),
    Ingredient("Red onion", "1"),
    Ingredient("Garlic", "1 clove"),
    Ingredient("Arborio rice", "150g"),
    Ingredient("Chilli jam", "1 pot (25g)"),
    Ingredient("Knorr vegetable stock cube", "1"),
    Ingredient("Chives", "5g"),
    Ingredient("Ground turmeric", "1/2 tsp"),
    Ingredient("Chinese rice wine", "1 sachet (5ml)"),
    Ingredient("Tomato paste", "1 sachet (32g)"),
    Ingredient("Cheddar cheese", "40g"),
    Ingredient("Smoked paprika", "1 tsp"),
    Ingredient("Butter"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${180.simpleFanInstruction}.",
    "Deseed the red and yellow peppers (scrape the seeds and pith out with a teaspoon) and cut into thin strips.",
    "Add the chopped pepper to a baking tray with a drizzle of olive oil and a pinch of salt.",
    s"Put the tray in the oven for 20-25 minutes until roasted and golden.",
    "Meanwhile, boil a full kettle.",
    "Peel and finely dice the red onion.",
    "Dissolve the Knorr vegetable stock cube in 700ml boiled water, then add the tomato paste, Chinese rice wine and chilli jam — this is your sweet tomato stock.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil and a knob of butter over a medium heat.",
    "Once hot, add the diced red onion with a pinch of salt and cook for 4 minutes until softened but not browned.",
    "Meanwhile, peel and finely chop (or grate) the garlic.",
    "Add the arborio rice, chopped garlic, smoked paprika and ground turmeric to the pan and cook for 1 minute further.",
    "Add 1/3 of the sweet tomato stock and stir continuously until absorbed.",
    "Continue to add the stock, a ladle at a time, stirring continuously for 15-20 minutes, until all the stock is absorbed and the rice is cooked — this is your risotto.",
    "Meanwhile, chop the chives finely.",
    "Grate the cheddar cheese.",
    "Once roasted, remove the roasted peppers from the oven.",
    "Stir half of the roasted peppers into the risotto (save the rest for garnish!).",
    "Once cooked, remove the risotto from the heat and stir in the grated cheese.",
    "Serve the risotto and garnish with the remaining roasted peppers and chopped chives."
  )
}
