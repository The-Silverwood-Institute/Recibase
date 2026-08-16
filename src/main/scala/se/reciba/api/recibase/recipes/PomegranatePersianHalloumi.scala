package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object PomegranatePersianHalloumi extends Recipe {
  val name = "Pomegranate Persian Halloumi"
  val createdAt = LocalDate.of(2020, 4, 24)

  val tags = Set(
    Tag.LowEffort,
    Tag.Quick,
    Tag.HotWeather,
    Tag.Vegetarian,
    Tag.Scales,
    Tag.StephaniIsh
  )

  override val source: Option[String] = "Gousto".some

  override val description: Option[String] =
    "Halloumi coated in ras el hanout, pan-fried until golden and served with pomegranate couscous and caramelised onions.".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Halloumi", "200g", "cut into thick slices"),
    Ingredient("Couscous", "125g"),
    Ingredient("Boiled water", "170ml"),
    Ingredient("Red onion", "2", "finely sliced"),
    Ingredient("Sultanas", "30g"),
    Ingredient("Pomegranate molasses", "15g"),
    Ingredient("Ras el hanout", "1 tbsp"),
    Ingredient("Mint", "10g", "leaves stripped and roughly chopped"),
    Ingredient("Natural yoghurt", "80g"),
    Ingredient("Olive oil"),
    Ingredient("Salt"),
    Ingredient("Pepper")
  )

  val method = List(
    "Boil a kettle.",
    "Add the couscous and sultanas to a bowl, pour over the boiled water, cover and set aside.",
    "Combine half the ras el hanout in a bowl with a generous grind of black pepper.",
    "Add the sliced halloumi and mix to coat evenly.",
    "Heat a large, wide-based pan (preferably non-stick) with 1 tbsp olive oil over a medium-high heat.",
    "Once hot, add the sliced red onion and cook for 6-7 min or until soft and lightly caramelised.",
    "Fluff the couscous with a fork.",
    "Add the pomegranate molasses, caramelised onions (reserve the pan!), 1 tbsp olive oil and the remaining ras el hanout and mix well.",
    "Combine the chopped mint in a small bowl with the natural yoghurt.",
    "Return the reserved pan to a medium-high heat.",
    "Once hot, add the spiced halloumi and cook for 1-2 min on each side or until golden.",
    "Serve the halloumi over the pomegranate couscous and dollop over the mint yoghurt."
  )
}
