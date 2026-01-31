package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object VegetarianMexican extends Recipe {
  val name = "Simple Vegetarian Mexican"
  override val permalink: Permalink =
    Permalink("vegetarian-mexican")

  override val description: Option[String] =
    "Low spoons vegetarian Mexican".some

  val tags = Set(Tag.Vegetarian, Tag.LowEffort, Tag.Stephani)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Black Beans", "2 tins".some, "drained".some),
    Ingredient("Frozen sweetcorn", "260g"),
    Ingredient("Squash", "1"),
    Ingredient("Garlic", None, "finely chopped".some),
    Ingredient(
      "Cheese",
      None,
      None,
      "ideally Sainsbury's 4 cheese mix or a herb/spiced cheese".some
    ),
    Ingredient("Tortillas"),
    Ingredient("Cinnamon"),
    Ingredient("Cumin"),
    Ingredient("Salt"),
    Ingredient("Soured Cream", None, None, "optional".some)
  )
  val method = List(
    s"Preheat the oven to ${200.celsius}.",
    "Peel the squash and chop into 2cm chunks.",
    "Spread on a baking tray and mix with oil, cinnamon and cumin. Roast for 35 minutes.",
    "Defrost the sweetcorn then combine in a large bowl with the black beans and garlic.",
    "Once roasted, add the squash to the bowl along with the cheese. Taste and add salt or more spices.",
    "Serve with tortillas"
  )
}
