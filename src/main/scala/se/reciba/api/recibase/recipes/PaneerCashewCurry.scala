package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object PaneerCashewCurry extends Recipe {
  val name = "Paneer Cashew Curry"
  val createdAt = LocalDate.of(2024, 4, 3)

  override val source: Option[String] =
    "https://vegancocotte.com/cashew-curry/".some

  override val description: Option[String] =
    "Creamy cashew curry with fried paneer and chickpeas, adapted from the vegan tofu version.".some

  val tags = Set(Tag.AI, Tag.Vegetarian, Tag.Scales, Tag.Freezes)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Raw cashews", "1 cup"),
    Ingredient("Fried paneer", "200g"),
    Ingredient("Coconut oil", "1 tbsp"),
    Ingredient("Onion", "1 medium", "roughly chopped"),
    Ingredient("Red pepper", "1", "sliced"),
    Ingredient("Cherry tomatoes", "150g", "halved", "optional"),
    Ingredient("Garlic", "2 large cloves", "finely chopped"),
    Ingredient("Fresh ginger", "1 inch", "finely chopped"),
    Ingredient("Ground cumin", "1/2 tbsp"),
    Ingredient("Ground coriander", "1/2 tbsp"),
    Ingredient("Garam masala", "1/2 tbsp"),
    Ingredient("Ground turmeric", "1/2 tsp"),
    Ingredient("Passata", "250ml"),
    Ingredient("Chickpeas", "1 tin", "drained and rinsed", "optional"),
    Ingredient("Vegetable stock cube", "1"),
    Ingredient("Baby spinach", "2 handfuls"),
    Ingredient("Fresh coriander"),
    Ingredient("Salt"),
    Ingredient("Black pepper")
  )

  val method = List(
    "Cover the cashews with boiling water and boil for 10 minutes. Drain, keeping {2/3 cup} of the cashew water.",
    "Add the cashews and reserved water to a food processor and blitz for 3-4 minutes until smooth. Set the cashew cream aside.",
    "In the meantime, heat the coconut oil in a large, deep pan and saute the onion and red pepper for 4-5 minutes over a medium heat until softened.",
    "Stir in the garlic and ginger and cook for another minute.",
    "Add the cumin, coriander, garam masala and turmeric and stir to combine.",
    "Add the passata, chickpeas, stock cube and just enough water to dissolve the stock cube. Bring to the boil, then lower the heat, cover and simmer for 10 minutes.",
    "Stir in the baby spinach and simmer for another minute, then mix in the the cashew cream.",
    "Let the sauce bubble for a minute, then stir in the fried paneer and fresh coriander.",
    "Season to taste and serve over rice or with naan."
  )
}
