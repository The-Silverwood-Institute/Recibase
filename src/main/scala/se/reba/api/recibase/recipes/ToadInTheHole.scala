package se.reciba.api.recipes

import se.reciba.api.model.{
  Image,
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object ToadInTheHole extends Recipe {
  val name = "Toad in the Hole"
  override val permalink: Permalink =
    Permalink.fromRawString("toad-in-the-hole")

  override val source: Option[String] = Some("Jeremy")
  override val notes: Option[String] = Some(
    "If you're using vegetarian sausages don't fully cook them beforehand, otherwise they get too dry."
  )
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/toad-in-the-hole.jpg")
  )
  override val tags = Set(Tag.Vegetarian, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Sausages", "6"),
    Ingredient("Plain Flour", "150g"),
    Ingredient("Eggs", "2"),
    Ingredient("Milk", "125ml"),
    Ingredient("Water", "125ml"),
    Ingredient("Salt", "A pinch"),
    Ingredient("Gravy granules", "7 tsp"),
    Ingredient("Red wine"),
    Ingredient("Marmite", "1/2 tsp")
  )
  val method = List(
    "Cook the sausages. Then turn the oven up to 200C.",
    "Sift the flour into a mixing bowl.",
    "Add the salt, eggs, water and milk.",
    "Whisk the ingredients for a few minutes.",
    "Brush a 20cm by 26cm by 4cm baking tray with oil.",
    "Warm the baking tray in the oven for 4 minutes",
    "Evenly pour half the batter into the baking tray.",
    "Place the sausages in the batter.",
    "Pour the remainder of the batter over the sausages.",
    "Bake in the oven for 25-30 minutes. You MUST NOT open the oven while it is cooking.",
    "Meanwhile add the gravy granules and a splash of red wine to a measuring jug.",
    "Top up the jug with boiling water to 400ml.",
    "Stir in the marmite. Add more water if the gravy is too thick.",
    "Serve the toad in the hole with lashings of gravy."
  )
}
