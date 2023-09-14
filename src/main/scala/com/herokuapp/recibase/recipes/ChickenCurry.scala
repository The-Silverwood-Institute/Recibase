package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object ChickenCurry extends Recipe {
  val name = "Chicken Curry (WIP)"
  override val permalink: Permalink = Permalink("chicken-curry")

  override val notes: Some[String] = Some(
    """
      |This is H's spice blend. Alternative spice profile by S:
      |Lots of cumin, smoked paprika (sweet) and cinnamon. A medium amount of turmeric and nutmeg. A couple tsp cloves. No sugar. Only salt after cooking.
      |I might re-jig the method to simplify but I want to make it a few more times.  
      |""".stripMargin
  )

  override val source: Option[String] = Some("H + S")
  override val tags = Set(
    Tag.Slow,
    Tag.Freezes,
    Tag.Scales,
    Tag.Spicy,
    Tag.Stephani
  )

  val ingredients = List(
    Ingredient("Chicken Breasts", Some("4"), Some("chopped into 3cm pieces")),
    Ingredient("Large Onions", Some("2"), Some("chopped")),
    Ingredient("Garlic", Some("6 cloves"), Some("diced")),
    Ingredient("Green Beans", Some("220g"), Some("topped, tailed and halved")),
    Ingredient("Chestnut Mushrooms", Some("485g"), Some("chopped")),
    Ingredient("Double Cream", Some("75ml"), None, Some("add more if desired")),
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
    Ingredient("Naan Bread", None, None, Some("Optional"))
  )
  val method = List(
    "Heat the wok over a hot flame.",
    "Fry the onions. Add the chicken halfway through then throw in the garlic.",
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
