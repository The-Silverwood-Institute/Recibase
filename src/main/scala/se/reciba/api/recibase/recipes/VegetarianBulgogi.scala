package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object VegetarianBulgogi extends Recipe {
  val name = "Vegetarian Bulgogi"

  override val permalink: Permalink = Permalink("vegetarian-bulgogi")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Chilli jam", "1 pot (25g)"),
    Ingredient("Baby leaf spinach", "80g"),
    Ingredient("Sriracha hot chilli sauce", "1 sachet (8ml)"),
    Ingredient("Toasted sesame oil", "1 sachet (15ml)"),
    Ingredient("Rice vinegar", "1 sachet (15ml)"),
    Ingredient("Steamed white basmati rice", "200g"),
    Ingredient("Meatless Farm mince", "300g"),
    Ingredient("Ginger & garlic paste", "1 sachet (15g)"),
    Ingredient("Tamari soy sauce", "1 sachet (5ml)"),
    Ingredient("Toasted sesame seeds", "1 sachet (5g)"),
    Ingredient("Carrot", "1"),
    Ingredient("Spring onion", "1"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Heat a large, wide-based pan (preferably non-stick) with 1 tbsp vegetable oil over a high heat.",
    "Boil a full kettle.",
    "Once hot, add the meat-free mince to the pan and cook for 4-5 minutes or until starting to brown.",
    "Meanwhile, add the spinach to a colander and pour boiled water all over it so that it starts to wilt.",
    "Rinse the wilted spinach under the cold tap.",
    "Once cool, squeeze the water out of the spinach as much as you can then add it to a bowl with 1/2 sesame oil sachet — this is your sesame spinach.",
    "Once the mince has browned, add the garlic and ginger paste and cook for 1 minute.",
    "Add the chilli jam, tamari soy sauce and remaining sesame oil and give it a good mix up — this is your meat-free bulgogi.",
    "Whilst the mince is browning, top, tail, peel and grate the carrot.",
    "Trim, then slice the spring onion.",
    "Combine the sriracha and rice vinegar in a bowl with a pinch of sugar and 1 tbsp water.",
    "Add the grated carrot and give it a good mix up and set aside — this is your spicy carrot pickle.",
    "Squeeze the pouches of steamed white basmati rice to separate the grains.",
    "Tear the top corner of the pouches (just a little!) and microwave for 2 minutes or until piping hot.",
    "Serve the meat-free bulgogi over the steamed rice with the sesame spinach and spicy carrot pickle to the side, and garnish with the toasted sesame seeds and sliced spring onion."
  )
}
