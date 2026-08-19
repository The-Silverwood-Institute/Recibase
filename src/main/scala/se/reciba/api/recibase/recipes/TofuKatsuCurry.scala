package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate

case object TofuKatsuCurry extends Recipe {
  val name = "Tofu Katsu Curry"
  val createdAt = LocalDate.of(2020, 4, 24)

  val tags = Set(Tag.Vegan, Tag.Quick, Tag.Scales)

  override val source: Option[String] = "Gousto".some

  override val description: Option[String] =
    "Crispy breaded tofu with homemade katsu curry sauce, sticky rice and roasted Tenderstem broccoli.".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Plain tofu", "280g"),
    Ingredient("White long grain rice", "130g"),
    Ingredient("Tenderstem broccoli", "160g"),
    Ingredient("Panko breadcrumbs", "40g"),
    Ingredient("Vegan mayonnaise", "25ml"),
    Ingredient(
      "Fresh root ginger",
      "15g",
      "peeled and finely chopped or grated"
    ),
    Ingredient("Curry powder", "1 tbsp"),
    Ingredient("Plain flour", "2 tbsp"),
    Ingredient("Soy sauce", "15ml"),
    Ingredient("Mango chutney", "20g"),
    Ingredient("Salt"),
    Ingredient("Vegetable oil")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Drain the tofu, pat it dry with kitchen paper and slice it lengthways into strips.",
    "Add the mayonnaise and panko breadcrumbs to separate plates and season the breadcrumbs with a pinch of salt.",
    "Toss the tofu strips in the mayonnaise until lightly coated, then press them into the breadcrumbs firmly to evenly coat.",
    "Add the breaded tofu to a baking tray lined with non-stick baking paper.",
    "Drizzle generously with vegetable oil and bake for 10 min.",
    "Add the Tenderstem broccoli to the tray, drizzle with oil and return to the oven for 10-15 min or until the tofu is golden and crispy and the broccoli is tender.",
    "Add the rice to a pot with a lid with 225ml cold water and bring to the boil over a high heat.",
    "Once boiling, reduce the heat to very low and cook, covered, for 12-15 min or until all the water has absorbed and the rice is cooked.",
    "Once done, stir vigorously to release the starch, then remove from the heat and set aside (lid on) to steam until serving.",
    "Meanwhile, boil a kettle.",
    "Heat a large, wide-based pan (preferably non-stick) with 2 tbsp vegetable oil over a medium heat.",
    "Once hot, add the chopped ginger and cook for 3 min or until fragrant.",
    "Add the curry powder and flour and cook for 1 min.",
    "Gradually whisk in 300ml boiled water and cook for 5-6 min or until thickened.",
    "Once the sauce has thickened, stir in the soy sauce and mango chutney.",
    "Serve the tofu katsu over the katsu sauce with the sticky rice and roasted Tenderstem broccoli."
  )
}
