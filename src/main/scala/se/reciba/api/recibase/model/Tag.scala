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
  case object Stephani extends TagCategory("stephani")
  case object Vibe extends TagCategory("vibe")
  case object Making extends TagCategory("making")
  case object Practical extends TagCategory("practical")

  // Added by the server from usage data. Recipes and meal stubs must not set these.
  case object Usage extends TagCategory("usage")
}

sealed abstract class Tag(
    override val entryName: String,
    val category: TagCategory
) extends EnumEntry {
  def description: Option[String] = None

  def superset: Option[Tag] = None

  def impliedTags: Set[Tag] = {
    def walk(remaining: Set[Tag], seen: Set[Tag]): Set[Tag] =
      if (remaining.isEmpty) seen
      else {
        val next = remaining.flatMap(_.superset.toSet).diff(seen)
        walk(next, seen ++ remaining)
      }

    walk(superset.toSet, Set.empty)
  }
}

object Tag extends Enum[Tag] with CirceEnum[Tag] {
  val values: IndexedSeq[Tag] = findValues

  val excludeFromMealPlannerTags: Set[Tag] = Set(
    Pudding,
    Baking,
    ExcludeFromMealPlanner
  )

  // Meal types
  case object Christmas extends Tag("Christmas", TagCategory.Meal)
  case object Pudding extends Tag("Pudding", TagCategory.Meal)
  case object Lunch extends Tag("Lunch", TagCategory.Meal) {
    override def description: Option[String] =
      "Typically a lunch dish, sometimes eaten for dinner".some
  }
  case object Baking extends Tag("Baking", TagCategory.Meal) {
    override def description: Option[String] =
      "A baked good like a cake".some
  }
  case object IncludeInMealPlanner
      extends Tag(
        "Ensures recipe is included in meal planner. Only use if necessary.",
        TagCategory.Meal
      )
  case object ExcludeFromMealPlanner
      extends Tag(
        "Ensures recipe is excluded from meal planner. Only use if necessary.",
        TagCategory.Meal
      )
  case object Soup extends Tag("Soup", TagCategory.Meal)

  // Dietary. Each tag's superset is the next, looser tag.
  case object Vegan extends Tag("Vegan", TagCategory.Diet) {
    override def description: Option[String] = "No animal products".some
    override def superset: Option[Tag] = VeganIsh.some
  }
  case object VeganIsh extends Tag("Vegan-ish", TagCategory.Diet) {
    override def description: Option[String] =
      "Can make vegan with minimal changes".some
    override def superset: Option[Tag] = Vegetarian.some
  }
  case object Vegetarian extends Tag("Vegetarian", TagCategory.Diet) {
    override def description: Option[String] = "No meat or fish".some
    override def superset: Option[Tag] = VegetarianIsh.some
  }
  case object VegetarianIsh extends Tag("Vegetarian-ish", TagCategory.Diet) {
    override def description: Option[String] =
      "Can make vegetarian with minimal changes".some
    override def superset: Option[Tag] = Pescatarian.some
  }
  case object Pescatarian extends Tag("Pescatarian", TagCategory.Diet) {
    override def description: Option[String] =
      "Contains fish but not meat".some
  }
  case object GlutenFree extends Tag("Gluten-Free", TagCategory.Diet)

  // Stephani dietary preferences
  case object StephaniUnhealthy
      extends Tag("StephaniUnhealthy", TagCategory.Stephani) {
    override def description: Option[String] =
      "Contains no Stephani allergens but low on nutrients".some
  }
  case object StephaniIsh extends Tag("Stephani-ish", TagCategory.Stephani) {
    override def description: Option[String] =
      "Can make Stephani compatible with minimal changes".some
    override def superset: Option[Tag] = StephaniUnhealthy.some
  }
  case object Stephani extends Tag("Stephani", TagCategory.Stephani) {
    override def description: Option[String] =
      "Contains no Stephani allergens".some
    override def superset: Option[Tag] = StephaniIsh.some
  }

  // Vibe
  case object ColdWeather extends Tag("Cold Weather", TagCategory.Vibe) {
    override def description: Option[String] = "Suited to winter".some
  }
  case object HotWeather extends Tag("Hot Weather", TagCategory.Vibe) {
    override def description: Option[String] = "Suited to hot summer".some
  }
  case object Stodge extends Tag("Stodge", TagCategory.Vibe) {
    override def description: Option[String] =
      "Hearty and filling but not healthy".some
  }
  case object Spicy extends Tag("Spicy", TagCategory.Vibe) {
    override def description: Option[String] =
      "Hot, rather than just aromatic".some
  }

  // Making
  case object Slow extends Tag("Slow", TagCategory.Making) {
    override def description: Option[String] =
      "Takes a long time to cook, including baking/simmering".some
  }
  case object Quick extends Tag("Quick", TagCategory.Making) {
    override def description: Option[String] =
      "Under 25 minutes from start to serving".some
  }
  case object Scales extends Tag("Scales", TagCategory.Making) {
    override def description: Option[String] =
      "Easy to scale up to many servings".some
  }
  case object HighEffort extends Tag("High Effort", TagCategory.Making) {
    override def description: Option[String] = "Takes a lot of work".some
  }
  case object LowEffort extends Tag("Low Effort", TagCategory.Making) {
    override def description: Option[String] =
      "Only a few steps, no major preparation".some
  }

  // Good to know
  case object Freezes extends Tag("Freezes", TagCategory.Practical) {
    override def description: Option[String] = "Keeps well in the freezer".some
  }
  case object BetterNextDay
      extends Tag("Better Next Day", TagCategory.Practical) {
    override def description: Option[String] =
      "Benefits from a cool/reheat cycle".some
  }
  case object AI extends Tag("AI", TagCategory.Practical) {
    override def description: Option[String] =
      "The recipe text was drafted with AI, double check for slop".some
  }

  // Usage. These are added to meals automatically.
  case object NeverEaten extends Tag("Never Eaten", TagCategory.Usage) {
    override def description: Option[String] = "Never eaten for dinner".some
  }
  case object Popular extends Tag("Popular", TagCategory.Usage) {
    override def description: Option[String] =
      "Eaten for dinner at least five times".some
  }
  case object Infrequent extends Tag("Infrequent", TagCategory.Usage) {
    override def description: Option[String] =
      "Eaten for dinner once or twice".some
  }
  case object New extends Tag("New", TagCategory.Usage) {
    override def description: Option[String] =
      s"Added in the last $newTagMonths months".some

    private val newTagMonths: Int = 12

    def applies(createdAt: Option[LocalDate], today: LocalDate): Boolean =
      createdAt.exists(_.isAfter(today.minusMonths(newTagMonths)))
  }
}
