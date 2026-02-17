package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object DropPancakes extends Recipe {
  val name = "Scotch Pancakes"

  override val source: Option[String] =
    "https://www.bbcgoodfood.com/recipes/drop-pancakes".some

  val tags =
    Set(Tag.Vegetarian, Tag.Scales, Tag.Pudding, Tag.Quick, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Plain flour", "200g"),
    Ingredient("Baking powder", "1/2 tbsp"),
    Ingredient("Fine salt", "1/2 tsp"),
    Ingredient("Golden caster sugar", "50g"),
    Ingredient("Egg", "1", "beaten"),
    Ingredient("Milk", "200ml"),
    Ingredient("Butter", None, None, "for cooking".some),
  )

  val method: List[String] = List(
    "Sieve the plain flour into a bowl, then add the baking powder, golden caster sugar and fine salt.",
    "Whisk the beaten egg and milk together in a jug, then pour into the bowl and whisk for a few minutes until you have a smooth, thick batter.",
    "Add a little butter to a large frying pan.",
    "Heat the pan over medium heat, and once hot drop 2 tablespoons of the batter into the pan to make small pancakes — you should be able to cook about 4-5 at a time.",
    "Cook the pancakes for 2-3 minutes until the edges are set and bubbles rise in the centre. Flip and cook for another 2-3 minutes until golden brown and cooked through. Repeat with the remaining batter, adding more butter when needed.",
    "Serve the drop pancakes topped with extra butter and a drizzle of maple syrup alongside seasonal fruit, if you like."
  )

  override val notes: Option[String] = "You need butter to cook the pancakes. Too much and they won't cook properly".some
}
