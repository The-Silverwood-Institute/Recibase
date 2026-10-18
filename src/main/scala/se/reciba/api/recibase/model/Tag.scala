package se.reciba.api.model

import cats.syntax.option._
import enumeratum.{CirceEnum, Enum, EnumEntry}

import java.time.LocalDate

sealed abstract class TagCategory(override val entryName: String)
    extends EnumEntry

object TagCategory extends Enum[TagCategory] with CirceEnum[TagCategory] {
  val values: IndexedSeq[TagCategory] = findValues

  case object Meal extends TagCategory("meal")
  case object Diet extends TagCategory("diet")
  case object Preference extends TagCategory("preference")
  case object Vibe extends TagCategory("vibe")
  case object Making extends TagCategory("making")
  case object Practical extends TagCategory("practical")

  // Added by the server from usage data. Recipes and meal stubs must not set these.
  case object Usage extends TagCategory("usage")
}

sealed abstract class Tag(
    override val entryName: String,
    val category: TagCategory,
    val description: Option[String] = None
) extends EnumEntry {
  def inherits: Set[Tag] = Set.empty

  def inheritedTags: Set[Tag] = {
    def walk(remaining: Set[Tag], seen: Set[Tag]): Set[Tag] =
      if (remaining.isEmpty) seen
      else {
        val next = remaining.flatMap(_.inherits).diff(seen)
        walk(next, seen ++ remaining)
      }

    walk(inherits, Set.empty)
  }
}

object Tag extends Enum[Tag] with CirceEnum[Tag] {
  private val newTagMonths: Int = 12

  val values: IndexedSeq[Tag] = findValues

  def displayNames(tags: Set[Tag]): List[String] =
    values.filter(tags.contains).map(_.entryName).toList

  val excludeFromMealPlannerTags: Set[Tag] = Set(
    Pudding,
    Baking,
    ExcludeFromMealPlanner
  )

  // Meal types
  case object Christmas
      extends Tag(
        "Christmas",
        TagCategory.Meal,
        None
      )
  case object Pudding
      extends Tag(
        "Pudding",
        TagCategory.Meal,
        None
      )
  case object Lunch
      extends Tag(
        "Lunch",
        TagCategory.Meal,
        "Typically a lunch dish, sometimes eaten for dinner".some
      )
  case object Baking
      extends Tag(
        "Baking",
        TagCategory.Meal,
        "A baked good like a cake".some
      )
  case object IncludeInMealPlanner
      extends Tag(
        "Overrides logic and ensures recipe is included in meal planner",
        TagCategory.Meal,
        None
      )
  case object ExcludeFromMealPlanner
      extends Tag(
        "Overrides logic and ensures recipe is excluded from meal planner",
        TagCategory.Meal,
        None
      )
  case object Soup
      extends Tag(
        "Soup",
        TagCategory.Meal,
        None
      )

  // Dietary. Each tag inherits the next, looser one.
  case object Vegan
      extends Tag(
        "Vegan",
        TagCategory.Diet,
        "No animal products".some
      ) {
    override def inherits: Set[Tag] = Set(VeganIsh)
  }
  case object VeganIsh
      extends Tag(
        "Vegan-ish",
        TagCategory.Diet,
        "Can make vegan with minimal changes".some
      ) {
    override def inherits: Set[Tag] = Set(Vegetarian)
  }
  case object Vegetarian
      extends Tag(
        "Vegetarian",
        TagCategory.Diet,
        "No meat or fish".some
      ) {
    override def inherits: Set[Tag] = Set(VegetarianIsh)
  }
  case object VegetarianIsh
      extends Tag(
        "Vegetarian-ish",
        TagCategory.Diet,
        "Can make vegetarian with minimal changes".some
      ) {
    override def inherits: Set[Tag] = Set(Pescatarian)
  }
  case object Pescatarian
      extends Tag(
        "Pescatarian",
        TagCategory.Diet,
        "Contains fish but not meat".some
      )
  case object GlutenFree
      extends Tag(
        "Gluten-Free",
        TagCategory.Diet,
        None
      )

  // Preference
  case object StephaniUnhealthy
      extends Tag(
        "StephaniUnhealthy",
        TagCategory.Preference,
        "Contains no Stephani allergens but low on nutrients".some
      ) {
    override def inherits: Set[Tag] = Set(StephaniIsh)
  }
  case object StephaniIsh
      extends Tag(
        "Stephani-ish",
        TagCategory.Preference,
        "Can make Stephani compatible with minimal changes".some
      ) {
    override def inherits: Set[Tag] = Set(Stephani)
  }
  case object Stephani
      extends Tag(
        "Stephani",
        TagCategory.Preference,
        "Contains no Stephani allergens".some
      )

  // Vibe
  case object ColdWeather
      extends Tag(
        "Cold Weather",
        TagCategory.Vibe,
        "Suited to winter".some
      )
  case object HotWeather
      extends Tag(
        "Hot Weather",
        TagCategory.Vibe,
        "Suited to hot summer".some
      )
  case object Stodge
      extends Tag(
        "Stodge",
        TagCategory.Vibe,
        "Hearty and filling but not healthy".some
      )
  case object Spicy
      extends Tag(
        "Spicy",
        TagCategory.Vibe,
        "Hot, rather than just aromatic".some
      )

  // Making
  case object Slow
      extends Tag(
        "Slow",
        TagCategory.Making,
        "Takes a long time to cook, including baking/simmering".some
      )
  case object Quick
      extends Tag(
        "Quick",
        TagCategory.Making,
        "Under 25 minutes from start to serving".some
      )
  case object Scales
      extends Tag(
        "Scales",
        TagCategory.Making,
        "Easy to scale up to many servings".some
      )
  case object HighEffort
      extends Tag(
        "High Effort",
        TagCategory.Making,
        "Takes a lot of work".some
      )
  case object LowEffort
      extends Tag(
        "Low Effort",
        TagCategory.Making,
        "Only a few steps, no major preparation".some
      )

  // Good to know
  case object Freezes
      extends Tag(
        "Freezes",
        TagCategory.Practical,
        "Keeps well in the freezer".some
      )
  case object BetterNextDay
      extends Tag(
        "Better Next Day",
        TagCategory.Practical,
        "Benefits from a cool/reheat cycle".some
      )
  case object AI
      extends Tag(
        "AI",
        TagCategory.Practical,
        "The recipe text was drafted with AI, double check for slop".some
      )

  // Usage. These are added to meals automatically.
  case object NeverEaten
      extends Tag(
        "Never Eaten",
        TagCategory.Usage,
        "Never eaten for dinner".some
      )
  case object Popular
      extends Tag(
        "Popular",
        TagCategory.Usage,
        "Eaten for dinner at least five times".some
      )
  case object Infrequent
      extends Tag(
        "Infrequent",
        TagCategory.Usage,
        "Eaten for dinner once or twice".some
      )
  case object New
      extends Tag(
        "New",
        TagCategory.Usage,
        s"Added in the last $newTagMonths months".some
      ) {

    def applies(createdAt: Option[LocalDate], today: LocalDate): Boolean =
      createdAt.exists(_.isAfter(today.minusMonths(newTagMonths)))
  }
}
