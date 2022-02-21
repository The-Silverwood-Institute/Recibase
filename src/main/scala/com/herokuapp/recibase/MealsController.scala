package com.herokuapp.recibase

import cats.Applicative
import cats.implicits._

trait MealsController[F[_]] {
  def meals: F[Set[MealStub]]
}

object MealsController {
  def impl[F[_]: Applicative]: MealsController[F] =
    new MealsController[F] {
      override def meals: F[Set[MealStub]] = Meal.meals.pure[F]
    }
}
