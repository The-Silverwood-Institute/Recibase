package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

case object RoastBeetrootDahl extends Recipe {
  val name = "Roast Beetroot Dahl"
  val permalink = "roast-beetroot-dahl"

  override val source: Option[String] = Some("Gousto")
  override val notes: Option[String] = Some(
    """The beetroot quantity is guestimated. Will refine over time.
        |
        |We use a modified version of <a href="https://www.theflavorbender.com/sri-lankan-roasted-curry-powder/">this</a> Sri Lankan Curry power recipe. Will write down our version some time.""".stripMargin
  )
  override val tags = Set(Tag.Vegan, Tag.Spicy)

  val ingredients = List(
    Ingredient("Beetroot", "500g", "cut into 2cm chunks"),
    Ingredient("Onion", "1", "thinly sliced"),
    Ingredient("Spring Onions", "2", "chopped"),
    Ingredient("Lime", "1", "zested and juiced"),
    Ingredient("Garlic", "2 cloves", "chopped"),
    Ingredient("Flatbreads", Some("4"), None, Some("Optional")),
    Ingredient("Sri Lankan Curry Powder"),
    Ingredient("Stock cube", "1"),
    Ingredient("Coconut Milk", "1 400ml tin"),
    Ingredient("Red Lentils", "150g"),
    Ingredient("Water", "200ml"),
    Ingredient("Oil")
  )
  val method = List(
    "Preheat the oven to 200 C (400 F, gas mark 6).",
    "Spread the beetroot on a baking tray. Drizzle with oil and season with salt and pepper.",
    "Roast the beetroot for 20-25 minutes then set aside.",
    "Boil the water and make stock.",
    "Heat a large saucepan with some oil. Add the onions and soften for a few minutes.",
    "Stir in the curry powder and garlic then cook for a minute.",
    "Add the coconut milk, lentils and stock, then bring to the boil.",
    "Turn down the heat and simmer for 20-25 minutes or until the lentils are soft. Stir every few minutes.",
    "Mix the roasted beetroot and lime juice into the lentils.",
    "Lightly toast the flatbreads.",
    "Serve with a garnish of lime zest and spring onions, with the flatbreads on the side."
  )
}
