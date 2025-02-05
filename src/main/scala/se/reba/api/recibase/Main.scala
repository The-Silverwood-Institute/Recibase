package se.reciba.api

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import se.reciba.api.server.RecibaseServer
import se.reciba.api.usage.UsageData

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
