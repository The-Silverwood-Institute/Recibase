package se.reciba.api.recipes

import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object ParsnipGingerSoup extends Recipe {
  val name = "Parsnip & Ginger Soup"
  override val permalink: Permalink =
    Permalink("parsnip-and-ginger-soup")

  val tags = Set(Tag.Soup, Tag.VeganIsh, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Parnsips", "450g", "Diced"),
    Ingredient("Onion", "1", "Diced"),
    Ingredient(
      "Potato",
      Some("1"),
      None,
      Some("Optional, subtitute for flour")
    ),
    Ingredient("Orange", "1", "Grate the rind and juice"),
    Ingredient("Fresh Ginger", "2.5cm", "Grated"),
    Ingredient("Stock cube"),
    Ingredient("Butter"),
    Ingredient("Single Cream", Some("250ml"), None, Some("Optional"))
  )
  val method = List(
    "Melt the butter in a large pan then stir in the parsnips, onion, flour, ginger and orange rind.",
    "Dissolve the stock in 500ml - 1L of water then mix in and bring to the boil.",
    "Simmer for 20 minutes or so, until the parsnips are soft.",
    "Blend the mixture to your desired consistency.",
    "Stir in the orange juice and reheat, without boiling.",
    "Add cream, if desired."
  )
}
