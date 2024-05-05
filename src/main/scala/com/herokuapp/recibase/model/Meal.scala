package com.herokuapp.recibase.model

import io.circe.Encoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

import java.time.LocalDate

trait Meal {
  def name: String
  def tags: Set[Tag]

  def isDinner: Boolean = tags.intersect(Tag.nonDinnerTags).isEmpty

  protected def inheritedTags: Set[Tag] = tags.flatMap(_.allParentTags)
}

case class MealStub(
    name: String,
    tags: Set[Tag],
    source: Option[Source] = None,
    lastEaten: Option[LocalDate] = None
) extends Meal {}

object MealStub {
  def apply(recipe: Recipe): MealStub =
    MealStub(recipe.name, recipe.tags, Some(Recibase(recipe.permalink.value)))

  def apply(name: String, tags: Set[Tag], source: Source): MealStub =
    MealStub(name, tags, Some(source))

  implicit val stubEncoder: Encoder[MealStub] =
    Encoder.forProduct5(
      "name",
      "tags",
      "inherited_tags",
      "source",
      "last_eaten"
    ) { mealStub =>
      (
        mealStub.name,
        mealStub.tags,
        mealStub.inheritedTags,
        mealStub.source,
        mealStub.lastEaten.map(date =>
          s"${date.getYear}-${date.getMonthValue}-${date.getDayOfMonth}"
        )
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
