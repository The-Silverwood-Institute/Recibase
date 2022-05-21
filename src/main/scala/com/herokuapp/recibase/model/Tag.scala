package com.herokuapp.recibase.model

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed abstract class Tag(override val entryName: String) extends EnumEntry

object Tag extends Enum[Tag] with CirceEnum[Tag] {
  val values: IndexedSeq[Tag] = findValues

  val nonDinnerTags: Set[Tag] = Set(
    Pudding,
    Lunch,
    Baking,
    NonMeal
  )

  // Meal types
  case object Christmas extends Tag("Christmas")
  case object Pudding extends Tag("Pudding")
  case object Lunch extends Tag("Lunch")
  case object Baking extends Tag("Baking")
  case object NonMeal extends Tag("Not a Meal")
  case object Soup extends Tag("Soup")

  // Dietary
  case object Vegan extends Tag("Vegan")
  case object VeganIsh extends Tag("Vegan-ish")
  case object Vegetarian extends Tag("Vegetarian")
  case object VegetarianIsh extends Tag("Vegetarian-ish")
  case object Pescatarian extends Tag("Pescatarian")

  // Vibe
  case object ColdWeather extends Tag("Cold Weather")
  case object HotWeather extends Tag("Hot Weather")
  case object Stodge extends Tag("Stodge")
  case object Spicy extends Tag("Spicy")

  // Making
  case object Slow extends Tag("Slow")
  case object Quick extends Tag("Quick")
  case object Scales extends Tag("Scales")
  case object HighEffort extends Tag("High Effort")
  case object LowEffort extends Tag("Low Effort")

  // Good to know
  case object Freezes extends Tag("Freezes")
  case object BetterNextDay extends Tag("Better Next Day")
}
