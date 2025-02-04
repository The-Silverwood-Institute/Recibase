package com.herokuapp.recibase

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import com.herokuapp.recibase.server.RecibaseServer
import com.herokuapp.recibase.usage.UsageData

object Main extends IOApp {
  def run(args: List[String]) = {
    for {
      usageData <- UsageData.apply[IO]
      exit <- RecibaseServer
        .stream[IO](usageData)
        .compile
        .drain
        .as(ExitCode.Success)
    } yield exit
  }
}
