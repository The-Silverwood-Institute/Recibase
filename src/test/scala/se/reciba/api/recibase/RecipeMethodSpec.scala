package se.reciba.api

import se.reciba.api.model.Recipe

class RecipeMethodSpec extends org.specs2.mutable.Specification {
  "recipes" >> {
    "end every method step with a full stop" >> {
      val offenders = Recipe.recipes.flatMap { recipe =>
        recipe.method.zipWithIndex.collect {
          case (step, index) if !step.trim.endsWith(".") =>
            s"${recipe.name} step ${index + 1}: $step"
        }
      }

      offenders must beEmpty
    }
  }
}
