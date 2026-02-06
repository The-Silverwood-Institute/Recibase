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

case object ButternutSquashPadThai extends Recipe {
  val name = "Butternut Squash Pad Thai"

  override val permalink: Permalink = Permalink("butternut-squash-pad-thai")
  val tags = Set(Tag.AI, Tag.Spicy, Tag.Vegan, Tag.Quick)

  override val source: Option[String] = "Gousto".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butternut squash", "120g", "cut into 2cm cubes"),
    Ingredient("Lime", "1"),
    Ingredient("Red chilli", "1"),
    Ingredient("Red pepper", "1", "cut into thin strips"),
    Ingredient("Garlic", "1 cloves", "finely sliced"),
    Ingredient("Roasted peanuts", "25g"),
    Ingredient("Soy sauce", "2 tbsp"),
    Ingredient("Tamarind paste", "3 tsp"),
    Ingredient("Toasted sesame oil", "1 tsp"),
    Ingredient("Tenderstem broccoli", "80g"),
    Ingredient("Red curry paste", "4 tsp"),
    Ingredient("Sriracha hot chilli sauce", "1 tbsp"),
    Ingredient("Fried onions", "3 tsp"),
    Ingredient("Thai rice noodles", "200g"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    s"Preheat the oven to ${200.simpleFanInstruction} and boil a kettle.",
    "Add the butternut squash cubes to a bowl with the red curry paste and a drizzle of vegetable oil and mix it up, then add to a tray.",
    "Put the tray in the oven for 15-20 min or until cooked with a slight bite.",
    "Whilst the butternut squash is cooking, add the Thai rice noodles to a bowl and cover with boiled water.",
    "Set aside for 12-15 min or until softened.",
    "Once softened, drain the noodles reserving a cup of starchy noodle water.",
    "Drizzle with a little vegetable oil and set aside.",
    "Heat a large, wide-based pan (preferably non-stick) with a generous drizzle of vegetable oil over a medium heat.",
    "Once hot, add the sliced red peppers and sliced garlic with a pinch of salt and cook for 5-6 min or until softened.",
    "Cut the Tenderstem broccoli in half.",
    "Once the peppers have softened, add the halved Tenderstem broccoli with a splash of boiled water and cook for 4-5 min or until the broccoli is cooked with a slight bite.",
    "Add the soy sauce to a bowl with the Sriracha hot chilli sauce, tamarind paste and the juice of the limes.",
    "Add sugar and water and stir it all together.",
    "Crush the peanuts in their bag with a rolling pin.",
    "Slice the red chillies finely.",
    "Once the butternut squash cubes are done, add them to the pan and reduce the heat to low.",
    "Add the pad Thai sauce and stir through the drained noodles.",
    "Add a splash of the reserved noodle water if it's looking a little dry.",
    "Serve the butternut squash pad Thai and garnish with the crushed peanuts, crispy fried onions and sliced red chilli."
  )
}
