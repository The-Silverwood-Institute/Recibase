package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate

case object RoastedVegetableTart extends Recipe {
  val name = "Roasted Vegetable Tart"
  val createdAt = LocalDate.of(2026, 7, 8)

  val tags = Set(Tag.Vegetarian, Tag.HotWeather, Tag.Slow)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Aubergines", "400g"),
    Ingredient("Courgettes", "400g"),
    Ingredient("Red Pepper", "1", "thickly sliced"),
    Ingredient("Yellow Pepper", "1", "thickly sliced"),
    Ingredient("Red Onions", "150g", "thickly sliced"),
    Ingredient("Garlic", "1 clove", "chopped"),
    Ingredient(
      "Fresh Rosemary or Thyme",
      "1 tsp",
      "chopped, plus extra fresh sprigs for topping"
    ),
    Ingredient("Olive Oil", "3 tbsp"),
    Ingredient("Salt"),
    Ingredient("Black Pepper"),
    Ingredient("Filo Pastry", "4 sheets", "about 125g altogether"),
    Ingredient("Feta", "150g", "diced")
  )

  val method = List(
    s"Heat the oven to ${200.celsius}. Cut the aubergines and courgettes into 1cm slices. Arrange all the vegetables in a single layer in a roasting tin, scatter the garlic and rosemary or thyme over them, then drizzle with 2 tablespoons of the olive oil. Season to taste.",
    "Roast the vegetables for 40-60 minutes until they have softened and browned.",
    "Meanwhile, place a baking sheet in the oven to warm. Line a 20-23cm loose-based tart tin with the sheets of filo pastry, brushing each layer with oil before adding the next. Crumple up any overhanging edges to form a rim. Place the tin on the baking sheet and bake the pastry case for 5-8 minutes until golden brown.",
    s"Reduce the oven to ${160.celsius}. Spoon the roasted vegetables into the pastry case and scatter the cheese and chopped rosemary and thyme evenly over the top. Return the tart to the oven for 10 minutes, or until the cheese has just melted. Cut into quarters and serve."
  )
}
