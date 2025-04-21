package se.reciba.api

import se.reciba.api.usage.{MealLogEntry, UsageData}

import java.time.LocalDate
import se.reciba.api.recibase.model.DatedNote

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
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 17), None),
        MealLogEntry("Beyond Burgers", LocalDate.of(2022, 2, 18), None),
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 19), None)
      )
    ) must_== Map(
      "Beyond Burgers" -> LocalDate.of(2022, 2, 18),
      "Macaroni" -> LocalDate.of(2022, 2, 19)
    )
  }

  "totals calculates how often meals have been eaten" >> {
    UsageData.totals(
      Set(
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 17), None),
        MealLogEntry("Beyond Burgers", LocalDate.of(2022, 2, 18), None),
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 19), None)
      )
    ) must_== Map(
      "Beyond Burgers" -> 1,
      "Macaroni" -> 2
    )
  }

  "aggregates notes made when making meals" >> {
    UsageData.notes(
      Set(
        MealLogEntry(
          "Macaroni",
          LocalDate.of(2022, 2, 17),
          Some("Add more cheese")
        ),
        MealLogEntry("Beyond Burgers", LocalDate.of(2022, 2, 18), None),
        MealLogEntry(
          "Macaroni",
          LocalDate.of(2022, 2, 19),
          Some("Try paprika on top before grilling")
        ),
        MealLogEntry("Macaroni", LocalDate.of(2022, 2, 20), None)
      )
    ) must_== Map(
      "Beyond Burgers" -> List.empty,
      "Macaroni" -> List(
        DatedNote(LocalDate.of(2022, 2, 17), "Add more cheese"),
        DatedNote(
          LocalDate.of(2022, 2, 19),
          "Try paprika on top before grilling"
        )
      )
    )
  }
}
