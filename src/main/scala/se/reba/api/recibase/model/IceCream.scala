package se.reciba.api.model

trait IceCream {
  protected val genericIngredients = IngredientsBlock(
    None,
    List(
      Ingredient("Mascarpone", "230g"),
      Ingredient("Eggs", "2"),
      Ingredient("Icing Sugar", "60g")
    )
  )

  protected val genericNotes = """I tend to double up this recipe to make enough for a few days.
                              |
                              |You can use up the egg whites by making <a href="https://www.bbcgoodfood.com/recipes/easy-chocolate-mousse" rel="nofollow">chocolate mousse</a>.""".stripMargin

  protected val genericMethodStart = List(
    "Carefully separate the egg yolks using your hands or spoons. Put aside the egg whites for another recipe.",
    "Whisk the egg yolks and sugar in a bowl, with an electric mixer, until thick and light in colour."
  )

  protected val genericMethodEnd = List(
    "Decant into a freezer suitable dish and freeze for at least 6 hours."
  )
}
