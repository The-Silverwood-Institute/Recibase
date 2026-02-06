package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}

case object GoanStyleBasa extends Recipe {
  val name = "Goan-style Basa"

  override val permalink: Permalink = Permalink("goan-style-basa")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Red onion", "1"),
    Ingredient("Red chilli", "1"),
    Ingredient("Garlic clove", "1"),
    Ingredient("Ground turmeric", "1 tsp"),
    Ingredient("Baby leaf spinach", "50g"),
    Ingredient("Basa fillets", "2 x 120g"),
    Ingredient("Tomato paste", "16g"),
    Ingredient("Solid creamed coconut", "50g"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Vegetable stock mix", "5.5g"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    "Boil half a kettle.",
    "Peel and finely dice the red onion.",
    "Peel (scrape the skin off with a teaspoon) and grate (or finely chop) the ginger.",
    "Peel and grate (or finely chop) the garlic.",
    "Cut the red chilli in half lengthways, deseed (scrape the seeds out with a teaspoon) and chop finely.",
    "Heat a large, wide-based pan (preferably non-stick, with a matching lid) with a drizzle of vegetable oil over a medium heat.",
    "Once hot, add the diced onion and cook for 3-4 minutes or until starting to soften.",
    "Once softened, add the grated ginger and grated garlic to the pan and cook for 1 minute or until fragrant.",
    "Add the basmati rice, a pinch of salt and 300ml cold water to a pot with a lid and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to very low and cook, covered, for 12-15 minutes or until all the water has absorbed and the rice is cooked.",
    "Once cooked, remove from the heat and keep covered until serving.",
    "While the rice is cooking, chop the creamed coconut roughly (if required!).",
    "Dissolve the chopped creamed coconut and vegetable stock mix in 300ml boiled water — this is your coconut stock.",
    "Add the tomato paste, ground turmeric and chopped chilli to the pan and cook for 1 minute further or until fragrant.",
    "Add the coconut stock and bring to the boil.",
    "Once boiling, add the basa fillets and cook for 4-5 minutes or until the fish is cooked through.",
    "Add the baby leaf spinach and cook for 1-2 minutes further or until wilted — this is your Goan-style basa curry.",
    "Serve the Goan-style basa curry over the basmati rice."
  )
}
