package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object BeefStroganoff extends Recipe {
  val name = "Beef Stroganoff"
  val createdAt = LocalDate.of(2020, 4, 24)

  val tags = Set(Tag.Scales, Tag.Slow)

  override val source = "Kit's Dad".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Beef",
      "500g".some,
      None,
      "Not casserole (too tough) or fillet (too expensive)".some
    ),
    Ingredient("Garlic Clove", "1"),
    Ingredient("Onion", "1"),
    Ingredient("Mushrooms", "5-6"),
    Ingredient("Soured Cream", "350ml"),
    Ingredient("Beef or Pork Stock Cube", None, None, "Or 1 tbsp Bovril".some),
    Ingredient("Salt", "Pinch"),
    Ingredient("Pepper", "Pinch"),
    Ingredient("Paprika", "Pinch"),
    Ingredient("Butter", "Wedge")
  )
  val method = List(
    "Cover meat with clingfilm and hit with a rolling pin to flatten it.",
    "Cut into thin strips and sprinkle with salt, pepper and paprika.",
    "Slice mushrooms and place them to one side.",
    "Slice the onion and crush the garlic then brown in melted butter.",
    "Once softened take out and put on a plate to one side.",
    "Brown the meat in batches then add the mushrooms and the Bovril or stock cube, diluted in a cup of hot water.",
    "Put the onions back and add the soured cream then bring the mixture to just under boiling.",
    "Simmer for 40 minutes then serve with rice or pasta, ideally rice."
  )
}
