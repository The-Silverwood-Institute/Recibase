package com.herokuapp.recibase

import cats.effect.Async
import fs2.Stream
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.implicits._
import org.http4s.server.middleware.{CORS, Logger}

object RecibaseServer {

  def stream[F[_]: Async]: Stream[F, Nothing] = {
    for {
      _ <- BlazeClientBuilder[F].stream
      recipesAlg = RecipeController.impl[F]
      mealsAlg = MealsController.impl[F]

      // Combine Service Routes into an HttpApp.
      // Can also be done via a Router if you
      // want to extract a segments not checked
      // in the underlying routes.
      httpApp = RedirectHeroku(
        CORS.policy.withAllowOriginAll
          .withAllowCredentials(false)
          .apply(RecibaseRoutes.routes[F](recipesAlg, mealsAlg).orNotFound)
      )

      // With Middlewares in place
      finalHttpApp = Logger.httpApp(true, true)(httpApp)

      port = scala.util.Properties.envOrElse("PORT", "8081").toInt

      exitCode <- BlazeServerBuilder[F]
        .bindHttp(port, "0.0.0.0")
        .withHttpApp(finalHttpApp)
        .serve
    } yield exitCode
  }.drain
}
