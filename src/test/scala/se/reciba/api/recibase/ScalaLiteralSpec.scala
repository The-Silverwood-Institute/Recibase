package se.reciba.api

import se.reciba.api.submit.ScalaLiteral

class ScalaLiteralSpec extends org.specs2.mutable.Specification {
  "quote" >> {
    "round trips through Scala's unicode pass and string escapes" >> {
      samples.foreach { raw =>
        decode(ScalaLiteral.quote(raw)) must beEqualTo(raw)
      }
      ok
    }

    "never leaves a raw quote or a user backslash in the literal" >> {
      samples.foreach { raw =>
        structural(ScalaLiteral.quote(raw)) must beTrue
      }
      ok
    }
  }

  // Built with concatenation so the compiler's own `\u` pass cannot rewrite them.
  private val slash = "\\"
  private val samples = List(
    "",
    "plain",
    "purée",
    "quote\"here",
    "back" + slash + "slash",
    "line\nbreak",
    "tab\there",
    "cr\rhere",
    "${180.celsius}",
    "\"\"\"",
    slash + "u0022; evil; " + slash + "u0022",
    slash + "u005c" + slash + "u0022",
    slash + "uu0022",
    slash + slash,
    "say \"hi\""
  )

  // Scala translates `\u` escapes, including `\uuXXXX`, before tokenising,
  // and does not rescan the result.
  private def unicodePass(source: String): String = {
    val out = new StringBuilder
    var index = 0
    while (index < source.length) {
      val multiU =
        source.charAt(index) == '\\' &&
          index + 1 < source.length &&
          source.charAt(index + 1) == 'u'
      if (multiU) {
        var hex = index + 2
        while (hex < source.length && source.charAt(hex) == 'u') hex += 1
        val complete = hex + 4 <= source.length &&
          (0 until 4).forall(offset => isHex(source.charAt(hex + offset)))
        if (complete) {
          out.append(
            Integer.parseInt(source.substring(hex, hex + 4), 16).toChar
          )
          index = hex + 4
        } else {
          out.append(source.charAt(index))
          index += 1
        }
      } else {
        out.append(source.charAt(index))
        index += 1
      }
    }
    out.toString
  }

  private def decode(quoted: String): String = {
    val source = unicodePass(quoted)
    val out = new StringBuilder
    var index = 1
    while (index < source.length) {
      source.charAt(index) match {
        case '"' =>
          if (index != source.length - 1)
            throw new IllegalArgumentException(quoted)
          return out.toString
        case '\\' =>
          source.charAt(index + 1) match {
            case '\\'  => out.append('\\')
            case '"'   => out.append('"')
            case 'n'   => out.append('\n')
            case 'r'   => out.append('\r')
            case 't'   => out.append('\t')
            case other =>
              throw new IllegalArgumentException(
                s"bad escape $other in $quoted"
              )
          }
          index += 2
        case char =>
          out.append(char)
          index += 1
      }
    }
    throw new IllegalArgumentException(s"unterminated $quoted")
  }

  private def structural(quoted: String): Boolean = {
    quoted.startsWith("\"") &&
    quoted.endsWith("\"") && {
      val inner = quoted.substring(1, quoted.length - 1)
      var index = 0
      var ok = true
      while (index < inner.length && ok) {
        inner.charAt(index) match {
          case '"'  => ok = false
          case '\\' =>
            val rest = inner.substring(index)
            if (
              rest
                .startsWith(slash + "u005c") || rest.startsWith(slash + "u0022")
            )
              index += 6
            else if (
              rest.startsWith(slash + "n") ||
              rest.startsWith(slash + "r") ||
              rest.startsWith(slash + "t")
            ) index += 2
            else ok = false
          case _ => index += 1
        }
      }
      ok && index == inner.length
    }
  }

  private def isHex(char: Char): Boolean =
    (char >= '0' && char <= '9') ||
      (char >= 'a' && char <= 'f') ||
      (char >= 'A' && char <= 'F')
}
