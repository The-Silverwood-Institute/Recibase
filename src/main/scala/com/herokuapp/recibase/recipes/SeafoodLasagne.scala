package com.herokuapp.recibase.recipes

import com.herokuapp.recibase.{Ingredient, Recipe}

object SeafoodLasagne {
  val recipe = Recipe(
    "Seafood Lasagne",
    "seafood-lasagne",
    None,
    None,
    None,
    None,
    List(
      Ingredient("Semi-skimmed milk", "1L"),
      Ingredient(
        "Mixed seafood",
        Some("400g"),
        None,
        Some("you can buy a pie mix or pick and mix your own")
      ),
      Ingredient("Garlic clove", "1"),
      Ingredient("Plain flour", "50g"),
      Ingredient("English mustard", "1 tsp"),
      Ingredient("Fresh lasagne sheets", "400g"),
      Ingredient("Tarragon", "2 tbsp"),
      Ingredient("Baby spinach", "large handful"),
      Ingredient("Cheddar", Some("150g"), Some("Grated")),
      Ingredient("Parmesan", Some("75g"), Some("Grated")),
      Ingredient("Butter")
    ),
    List(
      "Preheat the oven to 180C",
      "Melt a large knob of butter in a saucepan with a low heat.",
      "Add garlic and pepper then cook for a short while.",
      "Sift in flour while stirring then cook for 2-3 minutes.",
      "Slowly add milk over a medium heat.",
      "Turn down the heat then add mustard and tarragon.",
      "Place a spoonful or two of the sauce into a greased ovenproof dish to just cover the bottom. Cover with a couple of lasagne sheets.",
      "Stir the fish, seafood and spinach to the remaining sauce and stir until well combined.",
      "Spoon some of the fish sauce mixture onto the lasagne sheets and top with another layer of lasagne sheets. Repeat this layering of fish sauce mixture and lasagne until all of the sauce and pasta have been used up. The final layer should be lasagne sheets.",
      "Sprinkle the top with cheddar cheese and parmesan, then transfer to the oven to bake for 40 minutes, or until the fish is cooked and the topping is golden-brown.",
      "Serve at the table in its dish with a bowl of green salad and some garlic bread."
    )
  )
}
