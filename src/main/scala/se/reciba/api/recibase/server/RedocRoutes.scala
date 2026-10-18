package se.reciba.api.server

import cats.effect.Sync
import org.http4s.dsl.Http4sDsl
import org.http4s.headers.{`Content-Type`, Location}
import org.http4s.implicits._
import org.http4s.{HttpRoutes, MediaType}
import sttp.apispec.openapi.circe.yaml._
import sttp.tapir.AnyEndpoint
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter
import sttp.tapir.redoc.Redoc

object RedocRoutes {
  private val yamlType = MediaType.unsafeParse("text/yaml")

  def routes[F[_]: Sync](endpoints: List[AnyEndpoint]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    val yaml = OpenAPIDocsInterpreter()
      .toOpenAPI(endpoints, "Recibase", "0.2")
      .toYaml
    val html = Redoc.redocHtml("Recibase", "./docs.yaml")

    HttpRoutes.of[F] {
      case GET -> Root / "docs" =>
        PermanentRedirect(Location(uri"/docs/"))
      case GET -> Root / "docs" / "" =>
        Ok(html, `Content-Type`(MediaType.text.html))
      case GET -> Root / "docs" / "docs.yaml" =>
        Ok(yaml, `Content-Type`(yamlType))
    }
  }
}
