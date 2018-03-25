// Use H2Driver to connect to an H2 database
import slick.jdbc.SQLiteProfile.api._

class Loader(databasePath: String) {
  val databaseURL = s"jdbc:sqlite:$databasePath"
  val db = Database.forURL(databaseURL, driver = "org.sqlite.JDBC")

  class Recipes(tag: Tag) extends Table[(String, String, String, String)](tag, "Recipes") {
    def url = column[String]("url", O.PrimaryKey) // This is the primary key column
    def name = column[String]("name")
    def ingredients = column[String]("ingredients")
    def method = column[String]("method")
    def * = (url, name, ingredients, method)
  }
  val recipes = TableQuery[Recipes]

  def addRecipes(inRecipes: Seq[Recipe]): Unit = {
    val dbOperations = DBIO.seq(recipes.schema.create) andThen DBIO.sequence(inRecipes.map(addRecipe))

    try {
      db.run(dbOperations)
    } finally db.close
  }

  def addRecipe(recipe: Recipe): DBIO[Int] = {
    recipes += (
      recipe.url,
      recipe.name,
      recipe.ingredients.reduce(joinWithNewline),
      recipe.method.reduce(joinWithNewline)
    )
  }

  private def joinWithNewline(left: String, right: String): String = {
    left + "\n" + right
  }
}
