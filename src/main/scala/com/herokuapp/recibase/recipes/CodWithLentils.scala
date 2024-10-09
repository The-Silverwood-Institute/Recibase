package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

case object CodWithLentils extends Recipe {
  val name = "Cod with Lentils"

  override val source: Option[String] = Some(
    "Sand Dollar Café, Aberdeen"
  )
  override val tags = Set(Tag.Pescatarian, Tag.LowEffort, Tag.Quick)

  override val notes: Option[String] = Some(
    "The green lentils are an essential part of the dish, so don't substitute them for red lentils."
  )

  val ingredients = List(
    Ingredient("Red Onion", "1", "chopped"),
    Ingredient("Cod Fillets", "2"),
    Ingredient("Green Lentils", "2 400g tin"),
    Ingredient("Butter"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Lemon Juice")
  )
  val method = List(
    "Salt and pepper the cod. Wrap in tin foil then cook per packet instructions.",
    "Meanwhile, drain the tins of green lentils into a sieve. Rinse and set aside.",
    "Heat a knob of butter in a saucepan.",
    "Add the onion and cook over a medium heat until soft.",
    "Tip in the green lentils and gently heat up. Stir the lentils gently as it's important the lentils don't turn to mush.",
    "Season with salt, pepper and a dash of lemon juice. Add more butter if needed.",
    "Serve the lentil and onions with the cod on top."
  )
}
