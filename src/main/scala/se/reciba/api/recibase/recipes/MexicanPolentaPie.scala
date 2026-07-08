package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate

case object MexicanPolentaPie extends Recipe {
  val name = "Mexican Polenta Pie"
  val createdAt = LocalDate.of(2020, 4, 24)

  val tags = Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)

  val ingredientsBlocks: List[IngredientsBlock] = List(
    IngredientsBlock(
      "Base",
      List(
        Ingredient("Sunflower Oil", "1 tbsp"),
        Ingredient("Celery", "1 stick", "chopped"),
        Ingredient("Garlic", "1 large clove", "crushed"),
        Ingredient("Onions", "150g", "chopped"),
        Ingredient("Green Pepper", "1/2", "chopped"),
        Ingredient("Cayenne Pepper", "1 tsp"),
        Ingredient("Red Kidney Beans", "400g", "canned, drained and rinsed"),
        Ingredient("Green Olives", "12", "stoned, sliced"),
        Ingredient("Jalapeño Peppers", "1 tbsp", "chopped"),
        Ingredient("Sweetcorn", "75g", "canned, drained"),
        Ingredient("Chopped Tomatoes", "400g", "canned"),
        Ingredient("Tomato Purée", "1 tbsp"),
        Ingredient("Salt"),
        Ingredient("Black Pepper")
      )
    ),
    IngredientsBlock(
      "Topping",
      List(
        Ingredient("Cornmeal or Polenta", "125g"),
        Ingredient("Plain White Flour", "1 tbsp"),
        Ingredient("Baking Powder", "2 tsp"),
        Ingredient("Egg", "1", "beaten"),
        Ingredient("Skimmed Milk", "100ml"),
        Ingredient("Half-fat Mature Cheddar Cheese", "25g", "grated")
      )
    )
  )

  val method = List(
    s"Heat the oven to ${200.celsius}. Heat the oil in a saucepan over a high heat. Stir in the celery, garlic, onions and green pepper, bring them to a sizzle, then cover, reduce the heat to low and cook for 10 minutes, or until they have softened. Stir in the cayenne pepper and cook for a further 1-2 minutes.",
    "Stir in the kidney beans, olives, jalapeño peppers, sweetcorn, canned tomatoes, tomato purée and add salt and pepper to taste. Bring the mixture to the boil and simmer for 5 minutes. Then spoon the mixture into a 3 litre ovenproof serving dish.",
    "Topping: Mix together the cornmeal or polenta, flour, 1/2 teaspoon of salt and the baking powder, then beat in the egg and milk. The mixture should look like a thick batter; if not, add 1-2 tablespoons of milk.",
    "Spoon the topping over the vegetables, sprinkle with the cheese and bake for 40 minutes, or until the topping is risen and golden brown. Leave the pie to stand for 5 minutes before serving."
  )
}
