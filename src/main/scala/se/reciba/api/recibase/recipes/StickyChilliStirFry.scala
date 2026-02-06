package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object StickyChilliStirFry extends Recipe {
  val name = "Sticky Chilli Stir Fry"

  override val permalink: Permalink = Permalink("sticky-chilli-stir-fry")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red pepper", "1"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Spring onion", "1"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Chilli jam", "1 pot (40g)"),
    Ingredient("Rice vinegar", "1 sachet (15ml)"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Toasted sesame oil", "1 sachet (15ml)"),
    Ingredient("Toasted sesame seeds", "1 sachet (5g)"),
    Ingredient("Meatless Farm mince", "200g"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Add the basmati rice and 300ml cold water to a pot with a lid and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to very low and cook, covered, for 10-12 minutes or until all the water has absorbed and the rice is cooked.",
    "Once cooked, remove from the heat and keep covered until serving.",
    "Whilst the rice is cooking, heat a large, wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a medium-high heat.",
    "Once hot, add the meat-free mince and cook for 5-6 minutes or until browned and crisped.",
    "While the mince is cooking, deseed the red pepper (scrape the seeds and pith out with a teaspoon) and slice into small, bite-sized pieces.",
    "Peel (scrape the skin off with a teaspoon) and finely chop (or grate) the ginger.",
    "Peel and finely chop (or grate) the garlic.",
    "Trim, then finely slice the spring onion.",
    "Once the meat-free mince has browned, add the sliced red pepper to the pan and cook for 2-3 minutes until the pepper has started to soften.",
    "Meanwhile, add the rice vinegar, soy sauce, sesame oil and chilli jam to a bowl with 2 tsp sugar and 1 tbsp cold water and give it a good mix up — this is your sticky chilli sauce.",
    "Add the sticky chilli sauce to the pan and cook for 1-2 minutes further or until everything is coated and the sauce has thickened.",
    "Serve the sticky chilli stir fry over the basmati rice and garnish with the toasted sesame seeds and sliced spring onion."
  )
}
