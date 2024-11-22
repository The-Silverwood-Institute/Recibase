package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object ChilliConCarne extends Recipe {
  val name = "Chilli con Carne"
  override val permalink: Permalink =
    Permalink("chilli-con-carne")

  override val source: Option[String] = Some("Kit's Dad")
  override val tags = Set(
    Tag.VegetarianIsh,
    Tag.Freezes,
    Tag.BetterNextDay,
    Tag.Scales,
    Tag.Spicy
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Oil"),
    Ingredient("Salt"),
    Ingredient("Pepper"),
    Ingredient("Chilli Powder", "1 tsp"),
    Ingredient("Crushed or whole dried chillies", "1 tsp"),
    Ingredient("Red Pepper", "1"),
    Ingredient("Frozen Sweetcorn"),
    Ingredient("Paprika"),
    Ingredient("Tomato Puree"),
    Ingredient("Peeled plum tomatoes", "1 400g tin"),
    Ingredient("Italian Herbs"),
    Ingredient("Brown Sauce"),
    Ingredient("Beef stock cube or Bovril"),
    Ingredient("Rice"),
    Ingredient("Olive Oil"),
    Ingredient("Onion", "1"),
    Ingredient("Garlic Clove", "1"),
    Ingredient("Kidney Beans", "1 400g tin"),
    Ingredient("Honey", Some("1 tbsp"), None, Some("Optional")),
    Ingredient("Dark cooking chocolate", None, None, Some("Optional")),
    Ingredient("Mince", "500g")
  )
  val method = List(
    "Slice onions, crush garlic then brown in 2 tsp olive oil.",
    "Add the pepper and cook for a minute.",
    "Add the mince in batches and brown then stir in chilli powder and paprika.",
    "Add the stock cube/Bovril dissolved in a small amount of water and stir.",
    "Then add 2 inches or so of tomato purée and stir again, followed by the tinned tomatoes.",
    "Simmer for half an hour then check for taste.",
    "Add chilli powder or tomato purée depending on flavour, also salt/pepper if needed.",
    "Stir in the sweetcorn.",
    "A tablespoon of honey or a few pieces of dark chocolate can improve the flavour.",
    "Serve with rice (preferably) or pasta."
  )
}
