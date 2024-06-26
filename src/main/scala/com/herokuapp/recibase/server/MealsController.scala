package com.herokuapp.recibase.server

import cats.Applicative
import cats.implicits._
import com.herokuapp.recibase.model.{
  GoogleDrive,
  Meal,
  MealStub,
  Online,
  Recipe,
  Source,
  Tag
}
import com.herokuapp.recibase.usage.UsageData

import scala.collection.immutable

trait MealsController[F[_]] {
  def meals: F[Set[MealStub]]
  def mealNames: F[String]
}

object MealsController {
  def impl[F[_]: Applicative]: MealsController[F] =
    new MealsController[F] {
      override def meals: F[Set[MealStub]] = mealStubsWithUsageData.pure[F]
      override def mealNames: F[String] =
        mealStubsWithUsageData
          .filter(_.isDinner)
          .map(_.name)
          .toSeq
          .sorted
          .mkString("\n")
          .pure[F]
    }

  private val mealStubs: Set[MealStub] =
    Recipe.recipes.map(MealStub.apply).toSet ++ Set(
      MealStub(
        "Aubergine & Halloumi Lasagne",
        Set(Tag.Slow, Tag.Vegetarian, Tag.Scales)
      ),
      MealStub("Aubergine curry", Set(Tag.Vegan, Tag.Scales, Tag.Slow)),
      MealStub(
        "Avocado and coconut soup",
        Set(Tag.Vegan, Tag.Soup, Tag.Scales, Tag.Freezes),
        GoogleDrive(
          "170P50UetqQPkrqqYvthtt3FBXsjCAYU_"
        )
      ),
      MealStub(
        "Baked potatoes",
        Set(Tag.Slow, Tag.Vegetarian, Tag.ColdWeather, Tag.LowEffort)
      ),
      MealStub(
        "Banana Curry",
        Set(Tag.Slow, Tag.Vegan, Tag.Scales, Tag.Freezes),
        Online(
          "https://www.theendlessmeal.com/banana-curry/"
        )
      ),
      MealStub(
        "Bean and Broccoli Pasta",
        Set(Tag.VeganIsh, Tag.Scales),
        Online(
          "https://www.themediterraneandish.com/mediterranean-broccoli-pasta-bean/"
        )
      ),
      MealStub("Beyond Burgers", Set(Tag.Vegetarian, Tag.Quick, Tag.Stodge)),
      MealStub(
        "Haddock Moqueca",
        Set(Tag.Pescatarian, Tag.Spicy),
        Online(
          "https://www.gousto.co.uk/cookbook/fish-recipes/brazilian-haddock-moqueca-zesty-lime-rice"
        )
      ),
      MealStub("Butternut squash risotto", Set(Tag.Vegan, Tag.HotWeather)),
      MealStub("Carbonara", Set(Tag.VegetarianIsh, Tag.Quick, Tag.Scales)),
      MealStub(
        "Carrot & Coriander Burgers",
        Set(Tag.Vegetarian, Tag.Slow, Tag.HighEffort)
      ),
      MealStub(
        "Cashew Curry",
        Set(Tag.Vegan, Tag.Scales),
        Online(
          "https://vegancocotte.com/cashew-curry/"
        )
      ),
      MealStub("Cheese and olive tarts", Set(Tag.Vegetarian)),
      MealStub(
        "Cheese scones",
        Set(Tag.Vegetarian, Tag.HighEffort, Tag.Stodge),
        Online(
          "https://www.bbcgoodfood.com/user/896076/recipe/classic-cheese-scones"
        )
      ),
      MealStub(
        "Coconut & egg curry",
        Set(Tag.Vegetarian),
        Online("https://www.bbc.co.uk/food/recipes/whole_eggs_in_coconut_23624")
      ),
      MealStub("Cod in tomato sauce", Set(Tag.Pescatarian)),
      MealStub("Egg & Mozzarella Toasts", Set(Tag.Vegetarian, Tag.Quick)),
      MealStub(
        "Fish Pie",
        Set(Tag.Pescatarian, Tag.Scales, Tag.ColdWeather, Tag.Slow)
      ),
      MealStub(
        "Fettucine with Dolcelatte and Spinach",
        Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather, Tag.LowEffort)
      ),
      MealStub("Fishcakes", Set(Tag.Pescatarian)),
      MealStub(
        "Full Scottish Breakfast",
        Set(Tag.VegetarianIsh, Tag.HighEffort, Tag.Quick, Tag.Stodge)
      ),
      MealStub(
        "Garlic Spaghetti",
        Set(Tag.Vegan, Tag.Scales, Tag.Quick, Tag.HotWeather, Tag.LowEffort)
      ),
      MealStub("Gnocchi & Tomato Bake", Set(Tag.Vegetarian, Tag.Scales)),
      MealStub(
        "Goan-Style King Prawn Balchão Curry",
        Set(
          Tag.Pescatarian,
          Tag.LowEffort,
          Tag.Quick,
          Tag.Spicy,
          Tag.Scales
        ),
        Online(
          "https://www.gousto.co.uk/cookbook/fish-recipes/goan-prawn-balchao-curry-with-basmati-rice"
        )
      ),
      MealStub(
        "Goats cheese, leek and spinach pasta bake",
        Set(Tag.Vegetarian, Tag.Scales, Tag.HotWeather),
        Online(
          "https://www.gousto.co.uk/cookbook/recipes/goats-cheese-leek-spinach-pasta-bake"
        )
      ),
      MealStub("Grilled aubergine", Set(Tag.Quick, Tag.Vegan, Tag.LowEffort)),
      MealStub(
        "Haggis",
        Set(
          Tag.Vegetarian,
          Tag.Slow,
          Tag.HighEffort,
          Tag.Scales,
          Tag.Stodge,
          Tag.ColdWeather
        )
      ),
      MealStub(
        "Harira Soup",
        Set(Tag.Soup, Tag.Scales, Tag.Vegan, Tag.Freezes, Tag.ColdWeather),
        Online(
          "https://www.onegreenplanet.org/vegan-recipe/harira-soup-with-hummus-pitas/"
        )
      ),
      MealStub(
        "Jamaican Squash and Coconut Stew",
        Set(Tag.Scales, Tag.Vegan, Tag.Spicy, Tag.Freezes, Tag.BetterNextDay),
        Online(
          "https://www.gousto.co.uk/cookbook/vegan-recipes/jamaican-squash-coconut-stew"
        )
      ),
      MealStub(
        "Kedgeree",
        Set(Tag.Pescatarian, Tag.Scales),
        Online("https://www.bbcgoodfood.com/recipes/smoked-haddock-kedgeree")
      ),
      MealStub(
        "Kidney Bean & Vegetable gratin",
        Set(Tag.VegetarianIsh, Tag.Scales)
      ),
      MealStub("Lentil & Spinach Stew", Set(Tag.Vegan, Tag.Scales)),
      MealStub("Lentil & Vegetable Pilaf", Set(Tag.Vegan, Tag.Scales)),
      MealStub(
        "Macaroni",
        Set(Tag.Scales, Tag.Vegetarian, Tag.ColdWeather, Tag.Stodge),
        GoogleDrive("1aiAdl0JqdR6rU0Y-vJgsLre6IbJGhG8iCyD7HzP5Cvc")
      ),
      MealStub(
        "Vegetarian Meatballs",
        Set(Tag.Scales, Tag.Vegetarian)
      ),
      MealStub(
        "Mediterranean Fish Stew",
        Set(Tag.Pescatarian),
        Online(
          "https://www.gousto.co.uk/cookbook/fish-recipes/mediterranean-fish-stew-sunny-aioli"
        )
      ),
      MealStub(
        "Mediterranean Vegetable Gnocchi",
        Set(Tag.Vegetarian, Tag.Scales, Tag.Quick, Tag.HotWeather),
        Online(
          "https://www.gousto.co.uk/cookbook/vegetarian-recipes/mediterranean-veg-gnocchi-with-basil"
        )
      ),
      MealStub(
        "Mexican Polenta Pie",
        Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)
      ),
      MealStub(
        "Mexican Tofu with Refried Beans",
        Set(Tag.Vegetarian, Tag.Spicy),
        GoogleDrive(
          "12RZq9w7CGKFZdxvGPUfMVhcjAXm1tdJI"
        )
      ),
      MealStub(
        "Mild Paneer Curry",
        Set(Tag.Vegetarian),
        Online("https://www.gousto.co.uk/cookbook/recipes/mild-paneer-curry")
      ),
      MealStub(
        "Mozzarella and spinach pancakes",
        Set(Tag.HighEffort, Tag.Vegetarian),
        GoogleDrive("1L7CueEwwXy6ObWx7A2AjIxO4FdsI-YB_")
      ),
      MealStub(
        "Mozzarella Burgers",
        Set(Tag.Vegetarian, Tag.LowEffort, Tag.Stodge)
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
        ),
        GoogleDrive("1mxBjlql91Kxo6lHZL-LnmHmhGlRYThCk")
      ),
      MealStub(
        "Mushroom and parsnip rösti pie",
        Set(Tag.Vegetarian, Tag.Slow, Tag.HighEffort),
        GoogleDrive("1-YvovgTwMtwqYvuEBAz3gb2shqaTRtY69i5zJjNsbd8")
      ),
      MealStub(
        "N Bean Chilli",
        Set(Tag.Vegan, Tag.Freezes, Tag.BetterNextDay, Tag.Slow, Tag.Scales)
      ),
      MealStub(
        "Nutty Sweet Potato and Spinach Pie",
        Set(Tag.Vegetarian, Tag.HighEffort, Tag.ColdWeather),
        GoogleDrive("1dM9T4Bu7Hj3fbLplX3NYKnCFqvuNrFC4tgWhhgWYTUE")
      ),
      MealStub(
        "Paneer Butter Masala",
        Set(Tag.Vegetarian, Tag.Quick, Tag.LowEffort, Tag.Spicy),
        Online(
          "https://www.gousto.co.uk/cookbook/vegetarian-recipes/paneer-butter-masala-with-coriander-naan"
        )
      ),
      MealStub(
        "Pasta & Pesto",
        Set(
          Tag.VegetarianIsh,
          Tag.Quick,
          Tag.Scales,
          Tag.HotWeather,
          Tag.LowEffort
        )
      ),
      MealStub(
        "Penne with Walnut sauce",
        Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather, Tag.LowEffort)
      ),
      MealStub(
        "Pepper and goats cheese tart",
        Set(Tag.Vegetarian, Tag.Slow, Tag.Stodge, Tag.HotWeather)
      ),
      MealStub(
        "Pies",
        Set(Tag.LowEffort, Tag.Vegetarian, Tag.Stodge)
      ),
      MealStub(
        "Pizza",
        Set(Tag.HighEffort, Tag.Slow, Tag.Vegetarian, Tag.Stodge)
      ),
      MealStub(
        "Pomegranate Persian Halloumi",
        Set(Tag.LowEffort, Tag.Quick, Tag.HotWeather, Tag.Vegetarian),
        Online("https://drive.google.com/drive/folders/1sIZae-25brxIrc6KeWuOTf2uXE7lLvbQ")
      ),
      MealStub(
        "Potato gratin",
        Set(
          Tag.Vegetarian,
          Tag.Slow,
          Tag.HighEffort,
          Tag.Stodge,
          Tag.Scales,
          Tag.ColdWeather
        )
      ),
      MealStub(
        "Ricotta spinach pitas",
        Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather, Tag.LowEffort),
        GoogleDrive("1mwrdX7b3hk3AArjnDNWjbyMavuJ6JyI5")
      ),
      MealStub(
        "Roast Aubergine and Basil Risotto",
        Set(Tag.Vegetarian),
        Online(
          "https://www.gousto.co.uk/cookbook/recipes/tomato-risotto-with-crispy-roast-aubergine"
        )
      ),
      MealStub("Roast Nut Omelette", Set(Tag.Quick, Tag.Vegetarian)),
      MealStub(
        "Roast veg and chickpeas tomato sauce",
        Set(Tag.Vegan, Tag.Freezes, Tag.Slow, Tag.Scales)
      ),
      MealStub(
        "Roast vegetable risotto",
        Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)
      ),
      MealStub(
        "Roasted Vegetable Tart",
        Set(Tag.Vegetarian, Tag.HotWeather),
        GoogleDrive("1nIIXKu72Kohy6UDK_PwiMYYSp7I3Wcou")
      ),
      MealStub(
        "Satay Sweet Potato Curry",
        Set(Tag.Vegan, Tag.Scales, Tag.Spicy, Tag.Quick, Tag.BetterNextDay),
        Online(
          "https://www.bbc.co.uk/food/recipes/satay_sweet_potato_curry_59527"
        )
      ),
      MealStub(
        "Sausage and Bean Casserole",
        Set(Tag.VegetarianIsh, Tag.Scales, Tag.Slow, Tag.ColdWeather),
        Online("https://www.bbcgoodfood.com/recipes/sausage-bean-casserole")
      ),
      MealStub(
        "Sausages and Mash",
        Set(Tag.Vegetarian, Tag.Quick, Tag.Scales, Tag.LowEffort)
      ),
      MealStub(
        "Seitan Tagine",
        Set(Tag.Vegan, Tag.Freezes, Tag.Slow, Tag.Scales),
        Online(
          "https://www.onegreenplanet.org/vegan-recipe/seitan-tagine-with-apricots-and-dates/"
        )
      ),
      MealStub(
        "Shahi Paneer",
        Set(Tag.Vegetarian, Tag.Spicy, Tag.Scales),
        Online(
          "https://www.indianhealthyrecipes.com/shahi-paneer-recipe/"
        )
      ),
      MealStub(
        "Smoky sausage casserole",
        Set(
          Tag.VegetarianIsh,
          Tag.ColdWeather,
          Tag.Slow,
          Tag.Scales,
          Tag.BetterNextDay
        ),
        Online("https://www.bbcgoodfood.com/recipes/smoky-sausage-casserole")
      ),
      MealStub(
        "Spiced Parsnip & Apple Soup",
        Set(Tag.Soup, Tag.Scales, Tag.VeganIsh, Tag.Spicy, Tag.Freezes),
        Online(
          "https://www.bbcgoodfood.com/recipes/curried-lentil-parsnip-apple-soup"
        )
      ),
      MealStub(
        "Spicy Broccoli & Cauliflower",
        Set(
          Tag.Vegetarian,
          Tag.Quick,
          Tag.Scales,
          Tag.HotWeather,
          Tag.LowEffort
        )
      ),
      MealStub(
        "Spicy Butternut and Coconut Soup",
        Set(Tag.Soup, Tag.Scales, Tag.Vegan, Tag.Freezes),
        Online("https://www.bbc.co.uk/food/recipes/pumpkin_soup_45815")
      ),
      MealStub(
        "Spicy Chilli Paneer Noodles",
        Set(Tag.Vegetarian, Tag.Scales, Tag.Quick, Tag.Spicy),
        Online(
          "https://www.gousto.co.uk/cookbook/vegetarian-recipes/10-min-spicy-chilli-paneer-noodles"
        )
      ),
      MealStub("Stir fry", Set(Tag.Quick, Tag.Vegetarian)),
      MealStub(
        "Sweet Potato & Smoked Paprika Soup",
        Set(
          Tag.Vegetarian,
          Tag.ColdWeather,
          Tag.Scales,
          Tag.Spicy,
          Tag.Freezes
        ),
        Online(
          "https://www.italianfoodforever.com/2020/11/creamy-sweet-potato-soup/"
        )
      ),
      MealStub(
        "Sweet Potato, Peanut Butter and Coconut Curry",
        Set(Tag.Vegetarian, Tag.HotWeather)
      ),
      MealStub(
        "Sweetcorn and spinach polenta",
        Set(
          Tag.VegetarianIsh,
          Tag.Quick,
          Tag.Scales,
          Tag.HotWeather,
          Tag.LowEffort
        ),
        GoogleDrive("1sbycCsoWJSO8ETeg_AQ-2rHE4Ea6UYvi")
      ),
      MealStub(
        "Thai Green Curry",
        Set(Tag.VeganIsh, Tag.Slow, Tag.Scales, Tag.Spicy)
      ),
      MealStub("Tofu Katsu Curry", Set(Tag.Vegan)),
      MealStub(
        "Tofu and cashew nut stir fry",
        Set(Tag.Vegan, Tag.Quick, Tag.HotWeather),
        GoogleDrive("1nNWYsSiKtMubmN3VeXgGpIX8_RniCOlp")
      ),
      MealStub(
        "Tomato & Mozzarella Salad",
        Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather, Tag.LowEffort)
      ),
      MealStub(
        "Tomato sauce",
        Set(Tag.Freezes, Tag.Scales, Tag.Slow, Tag.BetterNextDay, Tag.LowEffort, Tag.VeganIsh)
      ),
      MealStub("Tuna and rice peppers", Set(Tag.Pescatarian, Tag.Slow)),
      MealStub(
        "Tuna Fish Pie",
        Set(Tag.Pescatarian, Tag.Scales),
        Online(
          "https://www.taste.com.au/recipes/tuna-pie-potato-topping/53c34dd0-edf6-4db9-929f-ac2fd4b65667"
        )
      ),
      MealStub(
        "Tuna in tomato sauce",
        Set(Tag.Pescatarian),
        GoogleDrive("1nDEnSpUpKG2a3tIL4VklxJrzAVO5GFkX")
      ),
      MealStub("Tuna Pasta", Set(Tag.Pescatarian, Tag.Quick, Tag.LowEffort)),
      MealStub("Tuna steaks with salsa verde", Set(Tag.Pescatarian)),
      MealStub(
        "Vegetable Hot Pot",
        Set(Tag.Vegetarian, Tag.Slow, Tag.HighEffort, Tag.ColdWeather)
      ),
      MealStub(
        "Vegetable Sambar",
        Set(Tag.Vegetarian, Tag.Spicy, Tag.Scales),
        Online(
          "https://www.gousto.co.uk/cookbook/vegan-recipes/fragrant-vegetable-sambar-with-coconut-yoghurt"
        )
      ),
      MealStub(
        "Veggie Goulash",
        Set(
          Tag.Vegetarian,
          Tag.Slow,
          Tag.Spicy,
          Tag.Scales,
          Tag.BetterNextDay,
          Tag.ColdWeather
        ),
        Online(
          "https://www.gousto.co.uk/cookbook/recipes/veggie-goulash-potato-cakes-sour-cream"
        )
      ),
      MealStub(
        "Venetian Style Pasta",
        Set(Tag.Quick, Tag.Vegan, Tag.Scales, Tag.HotWeather, Tag.LowEffort),
        Online("https://www.bbcgoodfood.com/recipes/12135/venetianstyle-pasta")
      )
    )

  val mealStubsWithUsageData = mealStubs.map(meal => {
    val mealTimesEaten = UsageData.mealCount.getOrElse(meal.name, 0)
    val mealWithCount = mealTimesEaten match {
      case 0                   => meal.copy(tags = meal.tags + Tag.NeverEaten)
      case count if count <= 2 => meal.copy(tags = meal.tags + Tag.Infrequent)
      case count if count >= 5 =>
        meal.copy(tags = meal.tags + Tag.Popular)
      case _ => meal
    }

    val mealWithUsageData = mealWithCount.copy(lastEaten =
      UsageData.mealLastEaten.get(mealWithCount.name),
      timesEaten = Some(mealTimesEaten)
    )

    mealWithUsageData
  })

  private val duplicates =
    mealStubsWithUsageData.toList.map(_.name).groupBy(derp => derp).flatMap {
      case (key, occurrences) if occurrences.length > 1 => Some(key)
      case _                                            => None
    }

  if (duplicates.nonEmpty) {
    throw new Exception(s"Duplicate meal names: ${duplicates.mkString(", ")}")
  }
}
