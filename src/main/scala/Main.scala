import java.io.File

object Main extends App {
  if (args.length != 2 && args.length != 3) {
    printUsage()
    System.exit(1)
  }

  val databaseDirectoryPath = args(1)
  val recipesDirectoryPath = args(0)
  val overwriteDatabase = args.length == 3 && args(2) == "--overwrite-db"


  if (!new File(databaseDirectoryPath).isDirectory) {
    println(s"Given database directory $databaseDirectoryPath does not exist")
    printUsage()
    System.exit(3)
  }

  val databaseFile = new File(databaseDirectoryPath, "recipes.db")

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

  println(s"Saving recipes to database at:\n${databaseFile.getAbsolutePath}")

  if (databaseFile.exists()) {
    if (overwriteDatabase) {
      println("Deleting existing database")
      databaseFile.delete()
    } else {
      println("Database already exists. Use flag '--overwrite-db' to overwrite.")
      System.exit(4)
    }
  }
  println("Connecting to database and creating schema")
  val databaseLoader: Loader = new Loader(databaseFile)
  println("Adding recipes...")
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
        |  databaseOutput    Path to directory where recipe database will be created
        |  [--overwrite-db]  Delete the database, if it already exists
      """.stripMargin)
  }
}
