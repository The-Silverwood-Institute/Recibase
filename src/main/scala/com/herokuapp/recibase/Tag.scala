package com.herokuapp.recibase

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed abstract class Tag(override val entryName: String) extends EnumEntry

object Tag extends Enum[Tag] with CirceEnum[Tag] {
  val values: IndexedSeq[Tag] = findValues

  case object Christmas extends Tag("Christmas")
  case object Pudding extends Tag("Pudding")
  case object Lunch extends Tag("Lunch")
  case object Baking extends Tag("Baking")

  case object Vegetarian extends Tag("Vegetarian")
  case object Soup extends Tag("Soup")
  case object Scales extends Tag("Scales")
  case object Freezes extends Tag("Freezes")
  case object BetterNextDay extends Tag("Better Next Day")
  case object Slow extends Tag("Slow")
  case object ColdWeather extends Tag("Cold Weather")
  case object Vegan extends Tag("Vegan")
  case object VeganIsh extends Tag("Vegan-ish")
  case object Spicy extends Tag("Spicy")
  case object Stodge extends Tag("Stodge")
  case object Quick extends Tag("Quick")
  case object VegetarianIsh extends Tag("Vegetarian-ish")
  case object HotWeather extends Tag("Hot Weather")
  case object Effort extends Tag("Effort")
  case object Pescatarian extends Tag("Pescatarian")
}
