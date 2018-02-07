import java.io.File

import Extractor.ingestRecipe
import org.specs2._

class CSONIngestionSpec extends mutable.Specification {
  "CSON => Recipe ingestion specification where" >> {
    "a Recipe must have a name" >> {
      Fixtures.getRecipe.name must_== "Lentil Lasagne"
    }

    "a Recipe must have ingredients" >> {
      Fixtures.getRecipe.ingredients must contain(Ingredient("Lasagne Sheets", "100g"))
      Fixtures.getRecipe.ingredients must contain(Ingredient("Lentils", "200g"))
    }
  }
}

object Fixtures {
  private val filePath = new File(getClass.getResource("/lentil-lasagne.cson").getFile)
  private val recipe = ingestRecipe(filePath)

  def getRecipe: Recipe = recipe
}