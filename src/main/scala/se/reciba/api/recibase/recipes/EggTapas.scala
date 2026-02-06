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

case object EggTapas extends Recipe {
  val name = "Egg Tapas"

  override val permalink: Permalink = Permalink("egg-tapas")

  val tags = Set(Tag.Vegetarian, Tag.Spicy)

  override val source: Option[String] = "Gousto".some

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Brown onion", "1", "thinly sliced"),
    Ingredient("Eggs", "2"),
    Ingredient("Red pepper", "1", "thinly sliced"),
    Ingredient("Garlic clove", "1", "finely chopped"),
    Ingredient("Spring onion", "1"),
    Ingredient("Coriander", "10g"),
    Ingredient("Stock Cube", "1"),
    Ingredient("Mayonnaise", "4 tbsp"),
    Ingredient("Chipotle paste", "5 tsp"),
    Ingredient("White potatoes", "4", "cut into bite-sized pieces"),
    Ingredient("Cayenne pepper", "1/2 tsp"),
    Ingredient("Cannellini beans", "1 tin (400g)", "drained and rinsed"),
    Ingredient("Olive oil"),
    Ingredient("Pepper"),
    Ingredient("Salt"),
    Ingredient("Sugar")
  )

  val method = List(
    s"Preheat the oven to ${220.simpleFanInstruction}.",
    "Add the potatoes to a baking tray, drizzle with olive oil, season with cayenne pepper, salt and pepper.",
    "Put the tray in the oven for 25-30 min or until golden and crisp.",
    "Heat a wide frying pan with a drizzle of olive oil over a medium-high heat.",
    "Add the sliced pepper and onion with a pinch of both salt and sugar. Cook for 7-9 min or until they've softened.",
    "Once softened, add the chopped garlic and cook for a further 1 min.",
    "Make 200ml of vegetable stock then stir in half of the chipotle paste.",
    "Add the stock and beans to the softened pepper and onion and cook for 10-15 min over a low heat or until reduced to a thick stew.",
    "Trim, then slice the spring onion finely. Chop the coriander finely, including the stalks.",
    "Combine the mayonnaise with the chopped spring onion, remaining chipotle paste, a drizzle of olive oil and half of the chopped coriander. Season with a pinch of both salt and pepper and set aside.",
    "Once your potatoes are almost cooked: Heat another pan with a matching lid (large enough to fit 2 eggs) with 1 tbsp olive oil over a medium-low heat.",
    "Crack the eggs into a bowl, and once the pan is hot, add the eggs in one go. Cover with a lid and cook for 2-3 min or until done to your liking, then remove from the heat and season with salt and pepper.",
    "Stir the remaining chopped coriander through the pepper and bean stew.",
    "Serve the eggs over the stew with the crispy potatoes and smoky mayo to the side."
  )
}
