package com.herokuapp.recibase.server

import cats.Applicative
import cats.implicits._
import com.herokuapp.recibase.model.{Meal, MealStub}

trait MealsController[F[_]] {
  def meals: F[Set[MealStub]]
  def mealNames: F[String]
}

object MealsController {
  def impl[F[_]: Applicative]: MealsController[F] =
    new MealsController[F] {
      override def meals: F[Set[MealStub]] = Meal.meals.pure[F]
      override def mealNames: F[String] =
        Meal.meals.map(_.name).toSeq.sorted.mkString("\n").pure[F]
    }
}
