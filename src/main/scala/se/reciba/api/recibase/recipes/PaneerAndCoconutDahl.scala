package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object PaneerAndCoconutDahl extends Recipe {
  val name = "Paneer & Coconut Dahl"

  override val permalink: Permalink = Permalink("paneer-and-coconut-dahl")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Garlic", "2 mini cloves"),
    Ingredient("Ground turmeric", "1 tsp"),
    Ingredient("Curry powder", "1 tbsp"),
    Ingredient("Red lentils", "100g"),
    Ingredient("Coconut cream", "1 sachet"),
    Ingredient("Vegetable stock mix", "1 sachet (11g)"),
    Ingredient("Paneer cheese", "200g"),
    Ingredient("Ground paprika", "1 tsp"),
    Ingredient("Nigella seeds", "1/2 tsp"),
    Ingredient("Cider vinegar", "1 sachet (30ml)"),
    Ingredient("Baby plum tomatoes", "125g"),
    Ingredient("Coriander", "5g"),
    Ingredient("Mini garlic & coriander naans", "2"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Boil a kettle.",
    "Peel and finely slice brown onion.",
    "Peel and finely chop (or grate) the garlic.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a medium heat.",
    "Once hot, add the sliced onion with a pinch of salt and cook for 5-7 minutes or until starting to soften.",
    "Meanwhile, remove the coconut cream from the sachet and chop it roughly (if required!).",
    "Dissolve the veg stock mix, coconut cream and a large pinch of sugar in 750ml boiled water — this is your coconut stock.",
    "Once the onion has softened, add the ground turmeric, curry powder and chopped garlic and cook for 1-2 minutes further or until fragrant.",
    "Add the red lentils and coconut stock to the pan and bring to the boil.",
    "Once boiling, reduce the heat to low and cook, covered, for 15-20 minutes or until the lentils are tender.",
    "While the lentils are cooking, chop the paneer into small bite-sized pieces.",
    "Add the chopped paneer to a bowl with the ground paprika, nigella seeds, a drizzle of vegetable oil and a pinch of salt and give everything a good mix up — this is your paprika coated paneer.",
    "Chop the coriander finely, including the stalks.",
    "Chop the baby plum tomatoes in half.",
    "Add the halved tomatoes to the pan and cook for 5-7 minutes further or until the tomatoes have softened and the lentils are fully cooked.",
    "Stir most of the chopped coriander (save some for garnish!) through the lentils — this is your tomato & coconut dal.",
    "Heat a separate large, wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a medium-high heat.",
    "Once hot, add the paprika coated paneer and cook for 4-5 minutes.",
    "Add the cider vinegar and cook for further 1-2 minutes or until the paneer is golden.",
    "Meanwhile, add the mini garlic & coriander naans to a baking tray and put the tray in the oven for 3-4 minutes until warmed through.",
    "Serve the paprika paneer over the tomato & coconut dal with the warmed mini garlic & coriander naans to the side."
  )
}
