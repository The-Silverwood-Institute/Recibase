package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object EasySoup
    extends Recipe(
      "Easy Soup",
      "easy-soup",
      None,
      None,
      None,
      List(
        Ingredient("Butter", Some("Knob")),
        Ingredient("Onion", Some("1")),
        Ingredient("Red Pepper", Some("1")),
        Ingredient("Apple", Some("1")),
        Ingredient("Carrot", Some("1")),
        Ingredient("Water", Some("600ml")),
        Ingredient("Stock Cube"),
        Ingredient("Mixed Herbs"),
        Ingredient("Extra vegetables", None, None, Some("Optional"))
      ),
      List(
        "Chop up everything and place everything but the onions in a bowl.",
        "Boil the water and add the stock cube and stir it in.",
        "Melt the butter then add the onions and soften then under a low heat for a minute or so.",
        "Add all the vegetables then the water and herbs.",
        "Turn up the heat and boil for a minute then turn down the heat and simmer it for 30 minutes. Wait until cool and blend."
      )
    )
