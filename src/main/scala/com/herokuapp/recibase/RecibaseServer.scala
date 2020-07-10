package com.herokuapp.recibase

import cats.effect.{ConcurrentEffect, ContextShift, Timer}
import fs2.Stream
import org.http4s.client.blaze.BlazeClientBuilder
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.middleware.{CORS, Logger}

import scala.concurrent.ExecutionContext.global

object RecibaseServer {

  def stream[F[_]: ConcurrentEffect](implicit
      T: Timer[F],
      C: ContextShift[F]
  ): Stream[F, Nothing] = {
    for {
      client <- BlazeClientBuilder[F](global).stream
      helloWorldAlg = RecipeController.impl[F]

      // Combine Service Routes into an HttpApp.
      // Can also be done via a Router if you
      // want to extract a segments not checked
      // in the underlying routes.
      httpApp = CORS(RecibaseRoutes.recipeRoutes[F](helloWorldAlg).orNotFound)

      // With Middlewares in place
      finalHttpApp = Logger.httpApp(true, true)(httpApp)

      port = scala.util.Properties.envOrElse("PORT", "8081").toInt

      exitCode <-
        BlazeServerBuilder[F]
          .bindHttp(port, "0.0.0.0")
          .withHttpApp(finalHttpApp)
          .serve
    } yield exitCode
  }.drain
}
