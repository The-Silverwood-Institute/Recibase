package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object LebaneseSpicedRiceAndCrispyFish extends Recipe {
  val name = "Lebanese Spiced Rice & Crispy Fish"

  override val permalink: Permalink = Permalink(
    "lebanese-spiced-rice-and-crispy-fish"
  )
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Lime", "1"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Ras el hanout", "1 tbsp"),
    Ingredient("Baby leaf spinach", "120g"),
    Ingredient("Tahini", "1 sachet (15g)"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Vegetable stock mix", "1 sachet (11g)"),
    Ingredient("Bag of sultanas", "1 (30g)"),
    Ingredient("Cornflour", "2 tbsp"),
    Ingredient("Basa fillets", "2 x 100g"),
    Ingredient("Ground turmeric", "1/2 tsp"),
    Ingredient("Spring onions", "2"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt"),
    Ingredient("Butter")
  )

  val method = List(
    "Boil a kettle.",
    "Peel and finely dice the brown onion.",
    "Peel (scrape the skin off with a teaspoon) and finely chop (or grate) the ginger.",
    "Peel and finely chop (or grate) the garlic.",
    "Heat a large, wide-based pan (preferably non-stick with a matching lid) with a knob of butter over a medium heat.",
    "Once hot, add the diced onion, chopped ginger and chopped garlic and cook for 4-5 minutes or until starting to soften.",
    "Once softened, add the ras el hanout and cook for a further 1-2 minutes or until fragrant.",
    "Meanwhile, dissolve the veg stock mix in 400ml boiled water.",
    "Roughly chop the sultanas.",
    "Add the basmati rice, chopped sultanas, veg stock, a pinch of salt and pepper and the juice of 1/2 lime to the pan.",
    "Give everything a good mix up and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to low and cook, covered, for 12-15 minutes or until all the liquid has dissolved and the rice is cooked.",
    "While the rice is cooking, pat the basa fillets dry with kitchen paper and cut into bite-sized pieces.",
    "Add the chopped basa to a large bowl with the cornflour, turmeric and a pinch of salt and pepper and give everything a good mix up until the fish is evenly coated.",
    "Once the rice has had 10 minutes, heat a separate, large wide-based pan (preferably non-stick) with a drizzle of olive oil over a high heat.",
    "Once hot, add the coated basa and cook for 3-4 minutes or until golden and crispy.",
    "Meanwhile, trim, then slice the spring onions finely.",
    "Once the rice is cooked, stir in the baby leaf spinach and tahini.",
    "Serve the crispy basa over the Lebanese spiced rice and garnish with the sliced spring onions."
  )
}
