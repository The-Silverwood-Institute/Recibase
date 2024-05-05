package com.herokuapp.recibase.usage

import org.typelevel.log4cats.Logger

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.io.Source
import scala.util.{Failure, Success, Try}

object UsageData {
  private val rawCsv = sys.env
    .get("MEAL_LOG_CSV_URL")
    .map(Source.fromURL)
    .map(_.getLines())
    .getOrElse(Iterator.empty)

  private val quotedMatcher = """^\"(.+)\",\"(.+)\",(.*)$""".r
  private val unquotedMatcher = """^\"(.+)\",(.+),(.*)$""".r

  private val mealLogEntries = rawCsv
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

  val mealCount: Map[String, Int] = totals(mealLogEntries)
  val mealLastEaten: Map[String, LocalDate] = lastEaten(mealLogEntries)

  def parseDate(input: String): Try[LocalDate] = {
    Try {
      val rawDate = input.split(",")(1).trim
      LocalDate.parse(rawDate, DateTimeFormatter.ofPattern("dd MMMM yy"))
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

  final case class InvalidMealLogCsvRow(row: String)
      extends IllegalArgumentException(
        s"Failed to parse meal log CSV row: $row"
      )
}

final case class MealLogEntry(mealName: String, date: LocalDate)

object MealLogEntry {
  def apply(mealName: String, rawDate: String): Try[MealLogEntry] =
    UsageData.parseDate(rawDate).map(MealLogEntry(mealName, _))
}
