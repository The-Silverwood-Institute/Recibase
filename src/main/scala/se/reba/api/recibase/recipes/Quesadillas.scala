package se.reciba.api.recipes

import se.reciba.api.model
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object Quesadillas extends Recipe {
  val name = "Quesadillas"

  override val source: Option[String] = Some(
    "https://www.hellofresh.co.uk/recipes/cheesy-chipotle-bean-quesadillas-5feb6402f4480c042d622a2d"
  )
  override val tags = Set(Tag.Quick, Tag.Vegetarian, Tag.Spicy, Tag.LowEffort)

  override val notes: Option[String] = Some(
    """This also works with ancho chilli paste.
      |
      |The original makes a side salad but I have better things to do with my life.""".stripMargin
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Mixed beans", "1 400ml tin"),
    Ingredient(
      "Kidney beans",
      Some("1 400ml tin"),
      None,
      Some("or black beans")
    ),
    Ingredient(
      "Frozen Sweetcorn",
      None,
      None,
      Some("optional, if the mixed beans have no sweetcorn")
    ),
    Ingredient("Cheddar", Some("60g"), Some("grated")),
    Ingredient("Spring Onions", Some("8"), Some("chopped")),
    Ingredient("Chipotle paste", "5 tsp"),
    Ingredient("Tomato Puree", "2 tbsp"),
    Ingredient("Tortillas", "4"),
    Ingredient("Soured Cream"),
    Ingredient("Oil"),
    Ingredient("Salt"),
    Ingredient("Pepper")
  )
  val method = List(
    "Add the beans to a mixing bowl and mush with a fork",
    "Add the cheese, spring onions, sweetcorn, chipotle paste and tomato puree to the mixing bowl. Season with salt and pepper to taste. Add more chipotle paste, if desired.",
    "Lay out the tortillas and split the mixture evenly across each.",
    "Spread the mixture across half of each tortilla, to make folding easier. Fold over each tortilla.",
    "Put a frying pan on a high heat with a small drizzle of oil.",
    "Fry each tortilla for a minute or two, until browned, then flip and repeat. Keep an eye on the underside to avoid it burning. Set aside once both sides are browned.",
    "Serve with some soured cream"
  )
}
