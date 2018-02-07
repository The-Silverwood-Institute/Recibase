import java.io.File

import spray.json.{DefaultJsonProtocol, _}

import scala.sys.process._

case class Recipe(name: String)

object RecipeProtocol extends DefaultJsonProtocol {
  implicit val recipeFormat = jsonFormat1(Recipe)
}

import RecipeProtocol._

object Extractor {
  def ingestRecipe(filePath: File): Recipe = {
    val json = Seq("python", "estherj/estherj.py", filePath.getAbsolutePath).!!

    json.parseJson.convertTo[Recipe]
  }
}
