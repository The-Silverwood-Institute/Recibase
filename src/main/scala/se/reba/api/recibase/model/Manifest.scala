package se.reciba.api.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Manifest(version: String)
