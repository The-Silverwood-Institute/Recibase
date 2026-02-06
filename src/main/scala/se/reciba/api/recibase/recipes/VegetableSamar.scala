package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object VegetableSamar extends Recipe {
  val name = "Vegetable Samar"

  override val permalink: Permalink = Permalink("vegetable-samar")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Tomatoes", "2"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Garam masala", "4 tbsp"),
    Ingredient("Ground fenugreek", "2 tsp"),
    Ingredient("Ground turmeric", "1/2 tsp"),
    Ingredient("Coriander", "5g"),
    Ingredient("Tamarind paste", "30g"),
    Ingredient("Ginger & garlic paste", "1 sachet (15g)"),
    Ingredient("Basmati rice", "100g"),
    Ingredient("Cultured coconut", "80g"),
    Ingredient("Vegetable stock mix", "1 sachet (11g)"),
    Ingredient("Fine green beans", "460g"),
    Ingredient("Red lentils", "100g"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Boil a kettle.",
    "Peel and roughly slice the brown onion.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a medium heat.",
    "Once hot, add the sliced onion with a pinch of salt and cook for 4-5 minutes or until beginning to soften.",
    "While the onion softens, dissolve the vegetable stock mix in 300ml boiled water.",
    "Chop the tomatoes roughly.",
    "Trim, then chop the green beans roughly.",
    "Once the onion is beginning to soften, add the garam masala, ground fenugreek, ground turmeric and cayenne pepper (can't handle the heat? Go easy!) to the pan.",
    "Add the ginger & garlic paste and cook for 1-2 minutes further or until fragrant.",
    "Rinse the red lentils in a sieve under the cold running water.",
    "Once fragrant, add the red lentils, vegetable stock and tamarind paste to the pan with the onion.",
    "Give everything a good mix up and bring to the boil over a high heat.",
    "Add the chopped green beans and tomatoes to the pan and cook, stirring occasionally, until everything is tender — this is your fragrant vegetable sambar.",
    "Meanwhile, add the basmati rice and 250ml cold water to a pot with a lid and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to very low and cook, covered, for 10-12 minutes or until all the water has been absorbed and the rice is cooked.",
    "Once cooked, remove from the heat and keep covered until serving.",
    "Chop the coriander finely.",
    "Serve the vegetable sambar over the basmati rice and garnish with the chopped coriander."
  )
}
