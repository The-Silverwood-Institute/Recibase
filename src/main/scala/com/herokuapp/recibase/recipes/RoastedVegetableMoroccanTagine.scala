package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object RoastedVegetableMoroccanTagine extends Recipe {
  override val name: String = "Roasted Vegetable Moroccan Tagine"

  override val source: Option[String] = Some(
    "https://www.onegreenplanet.org/vegan-recipe/delicious-roasted-veggie-moroccan-tagine/"
  )
  override val tags = Set(Tag.Vegan, Tag.Scales, Tag.Slow)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Aubergine", "1", "cut into 2cm chunks"),
    Ingredient("Carrots", "2", "cut into quarters"),
    Ingredient("Pepper", "1", "cut into quarters"),
    Ingredient("Sweet potato", "1", "cut into 3cm chunks"),
    Ingredient("Garlic", "4 cloves", "peel the skin but leave whole"),
    Ingredient("Broccoli", "1/2", "cut into florets"),
    Ingredient("Onion", "1", "roughly chopped"),
    Ingredient("Rosemary", "1/2 tsp"),
    Ingredient("Ground Cumin", "1/2 tsp"),
    Ingredient("Ground Coriander", "1/2 tsp"),
    Ingredient("Turmeric Powder", "1/2 tsp"),
    Ingredient("Chickpeas", "1 tin", "drained"),
    Ingredient("Tinned Tomatoes", "1 tin"),
    Ingredient("Harissa Paste", "1 tsp"),
    Ingredient(
      "Honey",
      Some("1 tsp"),
      None,
      Some("can use maple syrup instead")
    ),
    Ingredient("Stock Cube", "1"),
    Ingredient(
      "Couscous",
      Some("200g"),
      None,
      Some("can serve with rice instead")
    ),
    Ingredient("Olive Oil"),
    Ingredient("Salt")
  )

  override val method: List[String] = List(
    "Preheat the oven to 200 C (400 F, gas mark 6).",
    "Spread the aubergine, carrots, pepper and sweet potato across a large roasting tin. Drizzle with oil and sprinkle with salt and rosemary.",
    "Roast the vegetables for 20m or until lightly browned. Set aside once they're ready.",
    "Boil some water and make 240ml of stock. Mix in the chopped tomatoes, harissa paste, cumin, ground coriander, turmeric and honey. Set aside so the flavours can develop.",
    "Wait until the vegetables have been roasting for 15 minutes.",
    "Heat some olive oil in a large pan. Everything will eventually be added to this pan, so make sure it's big enough.",
    "Add the onions, garlic and broccoli to the pan and saute over a medium heat for 5-10 minutes, or until the garlic and onions are slightly browned.",
    "Add the roast vegetables and chickpeas to the pan.",
    "Cover the pan and simmer for 15-20 minutes.",
    "Cook the couscous, per packet instructions.",
    "Serve the tagine with a side of couscous."
  )
}
