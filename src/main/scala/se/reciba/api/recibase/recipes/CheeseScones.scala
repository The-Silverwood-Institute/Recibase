package se.reciba.api.recipes

import cats.syntax.all._
import se.reciba.api.model._
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object CheeseScones extends Recipe {
  val name =
    "Cheese Scones"

  val tags = Set(Tag.Vegetarian, Tag.HighEffort, Tag.Stodge)

  override val source = Some(
    "https://www.bbcgoodfood.com/user/896076/recipe/classic-cheese-scones"
  )

  override val description: Option[String] =
    Some("Scones, with cheese. Fill with jams and more")

  override val notes: Option[String] = Some(
    """Leave the milk out as it always needs more.
      |
      |Don't roll the dough too thin or they won't rise properly.""".stripMargin
  )

  override val image: Option[Image] = Some(
    Image("https://i.reciba.se/cheese-scones.jpg")
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Plain Flour", "208g"),
    Ingredient("Baking Powder", "21g"),
    Ingredient("Cayenne pepper", "pinch"),
    Ingredient("Butter", "55g".some, None, "chilled".some),
    Ingredient("Mature Cheddar", "120g".some, "grated".some),
    Ingredient("Milk", "90-100ml"),
    Ingredient("Salt", "pinch")
  )
  val method = List(
    s"Pre-heat the oven to ${180.celsius} and cut baking paper to cover a large baking tray.",
    "Sift the flour, salt, baking powder and cayenne pepper together in a mixing bowl.",
    "Add the butter in pieces and combine with your fingertips to make breadcrumbs.",
    "Add 100g of the cheese and rub together.",
    "Make a well in the centre of the mixture and slowly add the milk, mixing each time. Don't add it all at once as you might not need it. We usually need extra though.",
    "Lightly flour a surface and roll the dough to a 2cm thickness. Cut out scone shapes and lay them on the baking tray.",
    "Glaze with milk and top with the remaining cheese, leaving a slight gap at the edge of each scone.",
    "Bake in the oven for 15-20 minutes then serve with butter and jams"
  )
}
