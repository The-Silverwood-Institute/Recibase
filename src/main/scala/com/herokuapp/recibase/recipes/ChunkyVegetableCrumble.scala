package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import com.herokuapp.recibase.utils.IntUtils.TemperatureUtils

case object ChunkyVegetableCrumble extends Recipe {
  val name = "Chunky Vegetable Crumble"
  override val permalink: Permalink =
    Permalink("vegetable-crumble")

  override val source: Option[String] = Some(
    "Vegetarian Cookery Bible (2012: Reader's Digest)"
  )
  override val notes: Option[String] =
    Some(
      """Most brands of Worcestershire Sauce contain anchovies and are therefore not vegetarian. There are some that are, however.
Honey can be added with the carrots for extra sweetness."""
    )
  override val tags =
    Set(
      Tag.VegetarianIsh,
      Tag.Slow,
      Tag.HighEffort,
      Tag.Scales,
      Tag.ColdWeather
    )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Onion", "1", "sliced"),
    Ingredient(
      "Garlic",
      "3 minimum",
      "finely chopped or crushed"
    ),
    Ingredient("Carrots", "3", "cut into 2cm chunks"),
    Ingredient("Parsnips", "2", "cut into 2cm chunks"),
    Ingredient(
      "Baby turnips",
      Some("350g"),
      Some("quartered"),
      Some("Optional. Never been added")
    ),
    Ingredient(
      "New potatoes",
      Some("5-6"),
      Some("cut into 2cm chunks"),
      Some("Whatever number seems reasonable for the pan size")
    ),
    Ingredient(
      "Vegetable stock",
      Some("450ml"),
      None,
      Some("Use less for a thicker dish (preferred)")
    ),
    Ingredient("Worcestershire sauce", "generous dash"),
    Ingredient("Tomato purée", "1 tbsp"),
    Ingredient(
      "Bay leaves",
      Some("2"),
      None,
      Some("Optional. Never been added")
    ),
    Ingredient(
      "Butter beans",
      "1 410g tin",
      "drained and rinsed"
    ),
    Ingredient("Thyme", Some("1-2 tsp"), None, Some("Optional")),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Flour", "85g"),
    Ingredient(
      "Butter",
      Some("30g"),
      Some("diced"),
      Some("Should be cool, not room temp.")
    ),
    Ingredient(
      "Mature cheddar cheese",
      Some("75g"),
      Some("coarsely grated"),
      Some("Always use more")
    ),
    Ingredient("Sunflower seeds", "30g")
  )
  val method = List(
    s"Preheat oven to ${190.celsius}.",
    "Heat oil in a large saucepan. Add the onion and garlic and cook until soft.",
    "Add the carrots, parsnips, turnips (if used) and potatoes and cook briefly.",
    "Stir in the stock, Worcestershire sauce, tomato purée and bay leaves (if used).",
    "Bring to the boil and simmer for 20 minutes, stirring occasionally.",
    "Put the flour in a mixing bowl and rub in the butter to make the crumble topping. Sprinkle over 1 1/2 tbsp water and mix with fork to make large crumbs. Stir in the cheese and sunflower seeds.",
    "Stir the butter beans into the vegetable mixture and cook for further 5-7 minutes or until vegetables are tender.",
    "Remove the bay leaves (if added).",
    "Blend, mash or puree approx. 1 ladleful of the vegetable mixture.",
    "Stir in parsley (if used) and the salt and pepper.",
    "Pour the mixture into a suitable ovenproof dish.",
    "Sprinkle the crumble mixture evenly over the top.",
    "Bake for 20 minutes or until golden brown."
  )
}
