package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object UdonAndSesameFriedEgg extends Recipe {
  val name = "Udon & Sesame Fried Egg"

  override val permalink: Permalink = Permalink("udon-and-sesame-fried-egg")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Pepper", "1"),
    Ingredient("Carrot", "1"),
    Ingredient("British free-range eggs", "2"),
    Ingredient("Coriander", "5g"),
    Ingredient("Sriracha hot chilli sauce", "1 sachet (8ml)"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Mirin", "1 sachet (15ml)"),
    Ingredient("Sesame seed", "1 sachet (5g)"),
    Ingredient("Udon noodles", "400g"),
    Ingredient("Cornflour", "3g"),
    Ingredient("Blanched edamame beans", "80g"),
    Ingredient("Ginger & garlic paste", "1 sachet (15g)"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Deseed the pepper (scrape the seeds and pith out with a teaspoon) and cut into thin strips.",
    "Top, tail, peel and grate the carrot.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a high heat.",
    "Once hot, add the sliced pepper and ginger & garlic paste to the pan with a pinch of salt and cook for 1-2 minutes or until the pepper starts to soften.",
    "Meanwhile, heat a separate, large wide-based pan (preferably non-stick with a matching lid), with a drizzle of vegetable oil over a medium-high heat.",
    "Once hot, add the sesame seeds then crack the eggs into the pan, over the sesame seeds.",
    "Cook, covered, for 2-3 minutes or until done to your liking — these are your sesame fried eggs.",
    "Once the pepper has softened, add the udon noodles and cook for 3-4 minutes or until warmed through.",
    "Add the grated carrot to the pan and cook for 1-2 minutes further or until the carrot has softened slightly.",
    "Tip: Gently separate the noodles with a fork!",
    "Whilst everything is cooking, add the soy sauce to a bowl with the mirin, sriracha, cornflour and 4 tbsp cold water and mix until smooth — this is your spicy soy sauce.",
    "Once the carrot has softened, add the edamame beans and spicy soy sauce to the pan and cook for 2-3 minutes until everything is warmed through and fully coated in the sauce — this is your veggie udon stir-fry.",
    "Chop the coriander roughly.",
    "Serve the veggie udon stir-fry and top with the sesame fried eggs and chopped coriander."
  )
}
