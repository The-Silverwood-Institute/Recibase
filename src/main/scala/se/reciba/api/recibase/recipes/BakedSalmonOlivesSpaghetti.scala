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

case object BakedSalmonOlivesSpaghetti extends Recipe {
  val name = "Baked Salmon with Olives and Spaghetti"
  override val permalink: Permalink =
    Permalink("salmon-olive-spaghetti")

  override val description: Option[String] =
    "Baked salmon served on a bed of spaghetti, onions and olives.".some
  override val notes: List[String] =
    List(
      "Cover the baking tray in foil for easier cleaning later.",
      "Use the bigger pan."
    )
  val tags = Set(Tag.Pescatarian, Tag.HotWeather)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Salmon fillets",
      "1 per person".some,
      None,
      "Approximately 1 inch wide".some
    ),
    Ingredient("Capers", None, "finely chopped".some),
    Ingredient("Olive oil"),
    Ingredient("Onion", "1", "sliced"),
    Ingredient("Pimento-stuffed olives"),
    Ingredient("Lemon juice"),
    Ingredient("Thyme", None, None, "Dried or fresh".some),
    Ingredient("Spaghetti"),
    Ingredient("Cherry tomatoes", None, "halved".some, "Optional".some)
  )
  val method = List(
    s"Preheat the oven at ${160.celsius}.",
    "Cook the spaghetti in a saucepan.",
    "Meanwhile, rub the salmon fillets with the olive oil, lemon juice and the chopped capers. Sprinkle with salt.",
    "Place in the oven and bake for 10-15 minutes or until cooked through. If you are unsure, check the thickest part of the salmon with a fork.",
    "Drain the spaghetti and set aside.",
    "In the same pan, heat a small amount of oil and cook the onions, leaving them softened but still crisp. Add the olives, tomatoes, thyme and lemon juice and warm.",
    "Add the spaghetti and toss. Keep warm.",
    "Serve the salmon fillets on top of the spaghetti mixture."
  )
}
