package se.reciba.api

import se.reciba.api.usage.{MealLogEntry, UsageData}

import java.time.LocalDate

class UsageDataSpec extends org.specs2.mutable.Specification {
  "date parser correctly parses date strings" >> {
    UsageData.parseDate("Thursday, 17 February 22") must beSuccessfulTry(
      LocalDate.of(2022, 2, 17)
    )

    UsageData.parseDate("Friday, 8 December 23") must beSuccessfulTry(
      LocalDate.of(2023, 12, 8)
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
