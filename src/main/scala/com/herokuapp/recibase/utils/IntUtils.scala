package com.herokuapp.recibase.utils

object IntUtils {
  implicit class TemperatureUtils(t: Int) {
    def celius: String = {
      val fahrenheit = (t * 9 / 5) + 32

      s"$t°C ($fahrenheit°F)"
    }
  }
}
