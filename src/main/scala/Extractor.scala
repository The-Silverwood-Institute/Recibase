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
    val stdout = new StringBuilder
    val stderr = new StringBuilder
    val exitCode = Seq("python", "estherj/estherj.py", filePath.getAbsolutePath) ! ProcessLogger(stdout append _, stderr append "\n" + _)

    if (exitCode != 0) {
      throw InvalidCSONException(s"Failed to convert '${filePath.getName}' to JSON with Python stack trace:" + stderr)
    }

    val json = stdout.toString

    json.toString.parseJson.convertTo[Recipe]
  }
}

final case class InvalidCSONException(private val message: String = "", private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
  extends Exception(message, cause)
