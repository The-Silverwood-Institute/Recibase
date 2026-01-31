package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock, Image}

case object BirthdayCake extends Recipe {
  override val name: String = "Birthday Cake (classic)"

  override val source: Option[String] = (
    "Kit's Mum"
  ).some

  override val description: Option[String] = (
    "My mum's classic madeira cake recipe. Made with buttercream icing and topped with Smarties!"
  ).some

  override val notes: List[String] = List(
    "You can optionally slice off the top of the cake, to provide a flat surface for easier decoration."
  )

  val tags = Set(Tag.Pudding, Tag.Baking)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/birthday-cake.jpg")
  ).some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butter", "5oz"),
    Ingredient("Caster Sugar", "5oz"),
    Ingredient("Eggs", "3"),
    Ingredient("Self raising flour", "8oz"),
    Ingredient("Lemon essence", "1/4 tsp"),
    Ingredient("Unsalted Butter", "100g"),
    Ingredient("Icing Sugar", "200g"),
    Ingredient("Milk", "1 tbsp"),
    Ingredient("Smarties", "136g"),
    Ingredient(
      "Vanilla Extract",
      "1 tsp".some,
      None,
      "buy vanilla extract, not vanilla flavouring".some
    ),
    Ingredient(
      "Marzipan",
      None,
      None,
      "optional, if you want to decorate with lettering".some
    )
  )

  override val method: List[String] = List(
    "Pre-heat the oven to 165-180 C (325-350 F, gas mark 3-4).",
    "Cream the salted butter and sugar.",
    "Lightly whisk the eggs and add to the mixture.",
    "Add the lemon essence.",
    "Fold in the flour.",
    """Put the mixture in a deep 6" or 7" cake tin.""",
    "Bake in the oven for 1 1/4 hours.",
    "Remove from the oven, leave to cool.",
    "Optional: Slice horizontally in two, to allow for an icing filling.",
    "For the icing: beat the unsalted butter and sugar together until smooth.",
    "Beat in the milk and vanilla extract.",
    "Carefully spread it over the cake and in the middle of the two halves (if applicable).",
    "Decorate with smarties.",
    "Optional: Roll out the marzipan, create message with letter cutters and add to top of cake."
  )
}
