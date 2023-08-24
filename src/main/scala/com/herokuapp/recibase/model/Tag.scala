package com.herokuapp.recibase.model

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed abstract class Tag(override val entryName: String) extends EnumEntry {
  val parentTag: Option[Tag] = None

  def allParentTags: Set[Tag] = parentTag match {
    case Some(parent) => parent.allParentTags + parent
    case None         => Set.empty
  }
}

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
  case object VeganIsh extends Tag("Vegan-ish") {
    override val parentTag: Option[Tag] = Some(Vegan)
  }
  case object Vegetarian extends Tag("Vegetarian") {
    override val parentTag: Option[Tag] = Some(VeganIsh)
  }
  case object VegetarianIsh extends Tag("Vegetarian-ish") {
    override val parentTag: Option[Tag] = Some(Vegetarian)
  }
  case object Pescatarian extends Tag("Pescatarian") {
    override val parentTag: Option[Tag] = Some(VegetarianIsh)
  }

  // Vibe
  case object ColdWeather extends Tag("Cold Weather")
  case object HotWeather extends Tag("Hot Weather")
  case object Stodge extends Tag("Stodge")
  case object Spicy extends Tag("Spicy") // As in hot not aromatic

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
