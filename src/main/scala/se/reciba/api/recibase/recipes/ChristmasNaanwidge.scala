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

case object ChristmasNaanwidge extends Recipe {
  val name = "Christmas Naanwidge"

  override val permalink: Permalink = Permalink("christmas-naanwidge")
  val tags = Set(Tag.AI, Tag.Christmas, Tag.Stodge, Tag.Vegetarian, Tag.Spicy)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Coriander", "10g"),
    Ingredient("Ground turmeric", "1 tsp"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Curry powder", "1 tbsp"),
    Ingredient("Carrot", "1", "grated"),
    Ingredient("Parsnip", "1", "peeled into ribbons"),
    Ingredient("Potatoes", "3", "peeled and diced into small cubes"),
    Ingredient("Paneer", "200g", "chopped into cubes"),
    Ingredient("Greek-style yoghurt", "100g"),
    Ingredient("Smoked paprika", "1 tsp"),
    Ingredient("Cranberry sauce", "40g"),
    Ingredient("Plain naans", "2"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Oil")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Add the diced potatoes to one side of a baking tray and sprinkle with half the curry powder, season with a pinch of salt and pepper and drizzle with vegetable oil.",
    "Give everything a good mix up and put the tray in the oven for an initial 6-8 min.",
    "Stir together the ground turmeric, smoked paprika and chilli flakes in a large bowl with the remaining curry powder, half the Greek-style yoghurt and a pinch of salt and pepper.",
    "Add the chopped paneer to the tandoori marinade and give everything a good mix up.",
    "After the potatoes have had their initial 6-8 min, add the tandoori paneer to the other side of the baking tray.",
    "Return the tray to the oven and cook for a further 10-12 min or until golden and soft.",
    "Combine the cranberry sauce, tamarind paste and grated carrot in a bowl to make tamarind & cranberry slaw.",
    "Chop the coriander finely, including the stalks (saving a few whole leaves to garnish).",
    "Once the golden tandoori paneer is cooked, transfer it to a clean chopping board and reserve the tray.",
    "Add the parsnip ribbons to the reserved tray and return it to the oven for 5 min further or until both the potatoes and parsnips are golden and crispy.",
    "Put the plain naans in the oven for 3 min or until warmed through.",
    "Spread the remaining Greek-style yoghurt over naan, then top with the tamarind & cranberry slaw and the golden tandoori paneer.",
    "Sprinkle over the chopped coriander and top with the remaining naan.",
    "Cut each naanwich into 4 and garnish with the reserved coriander leaves and crispy parsnip ribbons.",
    "Serve with the spiced roast potatoes to the side."
  )
}
