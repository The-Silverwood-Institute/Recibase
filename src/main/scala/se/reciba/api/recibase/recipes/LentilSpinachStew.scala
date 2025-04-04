package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object LentilSpinachStew extends Recipe {
  val name = "Lentil & Spinach Stew"

  override val source: Option[String] = Some(
    "https://drive.google.com/file/d/1f247M9Y9DLk4T6NzMng1B6GRvhoaAX74C28UTyxk_Jo/view"
  )

  val tags = Set(Tag.Vegan, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Garlic", "1 clove", "diced"),
    Ingredient("Onion", "1", "roughly chopped"),
    Ingredient("Carrots", "2-3", "chopped"),
    Ingredient("Salad Tomatoes", None, Some("chopped")),
    Ingredient("Cream of coconut", None, Some("grated")),
    Ingredient("Frozen Spinach"),
    Ingredient("Lentils", "150g"),
    Ingredient("Water", "400ml"),
    Ingredient("Worcestershire Sauce"),
    Ingredient("Stock cube", "1"),
    Ingredient("Honey"),
    Ingredient("Chili flakes"),
    Ingredient("Cinnamon"),
    Ingredient("Nutmeg"),
    Ingredient("Olive Oil")
  )
  val method = List(
    "Put out frozen spinach so it can defrost.",
    "Boil the kettle and make stock.",
    "Heat the olive oil in a pan and cook the carrots and garlic with a little bit of honey for a few minutes.",
    "Add the onions and cook for a few more minutes.",
    "Add the tomatoes, stock, grated cream of coconut, a dash of Worcestershire sauce and the spices.",
    "Bring to simmer then add the lentils. You’ll need to possibly add a bit of water as the lentils simmer.",
    "Simmer with the lid on for however long lentils take (15-20 minutes?).",
    "Add frozen spinach."
  )
}
