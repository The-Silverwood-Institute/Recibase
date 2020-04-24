package com.herokuapp.recibase

import java.io.File

import com.herokuapp.recibase.recipes._

object Main extends App {
  if (args.length != 1 && args.length != 2) {
    printUsage()
    System.exit(1)
  }

  val databaseDirectoryPath = args(0)
  val overwriteDatabase = args.length == 2 && args(1) == "--overwrite-db"


  if (!new File(databaseDirectoryPath).isDirectory) {
    println(s"Given database directory $databaseDirectoryPath does not exist")
    printUsage()
    System.exit(3)
  }

  val databaseFile = new File(databaseDirectoryPath, "recipes.db")

  val recipes = List(
    BakedRigatoniAubergine,
    BakedSalmonOlivesSpaghetti,
    BeetrootRisotto,
    BlueCheeseGnocchi,
    BroccoliSalmonQuiche,
    CheesyCodSpinachGratin,
    ChilliConCarne,
    ChunkyVegetableCrumble,
    CourgetteSpinachPasties,
    CreamyCauliflowerCheeseWalnuts,
    CreamyMushroomStroganoff,
    Dahl,
    EasySoup,
    IndianPatties,
    Kashtouri,
    LemonFetaPasta,
    LentilShepardsPie,
    MeltyMushroomWellingtons,
    MushroomQuiche,
    MushroomRisotto,
    PaneerJalfrezi,
    ParsnipGingerSoup,
    ParsnipLentilLasagne,
    RoastedVegetableLasagne,
    RussianMushroomJulienne,
    SaagPaneer,
    ScrambledEggs,
    SeafoodLasagne,
    SmokyFishSweetPotatoCurry,
    SpicySmokedPaprikaChorizo,
    SweetChilliFetaPasta,
    VegetablePrimavera
  )

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
        |  databaseOutput    Path to directory where recipe database will be created
        |  [--overwrite-db]  Delete the database, if it already exists
      """.stripMargin)
  }
}
