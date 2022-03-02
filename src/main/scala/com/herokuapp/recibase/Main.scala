package com.herokuapp.recibase

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import com.herokuapp.recibase.server.RecibaseServer

object Main extends IOApp {
  def run(args: List[String]) =
    RecibaseServer.stream[IO].compile.drain.as(ExitCode.Success)
}
