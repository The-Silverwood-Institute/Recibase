import java.io.File

import org.specs2._

class FileDiscoverySpec extends mutable.Specification {
  "Recipe files discovery spec where" >> {
    "An empty folder returns no filepaths" >> {
      val emptyDirectory = DirectoryHelper.getFile("/emptyDirectory")

      emptyDirectory.createNewFile()

      Discoverer.discoverRecipes(emptyDirectory) must beEmpty
    }

    "A folder contains a single recipe" >> {
      val singleRecipeDirectory = DirectoryHelper.getFile("/singleRecipe")

      Discoverer.discoverRecipes(singleRecipeDirectory).length must_== 1
    }

    "A folder contains multiple recipes" >> {
      val multipleRecipeDirectory = DirectoryHelper.getFile("/multipleRecipes")

      Discoverer.discoverRecipes(multipleRecipeDirectory).length must_== 3
    }

    "A folder contains non CSON files" >> {
      val mixedFilesDirectory = DirectoryHelper.getFile("/mixedFiles")

      Discoverer.discoverRecipes(mixedFilesDirectory).length must_== 2
    }

    "A folder contains folders" >> {
      val nestedDirectories = DirectoryHelper.getFile("/nestedDirectories")

      Discoverer.discoverRecipes(nestedDirectories).length must_== 3
    }
  }
}

object DirectoryHelper {
  def getFile(relativePath: String): File = {
    new File(getClass.getResource("/discovery").getFile + relativePath)
  }
}
