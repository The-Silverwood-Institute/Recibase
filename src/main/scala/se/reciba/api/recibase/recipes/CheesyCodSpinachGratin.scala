package se.reciba.api.recipes

import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object CheesyCodSpinachGratin extends Recipe {
  val name =
    "Cheesy Cod and Spinach Gratin"
  override val permalink: Permalink = Permalink("cheesy-cod")
  val tags = Set(Tag.Pescatarian, Tag.LowEffort, Tag.Quick)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Cod", "2 110g fillets"),
    Ingredient("Stock cube", "1"),
    Ingredient("Spinach", Some("80g"), Some("torn or chopped")),
    Ingredient("Panko breadcrumbs", "30g"),
    Ingredient("Cheddar", Some("40g"), Some("grated")),
    Ingredient("Soft cheese", "50g"),
    Ingredient("Water", Some("150ml"), Some("boiling")),
    Ingredient("Crispy Potato Slices", None, None, Some("optional"))
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
