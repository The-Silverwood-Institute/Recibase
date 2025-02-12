package se.reciba.api

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import fs2._
import se.reciba.api.server.RecibaseServer
import se.reciba.api.usage.UsageData
import scala.jdk.DurationConverters._
import scala.concurrent.duration._

object Main extends IOApp {
  def run(args: List[String]) = {

    for {
      usageData <- UsageData.apply[IO]
      _ <- RecibaseServer
        .stream[IO](usageData)
        .concurrently(
          Stream
            .awakeEvery[IO](30 minutes)
            .flatMap(_ => Stream.eval(usageData.refreshMealLog))
        )
        .compile
        .drain
    } yield ExitCode.Success
  }
}
