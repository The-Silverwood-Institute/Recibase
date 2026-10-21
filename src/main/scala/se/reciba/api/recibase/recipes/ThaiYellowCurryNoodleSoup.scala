package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  IngredientsBlock,
  Permalink,
  Recipe,
  Tag
}
import java.time.LocalDate

case object ThaiYellowCurryNoodleSoup extends Recipe {
  val name = "Thai Yellow curry noodle soup"
  val createdAt = LocalDate.of(2026, 10, 20)
  override val permalink: Permalink = Permalink("thai-yellow-curry-noodle-soup")

  override val source: Option[String] = "Stasis/Bel".some
  override val description: Option[String] =
    "Rich, creamy, takes some time, but damn delicious. Makes a lot of portions; serve with any noodles (preferably rice noodles) Can be made vegan easily just with some mindfulness. Same with Gluten-free.".some
  override val notes: List[String] = List(
    "Gwen rating: 7.5. Lasts in the fridge for about a week."
  )

  val tags = Set(
    Tag.Soup,
    Tag.VeganIsh,
    Tag.GlutenFree,
    Tag.ColdWeather,
    Tag.Spicy,
    Tag.Slow
  )

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient(
      "Yellow Curry paste",
      "4 TBSP".some,
      None,
      "Please don't use sharwoods. Vegan/Veggie/Veggie-ish depending on choice here. Some contain shrimp depending on brand.".some
    ),
    Ingredient(
      "Tofu, extra firm/pre-fried",
      "A portion per person (50-80g) or 4-5 cubes per person of fried tofu",
      "Cut into spoon sized chunks"
    ),
    Ingredient(
      "Onions White preffered, otherwise brown.",
      "2 large, 3-4 small",
      "Chopped fine"
    ),
    Ingredient(
      "Fresh coriander",
      "50 grams of stemmed plant",
      "Chopped fine stems removed"
    ),
    Ingredient("Lime juice", "1 lime", "juiced"),
    Ingredient("Garlic powder", "2 TBSP"),
    Ingredient("Coriander seeds", "1 TBSP".some, None, "Optional".some),
    Ingredient(
      "vegetable stock cubes",
      "2",
      "Diluted in 250ml of hot water",
      "Use Gluten free stock pots for gluten free option."
    ),
    Ingredient("coconut milk + fat", "1.5lt"),
    Ingredient("MSG", "To taste"),
    Ingredient(
      "Fresh ginger",
      "1 small knob (25-50g)",
      "peeled, crushed/Chopped finely"
    ),
    Ingredient("Sweet potato", "1 large sweet potato"),
    Ingredient(
      "Fish sauce",
      "2-3 shakes".some,
      None,
      "Replace with Vegan Fish sauce if wish for vegan.".some
    ),
    Ingredient("Black pepper", "2 tbsp"),
    Ingredient("Lemon", "To taste", "Sliced to serve on the side"),
    Ingredient(
      "Cauliflower",
      "1 head",
      "chopped into small florets",
      "Frozen is fine too. just use 2 handfuls."
    ),
    Ingredient("Coconut oil or any other medium temp cooking oil", "1 tbsp"),
    Ingredient("Rice Noodles", "1 portion per person"),
    Ingredient(
      "Spring onion",
      None,
      "Just whites, chopped fine".some,
      "Optional (to serve)".some
    ),
    Ingredient("Crispy onions", None, None, "Optional (to serve)".some),
    Ingredient(
      "Chilli (fresh)",
      None,
      "Chopped into thin slithers after being deseeded".some,
      "Optional (to serve)".some
    )
  )

  val method = List(
    "Add your diced onions, coconut oil, and ginger to the pan, and cook on medium-high heat until the onions are translucent and soft. Then add the Vegetable stock cubes (dissolved in water) and the curry paste. Blend using an immersion blender off the heat until thick and no large chunks remain.",
    "Add the paste back to your pan, and turn the heat down to medium. While stirring, add in your coconut milk. Once it returns to temperature, add your spices and herbs, cauliflower, tofu (if using firm tofu), and Sweet potato. It should simmer gently; if it starts to boil, turn the heat down and stir to keep it from sticking. Simmer until reduced, and your potato is easily pierced with a fork (45-60 minutes). The texture should be thick and coat the back of a cold spoon easily. If using fried tofu, add that now.",
    "Cook your noodles according to package instructions, then add 1 or 2 ladles of the starchy water to the soup to loosen it and add gloss. Serve over the noodles. Add optional extras."
  )
}
