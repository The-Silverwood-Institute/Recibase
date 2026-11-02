package se.reciba.api.recibase.model

import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.semiauto._

import java.time.LocalDate

final case class DatedNote(date: LocalDate, note: String)

object DatedNote {
  implicit val stubEncoder: Encoder[DatedNote] = deriveEncoder[DatedNote]
  implicit val stubDecoder: Decoder[DatedNote] = deriveDecoder[DatedNote]
}
