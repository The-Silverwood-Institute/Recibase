package se.reciba.api.server

import cats.Applicative
import cats.implicits._
import se.reciba.api.model.Manifest

trait MetaController[F[_]] {
  def manifest: F[Manifest]
  def tags: F[TagCatalog]
}

object MetaController {
  def impl[F[_]: Applicative]: MetaController[F] =
    new MetaController[F] {
      override def manifest: F[Manifest] = Manifest(
        Manifest.deployedVersion()
      ).pure[F]
      override def tags: F[TagCatalog] = TagCatalog.all.pure[F]
    }
}
