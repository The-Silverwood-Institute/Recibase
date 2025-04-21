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
import org.apache.commons.csv.{CSVFormat, CSVParser}
import scala.jdk.CollectionConverters._
import se.reciba.api.recibase.model.DatedNote

object UsageData {
  def apply[F[_]](implicit F: Async[F]): F[UsageData[F]] =
    AtomicCell[F].of(FetchedMealLogEntries.empty).map(new UsageData(_))

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

  def notes(logEntries: Set[MealLogEntry]): Map[String, List[DatedNote]] =
    logEntries.groupBy(_.mealName).map { case (mealName, entries) =>
      mealName -> entries
        .collect { case MealLogEntry(_, date, Some(note)) =>
          DatedNote(date, note)
        }
        .toList
        .sortBy(_.date)
    }

  val softRefreshTime = Duration.ofHours(12)
  val hardRefreshTime = Duration.ofHours(72)

}

class UsageData[F[_]: Async](
    ref: AtomicCell[F, FetchedMealLogEntries]
) {
  private val csvUrlOpt = sys.env.get("MEAL_LOG_CSV_URL")

  // .parse(Source.fromURL(sys.env.get("MEAL_LOG_CSV_URL").get).bufferedReader())
  private val csvReader =
    CSVFormat.RFC4180.builder().setHeader().setSkipHeaderRecord(true).get()

  private def getRawCsv = csvUrlOpt
    .map(Source.fromURL(_).bufferedReader())
    .map(csvReader.parse)

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

  private def parseCsv(parserOpt: Option[CSVParser]): Set[MealLogEntry] =
    parserOpt.fold[Set[MealLogEntry]](Set.empty)(parser => {
      parser
        .getRecords()
        .asScala
        .flatMap(record => {
          (record.get("Date"), record.get("Meal"), record.get("Notes")) match {
            case (_, "", _) => None
            case (rawDate, mealName, rawNote) =>
              MealLogEntry(mealName, rawDate, rawNote).toOption
          }
        })
        .toSet
    })

  def refreshMealLog: F[Unit] = cachedMealLogEntries(
    UsageData.softRefreshTime
  ).void
  def mealCount: F[Map[String, Int]] =
    cachedMealLogEntries(UsageData.hardRefreshTime).map(UsageData.totals)
  def mealLastEaten: F[Map[String, LocalDate]] =
    cachedMealLogEntries(UsageData.hardRefreshTime).map(UsageData.lastEaten)
  def mealNotes: F[Map[String, List[DatedNote]]] =
    cachedMealLogEntries(UsageData.hardRefreshTime).map(UsageData.notes)
}

final case class MealLogEntry(
    mealName: String,
    date: LocalDate,
    note: Option[String]
)

object MealLogEntry {
  def apply(
      mealName: String,
      rawDate: String,
      rawNote: String
  ): Try[MealLogEntry] = {
    val note = if (rawNote == "") None else Some(rawNote)
    UsageData.parseDate(rawDate).map(MealLogEntry(mealName, _, note))
  }
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
