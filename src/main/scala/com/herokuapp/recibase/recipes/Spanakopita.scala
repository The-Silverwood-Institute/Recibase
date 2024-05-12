package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag}

case object Spanakopita extends Recipe {
  val name = "Spanakopita"

  override val source: Option[String] = Some(
    "Minna"
  )
  override val notes: Option[String] = Some(
    """
    The frozen spinach quantity is approximate as I measured an old bag that had a lot of ice in it.

    Iceland frozen spinach is better than other supermarkets' as they include whole leaves, while others are completely shredded.
    
    I used approximately 1/2tsp fennel seeds the first time and it wasn't enough, so I'm hoping 1tsp is enough.
    
    I didn't make this with onion or garlic the first time.""".stripMargin
  )
  override val tags = Set(Tag.Vegetarian, Tag.Slow)

  val ingredients = List(
    Ingredient("Frozen spinach", "300g"),
    Ingredient("Fresh Parsley", "30g", "chopped"),
    Ingredient("Onion", "1", "diced"),
    Ingredient("Garlic", "2 cloves", "diced"),
    Ingredient("Feta", "200g", "diced"),
    Ingredient("Eggs", "2"),
    Ingredient("Fillo Pastry", "125g"),
    Ingredient("Fennel Seeds", "1 tsp"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Olive Oil")
  )
  val method = List(
    "Preheat the oven to 160°C.",
    "Defrost the spinach and squeeze out as much moisture as you can through a sieve.",
    "Mix every ingredient except the oil and pastry in a bowl.",
    "Brush a 9 1/2″ X 13″ baking dish with olive oil",
    "Line the baking dish with 2/3rds of the fillo pastry sheets. Add them two at a time then brush the layer with olive oil.",
    "Evenly spread the spinach and feta filling over the fillo crust.",
    "Layer the rest of the fillo pasty sheets on top, using the same method as before.",
    "Brush the very top layer with olive oil, and sprinkle with just a few drops of water.",
    "Fold the flaps or excess from the sides, you can crumble them a little. Brush the folded sides well with olive oil. Cut Spanakopita part-way through into squares, or leave the cutting to later.",
    "Bake for 45-60 minutes, or until the fillo crust is crisp and golden brown. Remove from the oven. Finish cutting into squares and serve.",
    "Optionally serve with greek yoghurt or creme fraiche."
  )
}
