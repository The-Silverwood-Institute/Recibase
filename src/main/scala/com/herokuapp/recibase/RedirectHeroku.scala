package com.herokuapp.recibase

import cats.Applicative
import cats.data.{Kleisli, NonEmptyList}
import cats.implicits._
import org.http4s.Uri.{Authority, RegName, Scheme}
import org.http4s.headers.Location
import org.http4s._
import org.typelevel.ci.CIString

object RedirectHeroku {
  def createRedirect[G[_]](request: Request[G]): Response[G] =
    Response(
      status = Status.MovedPermanently,
      headers = Headers(
        Location(
          Uri(
            Some(Scheme.https),
            Some(Authority(host = RegName("api.reciba.se"))),
            request.uri.path,
            request.uri.query,
            request.uri.fragment
          )
        )
      )
    )

  def apply[F[_], G[_]](
      http: Http[F, G]
  )(implicit F: Applicative[F]): Http[F, G] =
    Kleisli { req =>
      req.headers.get(CIString("host")) match {
        case Some(NonEmptyList(header, _))
            if header == Header.Raw(
              CIString("host"),
              "recibase-api.herokuapp.com"
            ) =>
          createRedirect(req).pure[F]
        case _ => http(req)
      }
    }
}
