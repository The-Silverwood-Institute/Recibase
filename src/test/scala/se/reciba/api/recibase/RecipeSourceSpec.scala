package se.reciba.api

import se.reciba.api.model.Tag
import se.reciba.api.recipes.{ChilliConCarne, CrunchChocolateChipCoffeeCake}
import se.reciba.api.submit.{
  ConflictingSubmission,
  IngredientSubmission,
  InvalidSubmission,
  RecipeSource,
  RecipeSubmission
}

import java.time.LocalDate

class RecipeSourceSpec extends org.specs2.mutable.Specification {
  private val today = LocalDate.of(2026, 9, 7)

  "generate" >> {
    "writes one case object with an explicit permalink" >> {
      val generated = RecipeSource.generate(sample, today, Seq.empty)
      generated must beRight.like { case recipe =>
        recipe.objectName must beEqualTo("ChilliConCarne")
        recipe.permalink must beEqualTo("chilli-con-carne")
        recipe.branch must beEqualTo("recipe/chilli-con-carne")
        recipe.path must beEqualTo(
          "src/main/scala/se/reciba/api/recibase/recipes/ChilliConCarne.scala"
        )
        recipe.source must beEqualTo(expectedSample)
      }
    }

    "keeps stop words that Permalink.fromRawString would drop" >> {
      val generated =
        RecipeSource.generate(named("Toad in the Hole"), today, Seq.empty)
      generated must beRight.like { case recipe =>
        recipe.objectName must beEqualTo("ToadInTheHole")
        recipe.permalink must beEqualTo("toad-in-the-hole")
      }
    }

    "strips accents when naming the file" >> {
      val generated =
        RecipeSource.generate(named("Crème Brûlée"), today, Seq.empty)
      generated must beRight.like { case recipe =>
        recipe.objectName must beEqualTo("CremeBrulee")
        recipe.permalink must beEqualTo("creme-brulee")
      }
    }

    "omits empty optional fields" >> {
      val generated =
        RecipeSource.generate(named("Phone Test Soup"), today, Seq.empty)
      generated must beRight.like { case recipe =>
        recipe.source must beEqualTo(expectedPlain)
        recipe.source must not contain "s\""
        recipe.source must not contain ".celsius"
      }
    }

    "keeps newlines in a description" >> {
      val submission = named("Phone Test Soup").copy(
        description = Some("A weeknight soup.\nBetter the next day.")
      )
      val generated = RecipeSource.generate(submission, today, Seq.empty)
      generated must beRight.like { case recipe =>
        recipe.source must contain(
          """override val description: Option[String] = "A weeknight soup.\nBetter the next day.".some"""
        )
      }
    }

    "stores temperature text as a plain string" >> {
      val submission = named("Phone Test Soup").copy(
        method = List("Preheat to ${180.celsius}.")
      )
      val generated = RecipeSource.generate(submission, today, Seq.empty)
      generated must beRight.like { case recipe =>
        recipe.source must contain("${180.celsius}.")
        recipe.source must not contain "s\""
      }
    }

    "rejects a name that cannot be a Scala identifier" >> {
      val generated = RecipeSource.generate(named("2 eggs"), today, Seq.empty)
      generated must beLeft(
        InvalidSubmission(
          "Recipe name cannot be turned into a Scala file name"
        )
      )
    }

    "rejects names that would shadow the generated file" >> {
      val generated = RecipeSource.generate(named("Set"), today, Seq.empty)
      generated must beLeft(
        InvalidSubmission(
          "Recipe name cannot be turned into a Scala file name"
        )
      )
    }

    "rejects automatic tags" >> {
      val generated = RecipeSource.generate(
        named("Phone Test Soup").copy(tags = List("New")),
        today,
        Seq.empty
      )
      generated must beLeft(
        InvalidSubmission("Tag New is assigned automatically")
      )
    }

    "rejects tag display names" >> {
      val generated = RecipeSource.generate(
        named("Phone Test Soup").copy(tags = List("Vegetarian-ish")),
        today,
        Seq.empty
      )
      generated must beLeft(InvalidSubmission("Unknown tag: Vegetarian-ish"))
    }

    "rejects a duplicate name" >> {
      val generated =
        RecipeSource.generate(sample, today, Seq(ChilliConCarne))
      generated must beLeft(
        ConflictingSubmission("A recipe named Chilli con Carne already exists")
      )
    }

    "rejects a permalink already used by another recipe" >> {
      val generated = RecipeSource.generate(
        named("Coffee Cake"),
        today,
        Seq(CrunchChocolateChipCoffeeCake)
      )
      generated must beLeft(
        ConflictingSubmission(
          "A recipe with permalink coffee-cake already exists"
        )
      )
    }

    "rejects an object name that already has a file" >> {
      val generated = RecipeSource.generate(
        named("Crunch Chocolate Chip Coffee Cake!"),
        today,
        Seq(CrunchChocolateChipCoffeeCake)
      )
      generated must beLeft(
        ConflictingSubmission(
          "A recipe file named CrunchChocolateChipCoffeeCake.scala already exists"
        )
      )
    }
  }

