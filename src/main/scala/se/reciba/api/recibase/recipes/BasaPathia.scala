package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Permalink, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object BasaPathia extends Recipe {
  val name = "Basa Pathia"

  override val permalink: Permalink = Permalink("basa-pathia")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1", "finely chopped"),
    Ingredient("Cumin seeds", "1 tsp"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Curry powder", "1/2 tbsp"),
    Ingredient("Coriander", "5g"),
    Ingredient("Basa fillets", "200g"),
    Ingredient("Tamarind paste", "15g"),
    Ingredient("Ground turmeric", "1/2 tsp"),
    Ingredient("Tomato paste", "32g"),
    Ingredient("Basmati rice", "100g"),
    Ingredient("Garlic Clove", "2", "finely chopped"),
    Ingredient("Fresh root ginger", "15g", "finely chopped"),
    Ingredient("Naan", "2"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Oil")
  )

  val method = List(
    s"Preheat the oven to ${200.celsius} (fan ${180.celsius}).",
    "Heat a wide-based pan (preferably non-stick) with a drizzle of vegetable oil over a medium heat.",
    "Once hot, add the chopped onion with a generous pinch of salt and cook for 6-8 minutes or until softened.",
    "Meanwhile, heat a pot with a matching lid with a generous drizzle of vegetable oil over a medium heat.",
    "Once hot, add the cumin seeds and cook for 1-2 minutes or until sizzling.",
    "Once the cumin seeds start to sizzle, carefully add the basmati rice and stir it all together.",
    "Add the ground turmeric and 250ml cold water with a pinch of salt to the pot and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to very low and cook, covered, for 10-12 minutes or until the water has absorbed and the rice is cooked.",
    "Once cooked, remove from the heat and keep covered until serving.",
    "Add the ginger and garlic to the pan and cook for 1-2 minutes further or until fragrant.",
    "Once fragrant, add the ground cumin, curry powder and cayenne pepper with the tomato paste and stir it all together.",
    "Add the tamarind paste with 150ml boiled water and 2 tsp sugar and cook for 4-5 minutes or until the sauce is beginning to thicken.",
    "Add the chopped basa fillets and cook for 3-4 more minutes or until the fish is cooked through.",
    "Heat up the naans per packet instruction.",
    "Garnish with coriander."
  )
}
