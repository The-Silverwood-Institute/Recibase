package se.reciba.api.recipes

import cats.implicits._
import se.reciba.api.model.{
  Image,
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  IceCream,
  Permalink
}

case object StrawberryBasilIceCream extends Recipe with IceCream {
  val name = "Strawberry, Basil & Black Pepper Ice Cream"

  override val permalink: Permalink =
    Permalink("strawberry-basil-ice-cream")

  override val source: Option[String] = "Kit".some

  override val notes: List[String] = List(
    genericNotes,
    "I vibed the quantity of pepper. A few grinder twists wasn't enough so I added a healthy dose the second time. If I make this again I'll measure it in tsp. Consider using a fine spice mill or grinding with a mortar and pestal, because my supermarket grinder left large pieces.",
    "There was only 1/4tsp of vanilla essence left the first time I made this. I think 1/2-1tsp would work best.",
    "While the food colouring is optional the mixture is a concrete grey by default, so I'd recommend it! I've doubled the quantity of food colouring when writing this up because the mixture was still a bit grey, but YMMV.",
    "Stephani tasting notes: Interesting and complex. Most liked so far. Strong basil flavour with moments of strawberry and black pepper.",
    """Kit tasting notes: smells like pesto, tastes juicy and fruity with strawberry dominating the basil. Pepper a bit weak. Might improve after a few days in the freezer but I should consider soaking the pepper in the mascarpone for a day in the fridge before making ice cream. Consider adding a dash of lime juice to balance the strawberry sweetness, like <a href="https://peterleymanorfarm.co.uk/strawberry-basil-and-black-pepper-ice-cream/">this recipe</a> does."""
  )
  val tags = Set(Tag.Pudding)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/strawberry-basil-ice-cream.jpg")
  ).some

  val ingredientsBlocks = List(
    genericIngredients.prefixIngredients(
      Ingredient(
        "Strawberry powder",
        "12.5g".some,
        None,
        "freeze dried, no added sugar".some
      ),
      Ingredient("Fresh Basil", "15g"),
      Ingredient("Black pepper"),
      Ingredient("Green Food Colouring", "1tsp".some, None, "optional".some)
    )
  )

  val method = genericMethodStart ++ List(
    "Separate the basil leaves from their stems and put in a blender alongside a dollop of the mascarpone. Puree with a food blender.",
    "Add the basil puree and the remaining mascarpone to the whisked egg yolks. Grind in a large dose of black pepper.",
    "Mix in the strawberry powder enough that it won't spray everywhere, then whisk all the ingredients together."
  ) ++ genericMethodEnd
}
