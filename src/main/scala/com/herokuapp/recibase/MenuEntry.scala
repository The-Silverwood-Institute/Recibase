package com.herokuapp.recibase

import io.circe.generic.JsonCodec

@JsonCodec
case class MenuEntry(name: String, permalink: String)
