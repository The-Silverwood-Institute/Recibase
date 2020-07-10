package com.herokuapp.recibase

object StringUtils {
  // TODO: Replace this with proper stemming/recipe search
  implicit class PluralUtils(s: String) {
    def unpluralise: String =
      if (s.endsWith("s"))
        s.stripSuffix("s")
      else
        s.stripSuffix("es")
  }
}
