package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object GoanKingPrawnBalchao extends Recipe {
  val name = "Goan King Prawn Balchão"

  override val permalink: Permalink = Permalink("goan-king-prawn-balchao")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red onions", "2"),
    Ingredient("Garlic", "2 cloves"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Ground coriander", "1 tsp"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Tomato paste", "32g"),
    Ingredient("King prawns", "200g"),
    Ingredient("Tamarind paste", "15g"),
    Ingredient("Cider vinegar", "1 sachet (30ml)"),
    Ingredient("Sugar", "1 tsp"),
    Ingredient("Baby leaf spinach", "80g"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Peel and dice the red onions (as finely as you can!).",
    "Heat a large, wide-based pan (preferably non-stick) with a generous drizzle of vegetable oil over a medium heat.",
    "Once hot, add the diced onion with a pinch of salt and cook for 10-12 minutes or until softened.",
    "Meanwhile, peel (scrape the skin off with a teaspoon) and roughly chop the ginger.",
    "Peel and roughly chop the garlic.",
    "Add the chopped garlic, ginger, ground coriander, ground cumin, chilli flakes, cayenne pepper (can't handle the heat? Go easy!) and a generous pinch of salt to a pestle & mortar and grind to a smooth paste.",
    "Add 2 tbsp vegetable oil and give everything a good mix up — this is your Balchão spice paste.",
    "Once the onion has softened, add the Balchão spice paste and tomato paste to the pan and cook for 4-5 minutes or until fragrant.",
    "Meanwhile, add the basmati rice and 300ml cold water to a pot with a lid and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to low and cook, covered, for 10-12 minutes or until all the water has absorbed and the rice is cooked.",
    "Once done, remove from the heat and keep covered until serving.",
    "Add the king prawns, tamarind paste, cider vinegar and 1 tsp sugar and cook for 2-3 minutes or until the prawns are almost cooked through.",
    "Add the baby leaf spinach with 60ml cold water and cook for a further 2-3 minutes or until the spinach has just wilted and the sauce is thickened to a curry-like consistency — this is your Goan prawn Balchão curry.",
    "Serve the Goan prawn Balchão curry over the basmati rice."
  )
}
