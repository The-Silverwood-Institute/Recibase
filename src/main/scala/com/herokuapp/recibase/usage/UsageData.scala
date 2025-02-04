package com.herokuapp.recibase.usage

import org.typelevel.log4cats.Logger

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.io.Source
import scala.util.{Failure, Success, Try}
import cats.effect.kernel.Sync
import cats.implicits._
import java.time.Instant
import cats.effect.kernel.Ref
import cats.Applicative
import cats.FlatMap
import java.time.temporal.TemporalUnit
import java.time.temporal.ChronoUnit
import java.time.Duration

object UsageData {
  def apply[F[_]](implicit F: Sync[F]): F[UsageData[F]] =
    Ref[F].of(FetchedMealLogEntries.empty).map(new UsageData(_))

  def parseDate(input: String): Try[LocalDate] = {
    Try {
      val rawDate = input.split(",")(1).trim
      LocalDate.parse(rawDate, DateTimeFormatter.ofPattern("d MMMM yy"))
    }
  }

  def lastEaten(logEntries: Set[MealLogEntry]): Map[String, LocalDate] =
    logEntries.groupMapReduce(_.mealName)(_.date) {
      case (left, right) if left.isAfter(right) => left
      case (_, right)                           => right
    }

  def totals(logEntries: Set[MealLogEntry]): Map[String, Int] =
    logEntries.groupBy(_.mealName).map { case (mealName, dates) =>
      mealName -> dates.size
    }

  val refreshUsageDataAfter = Duration.ofHours(12)

}

class UsageData[F[_]: Sync: Applicative](ref: Ref[F, FetchedMealLogEntries]) {
  private val csvUrlOpt = sys.env.get("MEAL_LOG_CSV_URL")

  private def getRawCsv = csvUrlOpt
    .map(Source.fromURL)
    .map(_.getLines())
    .getOrElse(Iterator.empty)

  private val quotedMatcher = """^\"(.+)\",\"(.+)\",(.*)$""".r
  private val unquotedMatcher = """^\"(.+)\",(.+),(.*)$""".r

  private def mealLogEntries: F[Set[MealLogEntry]] = ref
    .updateAndGet(lastFetched => {
      val dataIsStale =
        lastFetched.fetchedAt
          .isBefore(Instant.now().minus(UsageData.refreshUsageDataAfter))
      if (dataIsStale) {
        println("Refreshing stale usage data")
        // Nasty undeclared side-effecting blocking operation, ew
        FetchedMealLogEntries(parseCsv(getRawCsv), Instant.now())
      } else {
        lastFetched
      }
    })
    .map(_.entries)

  private def parseCsv(raw: Iterator[String]): Set[MealLogEntry] = raw
    .map {
      case quotedMatcher(rawDate, name, _)   => MealLogEntry(name, rawDate)
      case unquotedMatcher(rawDate, name, _) => MealLogEntry(name, rawDate)
      case unknown => Failure(InvalidMealLogCsvRow(unknown))
    }
    .flatMap {
      case Success(entry) => Some(entry)
      case Failure(_)     =>
//        println(exception.getMessage)
        None
    }
    .toSet

  def mealCount: F[Map[String, Int]] =
    mealLogEntries.map(UsageData.totals)
  def mealLastEaten: F[Map[String, LocalDate]] =
    mealLogEntries.map(UsageData.lastEaten)
}

final case class MealLogEntry(mealName: String, date: LocalDate)

object MealLogEntry {
  def apply(mealName: String, rawDate: String): Try[MealLogEntry] =
    UsageData.parseDate(rawDate).map(MealLogEntry(mealName, _))
}

case class FetchedMealLogEntries(entries: Set[MealLogEntry], fetchedAt: Instant)

object FetchedMealLogEntries {
  def empty: FetchedMealLogEntries =
    FetchedMealLogEntries(Set.empty, Instant.MIN)
}

final case class InvalidMealLogCsvRow(row: String)
    extends IllegalArgumentException(
      s"Failed to parse meal log CSV row: $row"
    )
