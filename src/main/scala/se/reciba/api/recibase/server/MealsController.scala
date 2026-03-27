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
import java.time.LocalDate

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
        val extraFrequencyTags = mealTimesEaten match {
          // Non-dinner items shouldn't be assigned usage tags because they are misleading
          case _ if !meal.isDinner => Set.empty
          case 0                   => Set(Tag.NeverEaten)
          case count if count <= 2 =>
            Set(Tag.Infrequent)
          case count if count >= 5 =>
            Set(Tag.Popular)
          case _ => Set.empty
        }
        val extraRecencyTags =
          meal.createdAt.map(_.isAfter(LocalDate.now().minusMonths(12))) match {
            case Some(true) => Set(Tag.New)
            case _          => Set.empty
          }

        MealStubWithUsageData(
          meal.name,
          meal.tags ++ extraFrequencyTags ++ extraRecencyTags,
          meal.source,
          mealNotes.getOrElse(meal.name, List.empty),
          mealLastEaten.get(meal.name),
          mealTimesEaten
        )
      })
  }

  private val duplicates =
    MealDefinitions.mealStubs.toList
      .map(_.name.toLowerCase)
      .groupBy(identity)
      .flatMap {
        case (key, occurrences) if occurrences.length > 1 => key.some
        case _                                            => None
      }

  if (duplicates.nonEmpty) {
    throw new Exception(s"Duplicate meal names: ${duplicates.mkString(", ")}")
  }
}
