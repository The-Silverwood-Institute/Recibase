import java.io.File

import spray.json.DefaultJsonProtocol._
import spray.json._

import scala.sys.process._

case class Recipe(
                  name: String,
                  url: String,
                  source: Option[String],
                  notes: Option[String],
                  ingredients: List[String],
                  method: List[String]
                 )

object Extractor {
  // Tells Spray how to map JSON to Scala objects
  implicit val recipeFormat: RootJsonFormat[Recipe] = jsonFormat6(Recipe)

  def ingestRecipe(filePath: File): Recipe = {
    val json = Seq("python", "estherj/estherj.py", filePath.getAbsolutePath).!!

    json.parseJson.convertTo[Recipe]
  }
}
