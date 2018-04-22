// Use H2Driver to connect to an H2 database
import java.io.File
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

class Loader(databaseFile: File) {
  private val databasePath = databaseFile.getAbsolutePath
  private val databaseURL = s"jdbc:sqlite:$databasePath"
  private val db = Database.forURL(databaseURL, driver = "org.sqlite.JDBC")

  class Recipes(tag: Tag) extends Table[(String, String, String, String, String, String)](tag, "Recipes") {
    def url = column[String]("url", O.PrimaryKey) // This is the primary key column
    def name = column[String]("name")
    def description = column[String]("description")
    def notes = column[String]("notes")
    def ingredients = column[String]("ingredients")
    def method = column[String]("method")
    def * = (url, name, description, notes, ingredients, method)
  }

  private val recipes = TableQuery[Recipes]

  def addRecipes(inRecipes: Seq[Recipe]): Unit = {
    val dbOperations = DBIO.seq(recipes.schema.create) andThen DBIO.sequence(inRecipes.map(addRecipe))

    val action = db.run(dbOperations.transactionally)

    Await.result(action, Duration(3, "seconds"))

    db.close()
  }

  private def addRecipe(recipe: Recipe): DBIO[Int] = {
    recipes += (
      recipe.url,
      recipe.name,
      recipe.description.getOrElse(""),
      recipe.notes.getOrElse(""),
      recipe.ingredients.map(ingredientToString).mkString("\n"),
      recipe.method.mkString("\n")
    )
  }

  private def ingredientToString(ingredient: Ingredient): String = {
    val quantity = ingredient.quantity.fold("")(quantity => ": " + quantity)
    val prep = ingredient.prep.fold("")(prep => ", " + prep)
    val notes     = ingredient.notes.fold("")(notes => " (" + notes + ")")

    ingredient.name + quantity + prep + notes
  }
}
