package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object MildPaneerCurry extends Recipe {
  val name = "Mild Paneer Curry"

  override val permalink: Permalink = Permalink("mild-paneer-curry")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Tomatoes", "2"),
    Ingredient("Garlic cloves", "2"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Ground turmeric", "1 tsp"),
    Ingredient("Garam masala", "1 tbsp"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Kallo vegetable stock cube", "1"),
    Ingredient("Tomato paste", "1 sachet (32g)"),
    Ingredient("Paneer cheese", "226g"),
    Ingredient("Bag of sultanas", "1 (30g)"),
    Ingredient("Clotted cream", "1 pot (80g)"),
    Ingredient("Butter"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Add a knob of butter to a pot with a lid over a medium heat.",
    "Once melted, add the basmati rice with a pinch of the ground turmeric (save the rest for later!).",
    "Cook for 30 seconds or until the grains are coated in the spices.",
    "Add 300ml cold water and the sultanas and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to very low and cook, covered, for 10-15 minutes or until all the water has absorbed and the rice is cooked — this is your sultana rice.",
    "Meanwhile, boil a kettle.",
    "Peel and finely chop the brown onion.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a medium heat.",
    "Once hot, add the chopped onion with a pinch of salt and cook for 3-4 minutes or until beginning to soften.",
    "While the onions are cooking, cut the paneer into large, bite-sized pieces.",
    "Peel and finely chop (or grate) the garlic.",
    "Peel (scrape the skin off with a teaspoon) and finely chop (or grate) the ginger.",
    "Chop the tomatoes roughly.",
    "Once the onion is beginning to soften, add the chopped paneer and cook for 1-2 minutes.",
    "Add the chopped tomatoes, garlic, ginger, remaining ground turmeric, tomato paste and garam masala to the pan and cook for 1 minute or until fragrant.",
    "Crumble in the Kallo vegetable stock cube with 200ml boiled water and bring to the boil.",
    "Once boiling, reduce the heat to low and cook for 8-10 minutes or until the sauce has thickened.",
    "Stir in the clotted cream and cook for 1-2 minutes further — this is your mild paneer curry.",
    "Serve the mild paneer curry over the sultana rice."
  )
}
