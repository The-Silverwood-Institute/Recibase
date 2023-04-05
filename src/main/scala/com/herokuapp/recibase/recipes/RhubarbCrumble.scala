package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object RhubarbCrumble extends Recipe {
  val name = "Rhubarb & Date Crumble"

  override val permalink: Permalink = Permalink("rhubarb-crumble")

  override val source: Option[String] = Some("https://web.archive.org/web/20210227223551/http://www.claudiandfin.co.uk/healthy-rhubarb-date-crumble-recipe/")

  override val notes: Option[String] = Some(
    """Make sure to keep the butter in the fridge until right before you need it, to avoid it melting.
      |
      |You can leave out the dates or substitute the filling for another fruit combination. We use this recipe as the template for all our crumbles.
      |
      |We mix the fruit in the ovenproof dish because ours is basically a glass mixing bowl. If your ovenproof dish is a metal tin you might want to use a mixing bowl first.""".stripMargin)

  override val tags = Set(Tag.Pudding)

  val ingredients = List(
    Ingredient("Plain Flour", "120g"),
    Ingredient("Dark brown muscovado sugar", "50g"),
    Ingredient("Butter", "90g", "cut into small pieces"),
    Ingredient("Rhubarb", "3 sticks", "cut into 2-3cm pieces"),
    Ingredient("Pitted Dates", "50g", "chopped"),
    Ingredient("Fresh Ginger", "2cm", "grated"),
    Ingredient("Golden Syrup", "1-2 tbsp")
  )
  val method = List(
    "Pre-heat the oven to 180C.",
    "Rub the butter and flour together in a mixing bowl until it disappears.",
    "Mix in the brown sugar.",
    "In an ovenproof dish combine the rhubarb, dates, ginger and golden syrup.",
    "Pour the crumble topping evenly over the fruit mixture.",
    "Cook in the oven until the topping is golden and the fruit is bubbling around the edges. This will take 20 minutes in a shallow dish or up to 45 minutes for a deep dish.",
    "Serve with cream or ice cream. Rhubarb is very acidic so dairy is a must."
  )
}
