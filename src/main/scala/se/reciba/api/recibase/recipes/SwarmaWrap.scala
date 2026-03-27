package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate

case object ShawarmaWrap extends Recipe {
  override val name: String = "Shawarma Wraps"
  override val description: Option[String] =
    "Roasted sweet potato, red pepper and veggie mince with eastern spices in a wrap".some

  val createdAt = LocalDate.of(2026, 3, 27)

  override val source: Option[String] = (
    "Sylvia"
  ).some
  val tags = Set(Tag.VeganIsh, Tag.Scales)

  val ingredientsBlocks = List(
    IngredientsBlock(
      name = None,
      ingredients = List(
        Ingredient("Sweet Potato", "1", "cut into 2cm wedges"),
        Ingredient("Red Pepper", "1", "sliced"),
        Ingredient("Red Onion", "1", "thinly sliced"),
        Ingredient("Vivera Plant-Based Shawarma Kebab", "1", "175g"),
        Ingredient(
          "Eastern Spices",
          "1",
          "1 tsp each of cumin, coriander, turmeric, paprika, garam masala"
        ),
        Ingredient("Garlic", "3 cloves", "sliced"),
        Ingredient("Wraps"),
        Ingredient("Siracha Sauce", None, None, "Optional".some),
        Ingredient("Yoghurt", None, None, "Optional".some),
        Ingredient("Mayonaise", None, None, "Optional".some),
        Ingredient("Fresh coriander", "10g", "chopped"),
        Ingredient("Olive Oil"),
        Ingredient("Salt"),
        Ingredient("Pepper")
      )
    ),
    IngredientsBlock(
      "Shawarma Spice mix",
      List(
        Ingredient("Cumin", "1 tsp"),
        Ingredient("Ground Coriander", "1 tsp"),
        Ingredient("Smoked Paprika", "1 tsp"),
        Ingredient("Ground Cinnamon", "1/2 tsp"),
        Ingredient("Allspice", "1/2 tsp"),
        Ingredient("Cayenne Pepper", "1/2 tsp")
      )
    )
  )

  override val method: List[String] = List(
    s"Preheat the oven to ${200.celsius}.",
    "Start with sweet potatoes because they take the longest to roast.",
    "Spread the sweet potatoes out on a large roasting tray then drizzle with olive oil, the spice mix, salt and pepper. Roast for 30-40 minutes.",
    "Repeat the process for the red pepper, red onion and garlic. Roasting them for 20-30 minutes.",
    "Shortly before serving, heat up the shawarma kebab pieces in the oven for 5 minutes.",
    "Microwave the wraps per packet instructions.",
    "If you're using mayonaise then mix it with siracha.",
    "Spread siracha mayonaise or yoghurt on the wraps then add the roasted vegetables and mince. Garnish with fresh coriander."
  )

  override val notes: List[String] = List(
    "It might be useful mix the vegetables with oil and spices in a large bowl."
  )
}
