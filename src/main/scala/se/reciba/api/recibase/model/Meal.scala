package se.reciba.api.model

import io.circe.Encoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

import java.time.LocalDate
import se.reciba.api.recibase.model.DatedNote

trait Meal {
  def name: String
  def tags: Set[Tag]

  def isDinner: Boolean = tags.intersect(Tag.nonDinnerTags).isEmpty

  def inheritedTags: Set[Tag] = tags.flatMap(_.allParentTags)
}

case class MealStub(
    name: String,
    tags: Set[Tag],
    source: Option[Source] = None
) extends Meal

object MealStub {
  def apply(recipe: Recipe): MealStub =
    MealStub(recipe.name, recipe.tags, Some(Recibase(recipe.permalink.value)))

  def apply(name: String, tags: Set[Tag], source: Source): MealStub =
    MealStub(name, tags, Some(source))
}

case class MealStubWithUsageData(
    name: String,
    tags: Set[Tag],
    source: Option[Source],
    datedNotes: List[DatedNote],
    lastEaten: Option[LocalDate],
    timesEaten: Int
) extends Meal

object MealStubWithUsageData {
  def apply(
      mealStub: MealStub,
      datedNotes: List[DatedNote],
      lastEaten: Option[LocalDate],
      timesEaten: Int
  ): MealStubWithUsageData =
    MealStubWithUsageData(
      mealStub.name,
      mealStub.tags,
      mealStub.source,
      datedNotes,
      lastEaten,
      timesEaten
    )

  implicit val stubEncoder: Encoder[MealStubWithUsageData] =
    Encoder.forProduct7(
      "name",
      "tags",
      "inherited_tags",
      "source",
      "dated_notes",
      "last_eaten",
      "times_eaten"
    ) { mealStub =>
      (
        mealStub.name,
        mealStub.tags,
        mealStub.inheritedTags,
        mealStub.source,
        mealStub.datedNotes,
        mealStub.lastEaten,
        mealStub.timesEaten
      )
    }
}

sealed trait Source
final case class Online(url: String) extends Source
final case class Recibase(permalink: String) extends Source
final case class GoogleDrive(id: String) extends Source

object Source {
  implicit val genDevConfig: Configuration =
    Configuration.default.withSnakeCaseConstructorNames.withDiscriminator(
      "type"
    )
  implicit val sourceEncoder: Encoder[Source] = deriveConfiguredEncoder[Source]
}
