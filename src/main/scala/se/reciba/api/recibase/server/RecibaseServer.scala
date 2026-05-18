package se.reciba.api.server

import cats.effect.Async
import fs2.Stream
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.implicits._
import cats.syntax.all._
import org.http4s.server.middleware.{CORS, Logger}
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory
import se.reciba.api.usage.UsageData

object RecibaseServer {

  def stream[F[_]](
      usageData: UsageData[F]
  )(implicit F: Async[F]): Stream[F, Unit] = {
    implicit val loggerFactory: LoggerFactory[F] = Slf4jFactory.create[F]
    for {
      _ <- BlazeClientBuilder[F].stream
      recipesAlg = RecipeController.impl[F](usageData)
      mealsAlg = MealsController.impl[F](usageData)
      metaAlg = MetaController.impl[F]
      routes = RecibaseRoutes.routes[F](recipesAlg, mealsAlg, metaAlg)
      corsHttp <- Stream.eval(
        CORS.policy.withAllowOriginAll
          .withAllowCredentials(false)
          .apply(routes)
      )
      httpWithRedirect = RedirectHeroku(corsHttp)
      finalHttpApp = Logger.httpApp(false, false)(httpWithRedirect.orNotFound)

      port = scala.util.Properties.envOrElse("PORT", "8081").toInt

      _ <- BlazeServerBuilder[F]
        .bindHttp(port, "0.0.0.0")
        .withHttpApp(finalHttpApp)
        .serve
    } yield ()
  }
}
