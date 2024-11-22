package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Image,
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object VeganBrownies extends Recipe {
  val name = "Vegan Brownies (WIP)"
  override val permalink: Permalink = Permalink("vegan-brownies")

  override val source: Option[String] = Some(
    "https://reciba.se/brownies"
  )
  override val description: Option[String] = Some(
    "Version 4 of my vegan alt recipe, based on Linda McCartney's classic brownies"
  )
  override val notes: Option[String] = Some(
    """This recipe is all about the chocolate, so use high quality 70%+ dark cooking chocolate. I use Willie's Cacao Chocolate Drops but other vegan cooking chocolates are available. Always check the ingredients as some contain milk.
        |
        |If your vegan butter is unsalted then use a full teaspoon of salt. I reduced the salt quantity to 1/2 tsp because Vitalite is quite salty. The vegan version uses way less butter, but is still failing keep its fluffy texture, so I might reduce the Vitalite further.
        |
        |I've successfully made a gluten free (but non-vegan) version using potato flour and the taste is indistinguishable. The vegan gf versions failed to set, but that was using a much older version of the recipe. I'll try again with gf flour once I've perfected the vegan recipe.
        |
        |If you come up with any improvements please <a href="mailto:kittsville@gmail.com">email me</a> or DM me on Twitter: <a href="https://twitter.com/kittsville">@kittsville</a>.""".stripMargin
  )
  override val tags = Set(Tag.Pudding, Tag.Baking, Tag.Vegan)
  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/brownies.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Vitalite", "200g"),
    Ingredient("Dark Chocolate", Some("300g"), Some("Broken into pieces")),
    Ingredient(
      "Aquafaba",
      Some("214ml"),
      None,
      Some("Collect the water from 2 tins of chickpeas")
    ),
    Ingredient("Cream of tartar", "1/4 tsp"),
    Ingredient("Granulated Sugar", "450g"),
    Ingredient("Vanilla Extract", "1 tbsp"),
    Ingredient("Plain Flour", "200g"),
    Ingredient("Salt", "1/2 tsp")
  )
  val method = List(
    "Line a 34cm x 25cm x 6cm roasting tin with grease proof baking paper",
    "Pre-heat the oven to 180 C (350 F, gas mark 4)",
    "Melt the Vitalite and chocolate together in a heat-proof bowl suspended over a saucepan of barely simmering water.",
    "Whisk the aquafaba, cream of tartar, sugar and vanilla extract together in a bowl until the mixture is thick and creamy and coats the back of a spoon.",
    "Once the Vitalite and chocolate have melted, remove from the heat and gently fold in the aquafaba mixture. Be careful not to go knock the air out of the aquafaba.",
    "Sift in the flour and salt then gently fold in the flour until completely mixed.",
    "Pour into your lined tin, ensuring the mixture is evenly distributed. Bake in the oven for 20 - 25 minutes, or until the whole of the top has formed a little brown crust that has started to crack. This giant brownie should not wobble, but should remain a little gooey on the inside.",
    "Leave to cool for 20 minutes in the pan before lifting out and cutting into portions."
  )
}
