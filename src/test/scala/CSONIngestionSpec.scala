import java.io.File

import Extractor.ingestRecipe
import org.specs2._
import spray.json.DeserializationException

class CSONIngestionSpec extends mutable.Specification {
  "CSON to Recipe object ingestion specification where" >> {
    "a valid Recipe" >> {
      "must have a name" >> {
        Fixtures.recipe.name must_== "Lentil Lasagne"
      }

      "must have a URL" >> {
        Fixtures.recipe.url must_== "lentil-lasagne"
      }

      "can have a description" >> {
        Fixtures.recipe.description must beSome("A lasagne made with lentils.")
      }

      "need not have a description" >> {
        Fixtures.noOptionalsRecipe.description must beNone
      }

      "can have a tagline" >> {
        Fixtures.recipe.tagline must beSome("Does two days!")
      }

      "can have notes" >> {
        Fixtures.recipe.notes must beSome("Consider serving with cherry tomatoes.")
      }

      "need not have notes" >> {
        Fixtures.noOptionalsRecipe.notes must beNone
      }

      "must have an ingredient" >> {
        "with a name" >> {
          Fixtures.recipe.ingredients must contain(
            Ingredient(
              name = "Pepper"
            )
          )
        }

        "with a quantity" >> {
          Fixtures.recipe.ingredients must contain(
            Ingredient(
              name = "Onions",
              quantity = Some("5")
            )
          )
        }

        "with preparation instructions" >> {
          Fixtures.recipe.ingredients must contain(
            Ingredient(
              name = "Prepped Mozzarella",
              prep = Some("chopped into cubes")
            )
          )
        }

        "with notes" >> {
          Fixtures.recipe.ingredients must contain(
            Ingredient(
              name = "Goat's Cheese",
              notes = Some("don't buy half fat")
            )
          )
        }
      }

      "must have a method" >> {
        Fixtures.recipe.method.length must_== 3
        Fixtures.recipe.method must contain("Cook the lentils")
        Fixtures.recipe.method must contain("Spread the lentils between lasagne sheets")
        Fixtures.recipe.method must contain("Cook in the oven at 200C")
      }
    }

    "an invalid Recipe" >> {
      "with invalid CSON must raise an InvalidCSONException" >> {
        ingestRecipe(Fixtures.getFilePath("/illegal-cson.cson")) must throwAn[InvalidCSONException].like{
          case e => e.getMessage must startWith("Failed to convert 'illegal-cson.cson' to JSON with Python stack trace:")
        }
      }

      "with invalid Recipe JSON must raise an InvalidRecipeException" >> {
        ingestRecipe(Fixtures.getFilePath("/missing-url-recipe.cson")) must throwAn[InvalidRecipeException].like{
          case e => e.getMessage must contain("Failed to convert 'missing-url-recipe.cson' to a Recipe with stack trace:")
        }
      }
    }
  }
}

object Fixtures {
  lazy val recipe: Recipe = ingestRecipe(getFilePath("/lentil-lasagne.cson"))
  lazy val noOptionalsRecipe: Recipe = ingestRecipe(getFilePath("/no-optionals-recipe.cson"))
  def getFilePath(path: String): File = new File(getClass.getResource(path).getFile)
}
