package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import java.time.LocalDate

case object FrenchOnionPasta extends Recipe {
  val name = "French Onion Pasta"
  val createdAt = LocalDate.of(2026, 10, 26)

  override val description: Option[String] =
    "Rich one-pan pasta in the style of French onion soup: slow-caramelised onions, pancetta, chestnut mushrooms, beef broth and a grilled Gruyère top".some

  override val notes: List[String] = List(
    "Pancetta, Parmigiano Reggiano and Gruyère are all salty, so taste before using the rest of the salt.",
    "If the pan is not grill-safe, stir the Gruyère through off the heat instead."
  )

  override val source: Option[String] =
    "https://www.instagram.com/reel/DVY80PpgsRQ".some

  val tags = Set(Tag.AI, Tag.Stodge, Tag.ColdWeather, Tag.Slow, Tag.Scales)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Yellow onions", "3 large", "thinly sliced"),
    Ingredient("Butter", "2 tbsp"),
    Ingredient("Vegetable oil", "1 tbsp"),
    Ingredient("Pancetta", "225g", "diced"),
    Ingredient("Garlic", "2 cloves", "finely chopped"),
    Ingredient("White wine", "2 tbsp"),
    Ingredient("Salt", "1 tsp"),
    Ingredient("Thyme", "1/2 tsp", "dried"),
    Ingredient("Rosemary", "1/2 tsp", "fresh, finely chopped"),
    Ingredient(
      "Pasta",
      "225g - 280g".some,
      None,
      "Short shapes such as shells, rigatoni or orecchiette".some
    ),
    Ingredient("Beef broth", "750ml"),
    Ingredient("Double cream", "250ml"),
    Ingredient("Parmigiano Reggiano", "200g", "freshly grated"),
    Ingredient("Gruyère", "125g", "freshly grated")
  )

  val method = List(
    "Melt the butter with the vegetable oil in a large, deep, grill-safe pan over a medium heat. Add the onions and a pinch of the salt.",
    "Cook for 25-40 minutes, stirring every few minutes, until the onions are soft, deeply golden and jammy. If they start to catch, add a splash of water and scrape up the browned bits.",
    "Add the pancetta and cook for 5-7 minutes, stirring occasionally, until the fat has rendered and the edges are crisp.",
    "Stir in the garlic, thyme and rosemary and cook for about a minute, until fragrant.",
    "Pour in the white wine and scrape the base of the pan. Let it bubble until almost evaporated.",
    "Add the beef broth and bring to a simmer. Stir in the pasta and cook, stirring often, until it is al dente and most of the liquid has been absorbed. Add a splash of water if the pan dries out before the pasta is cooked.",
    "Stir in the cream and simmer for a minute, until the sauce is glossy. Take the pan off the heat and stir through the Parmigiano Reggiano until melted. Taste and add more of the salt if needed.",
    "Scatter the Gruyère over the top. Place under a hot grill for 2-4 minutes, until melted, bubbling and lightly browned. Rest for a couple of minutes, then serve."
  )
}
