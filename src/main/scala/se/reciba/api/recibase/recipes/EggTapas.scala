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

case object EggTapas extends Recipe {
  val name = "Egg Tapas"

  override val permalink: Permalink = Permalink("egg-tapas")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("British free-range eggs", "2"),
    Ingredient("Red pepper", "1"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Spring onion", "1"),
    Ingredient("Coriander", "10g"),
    Ingredient("Knorr vegetable stock cube", "1"),
    Ingredient("Mayonnaise", "1 sachet (50ml)"),
    Ingredient("Chipotle paste", "1 sachet (20g)"),
    Ingredient("White potatoes", "4"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Can of cannellini beans", "1 (400g)"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt"),
    Ingredient("Sugar")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Cut the potatoes (skins on) into bite-sized pieces.",
    "Add them to a baking tray, drizzle with olive oil, season with cayenne pepper (can't handle the heat? Go easy!), salt and pepper, then put in the oven for 25-30 minutes or until golden and crisp — these are your crispy potatoes.",
    "Chop the coriander finely, including the stalks.",
    "Deseed the red pepper (scrape the seeds and pith out with a teaspoon) and cut into thin strips.",
    "Peel and slice the brown onion finely.",
    "Peel and chop (or grate) the garlic finely.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil over a medium-high heat.",
    "Once hot, add the sliced pepper and onion with a pinch of both salt and sugar.",
    "Cook for 7-9 minutes or until they've softened.",
    "Once softened, add the chopped garlic and cook for a further 1 minute.",
    "Meanwhile, dissolve the Knorr vegetable stock cube in 200ml boiled water, then stir in half of the chipotle paste.",
    "Add the remaining chipotle paste, mayonnaise and a drizzle of olive oil to a bowl and give it a good mix up — this is your smoky mayo.",
    "Season with a pinch of both salt and pepper.",
    "Once your potatoes are almost cooked, prepare the eggs for the next step!",
    "Heat another large, wide-based pan (preferably non-stick with a matching lid) with 1 tbsp olive oil over a medium-high heat.",
    "Crack the eggs into a bowl, and once the pan's hot, add the eggs in one go.",
    "Cover with a lid and cook for 2-3 minutes or until done to your liking, then remove from the heat and season with pepper.",
    "Stir the remaining chopped coriander through the cannellini beans.",
    "Serve the crispy potatoes with the red pepper and white bean stew, topped with the fried egg and a dollop of smoky mayo."
  )
}
