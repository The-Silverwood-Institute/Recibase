import java.io.File

import org.specs2._
import Extractor.ingestRecipe

class CSONIngestionSpec extends mutable.Specification {
  "CSON => Recipe ingestion specification where" >> {
    "A Recipe must have a name" >> {
      val filePath = new File(getClass.getResource("/lentil-lasagne.cson").getFile)

      ingestRecipe(filePath) must_== Recipe("Lentil Lasagne")
    }
  }
}