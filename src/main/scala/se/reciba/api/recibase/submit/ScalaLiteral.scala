package se.reciba.api.submit

/** Quotes a string as a Scala `"..."` literal.
  *
  * Scala replaces `\uXXXX` escapes before it tokenises, including inside
  * strings, and one or more `u` characters are allowed. A user backslash must
  * never appear as a raw `\` in the file: a value such as `\u0022` would
  * otherwise close the literal during that pass. Backslash and quote are
  * therefore written as `\u005c` sequences that decode to ordinary string
  * escapes (`\\` and `\"`).
  */
object ScalaLiteral {
  def quote(raw: String): String = {
    val quoted = new StringBuilder(raw.length + 2)
    quoted.append('"')
    raw.foreach {
      case '"'  => quoted.append("\\u005c\\u0022")
      case '\\' => quoted.append("\\u005c\\u005c")
      case '\n' => quoted.append("\\n")
      case '\r' => quoted.append("\\r")
      case '\t' => quoted.append("\\t")
      case char => quoted.append(char)
    }
    quoted.append('"')
    quoted.toString
  }
}
