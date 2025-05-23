package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object ScrambledEggs extends Recipe {
  val name = "Scrambled Eggs"

  override val description: Option[String] = Some(
    "Soft, buttery scrambled eggs."
  )
  override val notes: List[String] = List(
    """Variants:
      |Paprika - add a generous amount of (smoked) paprika along with the salt/pepper.
      |Sriracha - mix in a dash of sriracha for a spicier dish. Can be combined with the paprika.
      |Stilton - crumble and melt blue stilton into the butter.
      |Spring onions - lightly fry a sliced spring onion in the butter. Also works with garlic.""".stripMargin
  )
  val tags = Set(Tag.Lunch, Tag.Vegetarian, Tag.LowEffort, Tag.Quick)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butter", None, None, Some("Use a decent amount")),
    Ingredient("Eggs", "2"),
    Ingredient("Milk"),
    Ingredient("Salt"),
    Ingredient("Black pepper")
  )
  val method = List(
    "Melt the butter in a (very) small saucepan.",
    "When bubbling, crack in the eggs and mix thoroughly.",
    "Add a dash of milk, along with the salt and pepper.",
    "Cook the eggs over a medium heat, stirring to prevent sticking.",
    "When the egg mixture reaches the desired consistency (ideally soft enough to pour), remove from heat.",
    "Serve on two slices of toast."
  )
}
