package com.herokuapp.recibase

import com.herokuapp.recibase.usage.{MealLogEntry, UsageData}

import java.time.LocalDate

class UsageDataSpec extends org.specs2.mutable.Specification {
  "date parser correctly parses a date string" >> {
    UsageData.parseDate("Thursday, 17 February 22") must beSuccessfulTry(
      LocalDate.of(2022, 2, 17)
    )
  }

  "lastEaten calculates the most recent date a meal was eaten" >> {
    UsageData.lastEaten(
      Set(
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 17)),
        MealLogEntry("Beyond Burgers", LocalDate.of(2022, 2, 18)),
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 19))
      )
    ) must_== Map(
      "Beyond Burgers" -> LocalDate.of(2022, 2, 18),
      "Macaroni" -> LocalDate.of(2022, 2, 19)
    )
  }

  "totals calculates how often meals have been eaten" >> {
    UsageData.totals(
      Set(
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 17)),
        MealLogEntry("Beyond Burgers", LocalDate.of(2022, 2, 18)),
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 19))
      )
    ) must_== Map(
      "Beyond Burgers" -> 1,
      "Macaroni" -> 2
    )
  }
}
