package se.reciba.api.recipes

import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object BroccoliStiltonSoup extends Recipe {
  val name = "Broccoli and Stilton soup"
  override val permalink: Permalink =
    Permalink("broccoli-stilton-soup")

  override val description: Option[String] =
    Some("A rich and nutritious winter warmer")

  override val notes: Option[String] = Some(
    "The original recipe uses a 1:2 stilton to broccoli ratio rather than our decadent 1:1 ratio. If you'd prefer not to get gout then stick with the original ratio."
  )

  override val tags = Set(
    Tag.Slow,
    Tag.Vegetarian,
    Tag.Scales,
    Tag.Soup,
    Tag.LowEffort,
    Tag.Freezes,
    Tag.BetterNextDay,
    Tag.ColdWeather
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Broccoli", "2 heads"),
    Ingredient("Stilton", "220g"),
    Ingredient("Onion", "1 onion", "roughly chopped"),
    Ingredient("Garlic", "3 cloves", "diced"),
    Ingredient("Stock Cube", "1"),
    Ingredient("Boiled water", "1L"),
    Ingredient("Butter", "1 knob"),
    Ingredient("Ground Nutmeg"),
    Ingredient("Lemon Juice"),
    Ingredient("Salt")
  )
  val method = List(
    "Cut off the broccoli florets and chop the stalk into 2cm pieces.",
    "Heat a large pan over a medium heat then melt the knob of butter.",
    "Add the garlic and onions then soften for a few minutes.",
    "Add the broccoli stalks and cook for another minute.",
    "Add the broccoli florets, stock cube and enough water to cover all but the last inch of the mixture.",
    "Add a few drops of lemon juice and a small sprinkle of nutmeg.",
    "Bring to the boil then cover and simmer for 20 minutes.",
    "Roughly chop the stilton.",
    "Turn off the heat and blend.",
    "Put back over a low heat and add the stilton. Stir until melted. Be careful: the mixture will now stick more easily and possibly spit.",
    "Add more lemon juice and possibly salt to taste.",
    "Serve with fresh bread."
  )
}
