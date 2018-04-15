import java.io.File

object Main extends App {
  if (args.length != 2 && args.length != 3) {
    printUsage()
    System.exit(1)
  }

  val databasePath = args(1)
  val recipesDirectoryPath = args(0)
  val overwriteDatabase = args.length == 3 && args(2) == "--overwrite-db"

  if (!databasePath.endsWith(".db")) {
    println("Invalid database name. Databases expected to end with '.db'")
    printUsage()
    System.exit(3)
  }

  println(s"Searching for recipes in:\n$recipesDirectoryPath")
  val recipesDirectory = new File(recipesDirectoryPath)
  val recipeFiles: Seq[File] = Discoverer.discoverRecipes(recipesDirectory)

  if (recipeFiles.isEmpty) {
    println("No recipes found")
    System.exit(2)
  } else {
    println(s"Found ${recipeFiles.length} recipes:")
    recipeFiles.foreach(file => println("    " + file.getName))
  }

  println("Ingesting recipes...")
  val recipes: Seq[Recipe] = recipeFiles.map(Extractor.ingestRecipe)

  println(s"Saving recipes to database at:\n$databasePath")
  if (!databasePath.endsWith(".db")) {
    println("Invalid database name. Databases expected to end with '.db'")
    System.exit(3)
  }

  val databaseFile = new File(databasePath)
  if (databaseFile.exists()) {
    if (overwriteDatabase) {
      println("Deleting existing database")
      databaseFile.delete()
    } else {
      println("Database already exists. Use flag '--overwrite-db' to overwrite.")
      System.exit(4)
    }
  }
  val databaseLoader: Loader = new Loader(databasePath)
  databaseLoader.addRecipes(recipes)
  println("Recipes saved to db")

  def printUsage(): Unit = {
    println(
      """
        | Recibase
        | --------
        | Recipe ingestion service
        | --------
        | Arguments:
        |  recipeDirectory   Location of recipes, as CSON files
        |  databaseOutput    Path to where recipe database will be created
        |  [--overwrite-db]  Delete the database, if it already exists
      """.stripMargin)
  }
}
