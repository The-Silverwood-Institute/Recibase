package se.reciba.api.recibase.model

import java.time.LocalDate
import io.circe.Encoder
import io.circe.generic.semiauto._

final case class DatedNote(date: LocalDate, note: String)

object DatedNote {
  implicit val stubEncoder: Encoder[DatedNote] = deriveEncoder[DatedNote]
}
