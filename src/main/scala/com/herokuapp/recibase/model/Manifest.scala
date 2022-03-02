package com.herokuapp.recibase.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Manifest(version: String)
