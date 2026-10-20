package se.reciba.api.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class MenuEntry(name: String, permalink: String)

object MenuEntry {
  implicit val encodeMenuEntry: Encoder[MenuEntry] = deriveEncoder
  implicit val decodeMenuEntry: Decoder[MenuEntry] = deriveDecoder
}
