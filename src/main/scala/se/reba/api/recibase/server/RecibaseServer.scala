package se.reciba.api.server

import cats.effect.Async
import fs2.Stream
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.implicits._
import cats.syntax.all._
import org.http4s.server.middleware.{CORS, Logger}
import se.reciba.api.usage.UsageData

object RecibaseServer {

  def stream[F[_]](
      usageData: UsageData[F]
  )(implicit F: Async[F]): Stream[F, Nothing] = {
    for {
      _ <- BlazeClientBuilder[F].stream
      recipesAlg = RecipeController.impl[F]
      mealsAlg = MealsController.impl[F](usageData)
      metaAlg = MetaController.impl[F]

      // Combine Service Routes into an HttpApp.
      // Can also be done via a Router if you
      // want to extract a segments not checked
      // in the underlying routes.
      httpApp = RedirectHeroku(
        CORS.policy.withAllowOriginAll
          .withAllowCredentials(false)
          .apply(
            RecibaseRoutes.routes[F](recipesAlg, mealsAlg, metaAlg).orNotFound
          )
      )

      // With Middlewares in place
      finalHttpApp = Logger.httpApp(false, false)(httpApp)

      port = scala.util.Properties.envOrElse("PORT", "8081").toInt

      exitCode <- BlazeServerBuilder[F]
        .bindHttp(port, "0.0.0.0")
        .withHttpApp(finalHttpApp)
        .serve
    } yield exitCode
  }.drain
}
