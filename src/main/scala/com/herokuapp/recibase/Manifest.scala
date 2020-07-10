package com.herokuapp.recibase

import io.circe.generic.JsonCodec

@JsonCodec
case class Manifest (version: String)
