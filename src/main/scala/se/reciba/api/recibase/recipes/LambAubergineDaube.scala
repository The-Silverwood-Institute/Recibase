package se.reciba.api.recipes

import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}

case object LambAubergineDaube extends Recipe {
  val name = "Lamb and Aubergine Daube"

  override val source: Option[String] = Some("The Times - Dinner Tonight")
  val tags = Set(Tag.Spicy)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Aubergine", "350g"),
    Ingredient("Onions", "2"),
    Ingredient("Lamb Neck Fillet", "750g"),
    Ingredient("Chopped Tomatoes", "1 400g tin"),
    Ingredient("Chicken Stock", "250ml"),
    Ingredient("Cumin Seed", Some("1/2 tsp")),
    Ingredient("Fennel Seed", Some("1/2 tsp")),
    Ingredient("Dried Chilli Flakes", Some("1/2 tsp")),
    Ingredient("Ginger", Some("10g"), Some("peeled and grated")),
    Ingredient("Olive Oil"),
    Ingredient("Cinamon Stick"),
    Ingredient("Salt"),
    Ingredient("Lemon")
  )
  val method = List(
    "Cut the aubergine into kebab sized chunks then immerse in water diluted with 2tbsp. Leave 20 for minutes. Rinse and drain.",
    "Finely chop the onions. Pulverise the cumin, fennel, chilli flakes and ginger to make a corse paste.",
    "Cut the lamb into kebab sized pieces.",
    "Heat the oil in a large frying pan and stir fry the aubergine, tossing until beginning to soften but not completely cooked. Remove from the pan.",
    "Add a dash more oil the cook the onions for 5 minutes, stirring frequently.",
    "Stir in the cinnamon stick and spice paste.",
    "Toss for a couple of minutes then push the onions to one side of the pan and brown the lamb.",
    "Add the aubergine back along with the chopped tomatoes and stock.",
    "Bring to a gentle simmer then cover and cook for 45 minutes or until lamb is tender.",
    "Season with salt and lemon."
  )
}
