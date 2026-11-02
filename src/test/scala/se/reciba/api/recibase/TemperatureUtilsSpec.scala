package se.reciba.api

import se.reciba.api.utils.IntUtils.TemperatureUtils

class TemperatureUtilsSpec extends org.specs2.mutable.Specification {
  "Temperature utils" should {
    "Convert celsius to a formatted string, rounding F to the nearest multiple of 5 and gas marks to an int" >> {
      190.celsius must beEqualTo(s"190°C (375°F, gas mark 5)")
    }

    "Convert fahrenheit to a formatted string, ignoring the gas mark if there's no clean conversion" >> {
      380.fahrenheit must beEqualTo(s"195°C (380°F)")
    }
  }
}
