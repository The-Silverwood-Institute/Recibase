import java.io.File

object Main extends App {
  if (args.length != 2) {
    printUsage()
    System.exit(1)
  }

  val databasePath = args(1)
  val recipesDirectoryPath = args(0)

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
  val databaseLoader: Loader = new Loader(databasePath)
  databaseLoader.addRecipes(recipes)

  def printUsage(): Unit = {
    println(
      """
        | Recibase
        | --------
        | Recipe ingestion service
        | --------
        | Arguments:
        |  recipeDirectory  Location of recipes, as CSON files
        |  databaseOutput   Path to create database of recipes
      """.stripMargin)
  }
}
