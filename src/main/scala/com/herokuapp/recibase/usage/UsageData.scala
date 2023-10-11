package com.herokuapp.recibase.usage

import scala.io.Source

object UsageData {
  private val rawPopularityData = sys.env
    .get("MEAL_LOG_CSV_URL")
    .map(Source.fromURL)
    .map(_.getLines())
    .getOrElse(Iterator.empty)

  private val quotedMatcher = """^\"(.+)\",([0-9]*)$""".r
  private val unquotedMatcher = """^(.+),([0-9]*)$""".r

  val mealCount: Map[String, Int] = rawPopularityData.flatMap {
    case quotedMatcher(name, count)   => Some(name -> parseInt(count))
    case unquotedMatcher(name, count) => Some(name -> parseInt(count))
    case unknown => {
      println(s"Failed to parse meal name: $unknown")
      None
    }
  }.toMap

  def parseInt(in: String): Int = {
    if (in.nonEmpty) in.toInt
    else 0
  }
}
