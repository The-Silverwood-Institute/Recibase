package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object RussianMushroomJulienne extends
Recipe(
  "Russian Mushroom Julienne",
  "russian-mushroom-julienne",
  None,
  None,
  None,
  List(
    Ingredient("Mushrooms", Some("250g"), Some("thinly sliced")),
    Ingredient("Onion", None, Some("thinly sliced")),
    Ingredient("White wine"),
    Ingredient("Sour cream", Some("150ml")),
    Ingredient("Double cream", Some("120ml")),
    Ingredient("Mozzarella cheese", Some("240g"), Some("roughly chopped")),
    Ingredient("Butter")
  ),
  List(
    "Preheat the oven to 190\u00b0C.",
    "In a medium pan, melt the butter then saute the mushrooms and onions on a medium heat, until they've given off liquid.",
    "Transfer the mixture to a medium casserole dish.",
    "Using the same pan, melt a knob of butter and add a slosh of white wine.",
    "Simmer on a medium heat for a couple of minutes, then stir in the double cream and sour cream.",
    "Bring it to boil and pour over the mushrooms. Stir the mixture.",
    "Sprinkle generously with cheese and bake for about 10 minutes (until the cheese is melted and starts to golden)."
  )
)
