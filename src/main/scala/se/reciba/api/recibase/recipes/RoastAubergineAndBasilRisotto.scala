package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{
  Ingredient,
  Permalink,
  Recipe,
  Tag,
  IngredientsBlock
}
import se.reciba.api.utils.IntUtils.TemperatureUtils

case object RoastAubergineAndBasilRisotto extends Recipe {
  val name = "Roast Aubergine & Basil Risotto"

  override val permalink: Permalink = Permalink(
    "roast-aubergine-and-basil-risotto"
  )
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1"),
    Ingredient("Aubergine", "1"),
    Ingredient("Baby plum tomatoes", "125g"),
    Ingredient("Rocket", "50g"),
    Ingredient("Dried basil", "1 tsp"),
    Ingredient("Knorr vegetable stock cube", "1"),
    Ingredient("Balsamic vinegar", "1 sachet (15ml)"),
    Ingredient("Grated Italian hard cheese", "35g"),
    Ingredient("Chinese rice wine", "1 sachet (30ml)"),
    Ingredient("Tomato paste", "1 sachet (32g)"),
    Ingredient("Arborio rice", "150g"),
    Ingredient("Garlic", "1 clove"),
    Ingredient("Dried chilli flakes", "1/2 tsp"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Boil a kettle.",
    "Peel and chop the brown onion.",
    "Heat a large, wide-based pan (preferably non-stick) with a drizzle of olive oil over a medium heat.",
    "Once hot, add the chopped onion with a pinch of salt and cook for 3-4 minutes or until softened.",
    "Meanwhile, peel and finely chop (or grate) the garlic.",
    "Dissolve the Knorr vegetable stock cube in 900ml boiled water and stir in the dried basil and tomato paste — this is your tomato stock.",
    "Once the onion has softened, add the arborio rice to the pan with the chopped garlic and half the chilli flakes (can't handle the heat? Go easy!) and cook for 30 seconds.",
    "Add the Chinese rice wine and cook for a further 30 seconds.",
    "Add the tomato stock a ladle at a time, stirring continuously, for 30-35 minutes or until all of the stock is absorbed and the rice is cooked.",
    "Whilst the rice is cooking, trim the green stalks off the aubergine and cut into quarters, lengthways, then slice finely.",
    "Add the sliced aubergine to a baking tray (or two!) with a very generous drizzle of olive oil and a generous pinch of salt.",
    "Give everything a good mix up and put the tray in the oven for 20 minutes, turning once halfway, until golden and tender.",
    "Whilst everything is cooking, chop the baby plum tomatoes in half.",
    "Add the chopped tomatoes to a large bowl with the rocket, balsamic vinegar with 2 tbsp olive oil and a generous pinch of salt and pepper — this is your balsamic dressing.",
    "Once the aubergine is golden and tender, push it together in the centre of the baking tray.",
    "Chop the basil finely, including the stalks.",
    "Sprinkle over half the grated Italian hard cheese.",
    "Return the tray to the oven for 5 minutes or until the cheese has melted.",
    "Once the risotto is cooked, stir in the remaining grated cheese and the roasted aubergine.",
    "Serve the risotto with the balsamic dressed rocket and tomatoes on the side."
  )
}
