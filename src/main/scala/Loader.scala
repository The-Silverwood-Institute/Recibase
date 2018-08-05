// Use H2Driver to connect to an H2 database
import java.io.File
import doobie._
import doobie.implicits._
import cats.effect.IO

class Loader(databaseFile: File) {
  private val databasePath = databaseFile.getAbsolutePath
  private val databaseURL = s"jdbc:sqlite:$databasePath"
  private val driver = "org.sqlite.JDBC"

  private val xa = Transactor.fromDriverManager[IO](
    driver, databaseURL
  )

  val y = xa.yolo
  import y._

  sql"""CREATE TABLE recipes(
    url VARCHAR NOT NULL UNIQUE,
    name VARCHAR NOT NULL,
    description VARCHAR,
    tagline VARCHAR,
    notes VARCHAR,
    ingredients VARCHAR NOT NULL,
    method VARCHAR NOT NULL
  )""".update.quick.unsafeRunSync()

  def addRecipes(recipes: Seq[Recipe]): Unit = {
    recipes.foreach(recipe => {
      val ingredients = recipe.ingredients.map(ingredientToString).mkString("\n")
      val method = recipe.method.mkString("\n")
      val notes = recipe.notes.mkString("\n")

      sql"""insert into recipes
           (url, name, description, tagline, notes, ingredients, method)
           values
           (${recipe.url}, ${recipe.name}, ${recipe.description}, ${recipe.tagline}, $notes, $ingredients, $method)""".update.quick.unsafeRunSync()
    })
  }

  private def ingredientToString(ingredient: Ingredient): String = {
    val quantity = ingredient.quantity.fold("")(quantity => ": " + quantity)
    val prep = ingredient.prep.fold("")(prep => ", " + prep)
    val notes     = ingredient.notes.fold("")(notes => " (" + notes + ")")

    ingredient.name + quantity + prep + notes
  }
}
