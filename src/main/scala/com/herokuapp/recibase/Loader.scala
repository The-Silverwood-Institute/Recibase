package com.herokuapp.recibase

// Use H2Driver to connect to an H2 database
import java.io.File

import cats.effect.IO
import doobie._
import doobie.implicits._

class Loader(databaseFile: File) {
  private val databasePath = databaseFile.getAbsolutePath
  private val databaseURL = s"jdbc:sqlite:$databasePath"
  private val driver = "org.sqlite.JDBC"

  private val xa = Transactor.fromDriverManager[IO](
    driver,
    databaseURL
  )

  val y = xa.yolo
  import y._

  sql"""CREATE TABLE recipes(
    url VARCHAR NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR,
    tagline VARCHAR,
    notes VARCHAR,
    method VARCHAR NOT NULL
  )""".update.quick.unsafeRunSync()

  sql"""CREATE TABLE ingredients(
    recipeUrl VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    quantity VARCHAR,
    prep VARCHAR,
    notes VARCHAR,
    FOREIGN KEY(recipeUrl) REFERENCES recipes(url)
  )""".update.quick.unsafeRunSync()

  def addRecipes(recipes: Seq[Recipe]): Unit = {
    recipes.foreach(recipe => {
      val method = recipe.method.mkString("\n")
      val notes = recipe.notes.mkString("\n")

      sql"""insert into recipes
           (url, name, description, tagline, notes, method)
           values
           (${recipe.url}, ${recipe.name}, ${recipe.description}, ${recipe.tagline}, $notes, $method)""".update.quick
        .unsafeRunSync()

      recipe.ingredients.foreach(ingredient =>
        addIngredient(ingredient, recipe.url)
      )
    })
  }

  def addIngredient(ingredient: Ingredient, recipeUrl: String): Unit =
    sql"""insert into ingredients
         (recipeUrl, name, quantity, prep, notes)
         values
         ($recipeUrl, ${ingredient.name}, ${ingredient.quantity}, ${ingredient.prep}, ${ingredient.notes})
      """.update.quick.unsafeRunSync()
}
