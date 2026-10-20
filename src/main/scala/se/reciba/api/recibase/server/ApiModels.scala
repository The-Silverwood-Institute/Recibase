package se.reciba.api.server

import io.circe.derivation.Configuration
import io.circe.{Decoder, Encoder}
import se.reciba.api.model.Image
import se.reciba.api.model.IngredientsBlock
import se.reciba.api.model.Tag
import se.reciba.api.recibase.model.DatedNote

import java.time.LocalDate

sealed trait MealSource
final case class Online(url: String) extends MealSource
final case class Recibase(permalink: String) extends MealSource
final case class GoogleDrive(id: String) extends MealSource

object MealSource {
  inline given Configuration =
    Configuration.default.withSnakeCaseConstructorNames
      .withDiscriminator("type")

  implicit val encodeMealSource: Encoder[MealSource] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeMealSource: Decoder[MealSource] =
    Decoder.derivedConfigured
}

final case class RecipeDetail(
    name: String,
    permalink: String,
    edit: String,
    source: Option[String],
    description: Option[String],
    tagline: Option[String],
    notes: List[String],
    datedNotes: List[DatedNote],
    tags: List[String],
    impliedTags: List[String],
    image: Option[Image],
    ingredientsBlocks: List[IngredientsBlock],
    method: List[String]
)

object RecipeDetail {
  inline given Configuration = ApiModels.snakeCaseCirce

  implicit val encodeRecipeDetail: Encoder[RecipeDetail] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeRecipeDetail: Decoder[RecipeDetail] =
    Decoder.derivedConfigured
}

final case class MealDetail(
    name: String,
    tags: List[String],
    impliedTags: List[String],
    source: Option[MealSource],
    datedNotes: List[DatedNote],
    lastEaten: Option[LocalDate],
    timesEaten: Int,
    featured: Option[LocalDate]
)

object MealDetail {
  inline given Configuration = ApiModels.snakeCaseCirce

  implicit val encodeMealDetail: Encoder[MealDetail] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeMealDetail: Decoder[MealDetail] =
    Decoder.derivedConfigured
}

final case class TagDoc(
    name: String,
    entryName: String,
    description: Option[String],
    category: String,
    superset: Option[Tag],
    impliedTags: Set[Tag]
)

object TagDoc {
  inline given Configuration = ApiModels.snakeCaseCirce

  implicit val encodeTagDoc: Encoder[TagDoc] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeTagDoc: Decoder[TagDoc] = Decoder.derivedConfigured

  def from(tag: Tag): TagDoc =
    TagDoc(
      tag.entryName,
      tag.entryName,
      tag.description,
      tag.category.entryName,
      tag.superset,
      tag.impliedTags
    )
}

final case class TagCatalog(tags: List[TagDoc])

object TagCatalog {
  inline given Configuration = ApiModels.snakeCaseCirce

  implicit val encodeTagCatalog: Encoder[TagCatalog] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeTagCatalog: Decoder[TagCatalog] = Decoder.derivedConfigured

  def all: TagCatalog = TagCatalog(Tag.values.map(TagDoc.from).toList)
}

final case class ManifestDoc(
    version: String,
    name: String,
    sourceUrl: String,
    baseCommitUrl: String
)

object ManifestDoc {
  inline given Configuration = ApiModels.snakeCaseCirce

  implicit val encodeManifestDoc: Encoder[ManifestDoc] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeManifestDoc: Decoder[ManifestDoc] =
    Decoder.derivedConfigured
}

final case class IngredientSubmissionDoc(
    name: String,
    quantity: Option[String],
    prep: Option[String],
    notes: Option[String]
)

object IngredientSubmissionDoc {
  implicit val encodeIngredientSubmissionDoc: Encoder[IngredientSubmissionDoc] =
    io.circe.generic.semiauto.deriveEncoder
  implicit val decodeIngredientSubmissionDoc: Decoder[IngredientSubmissionDoc] =
    io.circe.generic.semiauto.deriveDecoder
}

final case class RecipeSubmissionDoc(
    @sttp.tapir.Schema.annotations.encodedName("cf-turnstile-response")
    cfTurnstileResponse: String,
    name: String,
    source: Option[String],
    description: Option[String],
    notes: Option[List[String]],
    tags: Option[List[String]],
    ingredients: List[IngredientSubmissionDoc],
    method: List[String]
)

object RecipeSubmissionDoc {
  inline given Configuration =
    Configuration.default.withTransformMemberNames {
      case "cfTurnstileResponse" => "cf-turnstile-response"
      case other                 => other
    }

  implicit val encodeRecipeSubmissionDoc: Encoder[RecipeSubmissionDoc] =
    Encoder.AsObject.derivedConfigured
  implicit val decodeRecipeSubmissionDoc: Decoder[RecipeSubmissionDoc] =
    Decoder.derivedConfigured
}

final case class SubmissionAccepted(url: String)

object SubmissionAccepted {
  implicit val encodeSubmissionAccepted: Encoder[SubmissionAccepted] =
    io.circe.generic.semiauto.deriveEncoder
  implicit val decodeSubmissionAccepted: Decoder[SubmissionAccepted] =
    io.circe.generic.semiauto.deriveDecoder
}

final case class ApiError(error: String)

object ApiError {
  implicit val encodeApiError: Encoder[ApiError] =
    io.circe.generic.semiauto.deriveEncoder
  implicit val decodeApiError: Decoder[ApiError] =
    io.circe.generic.semiauto.deriveDecoder
}

private object ApiModels {
  inline def snakeCaseCirce: Configuration =
    Configuration.default.withSnakeCaseMemberNames
}
