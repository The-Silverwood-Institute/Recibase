package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, IngredientsBlock, Permalink, Recipe, Tag}
import java.time.LocalDate

case object SpicedAppleWinterSoup extends Recipe {
  val name = "Spiced Apple Winter Soup"
  val createdAt = LocalDate.of(2026, 9, 27)
  override val permalink: Permalink = Permalink("spiced-apple-winter-soup")

  override val source: Option[String] = "Stasis/Bel".some
  override val description: Option[String] = "Winter apple soup, scales nicely, very good in the cooler months. Can use most winter root veg to get added textures/flavours.".some
  override val notes: List[String] = List(
    "Gwen rating 8.5/10."
  )

  val tags = Set(Tag.Soup, Tag.Vegan, Tag.ColdWeather, Tag.Slow, Tag.Freezes, Tag.BetterNextDay)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Apples (Red)", "4", "Peeled, cored, chopped finely"),
    Ingredient("Onions (white or brown)", "4 medium or 2 large", "peeled, chopped finely (1-2cm cubes)"),
    Ingredient("Carrots", "2", "peeled, chooped intp 1-2cm cubes"),
    Ingredient("Apple juice", "2lt".some, None, "Preferably not from concentrate/added sugar. DO NOT USE SUGAR FREE.".some),
    Ingredient("Parsnips", "2 small or 1 large", "peeled, chopped 4s then cut into 0.5 - 1 inch segments", "Use fresh, not frozen for best results"),
    Ingredient("Fresh ginger", "1 knob", "Peeled, chop into 1 inch cubes", "Put into a mesh bag to be removed at the end."),
    Ingredient("Cinamon", "1 3 inch stem crush into rough segments".some, None, "Put into a mesh bag to be removed at the end.".some),
    Ingredient("Cloves", "5 cloves".some, None, "Put into a mesh bag to be removed at the end.".some),
    Ingredient("Star anise", "2 cloves".some, None, "Put into a mesh bag to be removed at the end.".some),
    Ingredient("Fennel", "2 tsp".some, None, "Put into a mesh bag to be removed at the end.".some),
    Ingredient("Thyme", "4 sprigs, or 2 tbsp dried".some, None, "Fresh prefered, Put into a mesh bag to be removed at the end.".some),
    Ingredient("Juniper berries (Dried)", "3 - 5".some, None, "Put into a mesh bag to be removed at the end.".some),
    Ingredient("Vegetable stock pots", "2".some, None, "Replace with 3 cubes if unavailable.".some),
    Ingredient("Cooking oil of choice", "as needed to prevent stickage".some, None, "personal preference is gee for an added richness, but olive or avacardo works fine.".some)
  )

  val method = List(
    "Add onions, carrots and parsnips into a medium high heat in a large, 3-5lt container or slow cooker.",
    "After 7 minutes, while the veg is sweating, add in your chopped apples and then sweat until all veg is fork soft (another 5-10 minutes)",
    "Heat 200ml of apple juice to dissolve stock into, then add all apple juice to the pot. add in your spice mesh bag and bring to simmer.",
    "Reduce heat to medium low, and leave to simmer for at least 30 minutes. Once reduced to desired apple-tensisity, serve."
  )
}
