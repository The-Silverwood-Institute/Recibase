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

case object MexicanTofu extends Recipe {
  val name = "Mexican Tofu"

  override val permalink: Permalink = Permalink("mexican-tofu")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Yellow pepper", "1"),
    Ingredient("Smoked tofu", "225g"),
    Ingredient("Brown rice", "100g"),
    Ingredient("Can of kidney beans", "1 (400g)"),
    Ingredient("Knorr vegetable stock cube", "1"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Garlic", "1 clove"),
    Ingredient("Coriander", "10g"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Rinse the brown rice, add it to a pot with plenty of cold water and a pinch of salt and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to medium and cook for 20-25 minutes or until it's tender with a slight bite.",
    "Once cooked, drain and return it to the pot and keep covered until serving.",
    "Combine the ground cumin and 2 tbsp olive oil in a bowl and season with a generous pinch of salt and pepper — this is your spice rub.",
    "Deseed the yellow pepper (scrape the seeds and pith out with a teaspoon) and cut into thick strips.",
    "Drain the smoked tofu and pat it dry with kitchen paper, then cut it into thick slices.",
    "Add the sliced tofu and chopped vegetables to a baking tray with the spice rub and give everything a good mix up.",
    s"Put the tray in the oven for 15-20 minutes or until the vegetables are tender and the tofu is golden — this is your Mexican tofu and vegetables.",
    "Meanwhile, boil a kettle.",
    "Peel and finely chop (or grate) the garlic.",
    "Chop the coriander finely (including the stalks), reserving a few leaves for garnish.",
    "Dissolve the Knorr vegetable stock cube in 250ml boiled water.",
    "Drain and rinse the kidney beans.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil over a medium heat.",
    "Once hot, add the chopped garlic and cook for 1-2 minutes.",
    "Add the vegetable stock and kidney beans and cook for 3-4 minutes or until warmed through.",
    "Serve the Mexican tofu and vegetables over the brown rice with the kidney beans and garnish with the reserved coriander leaves."
  )
}
