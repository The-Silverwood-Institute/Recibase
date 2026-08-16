package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate

case object TangyVegetablePadThai extends Recipe {
  val name = "Tangy Vegetable Pad Thai"
  val createdAt = LocalDate.of(2020, 4, 24)

  val tags = Set(Tag.LowEffort, Tag.Quick, Tag.Vegan)

  override val source: Option[String] = "Gousto".some

  override val description: Option[String] =
    "Courgette, pepper and rice noodles in a zingy pad Thai sauce.".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butternut squash cubes", "160g"),
    Ingredient("Rice noodles", "150g"),
    Ingredient("Red pepper", "1", "deseeded and cut into thin strips"),
    Ingredient("Courgette", "1"),
    Ingredient("Garlic", "2 cloves", "finely sliced"),
    Ingredient("Lime", "1"),
    Ingredient("Tamarind paste", "15g"),
    Ingredient("Soy sauce", "30ml"),
    Ingredient("Mirin", "15ml"),
    Ingredient("Sriracha hot chilli sauce", "8ml"),
    Ingredient("Thai basil", "5g"),
    Ingredient("Coriander", "5g"),
    Ingredient("Roasted peanuts", "25g"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    s"Preheat the oven to ${200.simpleFanInstruction} and boil a kettle.",
    "Add the butternut squash cubes to a baking tray with a pinch of salt and pepper and a drizzle of vegetable oil and mix well.",
    "Roast for 20-25 min or until cooked with a slight bite.",
    "Heat a large, wide-based pan (preferably non-stick) with a generous drizzle of vegetable oil over a medium heat.",
    "Once hot, add the pepper strips with a pinch of salt and cook for 3-4 min or until softened.",
    "Add the rice noodles to a pot and cover with boiled water.",
    "Boil over a high heat for 4-5 min or until softened with a slight bite.",
    "Drain the noodles, run them under cold water, then return to the pot with a drizzle of vegetable oil and set aside.",
    "Peel lengths off the courgette until you have a pile of ribbons.",
    "Add the tamarind paste to a bowl with the soy sauce, mirin, sriracha, the juice of 1/2 the lime and 1 tsp sugar and mix.",
    "Once the pepper has softened, add the courgette ribbons and sliced garlic to the pan and cook for 1-2 min until fragrant, then remove from the heat.",
    "Crush the roasted peanuts with a rolling pin.",
    "Roughly chop the Thai basil and coriander, including the stalks.",
    "Cut the remaining lime into wedges.",
    "Return the pan to a medium-high heat and add the drained noodles, roasted butternut squash and pad Thai sauce and mix well.",
    "Stir through half the chopped Thai basil and coriander.",
    "Serve topped with the remaining herbs, crushed peanuts and a lime wedge."
  )
}
