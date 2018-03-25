import java.io.File

object Main extends App {
  if (args.length != 2) {
    printUsage()
    System.exit(1)
  }
  println(s"Ingesting recipes from:\n${args(0)}")
  val recipesDirectory = new File(args(0))
  val databasePath = args(1)

  val recipes: Seq[Recipe] = Discoverer.discoverRecipes(recipesDirectory).map(Extractor.ingestRecipe)

  if (recipes.isEmpty) {
    println("No recipes found")
    System.exit(2)
  } else {
    println(s"Ingested ${recipes.length} recipes")
  }

  val databaseLoader: Loader = new Loader(databasePath)
  println(s"Saving recipe to database at:\n$databasePath")
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
