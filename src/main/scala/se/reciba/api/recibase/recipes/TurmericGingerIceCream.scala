package se.reciba.api.recipes

import se.reciba.api.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream
}

case object TurmericGingerIceCream extends Recipe with IceCream {
  val name = "Turmeric & Ginger Ice Cream"

  override val source: Option[String] = Some(
    "https://www.sugarlovespices.com/turmeric-ginger-honey-no-churn-ice-cream/"
  )
  override val description: Option[String] = Some(
    "A rich, spicy and earthy ice cream. No churn needed."
  )
  override val notes: List[String] = List(
    """The spice mix isn't set in stone. Taste test the mixture before freezing and adjust according to preference.
      |
      |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.
      |
      |For reference the picture is actually marmalade ice cream. It seems I never took a picture when I made this, though I remember it being delicious.""".stripMargin
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/ice-cream.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Mascarpone", "460g"),
    Ingredient("Eggs", "4"),
    Ingredient("Icing Sugar", "120g"),
    Ingredient("Honey", "1-2 tbsp"),
    Ingredient("Turmeric", "1 1/2 tsp"),
    Ingredient("Fresh Ginger", "1 tsp", "minced"),
    Ingredient("Vanilla Extract", "1/2 tsp"),
    Ingredient("Cardamon", "1/2 tsp", "remove the pods and grind the seeds"),
    Ingredient("Cinnamon", "1 tsp"),
    Ingredient("Chilli Powder", "a pinch")
  )
  val method = genericMethodStart ++ List(
    "Add the mascarpone cheese then continue whisking.",
    "Gently stir in all the remaining ingredients, to avoid aerosolising the powdered spices.",
    "Whisk until thoroughly mixed."
  ) ++ genericMethodEnd
}
