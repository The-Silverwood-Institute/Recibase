package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object RoastedVegetableLasagne extends Recipe {
  val name = "Roasted Vegetable Lasagne"

  override val source: Option[String] = Some(
    "https://www.bbcgoodfood.com/recipes/10603/roasted-vegetable-lasagne"
  )
  override val notes: Option[String] =
    Some(
      """This takes a while to make so leave lots of time.

Don't worry if the roasted vegetables are ready early. Just take them out and put them to one side, or decant them onto a plate."""
    )
  val tags = Set(Tag.Slow, Tag.HighEffort, Tag.Vegetarian, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red Peppers", "3"),
    Ingredient("Aubergines", "2"),
    Ingredient("Onions", "2", "diced"),
    Ingredient("Garlic Cloves", "2"),
    Ingredient("Carrot", "1", "roughly chopped"),
    Ingredient("Tomato Puree", "2 tbsp"),
    Ingredient("Red or White Wine"),
    Ingredient("Chopped Tomatoes", "3 tins"),
    Ingredient(
      "Dried mixed herbs",
      Some("handful"),
      None,
      Some("Italian herb blends or just plain oregano works")
    ),
    Ingredient("Butter", "knob"),
    Ingredient("Plain Flour"),
    Ingredient("Milk"),
    Ingredient("Fresh Lasagne sheets", "300g"),
    Ingredient(
      "Mozzarella",
      Some("125g"),
      None,
      Some("I'd buy extra just to be safe. Can always nom the rest")
    ),
    Ingredient("Olive Oil"),
    Ingredient("Cherry Tomatoes", None, Some("Halved"), Some("Optional")),
    Ingredient("Fresh Basil", None, None, Some("Optional"))
  )
  val method = List(
    "Pre-heat the oven to 200C/fan 180C/gas 6.",
    "Cut the peppers into large chunks. Cut the aubergines into slices about 1/2cm thick.",
    "Lightly grease 2 large baking trays, then place peppers and aubergines on top. Toss with the olive oil, season well, then roast for 25 mins until lightly browned. Meanwhile, make the red and white sauces.",
    "To make the red sauce, add the garlic and some oil to a saucepan over a medium heat.",
    "Add the onions and carrots and cook until softened.",
    "Turn up the heat, add the tomato purée, then cook for a further minute.",
    "Add the chopped tomatoes, dried mixed herbs and a generous slosh of wine. Bring to the boil then leave to simmer for at least 20 minutes.",
    "For the white sauce, melt the butter in a saucepan over a low heat.",
    "Sift in the flour, stirring regularly, until you have a very thick mixture.",
    "Switch to a medium heat and slowly add the milk until the sauce pours off the spoon. Be warned, there's a delay after adding the milk before it thickens, turn up the heat slightly if it's taking a long time.",
    "Reduce the oven to 180C/fan 160C/gas 4 and lightly oil an ovenproof serving dish (30 x 20cm).",
    "Arrange a layer of the roasted vegetables on the bottom, then pour over a third of the red sauce. Top with a layer of lasagne, then drizzle over a quarter of the white sauce. Repeat until you have 3 layers of pasta.",
    "To finish, spoon remaining white sauce over the pasta, making sure the whole surface is covered. Scatter mozzarella over the top. Bake for 45 mins until bubbling and golden.",
    "Scatter the cherry tomatoes and basil over the top then serve."
  )
}
