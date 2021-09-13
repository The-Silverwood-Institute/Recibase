package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object NewYorkBagel {
  val recipe = Recipe(
    "New York Bagels",
    "new-york-bagels",
    Some(
      "https://www.thevegspace.co.uk/recipe-four-fabulously-filling-bagel-toppings/"
    ),
    Some(
      "A vegetarian take on the classic pastrami bagel"
    ),
    None,
    None,
    List("lunch"),
    None,
    List(
      Ingredient("Bagels", "4"),
      Ingredient("Squeaky Bean Deli Pastrami", "180g"),
      Ingredient(
        "Cooked Beetroot",
        Some("180g"),
        None,
        Some("with chilli, if available")
      ),
      Ingredient("Pickles"),
      Ingredient(
        "Cheese",
        None,
        None,
        Some("ideally something fancy like Comté")
      ),
      Ingredient("Mayonnaise", None, None, Some("optional"))
    ),
    List(
      "Halve and lightly toast the bagels.",
      "Slice the beetroot, pickles and cheese.",
      "Layer the bottom half of each bagel with pastrami, pickels, beetroot and then cheese. Make sure the cheese covers everything so it doesn't burn.",
      "Grill the bottom halves of the bagels until the cheese is bubbly.",
      "Optionally spread the top half of each bagel with mayo.",
      "Combine the top and bottom halves of the bagels and serve."
    )
  )
}
