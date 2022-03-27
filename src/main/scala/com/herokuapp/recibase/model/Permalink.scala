package com.herokuapp.recibase.model

import org.apache.commons.lang3.StringUtils

case class Permalink(value: String)

object Permalink {
  def fromRawString(raw: String): Permalink = {
    // "fôô AND  bär!"
    val lowered = raw.toLowerCase
    // "fôô and  bär!"
    val lowerNoAccents = StringUtils.stripAccents(lowered)
    // "foo and  bar!"
    val latinOnly = lowerNoAccents.replaceAll("[^a-z -]", "")
    // "foo and  bar"
    val noAndWord =
      latinOnly.split(' ').filterNot(StopWords.words.contains).mkString(" ")
    // "foo  bar"
    val noWhiteSpaceBlocks = StringUtils.normalizeSpace(noAndWord)
    // "foo bar"
    val substitutedWhitespace = noWhiteSpaceBlocks.replace(' ', '-')
    // "foo-bar"
    Permalink(substitutedWhitespace)
  }
}
