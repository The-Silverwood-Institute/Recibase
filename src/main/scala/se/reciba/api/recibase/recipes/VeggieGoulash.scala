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

case object VeggieGoulash extends Recipe {
  val name = "Veggie Goulash"

  override val permalink: Permalink = Permalink("veggie-goulash")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Pepper", "1"),
    Ingredient("Smoked paprika", "1 tsp"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Parsley", "5g"),
    Ingredient("Knorr vegetable stock cube", "1"),
    Ingredient("Chestnut mushrooms", "160g"),
    Ingredient("Henderson's Relish", "1 sachet (5ml)"),
    Ingredient("Soured cream", "1 pot (100g)"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Can of finely chopped tomatoes", "1 (210g)"),
    Ingredient("Can of butter beans", "1 (185g)"),
    Ingredient("White potatoes", "4"),
    Ingredient("Carrot", "1"),
    Ingredient("Butter"),
    Ingredient("Flour"),
    Ingredient("Milk"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt"),
    Ingredient("Sugar")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Boil a kettle.",
    "Chop the potatoes (skins on) into bite-sized pieces.",
    "Add the chopped potatoes to a pot with plenty of boiled water and a generous pinch of salt and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to medium and cook for 12-15 minutes or until fork-tender.",
    "Once done, drain and return to the pot to steam dry.",
    "Meanwhile, peel and finely chop (or grate) the garlic.",
    "Peel and finely dice the brown onion.",
    "Top, tail and dice the carrot.",
    "Drain and rinse the butter beans.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil over a medium heat.",
    "Once hot, add the chopped garlic, onion and carrot and cook for 4-5 minutes or until beginning to soften.",
    "Meanwhile, deseed the pepper (scrape the seeds and pith out with a teaspoon) and cut into thin strips.",
    "Tear the chestnut mushrooms into bite-size pieces.",
    "Once the onion has softened, add the cayenne pepper (can't handle the heat? Go easy!) and smoked paprika to the pan and give everything a good mix up.",
    "Add the sliced pepper and torn mushrooms with a splash of water and cook for 4-5 minutes or until everything has softened.",
    "Re-boil a kettle.",
    "Meanwhile, mash the drained potato with a knob of butter.",
    "Add 1 tbsp flour, a splash of milk, season with a generous pinch of salt and pepper and mix thoroughly.",
    "Line a baking tray with non-stick baking paper and add spoonfuls to the tray.",
    "Add a drizzle of olive oil, pat each spoonful of potato down and put the tray in the oven for 20 minutes or until golden — these are your potato cakes.",
    "Add the chopped tomato, Henderson's relish, butter beans and 1 tsp sugar to the pan with the vegetables.",
    "Crumble in the Knorr vegetable stock cube with 200ml boiled water.",
    "Give everything a good mix up and cook for 12-15 minutes further or until the sauce has thickened — this is your veggie goulash.",
    "Roughly tear the parsley.",
    "Serve the veggie goulash with the potato cakes and garnish with the soured cream and torn parsley."
  )
}
