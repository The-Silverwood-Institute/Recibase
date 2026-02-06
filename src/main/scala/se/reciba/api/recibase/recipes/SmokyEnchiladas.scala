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

case object SmokyEnchiladas extends Recipe {
  val name = "Smoky Enchiladas"

  override val permalink: Permalink = Permalink("smoky-enchiladas")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Coriander", "10g"),
    Ingredient("Cherry tomatoes", "125g"),
    Ingredient("Smoked paprika", "2 tsp"),
    Ingredient("Ground cumin", "1 tsp"),
    Ingredient("Dried chilli flakes", "1 tsp"),
    Ingredient("Tomato paste", "32g"),
    Ingredient("Vegetable stock mix", "1 sachet (11g)"),
    Ingredient("Meatless Farm mince", "200g"),
    Ingredient("Plain tortillas", "6"),
    Ingredient("Cheddar cheese", "80g"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Boil half a kettle.",
    "Peel and finely chop the brown onion.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil over a medium heat.",
    "Once hot, add the chopped onion with a pinch of salt and cook for 4-5 minutes or until softened.",
    "While the onions are cooking, dissolve the vegetable stock mix and tomato paste in 250ml boiled water — this is your tomato stock.",
    "Once the onion has softened, add the meat-free mince, ground cumin, smoked paprika and chilli flakes (can't handle the heat? Go easy!) to the pan and cook for 4-6 minutes or until browned, breaking it up with a wooden spoon as you go.",
    "Meanwhile, grate the cheddar cheese.",
    "Increase the heat to high and add the tomato stock and cook for 2-3 minutes further or until the sauce has thickened to a ragù-like consistency — this is your smoky meat-free mince filling.",
    "Grease an oven-proof dish with a little olive oil.",
    "Once thickened, divide the smoky meat-free mince filling between the tortillas.",
    "Roll each tortilla up and arrange them into the greased oven-proof dish.",
    "Top with the grated cheese and a drizzle of olive oil.",
    s"Put the dish in the oven for 8-10 minutes or until beginning to crisp and the cheese has melted — this is your smoky meat-free mince enchiladas.",
    "Garnish with the chopped coriander and serve."
  )
}
