package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.Ingredient
import se.reciba.api.model.IngredientsBlock
import se.reciba.api.model.Recipe
import se.reciba.api.model.Tag
import se.reciba.api.utils.IntUtils.TemperatureUtils

import java.time.LocalDate

case object TandooriPaneerBake extends Recipe {
  val name = "Tandoori Paneer & Crispy Chickpea Bake"
  override val permalink = Permalink("tandoori-paneer-bake")
  val createdAt = LocalDate.of(2026, 11, 19)

  val tags = Set(Tag.AI, Tag.Vegetarian, Tag.LowEffort, Tag.Scales)

  override val source: Option[String] = "Gousto".some

  override val description: Option[String] =
    "Marinated paneer roasted with red pepper, onion, cauliflower and mildly spiced chickpeas, served on coriander naan with mango yoghurt.".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Paneer", "250g", "cut into large bite-sized pieces"),
    Ingredient("Garlic", "1 clove", "finely chopped or grated"),
    Ingredient(
      "Fresh root ginger",
      "15g",
      "peeled and finely chopped or grated"
    ),
    Ingredient("Ground turmeric", "1 tsp"),
    Ingredient("Curry powder", "1 tbsp"),
    Ingredient("Natural yoghurt", "120g"),
    Ingredient("Red pepper", "1", "deseeded and cut into thick strips"),
    Ingredient("Brown onion", "1", "cut into wedges"),
    Ingredient("Cauliflower", "1/2", "cut into florets"),
    Ingredient("Chickpeas", "1 tin", "drained and rinsed"),
    Ingredient("Garam masala", "1 tsp"),
    Ingredient("Mango chutney", "20g"),
    Ingredient("Mini garlic and coriander naans", "2"),
    Ingredient("Vegetable oil"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Add the garlic, ginger, ground turmeric and curry powder to a large bowl.",
    "Combine with {1 tbsp} of the natural yoghurt (you'll use the rest later), a drizzle of vegetable oil and a generous pinch of salt.",
    "Add the paneer and mix until evenly coated.",
    "Add the red pepper, onion, cauliflower, garam masala, chickpeas and a generous pinch of salt to a baking tray.",
    "Drizzle with vegetable oil and mix well.",
    "Top with the marinated paneer.",
    "Bake for 25-30 min or until everything is cooked through and starting to char.",
    "Meanwhile, combine the remaining yoghurt with the mango chutney, {1 tbsp} water and a pinch of salt.",
    "Once the tray bake is cooked, add the naans to a baking tray and warm in the oven for 3-5 min.",
    "Serve the tray bake over the warmed naans and drizzle with the mango yoghurt."
  )
}
