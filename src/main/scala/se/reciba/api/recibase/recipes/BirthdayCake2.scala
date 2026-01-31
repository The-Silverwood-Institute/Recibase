package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock, Image}

case object BirthdayCake2 extends Recipe {
  override val name: String = "Birthday Cake"

  override val source: Option[String] = (
    "https://www.bbc.co.uk/games/embed/food-interactive-sponge-cake-calculator?units=metric&cakeType=layer_cake&tinShape=round&mode=tinSize&value=18cm&flavouring=lemon&icing=buttercream_fill_cover"
  ).some

  override val description: Option[String] = (
    "Madeira cake with buttercream icing and topped with Smarties"
  ).some

  override val notes: List[String] = List(
    "This is based on the BBC cake calculator for my 2 x 18cm round cake tins with the addition of Smarties and marzipan lettering.",
    "You always add too little icing to the middle of the cake and have a lot left over."
  )

  val tags = Set(Tag.Pudding, Tag.Baking)
  override val image: Option[Image] = (
    Image("https://i.reciba.se/birthday-cake.jpg")
  ).some

  val ingredientsBlocks: List[IngredientsBlock] = List(
    IngredientsBlock(
      "Cake",
      List(
        Ingredient("Unsalted Butter", "200g", "Softened"),
        Ingredient("Caster Sugar", "200g"),
        Ingredient("Eggs", "2 medium"),
        Ingredient("Lemon", "1/2", "zest only"),
        Ingredient("Milk", "2 tbsp"),
        Ingredient("Plain Flour", "186g"),
        Ingredient("Baking Powder", "3 tsp")
      )
    ),
    IngredientsBlock(
      "Topping",
      List(
        Ingredient("Unsalted butter", "150g", "softened"),
        Ingredient("Icing Sugar", "300g"),
        Ingredient("Vanilla Extract", "1 tsp"),
        Ingredient("Milk", "1 tbsp"),
        Ingredient("Smarties", "200g".some, None, "optional".some),
        Ingredient(
          "Cocoa powder",
          "4.5 tsp".some,
          None,
          "add if you want chocolate icing".some
        ),
        Ingredient(
          "Marzipan",
          None,
          None,
          "optional, if you want to decorate with lettering".some
        )
      )
    )
  )

  override val method: List[String] = List(
    "Preheat the oven to 180C/160C (Fan)/Gas 4.",
    "Using your butter's wrapping, grease 2 x 18cm round cake tins with butter. Line the bottom of the tins with a circle of baking paper.",
    "In a large bowl, cream together the butter and sugar using an electric mixer until the mixture is pale and fluffy.",
    "Beat in the eggs one at a time, mixing until the egg is completely incorporated into the batter before adding the next. Add a tablespoon of flour if the mixture curdles.",
    "Mix in the lemon zest.",
    "Fold in the flour and baking powder using a large metal spoon until no traces of flour are visible. Gently fold in the milk to loosen the mixture.",
    "Spoon the mixture into the prepared cake tins, spreading evenly with a spatula. Make a slight dip in the centre with the tip of the spatula if you don't want the cake to be domed in the middle.",
    "Bake for 25 minutes, or until the cakes spring back when the centre is pressed gently with a finger.",
    "Remove from the oven and take the cakes out of the tins after about 10 minutes. Place the cakes on a wire rack to cool completely.",
    "To make the buttercream icing, sift half the icing sugar into a bowl.",
    "Add the softened butter and (optional) cocoa powder then beat until light and fluffy.",
    "Beat in the remaining icing sugar then beat in the vanilla extract and the milk.",
    "Place one of the cakes upside down onto a cake board or stand. Using a palette knife or spatula, spread the icing onto the bottom layer of the cake, then place the second layer on top.",
    "Decorate with smarties and marzipan lettering, if desired."
  )
}
