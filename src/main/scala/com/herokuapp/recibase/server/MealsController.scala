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

trait MealsController[F[_]] {
  def meals: F[Set[MealStub]]
  def mealNames: F[String]
}

object MealsController {
  def impl[F[_]: Applicative]: MealsController[F] =
    new MealsController[F] {
      override def meals: F[Set[MealStub]] = mealStubs.pure[F]
      override def mealNames: F[String] =
        mealStubs
          .filter(_.isDinner)
          .map(_.name)
          .toSeq
          .sorted
          .mkString("\n")
          .pure[F]
    }

  val mealStubs: Set[MealStub] =
    Recipe.recipes.map(MealStub.apply).toSet ++ Set(
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
        "Broccoli and Stilton soup",
        Set(
          Tag.Vegetarian,
          Tag.Soup,
          Tag.Scales,
          Tag.Freezes,
          Tag.BetterNextDay,
          Tag.Slow,
          Tag.ColdWeather,
          Tag.LowEffort
        )
      ),
      MealStub("Butternut squash risotto", Set(Tag.Vegan, Tag.HotWeather)),
      MealStub("Carbonara", Set(Tag.VegetarianIsh, Tag.Quick, Tag.Scales)),
      MealStub(
        "Carrot & Coriander Burgers",
        Set(Tag.Vegetarian, Tag.Slow, Tag.HighEffort)
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
      MealStub(
        "Cod with Lentils",
        Set(Tag.Quick, Tag.Pescatarian, Tag.LowEffort)
      ),
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
        "Goan-Style King Prawn Balchão Curry With Basmati Rice",
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
        "Mediterranean Vegetable Gnocchi",
        Set(Tag.Vegetarian, Tag.Scales, Tag.Quick),
        Online(
          "https://www.gousto.co.uk/cookbook/vegetarian-recipes/mediterranean-veg-gnocchi-with-basil"
        )
      ),
      MealStub(
        "Mexican Polenta Pie",
        Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)
      ),
      MealStub(
        "Mild Paneer Curry",
        Set(Tag.Vegetarian),
        Online("https://www.gousto.co.uk/cookbook/recipes/mild-paneer-curry")
      ),
      MealStub(
        "Mozzarella and spinach pancakes",
        Set(Tag.HighEffort, Tag.Vegetarian)
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
        )
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
        "Quesadillas",
        Set(Tag.Quick, Tag.Vegetarian, Tag.Spicy, Tag.LowEffort),
        Online(
          "https://www.hellofresh.co.uk/recipes/cheesy-chipotle-bean-quesadillas-5feb6402f4480c042d622a2d"
        )
      ),
      MealStub(
        "Ricotta spinach pitas",
        Set(Tag.Quick, Tag.Vegetarian, Tag.HotWeather, Tag.LowEffort)
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
      MealStub("Roasted Vegetable Tart", Set(Tag.Vegetarian, Tag.HotWeather)),
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
        "Spanakopita (Spinach/feta pastry)",
        Set(Tag.Vegetarian, Tag.Slow),
        GoogleDrive("1aiAdl0JqdR6rU0Y-vJgsLre6IbJGhG8iCyD7HzP5Cvc")
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
        )
      ),
      MealStub("Tofu Katsu Curry", Set(Tag.Vegan)),
      MealStub(
        "Tofu and cashew nut stir fry",
        Set(Tag.Vegan, Tag.Quick, Tag.HotWeather)
      ),
      MealStub(
        "Tomato & Mozzarella Salad",
        Set(Tag.Vegetarian, Tag.Quick, Tag.HotWeather, Tag.LowEffort)
      ),
      MealStub(
        "Tomato sauce",
        Set(Tag.Freezes, Tag.Scales, Tag.Slow, Tag.BetterNextDay, Tag.LowEffort)
      ),
      MealStub("Tuna and rice peppers", Set(Tag.Pescatarian, Tag.Slow)),
      MealStub("Tuna in tomato sauce", Set(Tag.Pescatarian)),
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
}
