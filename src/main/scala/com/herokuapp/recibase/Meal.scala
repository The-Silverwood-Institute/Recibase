package com.herokuapp.recibase

import io.circe.generic.JsonCodec

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
    MealStub(
      "Baked Rigatoni with Aubergine",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)
    ),
    MealStub("Baked potatoes", Set(Tag.Slow, Tag.Vegetarian, Tag.ColdWeather)),
    MealStub(
      "Bean & Lentil Lasagne",
      Set(Tag.Slow, Tag.Effort, Tag.Scales, Tag.Vegetarian)
    ),
    MealStub("Beetroot risotto", Set(Tag.Vegetarian, Tag.Slow, Tag.HotWeather)),
    MealStub("Beyond Burgers", Set(Tag.Vegetarian, Tag.Quick, Tag.Stodge)),
    MealStub(
      "Blue cheese gnocchi",
      Set(Tag.Stodge, Tag.Quick, Tag.VegetarianIsh, Tag.ColdWeather)
    ),
    MealStub(
      "Broccoli & salmon flan",
      Set(Tag.Stodge, Tag.Slow, Tag.Pescatarian)
    ),
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
    MealStub(
      "Chilli con Carne",
      Set(Tag.VegetarianIsh, Tag.Freezes, Tag.BetterNextDay, Tag.Scales)
    ),
    MealStub("Coconut & egg curry", Set(Tag.Vegetarian)),
    MealStub("Cod and cheese stock", Set(Tag.Pescatarian, Tag.Vegan)),
    MealStub("Cod in tomato sauce", Set(Tag.Pescatarian)),
    MealStub("Cod with Lentils", Set(Tag.Quick, Tag.Pescatarian)),
    MealStub(
      "Courgette and broccoli pasta",
      Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather)
    ),
    MealStub(
      "Courgette and spinach pasties",
      Set(Tag.Slow, Tag.Vegetarian, Tag.Stodge)
    ),
    MealStub(
      "Creamy cauliflower cheese with walnuts",
      Set(Tag.Vegetarian, Tag.Quick)
    ),
    MealStub("Dahl", Set(Tag.Vegan, Tag.Scales)),
    MealStub("Egg & Mozzarella Toasts", Set(Tag.Vegetarian, Tag.Quick)),
    MealStub(
      "Fettucine with Dolcelatte and Spinach",
      Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather)
    ),
    MealStub("Fishcakes", Set(Tag.Pescatarian)),
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
    MealStub(
      "Kashtouri  (Lentils, Rice and Pasta)",
      Set(Tag.Vegan, Tag.Scales, Tag.HotWeather)
    ),
    MealStub("Kedgeree", Set(Tag.Pescatarian, Tag.Scales)),
    MealStub(
      "Kidney Bean & Vegetable gratin",
      Set(Tag.VegetarianIsh, Tag.Scales)
    ),
    MealStub("Lemon pine nut pasta", Set(Tag.Quick, Tag.Vegetarian)),
    MealStub(
      "Lentil & Mint Patties",
      Set(Tag.Vegetarian, Tag.Effort, Tag.Slow)
    ),
    MealStub("Lentil & Spinach Stew", Set(Tag.Vegan, Tag.Scales)),
    MealStub("Lentil & Vegetable Pilaf", Set(Tag.Vegan, Tag.Scales)),
    MealStub(
      "Lentil Shepherd's Pie",
      Set(Tag.Vegetarian, Tag.Slow, Tag.Effort, Tag.Scales, Tag.ColdWeather)
    ),
    MealStub(
      "Macaroni",
      Set(Tag.Scales, Tag.Vegetarian, Tag.ColdWeather, Tag.Stodge)
    ),
    MealStub(
      "Melty mushroom wellingtons",
      Set(Tag.Slow, Tag.Vegetarian, Tag.Stodge, Tag.ColdWeather)
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
    MealStub("Mushroom flan", Set(Tag.Stodge, Tag.Slow, Tag.Vegetarian)),
    MealStub("Mushroom risotto", Set(Tag.Vegetarian)),
    MealStub("Mushroom stroganoff", Set(Tag.Vegetarian, Tag.Scales)),
    MealStub(
      "N Bean Chilli",
      Set(Tag.Vegan, Tag.Freezes, Tag.BetterNextDay, Tag.Slow, Tag.Scales)
    ),
    MealStub("Paneer jalfrezi", Set(Tag.Vegetarian, Tag.Quick)),
    MealStub(
      "Parsnip and Butter Bean Crumble",
      Set(Tag.VegetarianIsh, Tag.Slow, Tag.Effort, Tag.Scales)
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
    MealStub("Roast beetroot dahl", Set(Tag.Vegan)),
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
    MealStub(
      "Roasted vegetable lasagne",
      Set(Tag.Slow, Tag.Effort, Tag.Vegetarian, Tag.Scales)
    ),
    MealStub("Russian Mushroom Julienne", Set(Tag.Vegetarian, Tag.Stodge)),
    MealStub("Saag paneer", Set(Tag.Vegetarian, Tag.HotWeather)),
    MealStub("Salmon pasta", Set(Tag.Pescatarian, Tag.HotWeather)),
    MealStub(
      "Seafood Lasagne",
      Set(Tag.Pescatarian, Tag.Slow, Tag.Stodge, Tag.ColdWeather)
    ),
    MealStub(
      "Seitan Tagine",
      Set(Tag.Vegan, Tag.Freezes, Tag.Slow, Tag.Scales)
    ),
    MealStub("Smokey fish curry", Set(Tag.Pescatarian)),
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
    MealStub("Sweet chilli feta pasta", Set(Tag.Quick, Tag.Vegetarian)),
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
      "Vegetable Primavera (baby vegetables, filled pasta and mustard)",
      Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather)
    ),
    MealStub(
      "Venetian Style Pasta",
      Set(Tag.Quick, Tag.Vegan, Tag.Scales, Tag.HotWeather)
    )
  )
}

@JsonCodec
case class MealStub(
    name: String,
    tags: Set[Tag],
    url: Option[String] = None
) extends Meal

object MealStub {
  def apply(recipe: Recipe): MealStub = MealStub(recipe.name, recipe.tags)
}
