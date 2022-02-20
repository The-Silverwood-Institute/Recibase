package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object BroccoliSalmonQuiche extends Recipe {
  val name = "Broccoli & Salmon Quiche"
  val url = "broccoli-salmon-quiche"

  override val notes: Option[String] =
    Some(
      "Consider using the remaining broccoli stalks and stilton in a broccoli and stilton soup."
    )

  val ingredients =
    List(
      Ingredient(
        "Broccoli Florets",
        Some("100g"),
        Some("Cut to 1-3cm pieces"),
        Some("Save the stalks for a soup")
      ),
      Ingredient("Smoked Salmon", "120g", "Cut into 2cm pieces"),
      Ingredient("Stilton", "50g"),
      Ingredient("Shortcrust Pastry Sheet", "230g"),
      Ingredient("Eggs", "3"),
      Ingredient("Mascarpone Cheese", "2 tbsp"),
      Ingredient("Pepper")
    )
  val method =
    List(
      "Add the mascarpone cheese to a mixing bowl. It may need a few seconds in the microwave to warm up.",
      "Beat in the two eggs.",
      "Mix in the broccoli and salmon pieces",
      "Lay the shortcrust pastry sheet over a 9 inch flan dish and gently push into the edges.",
      "Snip off any excess pastry escaping the dish. You can save this to bake mini sweet treats.",
      "Pour the mixture into the pastry dish, spreading it evenly.",
      "Bake in the oven at 200C/gas 6 for 20 minutes"
    )
}
