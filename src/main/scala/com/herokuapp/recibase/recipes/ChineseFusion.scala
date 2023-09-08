package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Permalink, Recipe, Tag}

case object ChineseFusion extends Recipe {
  override val name: String = "Chinese Fusion with Hoisin"

  override val permalink: Permalink = Permalink("chinese-fusion")

  override val source: Option[String] = Some(
    "Stephani"
  )

  override val notes: Option[String] = Some(
    """You can add the salt during cooking rather than at the end.
      |
      |Yes I know, using a wok on a medium heat, blah blah blah.
      |""".stripMargin
  )

  override val ingredients: List[Ingredient] = List(
    Ingredient("Butternut Squash", "1"),
    Ingredient(
      "Lamb Mince",
      Some("250g"),
      None,
      Some(
        "alternatively use turkey thigh mince, chicken thigh fillet also works"
      )
    ),
    Ingredient("Leeks", "2 large"),
    Ingredient("Shiitake mushrooms", "125g"),
    Ingredient("Garlic", "4 cloves"),
    Ingredient("Jar Ginger", "1 fork-full"),
    Ingredient("Sliced Water chestnuts", "1 tin", "drained"),
    Ingredient("Sliced bamboo", "1 tin", "drained"),
    Ingredient("Five spice"),
    Ingredient("Rich hoisin sauce"),
    Ingredient("Noodles"),
    Ingredient("Oil"),
    Ingredient("Salt")
  )

  override val method: List[String] = List(
    "Preheat the oven to 200 C (400 F, gas mark 6).",
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
