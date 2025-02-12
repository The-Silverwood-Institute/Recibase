package se.reciba.api.usage

import org.typelevel.log4cats.Logger

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.io.Source
import scala.util.{Failure, Success, Try}
import cats.implicits._
import java.time.Instant
import cats.FlatMap
import java.time.temporal.TemporalUnit
import java.time.temporal.ChronoUnit
import java.time.Duration
import cats.effect.std.AtomicCell
import cats.effect.kernel.Async

object UsageData {
  def apply[F[_]](implicit F: Async[F]): F[UsageData[F]] =
    for {
      cell <- AtomicCell[F].of(FetchedMealLogEntries.empty)
      usageData = new UsageData(cell)
      _ <- usageData.refreshMealLog
    } yield usageData

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

  val softRefreshTime = Duration.ofHours(12)
  val hardRefreshTime = Duration.ofHours(72)

}

class UsageData[F[_]: Async](
    ref: AtomicCell[F, FetchedMealLogEntries]
) {
  private val csvUrlOpt = sys.env.get("MEAL_LOG_CSV_URL")

  private def getRawCsv = csvUrlOpt
    .map(Source.fromURL)
    .map(_.getLines())
    .getOrElse(Iterator.empty)

  private val quotedMatcher = """^\"(.+)\",\"(.+)\",(.*)$""".r
  private val unquotedMatcher = """^\"(.+)\",(.+),(.*)$""".r

  private def cachedMealLogEntries(timeout: Duration): F[Set[MealLogEntry]] =
    ref
      .evalUpdateAndGet(lastFetched => {
        val dataIsStale =
          lastFetched.fetchedAt
            .isBefore(Instant.now().minus(timeout))
        if (dataIsStale) {
          println(
            s"Refreshing stale usage data: ${lastFetched.fetchedAt} vs now ${Instant.now()}, exceeds ${timeout.toHours()} hour timeout"
          )
          Async[F]
            .blocking(FetchedMealLogEntries(parseCsv(getRawCsv), Instant.now()))
        } else {
          lastFetched.pure[F]
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

  def refreshMealLog: F[Unit] = cachedMealLogEntries(
    UsageData.softRefreshTime
  ).void
  def mealCount: F[Map[String, Int]] =
    cachedMealLogEntries(UsageData.hardRefreshTime).map(UsageData.totals)
  def mealLastEaten: F[Map[String, LocalDate]] =
    cachedMealLogEntries(UsageData.hardRefreshTime).map(UsageData.lastEaten)
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
