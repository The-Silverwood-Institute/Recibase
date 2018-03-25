import java.io.File

import spray.json.DefaultJsonProtocol._
import spray.json._

import scala.sys.process._

case class Ingredient(name: String, quantity: String)
case class Recipe(name: String, ingredients: List[Ingredient])

object Extractor {
  // Tells Spray how to map JSON to Scala objects
  implicit val ingredientFormat: JsonFormat[Ingredient] = jsonFormat2(Ingredient)
  implicit val recipeFormat: RootJsonFormat[Recipe] = jsonFormat2(Recipe)

  def ingestRecipe(filePath: File): Recipe = {
    val json = Seq("python", "estherj/estherj.py", filePath.getAbsolutePath).!!

    json.parseJson.convertTo[Recipe]
  }
}
