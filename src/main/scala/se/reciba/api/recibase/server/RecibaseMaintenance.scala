package se.reciba.api.recibase.server

import cats.effect.Async
import fs2._
import scala.concurrent.duration._
import se.reciba.api.usage.UsageData

object RecibaseMaintenance {
  private val maintenanceInterval = 30 minutes

  def stream[F[_]](
      usageData: UsageData[F]
  )(implicit F: Async[F]): Stream[F, Unit] =
    Stream
      .emit(1)
      .flatMap(_ => Stream.eval(usageData.refreshMealLog)) ++
      Stream
        .awakeEvery[F](maintenanceInterval)
        .flatMap(_ => Stream.eval(usageData.refreshMealLog))
}
