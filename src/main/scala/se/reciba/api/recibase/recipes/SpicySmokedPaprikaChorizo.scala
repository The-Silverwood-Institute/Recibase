package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object SpicySmokedPaprikaChorizo extends Recipe {
  val name = "Spicy Smoked Paprika Chorizo"

  val tags = Set(Tag.Spicy, Tag.Scales, Tag.BetterNextDay, Tag.Slow)

  override val source: Option[String] = "Kit's Dad".some
  override val notes: List[String] = List(
    "If your chorio is very spicy you might not need any chilli flakes. Similarly if you use chilli oil.",
    "This dish tastes best if you leave it to cool then reheat it.",
    "You could try serving this dish over grilled aubergines."
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Spanish Chorizo",
      "225g".some,
      None,
      "ideally good quality".some
    ),
    Ingredient("Red Onions", "4".some, "finely diced".some),
    Ingredient(
      "Garlic Cloves",
      "Several".some,
      "fined diced or crushed in a press".some
    ),
    Ingredient("Pointed Red Peppers", "2".some, "sliced".some),
    Ingredient("Carrots", "2-3".some, "diced".some),
    Ingredient(
      "Fresh Spinach",
      "100g".some,
      "torn".some,
      "frozen would also work".some
    ),
    Ingredient("Tinned Tomatoes", "3"),
    Ingredient("Tomato Paste", "4 Inches"),
    Ingredient(
      "Red Wine",
      "10-20CL".some,
      None,
      "something in the \u00a35-10 range".some
    ),
    Ingredient("Smoked Paprika", "Several teaspoons"),
    Ingredient("Olive Oil"),
    Ingredient("Chilli Flakes"),
    Ingredient(
      "Honey",
      "2 tsp".some,
      None,
      "anything but that Rowse shit".some
    ),
    Ingredient("Dried Oregano", "1 tbsp"),
    Ingredient(
      "Stick of Cinnamon",
      "1".some,
      None,
      "Ground also works".some
    ),
    Ingredient("Pitted Black Olives", "6 tbsp".some, "halved".some),
    Ingredient(
      "Cannellini beans",
      "1 400g tin".some,
      "drained and rinsed".some,
      "Optional".some
    ),
    Ingredient(
      "Celery",
      None,
      "chopped into 1cm pieces".some,
      "Optional".some
    ),
    Ingredient("Whole Cloves", "2-3".some, None, "Optional".some),
    Ingredient("Mascarpone", "2 tbsp".some, None, "Optional".some)
  )
  val method = List(
    "Cut the chorizo into half centimeter thick semi-circles.",
    "Add the oil and smoked paprika to a wide pan.",
    "Cook the carrots and celery on a medium to high heat for a minute or so. Stir regularly to avoid sticking.",
    "Add the red onions and garlic then cook for minute.",
    "Stir in the chorizo, peppers and tomato paste then cook for a few more minutes.",
    "Add the pasata, tinned tomatoes, cloves, chilli flakes, red wine, oregano, cinamon stick, and honey. If the pan is looking full then wait until the mixure has reduced before adding the rest of the tinned tomatoes/wine.",
    "Wait until bubbling then turn down the heat and simmer for at least 20 minutes.",
    "Stir in spinach, mascarpone and cannellini beans.",
    "Serve with pasta"
  )
}
