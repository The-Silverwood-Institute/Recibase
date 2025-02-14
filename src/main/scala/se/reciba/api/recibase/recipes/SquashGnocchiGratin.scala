package se.reciba.api.recipes

import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object SquashGnocchiGratin extends Recipe {
  val name = "Squash and Gnocchi Gratin"

  override val permalink: Permalink = Permalink("squash-gnocchi-gratin")

  override val source: Option[String] = Some(
    "https://vervetimes.com/rukmini-iyers-crispy-baked-squash-and-gnocchi-gratin-with-creme-fraiche-feta-and-kale-feasting-with-ocado/"
  )
  override val notes: Option[String] = Some(
    """Using 200g feta felt like a bit too much so I've noted it down as 100g. Can adjust if that's too little.
      |
      |You can use pumpkin instead of squash.
      |
      |If you have a suitable casserole dish you can bake both the squash and the final mixture in the same dish, to save on washing.
      |""".stripMargin
  )
  override val tags =
    Set(Tag.Vegetarian, Tag.Slow, Tag.LowEffort, Tag.Healthy, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Squash", "1", "chopped into 1 1/2cm cubes"),
    Ingredient("Rosemary", "1 sprig", "needles chopped"),
    Ingredient("Chilli Flakes", "1 tsp"),
    Ingredient("Gnocchi", "500g"),
    Ingredient("Kale", "125g", "chopped"),
    Ingredient("Creme fraiche", "200ml"),
    Ingredient("Feta", "100g"),
    Ingredient("Panko breadcrumbs ", "100g"),
    Ingredient("Salt"),
    Ingredient("Olive Oil"),
    Ingredient("Black pepper")
  )
  val method = List(
    "Pre-heat the oven to 200C/fan 180C/gas 6.",
    "Lay out the squash on a baking tray, cover with olive oil then scatter with rosemary, chilli flakes and salt.",
    "Bake for 25 minutes until beginning to soften.",
    "Meanwhile, blanche the gnocchi and kale by covering with hot water for 2 minutes and then draining.",
    "Tip the gnocchi and kale into a casserole dish and add the creme fraiche.",
    "Take the squash out of the oven and mix into the casserole dish.",
    "Crumble feta over the mixture.",
    "Bake in the oven for 30 minutes until the top is golden brown."
  )
}
