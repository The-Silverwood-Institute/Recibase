package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object BakedSalmonOlivesSpaghetti
    extends Recipe(
      "Baked Salmon with Olives and Spaghetti",
      "salmon-olive-spaghetti",
      Some("Baked salmon served on a bed of spaghetti, onions and olives."),
      None,
      Some("Cover the baking tray in foil for easier cleaning later."),
      List(
        Ingredient(
          "Salmon fillets",
          Some("1 per person"),
          None,
          Some("Approximately 1 inch wide")
        ),
        Ingredient("Capers", None, Some("finely chopped")),
        Ingredient("Olive oil"),
        Ingredient("Onion", Some("1"), Some("sliced")),
        Ingredient("Pimento-stuffed olives"),
        Ingredient("Lemon juice"),
        Ingredient("Thyme", None, None, Some("Dried or fresh")),
        Ingredient("Spaghetti"),
        Ingredient("Cherry tomatoes", None, Some("halved"), Some("Optional"))
      ),
      List(
        "Preheat the oven at 200/220 C.",
        "Cook the spaghetti in a saucepan.",
        "Meanwhile, rub the salmon fillets with the olive oil, lemon juice and the chopped capers. Sprinkle with salt.",
        "Place in the oven and bake for approximately 4-6 minutes per half-inch of thickness or until cooked through.",
        "Drain the spaghetti and set aisde.",
        "In the same pan, heat a small amount of oil and cook the onions, leaving them softened but still crisp. Add the olives, tomatoes, thyme and lemon juice and warm.",
        "Add the spaghetti and toss. Keep warm.",
        "Serve the salmon fillets on top of the spaghetti mixture."
      )
    )
