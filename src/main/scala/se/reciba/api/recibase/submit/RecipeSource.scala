package se.reciba.api.submit

import org.apache.commons.lang3.StringUtils
import se.reciba.api.model.{Recipe, Tag}

import java.time.LocalDate
import java.util.Locale

case class GeneratedRecipe(
    name: String,
    objectName: String,
    permalink: String,
    branch: String,
    path: String,
    source: String
)

sealed trait SubmitRejection
final case class InvalidSubmission(message: String) extends SubmitRejection
final case class ConflictingSubmission(message: String) extends SubmitRejection

object RecipeSource {
  private val NameLimit = 80
  private val TextLimit = 2000
  private val ListLimit = 80
  private val TagLimit = 40

  // These identifiers are referenced by the generated file. A case object
  // with the same name would shadow them and fail to compile.
  private val reservedIdentifiers = Set(
    "Recipe",
    "Tag",
    "Ingredient",
    "IngredientsBlock",
    "Permalink",
    "List",
    "Set",
    "None",
    "Some",
    "Option",
    "LocalDate"
  )

  private val automaticTags = Set(
    "NeverEaten",
    "Popular",
    "Infrequent",
    "New"
  )

  private val tagsByObjectName: Map[String, String] =
    Tag.values.map { tag =>
      val objectName = tag.getClass.getSimpleName.stripSuffix("$")
      objectName -> objectName
    }.toMap

  def generate(
      submission: RecipeSubmission,
      createdAt: LocalDate,
      existing: Seq[Recipe]
  ): Either[SubmitRejection, GeneratedRecipe] =
    for {
      clean <- validate(submission)
      identified <- identify(clean)
      _ <- conflicts(identified, existing)
    } yield render(identified, createdAt)

  private case class CleanIngredient(
      name: String,
      quantity: Option[String],
      prep: Option[String],
      notes: Option[String]
  )

  private case class CleanRecipe(
      name: String,
      source: Option[String],
      description: Option[String],
      notes: List[String],
      tags: List[String],
      ingredients: List[CleanIngredient],
      method: List[String]
  )

  private case class IdentifiedRecipe(
      clean: CleanRecipe,
      objectName: String,
      permalink: String
  )

  private def validate(
      submission: RecipeSubmission
  ): Either[SubmitRejection, CleanRecipe] = {
    val name = submission.name.trim
    val source = blank(submission.source)
    val description = blank(submission.description)
    val notes = submission.notes.map(_.trim).filter(_.nonEmpty)
    val tags = submission.tags.map(_.trim).filter(_.nonEmpty).distinct
    val method = submission.method.map(_.trim).filter(_.nonEmpty)

    if (submission.ingredients.length > ListLimit)
      invalid("Too many ingredients")
    else if (submission.method.length > ListLimit)
      invalid("Too many method steps")
    else if (submission.notes.length > ListLimit)
      invalid("Too many notes")
    else if (submission.tags.length > TagLimit)
      invalid("Too many tags")
    else if (name.isEmpty)
      invalid("Name is required")
    else {
      for {
        checkedName <- text("Name", name, NameLimit, singleLine = true)
        checkedSource <- optionalText("Source", source)
        checkedDescription <- optionalText("Description", description)
        checkedNotes <- listText("A note", notes)
        checkedTags <- parseTags(tags)
        checkedIngredients <- ingredients(submission.ingredients)
        checkedMethod <-
          if (method.isEmpty) invalid("Add at least one method step")
          else listText("A method step", method)
      } yield CleanRecipe(
        checkedName,
        checkedSource,
        checkedDescription,
        checkedNotes,
        checkedTags,
        checkedIngredients,
        checkedMethod
      )
    }
  }

  private def ingredients(
      submitted: List[IngredientSubmission]
  ): Either[SubmitRejection, List[CleanIngredient]] = {
    val cleaned = submitted
      .map { ingredient =>
        CleanIngredient(
          ingredient.name.trim,
          blank(ingredient.quantity),
          blank(ingredient.prep),
          blank(ingredient.notes)
        )
      }
      .filter { ingredient =>
        ingredient.name.nonEmpty ||
        ingredient.quantity.nonEmpty ||
        ingredient.prep.nonEmpty ||
        ingredient.notes.nonEmpty
      }

    cleaned
      .foldLeft[Either[SubmitRejection, List[CleanIngredient]]](
        Right(Nil)
      ) { (acc, ingredient) =>
        acc.flatMap { soFar =>
          if (ingredient.name.isEmpty)
            invalid("Each ingredient needs a name")
          else {
            for {
              name <- text(
                "An ingredient field",
                ingredient.name,
                TextLimit,
                singleLine = true
              )
              quantity <- optionalText(
                "An ingredient field",
                ingredient.quantity
              )
              prep <- optionalText("An ingredient field", ingredient.prep)
              notes <- optionalText("An ingredient field", ingredient.notes)
            } yield soFar :+ CleanIngredient(name, quantity, prep, notes)
          }
        }
      }
      .flatMap { result =>
        if (result.isEmpty) invalid("Add at least one ingredient")
        else Right(result)
      }
  }

