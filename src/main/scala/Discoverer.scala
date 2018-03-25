import java.io.File

object Discoverer {
  def discoverRecipes(directoryPath: File): Seq[File] = {
    val files = directoryPath.listFiles.toList

    files.filter(_.getName.endsWith(".cson")) ++ files.filter(_.isDirectory).flatMap(discoverRecipes)
  }
}
