package se.reciba.api.submit

import io.circe.{Decoder, HCursor}

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

case class IngredientSubmission(
    name: String,
    quantity: Option[String],
    prep: Option[String],
    notes: Option[String]
)

case class RecipeSubmission(
    name: String,
    source: Option[String],
    description: Option[String],
    notes: List[String],
    tags: List[String],
    ingredients: List[IngredientSubmission],
    method: List[String]
)

object RecipeSubmission {
  implicit val decodeIngredient: Decoder[IngredientSubmission] =
    Decoder.instance { cursor =>
      for {
        name <- cursor.get[String]("name")
        quantity <- cursor.get[Option[String]]("quantity")
        prep <- cursor.get[Option[String]]("prep")
        notes <- cursor.get[Option[String]]("notes")
      } yield IngredientSubmission(name, quantity, prep, notes)
    }

  implicit val decodeSubmission: Decoder[RecipeSubmission] =
    Decoder.instance { cursor =>
      for {
        name <- cursor.get[String]("name")
        source <- cursor.get[Option[String]]("source")
        description <- cursor.get[Option[String]]("description")
        notes <- optionalList[String](cursor, "notes")
        tags <- optionalList[String](cursor, "tags")
        ingredients <- cursor.get[List[IngredientSubmission]]("ingredients")
        method <- cursor.get[List[String]]("method")
      } yield RecipeSubmission(
        name,
        source,
        description,
        notes,
        tags,
        ingredients,
        method
      )
    }

  private def optionalList[A: Decoder](
      cursor: HCursor,
      field: String
  ): Decoder.Result[List[A]] =
    cursor.downField(field).as[Option[List[A]]].map(_.getOrElse(Nil))
}

object Passcode {
  def equal(expected: String, provided: String): Boolean =
    MessageDigest.isEqual(
      expected.getBytes(StandardCharsets.UTF_8),
      provided.getBytes(StandardCharsets.UTF_8)
    )
}
