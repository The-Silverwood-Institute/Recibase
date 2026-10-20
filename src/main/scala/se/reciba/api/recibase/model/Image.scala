package se.reciba.api.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class Image(src: String, width: Int = 1080, height: Int = 1080)

object Image {
  implicit val encodeImage: Encoder[Image] = deriveEncoder
  implicit val decodeImage: Decoder[Image] = deriveDecoder
}