  private def parseTags(
      tags: List[String]
  ): Either[SubmitRejection, List[String]] =
    tags.foldLeft[Either[SubmitRejection, List[String]]](Right(Nil)) {
      (acc, tag) =>
        acc.flatMap { soFar =>
          if (unsupported(tag, singleLine = true))
            invalid("A tag contains unsupported characters")
          else if (automaticTags.contains(tag))
            invalid(s"Tag $tag is assigned automatically")
          else
            tagsByObjectName.get(tag) match {
              case Some(objectName) => Right(soFar :+ objectName)
              case None             =>
                val shown =
                  if (tag.length > 40) tag.take(40) + "..." else tag
                invalid(s"Unknown tag: $shown")
            }
        }
    }

  private def optionalText(
      label: String,
      value: Option[String]
  ): Either[SubmitRejection, Option[String]] =
    value match {
      case None       => Right(None)
      case Some(text) =>
        this.text(label, text, TextLimit, singleLine = true).map(Some(_))
    }

  private def listText(
      label: String,
      values: List[String]
  ): Either[SubmitRejection, List[String]] =
    values.foldLeft[Either[SubmitRejection, List[String]]](Right(Nil)) {
      (acc, value) =>
        acc.flatMap { soFar =>
          text(label, value, TextLimit, singleLine = false).map(soFar :+ _)
        }
    }

  private def text(
      label: String,
      value: String,
      max: Int,
      singleLine: Boolean
  ): Either[SubmitRejection, String] =
    if (unsupported(value, singleLine))
      invalid(s"$label contains unsupported characters")
    else if (value.length > max)
      invalid(s"$label is too long")
    else Right(value)

  private def unsupported(value: String, singleLine: Boolean): Boolean = {
    var index = 0
    while (index < value.length) {
      val codePoint = value.codePointAt(index)
      val blocked =
        codePoint == 0x2028 || codePoint == 0x2029 ||
          (Character.isISOControl(codePoint) &&
            codePoint != '\n' &&
            codePoint != '\r' &&
            codePoint != '\t') ||
          (singleLine && (codePoint == '\n' || codePoint == '\r' || codePoint == '\t'))
      if (blocked) return true
      index += Character.charCount(codePoint)
    }
    false
  }

  private def identify(
      clean: CleanRecipe
  ): Either[SubmitRejection, IdentifiedRecipe] = {
    val objectName = words(clean.name).map(capitalise).mkString
    val slug = permalink(clean.name)
    if (
      objectName.isEmpty ||
      !objectName.matches("[A-Z][A-Za-z0-9]*") ||
      reservedIdentifiers.contains(objectName) ||
      !slug.matches("[a-z0-9]+(-[a-z0-9]+)*")
    )
      invalid("Recipe name cannot be turned into a Scala file name")
    else Right(IdentifiedRecipe(clean, objectName, slug))
  }

  private def conflicts(
      identified: IdentifiedRecipe,
      existing: Seq[Recipe]
  ): Either[SubmitRejection, Unit] = {
    val name = identified.clean.name
    if (existing.exists(_.name.equalsIgnoreCase(name)))
      conflict(s"A recipe named $name already exists")
    else if (existing.exists(_.permalink.value == identified.permalink))
      conflict(
        s"A recipe with permalink ${identified.permalink} already exists"
      )
    else if (existing.exists(_.productPrefix == identified.objectName))
      conflict(
        s"A recipe file named ${identified.objectName}.scala already exists"
      )
    else Right(())
  }

