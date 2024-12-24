package com.herokuapp.recibase.utils

object IntUtils {
  implicit class TemperatureUtils(t: Int) {
    def celsius: String = {
      val asFahrenheit = (t.toFloat * 9 / 5) + 32
      val roundedFahrenheit = nearestMultipleOf(asFahrenheit, 5)
      val gasMark = celsiusToGasMark(t)

      formattedTemperatureString(t, roundedFahrenheit, gasMark)
    }

    def fahrenheit: String = {
      val asCelsius = (t - 32) * 5f / 9
      val roundedCelsuis = nearestMultipleOf(asCelsius, 5)
      val gasMark = celsiusToGasMark(roundedCelsuis)

      formattedTemperatureString(roundedCelsuis, t, gasMark)
    }

  }

  private def celsiusToGasMark(c: Int): Option[String] = {
    val conversions = Map(
      140 -> "1",
      150 -> "2",
      160 -> "3",
      170 -> "3.5",
      180 -> "4",
      190 -> "5",
      200 -> "6",
      210 -> "7",
      220 -> "8",
      230 -> "8.5",
      240 -> "9"
    )

    conversions.get(c)
  }

  private def nearestMultipleOf(in: Float, of: Int): Int =
    of * (Math.round(in / of))
  private def formattedTemperatureString(
      c: Int,
      f: Int,
      gM: Option[String]
  ): String = {
    val formattedGasMark = gM.map(g => s", gas mark $g").getOrElse("")
    s"$c°C ($f°F$formattedGasMark)"
  }
}