  "tag object names" >> {
    "match the identifiers the generator emits" >> {
      Tag.VeganIsh.getClass.getSimpleName.stripSuffix("$") must beEqualTo(
        "VeganIsh"
      )
      Tag.New.getClass.getSimpleName.stripSuffix("$") must beEqualTo("New")
    }
  }

  private def named(name: String): RecipeSubmission =
    RecipeSubmission(
      name = name,
      source = None,
      description = None,
      notes = Nil,
      tags = Nil,
      ingredients = List(IngredientSubmission("Onion", Some("1"), None, None)),
      method = List("Simmer.")
    )

  private val sample = RecipeSubmission(
    name = "Chilli con Carne",
    source = Some("Kit's Dad"),
    description = Some("A weeknight chilli."),
    notes = List("Better the next day."),
    tags = List("VegetarianIsh", "Spicy", "Spicy"),
    ingredients = List(
      IngredientSubmission("Mince", Some("500g"), None, None),
      IngredientSubmission("Honey", Some("1 tbsp"), None, Some("Optional")),
      IngredientSubmission("Oil", None, None, None),
      IngredientSubmission("Garlic", Some("2"), Some("crushed"), Some("Fresh")),
      IngredientSubmission(" ", None, None, None)
    ),
    method = List("Brown the mince.")
  )

  private val expectedSample =
    """package se.reciba.api.recipes
      |
      |import cats.syntax.option._
      |import se.reciba.api.model.{Ingredient, IngredientsBlock, Permalink, Recipe, Tag}
      |import java.time.LocalDate
      |
      |case object ChilliConCarne extends Recipe {
      |  val name = "Chilli con Carne"
      |  val createdAt = LocalDate.of(2026, 9, 7)
      |  override val permalink: Permalink = Permalink("chilli-con-carne")
      |
      |  override val source: Option[String] = "Kit's Dad".some
      |  override val description: Option[String] = "A weeknight chilli.".some
      |  override val notes: List[String] = List(
      |    "Better the next day."
      |  )
      |
      |  val tags = Set(Tag.VegetarianIsh, Tag.Spicy)
      |
      |  val ingredientsBlocks = IngredientsBlock.simple(
      |    Ingredient("Mince", "500g"),
      |    Ingredient("Honey", "1 tbsp".some, None, "Optional".some),
      |    Ingredient("Oil"),
      |    Ingredient("Garlic", "2", "crushed", "Fresh")
      |  )
      |
      |  val method = List(
      |    "Brown the mince."
      |  )
      |}
      |""".stripMargin

  private val expectedPlain =
    """package se.reciba.api.recipes
      |
      |import se.reciba.api.model.{Ingredient, IngredientsBlock, Permalink, Recipe, Tag}
      |import java.time.LocalDate
      |
      |case object PhoneTestSoup extends Recipe {
      |  val name = "Phone Test Soup"
      |  val createdAt = LocalDate.of(2026, 9, 7)
      |  override val permalink: Permalink = Permalink("phone-test-soup")
      |
      |  val tags = Set.empty[Tag]
      |
      |  val ingredientsBlocks = IngredientsBlock.simple(
      |    Ingredient("Onion", "1")
      |  )
      |
      |  val method = List(
      |    "Simmer."
      |  )
      |}
      |""".stripMargin
}
