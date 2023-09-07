package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

case object BirthdayCake extends Recipe {
  override val name: String = "Birthday Cake"

  override val source: Option[String] = Some(
    "Kit's Mum"
  )

  override val description: Option[String] = Some(
    "My mum's classic madeira cake recipe, with buttercream icing!"
  )

  override val notes: Option[String] = Some(
    "You can optionally slice off the top of the cake, to provide a flat surface for easier decoration."
  )

  override val tags = Set(Tag.Pudding)

  override val ingredients: List[Ingredient] = List(
    Ingredient("Butter", "5oz"),
    Ingredient("Caster Sugar", "5oz"),
    Ingredient("Eggs", "3"),
    Ingredient("Self raising flour", "8oz"),
    Ingredient("Lemon essence", "1/4 teaspoon")
  )

  override val method: List[String] = List(
    "Pre-heat the oven to 165-180 C (325-350 F, gas mark 3-4).",
    "Cream the butter and sugar.",
    "Lightly whisk the eggs and add to the mixture.",
    "Add the lemon essence.",
    "Fold in the flour.",
    """Put the mixture in a deep 6" or 7" cake tin.""",
    "Bake in the oven for 1 1/4 hours."
  )
}
