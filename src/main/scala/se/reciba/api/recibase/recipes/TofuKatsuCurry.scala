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

case object TofuKatsuCurry extends Recipe {
  val name = "Tofu Katsu Curry"

  override val permalink: Permalink = Permalink("tofu-katsu-curry")
  val tags = Set(Tag.AI)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Shallot", "1"),
    Ingredient("Fresh root ginger", "15g"),
    Ingredient("Baby leaf salad", "50g"),
    Ingredient("Mango chutney", "1 pot (20g)"),
    Ingredient("Curry powder", "1 tbsp"),
    Ingredient("Basmati rice", "130g"),
    Ingredient("Red wine vinegar", "1 sachet (15ml)"),
    Ingredient("Soy sauce", "1 sachet (30ml)"),
    Ingredient("Plain tofu", "280g"),
    Ingredient("Free-from mayonnaise", "45g"),
    Ingredient("Panko breadcrumbs", "60g"),
    Ingredient("Carrot", "1"),
    Ingredient("Flour"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt"),
    Ingredient("Sugar"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Drain and pat the tofu dry with kitchen paper and slice it lengthways into 4 strips.",
    "Add the mayo and panko breadcrumbs to separate plates.",
    "Toss the tofu strips in the mayo until lightly coated, then press them into the breadcrumbs firmly to evenly coat all over — this is your breaded tofu.",
    "Add the breaded tofu to a baking tray lined with non-stick baking paper.",
    "Drizzle generously with vegetable oil and put the tray in the oven for 20-25 minutes or until golden and crispy — this is your tofu katsu.",
    "Add the basmati rice and 300ml cold water to a pot with a lid and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to low and cook, covered, for 10-12 minutes or until all the water has absorbed and the rice is cooked.",
    "Remove from the heat and stir vigorously to release the starch — this is your sticky rice.",
    "Keep covered until serving.",
    "Meanwhile, boil half a kettle.",
    "Peel (scrape the skin off with a teaspoon) and finely chop (or grate) the ginger.",
    "Peel the shallot and finely slice into rings.",
    "Top, tail, peel and grate the carrot.",
    "Combine the red wine vinegar with 1 tbsp boiled water — this is your pickling liquid.",
    "Add the pickling liquid to a bowl with the shallot rings, a pinch of salt and a pinch of sugar then set aside until later — these are your quick-pickled shallots.",
    "Heat a large, wide-based pan (preferably non-stick) with 2 tbsp vegetable oil over a medium heat.",
    "Once hot, add the chopped ginger and cook for 3 minutes or until fragrant.",
    "Add the curry powder and 2 tbsp flour and cook for 1 minute.",
    "Gradually whisk in 300ml boiled water and cook for 5-6 minutes or until thickened.",
    "Once your sauce has thickened, stir in the soy sauce and mango chutney — this is your katsu sauce.",
    "Meanwhile, drain the quick-pickled shallots, reserving 1 tbsp of the pickling liquid.",
    "Wash and dry the baby leaf salad, then combine it in a bowl along with the pickled shallots, reserved pickling liquid, grated carrot and a drizzle of olive oil and a generous pinch of salt and pepper — this is your dressed salad.",
    "Serve the tofu katsu over the katsu sauce with the sticky rice and dressed salad to the side."
  )
}
