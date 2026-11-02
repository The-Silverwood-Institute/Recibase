package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.Ingredient
import se.reciba.api.model.IngredientsBlock
import se.reciba.api.model.Permalink
import se.reciba.api.model.Recipe
import se.reciba.api.model.Tag

import java.time.LocalDate

case object RedPepperSoup extends Recipe {
  val name = "Red Pepper & Apple Soup"
  val createdAt = LocalDate.of(2020, 4, 24)
  override val permalink: Permalink = Permalink("red-pepper-soup")

  val tags = Set(Tag.Soup, Tag.Scales, Tag.VeganIsh, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Butter", "Knob"),
    Ingredient("Onion", "1"),
    Ingredient("Red Pepper", "1"),
    Ingredient("Apple", "1"),
    Ingredient("Carrot", "1"),
    Ingredient("Water", "600ml"),
    Ingredient("Stock Cube"),
    Ingredient("Mixed Herbs"),
    Ingredient("Extra vegetables", None, None, "Optional".some)
  )
  val method = List(
    "Chop up everything and place everything but the onions in a bowl.",
    "Boil the water and add the stock cube and stir it in.",
    "Melt the butter then add the onions and soften then under a low heat for a minute or so.",
    "Add all the vegetables then the water and herbs.",
    "Turn up the heat and boil for a minute then turn down the heat and simmer it for 30 minutes. Wait until cool and blend."
  )
}
