import java.io.File

import Extractor.ingestRecipe
import org.specs2._

class CSONIngestionSpec extends mutable.Specification {
  "CSON => Recipe ingestion specification where" >> {
    "a Recipe must have a name" >> {
      Fixtures.recipe.name must_== "Lentil Lasagne"
    }

    "a Recipe must have ingredients" >> {
      Fixtures.recipe.ingredients must contain(Ingredient("Lasagne Sheets", "100g"))
      Fixtures.recipe.ingredients must contain(Ingredient("Lentils", "200g"))
    }
  }
}

object Fixtures {
  private val filePath = new File(getClass.getResource("/lentil-lasagne.cson").getFile)
  val recipe: Recipe = ingestRecipe(filePath)
}