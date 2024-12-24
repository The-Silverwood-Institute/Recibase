package com.herokuapp.recibase

import com.herokuapp.recibase.utils.IntUtils._

class TemperatureUtilsSpec extends org.specs2.mutable.Specification {
  "Temperature utils" should {
    "Convert celsius to a formatted string, rounding F to the nearest multiple of 5 and gas marks to an int" >> {
      190.celsius must_== s"190°C (375°F, gas mark 5)"
    }

    "Convert fahrenheit to a formatted string, ignoring the gas mark if there's no clean conversion" >> {
      380.fahrenheit must_== s"195°C (380°F)"
    }
  }
}
