package com.herokuapp.recibase.server

import cats.Applicative
import cats.implicits._
import com.herokuapp.recibase.model.Manifest

trait MetaController[F[_]] {
  def manifest: F[Manifest]
}

object MetaController {
  def impl[F[_] : Applicative]: MetaController[F] =
    new MetaController[F] {
      override def manifest: F[Manifest] = Manifest(sys.env.getOrElse("HEROKU_SLUG_COMMIT", "latest")).pure[F]
    }
}
