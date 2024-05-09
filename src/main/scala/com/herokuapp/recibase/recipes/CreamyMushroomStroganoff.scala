package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object CreamyMushroomStroganoff extends Recipe {
  val name = "Mushroom Stroganoff"

  override val source: Option[String] = Some(
    "http://allrecipes.co.uk/recipe/6460/creamy-mushroom-stroganoff.aspx"
  )
  override val notes: Option[String] = Some(
    """You can substitute Shiitake or Porchini mushrooms for their dried equivalents.
Pots of dried forest mushrooms also work. Try softening the mushrooms in the stock."""
  )
  override val tags = Set(Tag.Vegetarian, Tag.Scales, Tag.LowEffort, Tag.Quick)

  val ingredients = List(
    Ingredient("Butter", "50g"),
    Ingredient("Large Onion", "1", "sliced"),
    Ingredient("Brown Mushrooms", "250g", "sliced"),
    Ingredient("Shiitake or Porchini Mushrooms", "Some"),
    Ingredient("Vegetable or Mushroom stock cube", "1"),
    Ingredient("Soured Cream", "350ml"),
    Ingredient("Plain Flour", "3 tbsp"),
    Ingredient("Salt"),
    Ingredient("Black Pepper"),
    Ingredient("Nutmeg", None, None, Some("Optional")),
    Ingredient("Brandy", None, None, Some("Optional"))
  )
  val method = List(
    "Chop the shiitake or porchini mushrooms into large pieces",
    "Boil the kettle then use as little water as possible to disolve the cube in a jug.",
    "Melt butter in a large frying pan then soften the onion.",
    "Turn up the heat and add the brown mushrooms. Cook for a minute or so.",
    "Add the Shiitake or Porchini Mushrooms and cook for a minute more.",
    "Turn down the heat then stir in the soured cream, being careful not to let it boil.",
    "Stir in the vegetable stock until you have a creamy sauce that isn't too watery. You might not need all the stock. Sift in plain flour, a small bit at a time, if needed.",
    "Add salt and black pepper to taste.",
    "Serve with rice."
  )
}
