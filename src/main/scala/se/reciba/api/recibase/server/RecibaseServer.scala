package se.reciba.api.server

import cats.effect.Async
import com.comcast.ip4s._
import fs2.Stream
import fs2.io.net.Network
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import cats.syntax.all._
import org.http4s.server.middleware.{CORS, Logger}
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory
import se.reciba.api.usage.UsageData

object RecibaseServer {

  def stream[F[_]: Async: Network](
      usageData: UsageData[F]
  ): Stream[F, Unit] = {
    implicit val loggerFactory: LoggerFactory[F] = Slf4jFactory.create[F]
    val recipesAlg = RecipeController.impl[F](usageData)
    val mealsAlg = MealsController.impl[F](usageData)
    val metaAlg = MetaController.impl[F]
    val routes = RecibaseRoutes.routes[F](recipesAlg, mealsAlg, metaAlg)
    val port = scala.util.Properties.envOrElse("PORT", "8081").toInt

    for {
      corsHttp <- Stream.eval(
        CORS.policy.withAllowOriginAll
          .withAllowCredentials(false)
          .apply(routes)
      )
      finalHttpApp = Logger.httpApp(false, false)(corsHttp.orNotFound)
      _ <- Stream
        .resource(
          EmberServerBuilder
            .default[F]
            .withHost(ipv4"0.0.0.0")
            .withPort(Port.fromInt(port).get)
            .withHttpApp(finalHttpApp)
            .build
        )
        .flatMap(_ => Stream.never[F])
    } yield ()
  }
}
