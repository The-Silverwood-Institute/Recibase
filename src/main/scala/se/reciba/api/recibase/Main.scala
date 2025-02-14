package se.reciba.api

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import se.reciba.api.server.RecibaseServer
import se.reba.api.recibase.server.RecibaseMaintenance
import se.reciba.api.usage.UsageData

object Main extends IOApp {
  def run(args: List[String]) = {

    for {
      usageData <- UsageData.apply[IO]
      _ <- RecibaseServer
        .stream[IO](usageData)
        .concurrently(
          RecibaseMaintenance.stream[IO](usageData)
        )
        .compile
        .drain
    } yield ExitCode.Success
  }
}
