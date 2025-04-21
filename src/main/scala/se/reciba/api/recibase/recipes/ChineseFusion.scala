package se.reciba.api.recipes

import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object ChineseFusion extends Recipe {
  override val name: String = "Chinese Fusion with Hoisin"

  override val permalink: Permalink = Permalink("chinese-fusion")

  val tags: Set[Tag] = Set(Tag.Stephani)

  override val source: Option[String] = Some(
    "Stephani"
  )

  override val notes: List[String] = List(
    "You can add the salt during cooking rather than at the end.",
    "Yes I know, using a wok on a medium heat, blah blah blah."
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butternut Squash", "1"),
    Ingredient(
      "Lamb Mince",
      Some("500g"),
      None,
      Some(
        "alternatively use turkey thigh mince, chicken thigh fillet also works"
      )
    ),
    Ingredient("Leeks", "2 large"),
    Ingredient("Shiitake mushrooms", "125g"),
    Ingredient("Garlic", "4 cloves"),
    Ingredient("Jar Ginger", "2 fork-fulls"),
    Ingredient("Sliced Water chestnuts", "1 tin", "drained"),
    Ingredient("Sliced bamboo", "1 tin", "drained"),
    Ingredient("Five spice"),
    Ingredient("Rich hoisin sauce"),
    Ingredient("Noodles"),
    Ingredient("Oil"),
    Ingredient("Salt")
  )

  override val method: List[String] = List(
    s"Preheat the oven to ${200.celsius}.",
    "Peel butternut squash and cut into 3-4cm cubes.",
    "Place on roasting tray, mix with oil and roast for 80-120 minutes.",
    "Slice leeks into 7mm slices. Finely chop the garlic.",
    "Add some oil to a large wok and heat over a medium flame.",
    "Fry the leeks, garlic and ginger in the wok until reduced.",
    "Add the mince and five spice then brown.",
    "Add mushrooms and cook until the water is almost gone.",
    "Mix in the butternut squash, water chestnuts and sliced bamboo.",
    "Cook the noodles per packet instructions.",
    "Serve on top of the noodles. Add salt and hoisin sauce to taste."
  )
}
