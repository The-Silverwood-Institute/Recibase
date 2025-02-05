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
  Tag
}
import se.reciba.api.usage.UsageData

import scala.collection.immutable
import se.reciba.api.MealDefinitions
import cats.effect.kernel.Sync

trait MealsController[F[_]] {
  def meals: F[Set[MealStub]]
  def mealNames: F[String]
}

object MealsController {
  def impl[F[_]: Applicative](
      usageData: UsageData[F]
  )(implicit F: Sync[F]): MealsController[F] =
    new MealsController[F] {
      override def meals: F[Set[MealStub]] =
        mealStubsWithUsageData[F](usageData)
      override def mealNames: F[String] =
        mealStubsWithUsageData[F](usageData).map(
          _.filter(_.isDinner)
            .map(_.name)
            .toSeq
            .sorted
            .mkString("\n")
        )
    }

  def mealStubsWithUsageData[F[_]: Sync](
      usageData: UsageData[F]
  ): F[Set[MealStub]] = {
    for {
      mealCount <- usageData.mealCount
      mealLastEaten <- usageData.mealLastEaten
    } yield MealDefinitions.mealStubs
      .map(meal => {
        val mealTimesEaten = mealCount.getOrElse(meal.name, 0)
        val mealWithCount = mealTimesEaten match {
          case 0 => meal.copy(tags = meal.tags + Tag.NeverEaten)
          case count if count <= 2 =>
            meal.copy(tags = meal.tags + Tag.Infrequent)
          case count if count >= 5 =>
            meal.copy(tags = meal.tags + Tag.Popular)
          case _ => meal
        }

        val mealWithUsageData = mealWithCount.copy(
          lastEaten = mealLastEaten.get(mealWithCount.name),
          timesEaten = Some(mealTimesEaten)
        )

        mealWithUsageData
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
