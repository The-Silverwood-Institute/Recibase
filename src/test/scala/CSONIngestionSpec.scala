import java.io.File

import Extractor.ingestRecipe
import org.specs2._

class CSONIngestionSpec extends mutable.Specification {
  "CSON to Recipe object ingestion specification where" >> {
    "a Recipe must have a name" >> {
      Fixtures.recipe.name must_== "Lentil Lasagne"
    }

    "a Recipe must have a URL" >> {
      Fixtures.recipe.url must_== "lentil-lasagne"
    }

    "a Recipe must have ingredients" >> {
      Fixtures.recipe.ingredients.length must_== 2
      Fixtures.recipe.ingredients must contain("100g Lasagne Sheets")
      Fixtures.recipe.ingredients must contain("200g Lentils")
    }

    "a recipe must have a method" >> {
      Fixtures.recipe.method.length must_== 3
      Fixtures.recipe.method must contain("Cook the lentils")
      Fixtures.recipe.method must contain("Spread the lentils between lasagne sheets")
      Fixtures.recipe.method must contain("Cook in the oven at 200C")
    }
  }
}

object Fixtures {
  private val filePath = new File(getClass.getResource("/lentil-lasagne.cson").getFile)
  val recipe: Recipe = ingestRecipe(filePath)
}