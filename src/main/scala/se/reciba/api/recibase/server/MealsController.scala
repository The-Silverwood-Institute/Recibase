package se.reciba.api.server

import cats.Applicative
import cats.implicits._
import se.reciba.api.model.{
  GoogleDrive,
  Meal,
  MealStub,
  Online,
  Recipe,
  Source,
  Tag,
  MealStubWithUsageData
}
import se.reciba.api.usage.UsageData

import scala.collection.immutable
import se.reciba.api.MealDefinitions
import cats.effect.kernel.Sync

trait MealsController[F[_]] {
  def meals: F[Set[MealStubWithUsageData]]
  def mealNames: F[String]
}

object MealsController {
  def impl[F[_]: Applicative](
      usageData: UsageData[F]
  )(implicit F: Sync[F]): MealsController[F] =
    new MealsController[F] {
      override def meals: F[Set[MealStubWithUsageData]] =
        mealStubsWithUsageData[F](usageData)
      override def mealNames: F[String] =
        MealDefinitions.mealStubs
          .filter(_.isDinner)
          .map(_.name)
          .toSeq
          .sorted
          .mkString("\n")
          .pure[F]

    }

  def mealStubsWithUsageData[F[_]: Sync](
      usageData: UsageData[F]
  ): F[Set[MealStubWithUsageData]] = {
    for {
      mealCount <- usageData.mealCount
      mealLastEaten <- usageData.mealLastEaten
      mealNotes <- usageData.mealNotes
    } yield MealDefinitions.mealStubs
      .map(meal => {
        val mealTimesEaten = mealCount.getOrElse(meal.name, 0)
        val mealWithFrequencyTags = mealTimesEaten match {
          // Non-dinner items shouldn't be assigned usage tags because they are misleading
          case _ if !meal.isDinner => meal
          case 0 => meal.copy(tags = meal.tags + Tag.NeverEaten)
          case count if count <= 2 =>
            meal.copy(tags = meal.tags + Tag.Infrequent)
          case count if count >= 5 =>
            meal.copy(tags = meal.tags + Tag.Popular)
          case _ => meal
        }

        MealStubWithUsageData(
          mealWithFrequencyTags,
          mealNotes.getOrElse(meal.name, List.empty),
          mealLastEaten.get(mealWithFrequencyTags.name),
          mealTimesEaten
        )
      })
  }

  private val duplicates =
    MealDefinitions.mealStubs.toList
      .map(_.name.toLowerCase)
      .groupBy(identity)
      .flatMap {
        case (key, occurrences) if occurrences.length > 1 => Some(key)
        case _                                            => None
      }

  if (duplicates.nonEmpty) {
    throw new Exception(s"Duplicate meal names: ${duplicates.mkString(", ")}")
  }
}
