package com.herokuapp.recibase

import io.circe.Encoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.generic.semiauto.deriveEncoder

trait Meal {
  def name: String
  def tags: Set[Tag]
}

object Meal {
  val meals: Set[MealStub] = Recipe.recipes.map(MealStub.apply).toSet ++ Set(
    MealStub(
      "Aubergine & Halloumi Lasagne",
      Set(Tag.Slow, Tag.Vegetarian, Tag.Scales)
    ),
    MealStub("Aubergine & Mozzarella Bake", Set(Tag.Vegetarian, Tag.Slow)),
    MealStub("Aubergine curry", Set(Tag.Vegan, Tag.Scales, Tag.Slow)),
    MealStub(
      "Avocado and coconut soup",
      Set(Tag.Vegan, Tag.Soup, Tag.Scales, Tag.Freezes)
    ),
    MealStub("Baked potatoes", Set(Tag.Slow, Tag.Vegetarian, Tag.ColdWeather)),
    MealStub("Beyond Burgers", Set(Tag.Vegetarian, Tag.Quick, Tag.Stodge)),
    MealStub(
      "Broccoli and Stilton soup",
      Set(
        Tag.Vegetarian,
        Tag.Soup,
        Tag.Scales,
        Tag.Freezes,
        Tag.BetterNextDay,
        Tag.Slow,
        Tag.ColdWeather
      )
    ),
    MealStub("Butternut squash risotto", Set(Tag.Vegan, Tag.HotWeather)),
    MealStub(
      "Carrot & Coriander Burgers",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Effort)
    ),
    MealStub("Cheese and olive tarts", Set(Tag.Vegetarian)),
    MealStub("Cheese scones", Set(Tag.Vegetarian, Tag.Effort, Tag.Stodge)),
    MealStub("Coconut & egg curry", Set(Tag.Vegetarian)),
    MealStub("Cod in tomato sauce", Set(Tag.Pescatarian)),
    MealStub("Cod with Lentils", Set(Tag.Quick, Tag.Pescatarian)),
    MealStub("Egg & Mozzarella Toasts", Set(Tag.Vegetarian, Tag.Quick)),
    MealStub(
      "Fettucine with Dolcelatte and Spinach",
      Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather)
    ),
    MealStub("Fishcakes", Set(Tag.Pescatarian)),
    MealStub("Full Scottish Breakfast", Set(Tag.VegetarianIsh, Tag.Effort, Tag.Quick, Tag.Stodge)),
    MealStub("Gnocchi & Tomato Bake", Set(Tag.Vegetarian, Tag.Scales)),
    MealStub("Grilled aubergine", Set(Tag.Quick, Tag.Vegan)),
    MealStub(
      "Haggis",
      Set(
        Tag.Vegetarian,
        Tag.Slow,
        Tag.Effort,
        Tag.Scales,
        Tag.Stodge,
        Tag.ColdWeather
      )
    ),
    MealStub(
      "Harira Soup",
      Set(Tag.Soup, Tag.Scales, Tag.Vegan, Tag.Freezes, Tag.ColdWeather)
    ),
    MealStub("Kedgeree", Set(Tag.Pescatarian, Tag.Scales)),
    MealStub(
      "Kidney Bean & Vegetable gratin",
      Set(Tag.VegetarianIsh, Tag.Scales)
    ),
    MealStub("Lentil & Spinach Stew", Set(Tag.Vegan, Tag.Scales)),
    MealStub("Lentil & Vegetable Pilaf", Set(Tag.Vegan, Tag.Scales)),
    MealStub(
      "Macaroni",
      Set(Tag.Scales, Tag.Vegetarian, Tag.ColdWeather, Tag.Stodge)
    ),
    MealStub("Mexican Polenta Pie", Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)),
    MealStub(
      "Mozzarella and spinach pancakes",
      Set(Tag.Effort, Tag.Vegetarian)
    ),
    MealStub("Mushroom Lasagne", Set(Tag.Vegetarian, Tag.Slow, Tag.Stodge)),
    MealStub(
      "Mushroom Soup",
      Set(
        Tag.Vegan,
        Tag.Soup,
        Tag.Slow,
        Tag.Scales,
        Tag.Freezes,
        Tag.ColdWeather
      )
    ),
    MealStub(
      "Mushroom and parsnip rösti pie",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Effort)
    ),
    MealStub(
      "N Bean Chilli",
      Set(Tag.Vegan, Tag.Freezes, Tag.BetterNextDay, Tag.Slow, Tag.Scales)
    ),
    MealStub(
      "Pasta & Pesto",
      Set(Tag.VegetarianIsh, Tag.Quick, Tag.Scales, Tag.HotWeather)
    ),
    MealStub(
      "Penne with Walnut sauce",
      Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather)
    ),
    MealStub(
      "Pepper and goats cheese tart",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Stodge, Tag.HotWeather)
    ),
    MealStub("Pizza", Set(Tag.Effort, Tag.Slow, Tag.Vegetarian, Tag.Stodge)),
    MealStub(
      "Potato gratin",
      Set(
        Tag.Vegetarian,
        Tag.Slow,
        Tag.Effort,
        Tag.Stodge,
        Tag.Scales,
        Tag.ColdWeather
      )
    ),
    MealStub(
      "Ricotta spinach pitas",
      Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather)
    ),
    MealStub("Roast Nut Omelette", Set(Tag.Quick, Tag.Vegetarian)),
    MealStub(
      "Roast veg and chickpeas tomato sauce",
      Set(Tag.Vegan, Tag.Freezes, Tag.Slow, Tag.Scales)
    ),
    MealStub(
      "Roast vegetable Moroccan tagine",
      Set(Tag.Vegan, Tag.Freezes, Tag.Scales)
    ),
    MealStub(
      "Roast vegetable risotto",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)
    ),
    MealStub("Roasted Vegetable Tart", Set(Tag.Vegetarian, Tag.HotWeather)),
    MealStub("Sausages and Mash", Set(Tag.Vegetarian, Tag.Quick, Tag.Scales)),
    MealStub(
      "Seitan Tagine",
      Set(Tag.Vegan, Tag.Freezes, Tag.Slow, Tag.Scales)
    ),
    MealStub(
      "Spanakopita (Spinach/feta pastry)",
      Set(Tag.Vegetarian, Tag.Slow)
    ),
    MealStub(
      "Spiced Parsnip & Apple Soup",
      Set(Tag.Soup, Tag.Scales, Tag.VeganIsh, Tag.Spicy, Tag.Freezes)
    ),
    MealStub(
      "Spicy Broccoli & Cauliflower",
      Set(Tag.Vegetarian, Tag.Quick, Tag.Scales, Tag.HotWeather)
    ),
    MealStub(
      "Spicy butternut and coconut soup",
      Set(Tag.Soup, Tag.Scales, Tag.Vegan, Tag.Freezes)
    ),
    MealStub("Stir fry", Set(Tag.Quick, Tag.Vegetarian)),
    MealStub(
      "Sweet Potato, Peanut Butter and Coconut Curry",
      Set(Tag.Vegetarian, Tag.HotWeather)
    ),
    MealStub(
      "Sweetcorn and spinach polenta",
      Set(Tag.VegetarianIsh, Tag.Quick, Tag.Scales, Tag.HotWeather)
    ),
    MealStub("Tofu Katsu Curry", Set(Tag.Vegan)),
    MealStub(
      "Tofu and cashew nut stir fry",
      Set(Tag.Vegan, Tag.Quick, Tag.HotWeather)
    ),
    MealStub(
      "Tomato sauce",
      Set(Tag.Freezes, Tag.Scales, Tag.Slow, Tag.BetterNextDay)
    ),
    MealStub("Tuna and rice peppers", Set(Tag.Pescatarian, Tag.Slow)),
    MealStub("Tuna in tomato sauce", Set(Tag.Pescatarian)),
    MealStub(
      "Vegetable Hot Pot",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Effort, Tag.ColdWeather)
    ),
    MealStub(
      "Venetian Style Pasta",
      Set(Tag.Quick, Tag.Vegan, Tag.Scales, Tag.HotWeather)
    )
  )
}

case class MealStub(
    name: String,
    tags: Set[Tag],
    source: Option[Source] = None
) extends Meal

object MealStub {
  def apply(recipe: Recipe): MealStub =
    MealStub(recipe.name, recipe.tags, Some(Recibase(recipe.permalink)))

  implicit val stubEncoder: Encoder[MealStub] = deriveEncoder[MealStub]
}

sealed trait Source
final case class Online(url: String) extends Source
final case class Recibase(permalink: String) extends Source

object Source {
  implicit val genDevConfig: Configuration =
    Configuration.default.withSnakeCaseConstructorNames.withDiscriminator(
      "type"
    )
  implicit val sourceEncoder: Encoder[Source] = deriveConfiguredEncoder[Source]
}
