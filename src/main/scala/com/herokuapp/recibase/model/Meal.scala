package com.herokuapp.recibase.model

import io.circe.Encoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.generic.semiauto.deriveEncoder

trait Meal {
  def name: String
  def tags: Set[Tag]
}

case class MealStub(
    name: String,
    tags: Set[Tag],
    source: Option[Source] = None
) extends Meal

object MealStub {
  def apply(recipe: Recipe): MealStub =
    MealStub(recipe.name, recipe.tags, Some(Recibase(recipe.permalink)))

  def apply(name: String, tags: Set[Tag], source: Source): MealStub =
    MealStub(name, tags, Some(source))

  implicit val stubEncoder: Encoder[MealStub] = deriveEncoder[MealStub]
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