  private def render(
      identified: IdentifiedRecipe,
      createdAt: LocalDate
  ): GeneratedRecipe = {
    val clean = identified.clean
    val ingredientLines = clean.ingredients.map(ingredientExpr)
    val needsCats =
      clean.source.isDefined ||
        clean.description.isDefined ||
        ingredientLines.exists(_._2)
    val imports =
      (if (needsCats) List("import cats.syntax.option._") else Nil) ++ List(
        "import se.reciba.api.model.{Ingredient, IngredientsBlock, Permalink, Recipe, Tag}",
        "import java.time.LocalDate"
      )
    val metadata = List(
      clean.source.map(value =>
        s"  override val source: Option[String] = ${ScalaLiteral.quote(value)}.some"
      ),
      clean.description.map(value =>
        s"  override val description: Option[String] = ${ScalaLiteral.quote(value)}.some"
      )
    ).flatten ++ (
      if (clean.notes.isEmpty) Nil
      else
        indentedList(
          "override val notes: List[String] = List",
          clean.notes.map(ScalaLiteral.quote)
        )
    )
    val tags =
      if (clean.tags.isEmpty) "  val tags = Set.empty[Tag]"
      else
        s"  val tags = Set(${clean.tags.map(tag => s"Tag.$tag").mkString(", ")})"
    val lines =
      List("package se.reciba.api.recipes", "") ++
        imports ++
        List(
          "",
          s"case object ${identified.objectName} extends Recipe {",
          s"  val name = ${ScalaLiteral.quote(clean.name)}",
          s"  val createdAt = LocalDate.of(${createdAt.getYear}, ${createdAt.getMonthValue}, ${createdAt.getDayOfMonth})",
          s"  override val permalink: Permalink = Permalink(${ScalaLiteral.quote(identified.permalink)})",
          ""
        ) ++
        (if (metadata.isEmpty) Nil else metadata :+ "") ++
        List(tags, "") ++
        indentedList(
          "val ingredientsBlocks = IngredientsBlock.simple",
          ingredientLines.map(_._1)
        ) ++
        List("") ++
        indentedList(
          "val method = List",
          clean.method.map(ScalaLiteral.quote)
        ) ++
        List("}")

    GeneratedRecipe(
      name = clean.name,
      objectName = identified.objectName,
      permalink = identified.permalink,
      branch = s"recipe/${identified.permalink}",
      path =
        s"src/main/scala/se/reciba/api/recibase/recipes/${identified.objectName}.scala",
      source = lines.mkString("\n") + "\n"
    )
  }

  private def ingredientExpr(ingredient: CleanIngredient): (String, Boolean) =
    (ingredient.quantity, ingredient.prep, ingredient.notes) match {
      case (None, None, None) =>
        (s"Ingredient(${ScalaLiteral.quote(ingredient.name)})", false)
      case (Some(quantity), None, None) =>
        (
          s"Ingredient(${ScalaLiteral.quote(ingredient.name)}, ${ScalaLiteral.quote(quantity)})",
          false
        )
      case (Some(quantity), Some(prep), None) =>
        (
          s"Ingredient(${ScalaLiteral.quote(ingredient.name)}, ${ScalaLiteral.quote(quantity)}, ${ScalaLiteral.quote(prep)})",
          false
        )
      case (Some(quantity), Some(prep), Some(notes)) =>
        (
          s"Ingredient(${ScalaLiteral.quote(ingredient.name)}, ${ScalaLiteral.quote(quantity)}, ${ScalaLiteral.quote(prep)}, ${ScalaLiteral.quote(notes)})",
          false
        )
      case (quantity, prep, notes) =>
        (
          s"Ingredient(${ScalaLiteral.quote(ingredient.name)}, ${opt(quantity)}, ${opt(prep)}, ${opt(notes)})",
          true
        )
    }

  private def opt(value: Option[String]): String =
    value.fold("None")(text => s"${ScalaLiteral.quote(text)}.some")

  private def indentedList(
      prefix: String,
      items: List[String]
  ): List[String] = {
    val body = items.zipWithIndex.map { case (item, index) =>
      val comma = if (index == items.length - 1) "" else ","
      s"    $item$comma"
    }
    s"  $prefix(" :: body ::: List("  )")
  }

  private def words(name: String): Array[String] =
    StringUtils
      .stripAccents(name)
      .split("[^A-Za-z0-9]+")
      .filter(_.nonEmpty)

  private def capitalise(word: String): String =
    word.head.toUpper.toString + word.tail.toLowerCase(Locale.ROOT)

  private def permalink(name: String): String =
    StringUtils
      .stripAccents(name)
      .toLowerCase(Locale.ROOT)
      .replaceAll("[^a-z0-9]+", "-")
      .stripPrefix("-")
      .stripSuffix("-")

  private def blank(value: Option[String]): Option[String] =
    value.map(_.trim).filter(_.nonEmpty)

  private def invalid(message: String): Either[SubmitRejection, Nothing] =
    Left(InvalidSubmission(message))

  private def conflict(message: String): Either[SubmitRejection, Nothing] =
    Left(ConflictingSubmission(message))
}
