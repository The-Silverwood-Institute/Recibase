package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object OnionBhajiBurger extends Recipe {
  val name = "Onion Bhaji Burger"

  override val permalink: Permalink = Permalink("onion-bhaji-burger")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onions", "2"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Coriander", "10g"),
    Ingredient("Cucumber", "1/2"),
    Ingredient("Mango chutney", "1 pot (20g)"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Curry powder", "2 tbsp"),
    Ingredient("Cornflour", "2 tbsp"),
    Ingredient("White potatoes", "3"),
    Ingredient("Plant-based brioche buns", "2"),
    Ingredient("Coconut yoghurt", "1 pot"),
    Ingredient("Mint sauce", "1 sachet"),
    Ingredient("Baby leaf salad", "50g"),
    Ingredient("Flour"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil"),
    Ingredient("Olive oil")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Peel and dice the potatoes (skins on) into thin chips, then add them to a baking tray with a generous drizzle of vegetable oil and a pinch of salt.",
    "Give everything a good mix up and put the tray in the oven for 25-30 minutes or until crisp.",
    "Meanwhile, peel and finely slice the brown onions (as finely as you can!).",
    "Peel (scrape the skin off with a teaspoon) and finely chop (or grate) the ginger.",
    "Peel and finely chop (or grate) the garlic.",
    "Chop the coriander roughly (including the stalks).",
    "Add 60g flour to a large bowl along with the cornflour, curry powder and a generous pinch of salt.",
    "Add 100ml cold water and mix thoroughly to a smooth, thick batter — this is your spiced batter.",
    "Add the sliced onion, chopped coriander, ginger and garlic to the bowl with the spiced batter and gently mix until all of the onion is coated — this is your onion mixture.",
    "Heat a large, wide-based pan (preferably non-stick) with a very generous drizzle of vegetable oil (enough to fully coat the bottom of the pan) over a high heat.",
    "Once very hot, add 4 large spoonfuls of the onion mixture to the pan and cook for 3-4 minutes on each side until crispy and golden.",
    "Once done, add the patties to a plate and set aside — these are your onion bhaji patties.",
    "While the patties are cooking, grate half the cucumber and dice the rest.",
    "Add the grated cucumber to a bowl with the coconut yoghurt, mint sauce and a pinch of salt.",
    "Give it a good mix up — this is your coconut raita.",
    "Wash the baby leaf salad, then add it to a bowl with the diced cucumber and a drizzle of olive oil — this is your cucumber salad.",
    "Once the chips are almost done, remove the tray from the oven and sprinkle over the chilli flakes (can't handle the heat? Go easy!) — these are your chilli chips.",
    "Slice the plant-based brioche buns in half, add them to the tray with the chips and return the tray to the oven for 3-4 minutes until the brioche is warmed through.",
    "Spread a dollop of coconut raita on the base of each warmed brioche bun, then top with the onion bhaji patties, mango chutney, cucumber salad and the top of the bun."
  )
}
