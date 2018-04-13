import java.io.File

import spray.json.DefaultJsonProtocol._
import spray.json._

import scala.sys.process._

case class Ingredient(
                     name: String,
                     quantity: Option[String] = None,
                     prep: Option[String] = None,
                     notes: Option[String] = None
                     )

case class Recipe(
                  name: String,
                  url: String,
                  description: Option[String],
                  notes: Option[String],
                  ingredients: List[Ingredient],
                  method: List[String]
                 )

object Extractor {
  // Tells Spray how to map JSON to Scala objects
  implicit val ingredientFormat: JsonFormat[Ingredient] = jsonFormat4(Ingredient)
  implicit val recipeFormat: RootJsonFormat[Recipe] = jsonFormat6(Recipe)

  def ingestRecipe(filePath: File): Recipe = {
    val stdout = new StringBuilder
    val stderr = new StringBuilder
    val exitCode = Seq("python", "estherj/estherj.py", filePath.getAbsolutePath) ! ProcessLogger(stdout append _, stderr append "\n" + _)

    if (exitCode != 0) {
      val message = s"Failed to convert '${filePath.getName}' to JSON with Python stack trace:\n" + stderr + "\n"
      throw InvalidCSONException(message)
    }

    val json = stdout.toString

    try {
      json.toString.parseJson.convertTo[Recipe]
    } catch {
      case e: DeserializationException => {
        val message = s"Failed to convert '${filePath.getName}' to a Recipe with stack trace:\n" +  e.msg
        throw InvalidRecipeException(message)
      }
    }
  }
}

final case class InvalidCSONException(private val message: String = "", private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
final case class InvalidRecipeException(private val message: String = "", private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
