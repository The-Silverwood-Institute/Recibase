package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object LentilShepardsPie extends Recipe {
  val name = "Veggie Shepherd's Pie"

  val tags =
    Set(Tag.Vegetarian, Tag.Slow, Tag.HighEffort, Tag.Scales, Tag.ColdWeather)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Onions", "1".some, "Diced".some),
    Ingredient("Carrots", "4".some, "Diced".some),
    Ingredient("Celery", "1 head".some, "Chopped".some, "Optional".some),
    Ingredient("Garlic", "4 Cloves".some, "Finely chopped".some),
    Ingredient("Chestnut mushrooms", "200g".some, "sliced".some),
    Ingredient("Red Lentils", "230g"),
    Ingredient("Butter"),
    Ingredient("Bay Leaf", "2".some, None, "Optional".some),
    Ingredient("Thyme", "1 tbsp"),
    Ingredient("Red wine", "100ml".some, None, "Optional".some),
    Ingredient("Stock cube", "1"),
    Ingredient("Tomato purée", "3 tbsp"),
    Ingredient(
      "King Edwards Potatoes",
      "500g".some,
      None,
      "Other floury potatoes will do".some
    ),
    Ingredient("Butter", "85g"),
    Ingredient("Milk", "100ml"),
    Ingredient("Cheddar", "50g".some, "Grated".some)
  )
  val method = List(
    "To make the sauce, heat the butter in a pan, then gently fry the onions, carrots, celery and garlic for 15 mins until soft and golden.",
    "Turn up the heat, add the mushrooms, then cook for 4 mins more.",
    "Add the herbs, lentils, wine and stock. It's important that you do not season with salt at this stage.",
    "Simmer for 40-50 mins until the lentils are very soft.",
    "Take off the heat and stir in the tomato pur\u00e9e. Season to taste.",
    "While the lentils are cooking, tip the potatoes into a pan of water, then boil for about 15 mins until tender.",
    "Drain the potatoes well, then mash with the butter and milk.",
    "Pour the lentil mixture into a casserole dish and top with the mash potatoes.",
    "Use a fork to rake the surface of the mash potatoes. This will help golden the dish.",
    "Scatter with grated cheddar then bake in a 190C/fan 170C oven for 30 minutes, until golden."
  )
}
