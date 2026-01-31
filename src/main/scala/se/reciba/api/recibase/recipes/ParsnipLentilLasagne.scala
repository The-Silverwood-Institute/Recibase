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

case object ParsnipLentilLasagne extends Recipe {
  val name = "Parsnip and Lentil Lasagne"
  override val permalink: Permalink =
    Permalink("parsnip-and-lentil-lasagne")

  val tags = Set(Tag.Slow, Tag.HighEffort, Tag.Scales, Tag.Vegetarian)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Lasagne sheets", "200g".some, None, "12 sheets".some),
    Ingredient("Soft Goats cheese", "150g".some, None, "or ricotta".some),
    Ingredient("Feta", "200g"),
    Ingredient(
      "Milk",
      "100ml".some,
      None,
      "Full fat or semi-skimmed".some
    ),
    Ingredient("Parsnips", "400g", "sliced into sticks"),
    Ingredient("Red Onion", "1 large", "thinly sliced"),
    Ingredient("Red lentils", "100g"),
    Ingredient("Red peppers", "2 large", "diced"),
    Ingredient("Carrot", "1 large", "thinly sliced"),
    Ingredient("Vegetable Stock", "300ml"),
    Ingredient("Passata", "250ml"),
    Ingredient(
      "Kidney Beans",
      "2 400g tins".some,
      "drained and rinsed".some
    ),
    Ingredient("Sunflower Oil", None, None, "or olive oil".some),
    Ingredient("Bay Leaf"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Nutmeg", None, "grated".some, "Optional".some)
  )
  val method = List(
    s"Preheat the oven the ${190.celsius}.",
    "Heat the oil in a large saucepan.",
    "Add the onion and soften for about 10 minutes.",
    "Add the lentils, red peppers, carrot, vegetable stock, bay leaf and pasatta.",
    "Bring the mixture to the boil, then reduce the heat and simmer for 25 minutes or until the lentils/vegetables are soft.",
    "Oil and season the parsnips then roast in the oven for about 25 minutes.",
    "Remove the bay leaf and partially puree with a hand blender.",
    "Season with salt/pepper to taste then mix in the beans.",
    "Spoon 1/4 of the sauce over the bottom of a large greaseproof dish then cover with lasagne sheets.",
    "Add two more layers like so: spread half the sauce on top of the lasagne sheets, arrange half the roast parsnips in the sauce then finally cover with lasagne sheets.",
    "Put the goats cheese in a bowl and stir in the milk until smooth. If the mixture is too firm/cold give it a second or two in the microwave. Season with pepper.",
    "Spoon the goats cheese mixture over the dish then scatter with crumbled feta and nutmeg.",
    "Bake for 40 minutes or until bubbly and golden.",
    "Take out of the oven and leave to stand for 5 minutes before serving."
  )
}
