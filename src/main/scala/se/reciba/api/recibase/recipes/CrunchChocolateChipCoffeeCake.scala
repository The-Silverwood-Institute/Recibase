package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate
import se.reciba.api.model.Permalink

case object CrunchChocolateChipCoffeeCake extends Recipe {
  val name = "Crunch Chocolate Chip Coffee Cake"
  val permalink = Permalink("coffee-cake")

  val createdAt = LocalDate.of(2026, 7, 8)

  val tags = Set(Tag.Pudding, Tag.Baking, Tag.Vegetarian)

  val ingredientsBlocks: List[IngredientsBlock] = List(
    IngredientsBlock(
      "Cake",
      List(
        Ingredient("Plain Flour", "375g"),
        Ingredient("Baking Powder", "2 tsp"),
        Ingredient("Baking Soda", "1/2 tsp"),
        Ingredient("Salt", "1/4 tsp"),
        Ingredient("Butter", "180g"),
        Ingredient("Cream Cheese", "250g", "soft"),
        Ingredient("Granulated Sugar", "300g"),
        Ingredient("Vanilla Extract", "1 tsp"),
        Ingredient("Eggs", "3 large"),
        Ingredient("Milk", "180ml")
      )
    ),
    IngredientsBlock(
      "Topping",
      List(
        Ingredient("Dark Brown Sugar", "100g"),
        Ingredient("Plain Flour", "75g"),
        Ingredient("Butter", "60g"),
        Ingredient("Dark Chocolate Chips", "180g"),
        Ingredient("Walnuts", "60g")
      )
    )
  )
  val method = List(
    s"Preheat the oven to ${180.celsius}.",
    "Butter and flour a 13 x 9-inch (32 x 23-cm) baking pan.",
    "Topping: Stir the sugar and flour in a medium bowl. Use a pastry blender to cut in the butter until the mixture resembles fine crumbs. Stir in the chocolate chips and walnuts.",
    "Cake: Mix the flour, baking powder, baking soda and salt in a large bowl.",
    "Beat the butter, cream cheese, sugar and vanilla in a large bowl with an electric mixer at medium speed until creamy.",
    "Add the eggs, one at a time, beating until just blended after each addition.",
    "With the mixer at low speed, gradually beat in the dry ingredients, alternating with the milk.",
    "Spoon the batter into the prepared pan. Sprinkle with the topping.",
    "Bake until a toothpick inserted into the centre comes out clean, 50-60 minutes.",
    "Cool the cake completely in the pan on a wire rack."
  )
}
