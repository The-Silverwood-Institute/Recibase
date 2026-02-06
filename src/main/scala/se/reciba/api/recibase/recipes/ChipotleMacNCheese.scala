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

case object ChipotleMacNCheese extends Recipe {
  val name = "Chipotle Mac 'n' Cheese"

  override val permalink: Permalink = Permalink("chipotle-mac-n-cheese")
  val tags = Set(Tag.AI, Tag.Vegetarian, Tag.Scales, Tag.Stodge)

  override val source: Option[String] = "Gousto".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Yellow pepper", "1", "cut into thin strips"),
    Ingredient("Red pepper", "1", "cut into thin strips"),
    Ingredient("Red onion", "1", "sliced"),
    Ingredient("Macaroni", "150g"),
    Ingredient("Vegetable stock cube", "1"),
    Ingredient("Spring onion", "1", "finely sliced"),
    Ingredient("Smoked paprika", "2 tsp"),
    Ingredient("Chipotle paste", "40g"),
    Ingredient("Tomato paste", "1 tbsp"),
    Ingredient("Cheddar cheese", "80g", "grated"),
    Ingredient("Panko breadcrumbs", "30g"),
    Ingredient("Creme fraiche", "200g"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Heat a wide-based pan (preferably non-stick with a matching lid) with a drizzle of vegetable oil over a medium heat.",
    "Once hot, add the peppers and cook, covered, for 4-5 min.",
    "Meanwhile, boil a kettle.",
    "Add the sliced onion to the pan with a pinch of salt and cook, covered, for a further 4-5 min.",
    "While the onion is cooking, add the macaroni to a pot of boiled water with a large pinch of salt and bring to the boil over a high heat.",
    "Cook for 7 min or until it's cooked with a slight bite.",
    "Once done, drain the macaroni, reserving 250ml of the starchy pasta water.",
    "Combine the panko breadcrumbs, smoked paprika, a pinch of salt and a generous drizzle of vegetable oil.",
    "Dissolve the vegetable stock cube in the reserved pasta water.",
    "Once the onion has softened, add the chipotle paste, tomato paste, drained macaroni, creme fraiche, grated cheddar and the starchy pasta stock.",
    "Give everything a good old mix up.",
    "Transfer the chipotle mac 'n' cheese to an oven-proof dish. Ideally one small dish per person.",
    "Top with the smoky panko breadcrumbs.",
    "Put the dish in the oven for 10 min or until bubbling and crispy.",
    "Remove the chipotle mac 'n' cheese from the oven and leave to stand until cooled slightly.",
    "Garnish with the sliced spring onion."
  )
}
