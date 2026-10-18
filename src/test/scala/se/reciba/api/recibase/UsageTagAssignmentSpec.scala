package se.reciba.api

import se.reciba.api.model.{Recipe, TagCategory}

class UsageTagAssignmentSpec extends org.specs2.mutable.Specification {
  "recipes" >> {
    "do not assign usage tags directly" >> {
      val offenders = Recipe.recipes.flatMap { recipe =>
        recipe.tags.filter(_.category == TagCategory.Usage).map { tag =>
          s"${recipe.name}: ${tag.entryName}"
        }
      }

      offenders must beEmpty
    }
  }
}
