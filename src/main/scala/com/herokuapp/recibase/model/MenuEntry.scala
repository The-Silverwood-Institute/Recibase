package com.herokuapp.recibase.model

import io.circe.generic.JsonCodec

@JsonCodec
case class MenuEntry(name: String, permalink: String)
