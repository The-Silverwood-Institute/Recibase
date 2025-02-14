package se.reciba.api.recipes

import se.reciba.api.model.{Image, Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object Brownies extends Recipe {
  val name = "Brownies"

  override val source: Option[String] = Some(
    "https://www.louisegorrod.com/buttercup-archive/2011/07/chocolate-brownies.html"
  )
  override val description: Option[String] = Some(
    "I originally got this Linda McCartney recipe from my dad, although I've since re-found it on Louise Gorrod's website. I've mirrored it here both for my own notes and because websites inevitably disappear when you least expect them to."
  )
  override val notes: Option[String] = Some(
    """This recipe is all about the chocolate, so use high quality 70% dark cooking chocolate. I use Willie's Cacao Chocolate Drops or Menier Swiss Dark Chocolate.
        |
        |You can use gluten free flour and the taste is indistinguishable. I've been working on a <a href="https://reciba.se/vegan-brownies">vegan version</a> using aquafaba.""".stripMargin
  )
  override val tags = Set(Tag.Pudding, Tag.Baking, Tag.Vegetarian)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/brownies.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Unsalted Butter", "300g"),
    Ingredient("Dark Chocolate", Some("300g"), Some("Broken into pieces")),
    Ingredient("Eggs", "5 large"),
    Ingredient("Granulated Sugar", "450g"),
    Ingredient("Vanilla Extract", "1 tbsp"),
    Ingredient("Plain Flour", "200g"),
    Ingredient("Salt", "1 tsp")
  )
  val method = List(
    "Line a 34cm x 25cm x 6cm roasting tin with grease proof baking paper",
    s"Pre-heat the oven to ${180.celsius}",
    "Melt the butter and chocolate together in a heat-proof bowl suspended over a saucepan of barely simmering water.",
    "Whisk the eggs, sugar and vanilla extract together in a bowl until the mixture is thick and creamy and coats the back of a spoon.",
    "Once the butter and chocolate have melted, remove from the heat and gently fold in the egg mixture. Be careful not to go knock the air out of the egg mixture.",
    "Sift in the flour and salt then gently fold in the flour until completely mixed.",
    "Pour into your lined tin, ensuring the mixture is evenly distributed. Bake in the oven for 20 - 25 minutes, or until the whole of the top has formed a little brown crust that has started to crack. This giant brownie should not wobble, but should remain a little gooey on the inside.",
    "Leave to cool for 20 minutes in the pan before lifting out and cutting into portions."
  )
}
