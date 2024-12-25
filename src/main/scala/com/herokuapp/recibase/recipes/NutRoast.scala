package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Ingredient,
  Recipe,
  Tag,
  IngredientsBlock,
  Image
}
import com.herokuapp.recibase.utils.IntUtils.TemperatureUtils
import cats.syntax.all._

case object NutRoast extends Recipe {
  val name = "Nut Roast"

  override val tags =
    Set(Tag.Vegetarian, Tag.HighEffort, Tag.Christmas, Tag.ColdWeather)

  override val notes: Option[String] =
    """We use Waitrose mixed roasted nuts, which is a mixture of brazil nuts, almonds, hazelnuts and macadamia nuts. The pre-roasting really adds to the flavour, so if you buy raw nuts do consider roasting them youself.
    |
    |You can prepare the dry ingredients several days in advance, to reduce stress on the day.
    |
    |This dish is very filling you you'll only need 2 slices per person.
    |
    |The ingredient quantities are largely vibe based, depending how Alex feels each year.
    |
    |The number of eggs needed varies each year, depending how dry the mixture is. Always buy more than needed.""".stripMargin.some

  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/nut-roast.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Mixed Roasted Nuts", "500g"),
    Ingredient("Rosemary", "5 sprigs".some, "finely chopped".some),
    Ingredient("Cranberries", "100g".some, "rinsed".some),
    Ingredient("Eggs", "4-6"),
    Ingredient("Onion", "1".some, "finely chopped".some),
    Ingredient("Chestnut mushrooms", "250g".some, "finely chopped".some),
    Ingredient(
      "Brown crusty bread",
      "2 slices".some,
      None,
      "use more slices if they're not thick. Older/stale bread works better".some
    ),
    Ingredient("Puff Pastry", "2 sheets"),
    Ingredient("Salt"),
    Ingredient("Oil")
  )
  val method = List(
    s"Pre-heat the oven to ${200.celsius}",
    "Smash up the nuts with a large mortar and pestle. If you don't have one you can smash up the nuts using a metal mixing bowl and the end of a rolling pin.",
    "Transfer the mixture to a large mixing bowl.",
    "Toast the bread then blend it into breadcrumbs and add to the mixture.",
    "Heat some oil in a large frying pan then cook the onions and mushrooms for a few minutes.",
    "Take the pan off the heat and leave to cool.",
    "Add the mushrooms, onion, rosemary and some salt to the bowl. Mix together.",
    "Mix in the eggs. Add as many as is necessary for the mixture to stick together.",
    "Roll out one of the sheets of puff pasty on a large baking tray.",
    "Spoon the mixture onto the pastry sheet, leaving a few cm at the edges.",
    "Fold the edges of the pastry up over the mixture.",
    "Slice the second pastry sheet into 1cm wide diagonal strips.",
    "Lay the strips over the mixture in an interlacing lattice. Connect them to the folded-up edges of the first pastry sheet to fully encase the mixture.",
    "Beat an egg then brush the pastry.",
    "Bake in the oven for 40 minutes or until golden brown.",
    "Serve with gravy, roasted vegetables and cranberry relish."
  )
}
