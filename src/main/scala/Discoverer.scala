import java.io.File

object Discoverer {
  def discoverRecipes(directoryPath: File): Seq[File] = {
    val directoryListing = directoryPath.listFiles.toList

    directoryListing.filter(recipeFileFilter) ++ directoryListing.filter(recipeDirectoryFilter).flatMap(discoverRecipes)
  }

  private def recipeFileFilter(file: File): Boolean = file.getName.endsWith(".cson")

  private def recipeDirectoryFilter(file: File): Boolean = file.isDirectory && file.getName != "_drafts"
}
