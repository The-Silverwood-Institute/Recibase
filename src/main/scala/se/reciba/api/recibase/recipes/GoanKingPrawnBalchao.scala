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
  val tags =
    Set(Tag.Pescatarian, Tag.LowEffort, Tag.Quick, Tag.Spicy, Tag.Scales)

  override val source: Option[String] = "Gousto".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red onions", "2", "finely diced"),
    Ingredient("Garlic", "3 cloves", "roughly chopped"),
    Ingredient("Fresh root ginger", "15g", "peeled and roughly chopped"),
    Ingredient("Ground coriander", "1 tsp"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Tomato paste", "32g"),
    Ingredient("King prawns", "171g"),
    Ingredient("Tamarind paste", "15g"),
    Ingredient("Cider vinegar", "30ml"),
    Ingredient("Sugar", "1 tsp"),
    Ingredient("Baby leaf spinach", "80g"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil"),
    Ingredient("Water", "300ml")
  )

  val method = List(
    "Fry the onion in a wide pan with a generous drizzle of vegetable oil over a medium heat for 10-12 min or until softened.",
    "Rinse the rice and cook in the water for 10-12 minutes.",
    "Add the chopped garlic, ginger, ground coriander, ground cumin, chilli flakes, cayenne pepper and a generous pinch of salt to a pestle & mortar and grind to a smooth paste. Add 2 tbsp vegetable oil and give everything a good mix up.",
    "Once the onion has softened, add the Balchao spice paste and tomato paste to the pan and cook for 4-5 min or until fragrant.",
    "Add the king prawns, tamarind paste, cider vinegar and 1 tsp sugar and cook for 2-3 min or until the prawns are almost cooked through.",
    "Add the baby leaf spinach with 60ml cold water and cook for a further 2-3 min or until the spinach has just wilted and the sauce is thickened to a curry-like consistency.",
    "Serve the Goan prawn Balchao curry over the basmati rice."
  )
}
