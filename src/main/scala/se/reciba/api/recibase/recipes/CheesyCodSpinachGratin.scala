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
import se.reciba.api.model.Image

case object CheesyCodSpinachGratin extends Recipe {
  val name =
    "Cheesy Cod and Spinach Gratin"
  override val permalink: Permalink = Permalink("cheesy-cod")
  val tags = Set(Tag.Pescatarian, Tag.LowEffort, Tag.Quick)

  override val image: Option[Image] = (
    Image("https://i.reciba.se/cod-spinach-gratin.jpg")
  ).some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Cod", "2 110g fillets"),
    Ingredient("Stock cube", "1"),
    Ingredient("Spinach", "80g".some, "torn or chopped".some),
    Ingredient("Panko breadcrumbs", "30g"),
    Ingredient("Cheddar", "40g".some, "grated".some),
    Ingredient("Soft cheese", "50g"),
    Ingredient("Water", "150ml".some, "boiling".some),
    Ingredient("Crispy Potato Slices", None, None, "optional".some)
  )
  val method = List(
    s"Heat the oven to ${200.celsius}.",
    "Dissolve the stock cube and soft cheese in the boiling water.",
    "Place the spinach in an ovenproof dish and pour over the cheesy stock.",
    "Place the cod fillets on top of the spinach.",
    "Sprinkle the cheddar and breadcrumbs over the cod.",
    "Put in the oven for 15-20 mins or until the fish is cooked through."
  )
}
