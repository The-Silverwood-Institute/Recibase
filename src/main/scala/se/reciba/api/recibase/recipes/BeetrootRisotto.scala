package se.reciba.api.recipes

import se.reciba.api.model._
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object BeetrootRisotto extends Recipe {
  val name =
    "Roast Beetroot Risotto"
  override val permalink: Permalink =
    Permalink("beetroot-risotto")

  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/beetroot-risotto.jpg")
  )

  override def notes: List[String] = List(
    """<a href="https://t.sci1.uk/risotto-calculator/">An arborio rice/water ratio calculator</a>"""
  )

  val tags = Set(Tag.Vegetarian, Tag.Slow, Tag.HotWeather)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Beetroot",
      Some("5"),
      Some("peeled and cut into 1-2cm pieces"),
      Some("Quantity is approximate")
    ),
    Ingredient("Arborio rice", "1 cup"),
    Ingredient("White wine", "A decent slosh"),
    Ingredient("Thyme"),
    Ingredient("Stock cube", "1"),
    Ingredient(
      "Water",
      Some("700ml"),
      Some("boiling"),
      Some("might need to add more")
    ),
    Ingredient("Soft Goats Cheese", "up to 75g")
  )
  val method = List(
    s"Preheat the oven to ${200.celsius}.",
    "Place the peeled beetroot on a baking tray, drizzle with oil and put in the oven for 20 minutes or until soft.",
    "If the beetroot came with stems and leaves, cut these into small pieces and set aside.",
    "Dissolve the stock cube in the boiling water and add the wine and thyme.",
    "Put the arborio rice in a pan over a medium heat and gradually stir in the stock, mixing often and not adding more until the previous lot of water has been absorbed.",
    "About half-way through making the rice, add the beetroot stalks and leaves to the rice pan.",
    "When the rice is tender, add the beetroot and mix thoroughly.",
    "Mix in the goats cheese."
  )
}
