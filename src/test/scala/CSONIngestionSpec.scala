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

      "can have a source" >> {
        Fixtures.recipe.source must beSome("https://example.com/recipes/lentil-lasagne")
      }

      "need not have a source" >> {
        Fixtures.noOptionalsRecipe.source must beNone
      }

      "can have notes" >> {
        Fixtures.recipe.notes must beSome("Consider serving with cherry tomatoes.")
      }

      "need not have notes" >> {
        Fixtures.noOptionalsRecipe.notes must beNone
      }

      "must have ingredients" >> {
        Fixtures.recipe.ingredients.length must_== 2
        Fixtures.recipe.ingredients must contain("100g Lasagne Sheets")
        Fixtures.recipe.ingredients must contain("200g Lentils")
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
          case e => e.getMessage must startWith("Failed to ingest 'illegal-cson.cson' with Python stack trace:")
        }
      }

      "with invalid Recipe JSON must raise an DeserializationException" >> {
        ingestRecipe(Fixtures.getFilePath("/missing-url-recipe.cson")) must throwAn[DeserializationException].like{
          case e => e.getMessage must contain("Object is missing required member 'url'")
        }
      }
    }
  }
}

object Fixtures {
  val recipe: Recipe = ingestRecipe(getFilePath("/lentil-lasagne.cson"))
  val noOptionalsRecipe: Recipe = ingestRecipe(getFilePath("/no-optionals-recipe.cson"))
  def getFilePath(path: String): File = new File(getClass.getResource(path).getFile)
}