package se.reciba.api.model

import io.circe.generic.JsonCodec

@JsonCodec
case class MenuEntry(name: String, permalink: String)
