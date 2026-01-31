package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object ChickenCurry extends Recipe {
  val name = "Chicken Curry (WIP)"
  override val permalink: Permalink = Permalink("chicken-curry")

  override val notes: List[String] = List(
    """
      |This is H's spice blend. Alternative spice profile by S:
      |Lots of cumin, smoked paprika (sweet) and cinnamon. A medium amount of turmeric and nutmeg. A couple tsp cloves. No sugar. Only salt after cooking.
      |I might re-jig the method to simplify but I want to make it a few more times.  
      |""".stripMargin
  )

  override val source: Option[String] = "H + S".some
  val tags = Set(
    Tag.Slow,
    Tag.Freezes,
    Tag.Scales,
    Tag.Spicy,
    Tag.Stephani
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Chicken Breasts", "4".some, "chopped into 3cm pieces".some),
    Ingredient("Large Onions", "2".some, "chopped".some),
    Ingredient("Garlic", "6 cloves".some, "diced".some),
    Ingredient("Green Beans", "220g".some, "topped, tailed and halved".some),
    Ingredient("Chestnut Mushrooms", "485g".some, "chopped".some),
    Ingredient("Double Cream", "75ml".some, None, "add more if desired".some),
    Ingredient("Sweetcorn", "1 large tin"),
    Ingredient("Lemongrass", "2 stems"),
    Ingredient("Kaffir lime leaves"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Smoked Paprika"),
    Ingredient("Cumin"),
    Ingredient("Cloves"),
    Ingredient("Nutmeg"),
    Ingredient("Turmeric"),
    Ingredient("Red Peppers", "2".some, None, "Optional".some),
    Ingredient("Chillies", None, None, "Optional".some),
    Ingredient("Naan Bread", None, None, "Optional".some)
  )
  val method = List(
    "Heat the wok over a hot flame.",
    "Fry the onions. Add the chicken halfway through then throw in the garlic and (optional) peppers.",
    "Add the smoked paprika, cumin, nutmeg, cloves and turmeric. Primarily paprika and cumin. Cook the spices for a moment.",
    "Transfer to a large pan.",
    "Add the cream, sweetcorn (including brine), sugar and salt to the large pan. Add a little water, sparingly, if it looks dry.",
    "Slice the lemongrass leaves lengthways, excluding the root, so they stay together. Crush the lemongrass with the side of knife to release the flavour.",
    "Add the kaffir lime leaves and lemongrass to the large pan, then bring to a simmer.",
    "Meanwhile, fry the green beans and mushrooms in the wok.",
    "Transfer the green beans and mushrooms to the large pan.",
    "Continue simmering to reduce most of the liquid.",
    "Heat the naans and serve alongside.",
    "Do cute victory dance with butt wiggle."
  )
}
