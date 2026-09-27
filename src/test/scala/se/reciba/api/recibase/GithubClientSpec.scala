package se.reciba.api

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.circe.Json
import io.circe.jawn
import se.reciba.api.submit.{
  BranchAlreadyExists,
  GeneratedRecipe,
  GithubClient,
  GithubRejected,
  GithubSettings
}

import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.concurrent.{ConcurrentLinkedQueue, Executors}
import com.sun.net.httpserver.{HttpExchange, HttpServer}
import scala.jdk.CollectionConverters._

class GithubClientSpec extends org.specs2.mutable.Specification {
  private val settings =
    GithubSettings("test-token", "The-Silverwood-Institute/Recibase", "master")

  "open" >> {
    "creates a branch, commits the file, and opens a pull request" >> {
      withGithub { github =>
        github.respond("GET", _.contains("/git/ref/heads/master"), 200, sha)
        github.respond("POST", _.endsWith("/git/refs"), 201, "{}")
        github.respond("PUT", _.contains("/contents/"), 201, "{}")
        github.respond(
          "POST",
          _.endsWith("/pulls"),
          201,
          """{"html_url":"https://github.com/The-Silverwood-Institute/Recibase/pull/4"}"""
        )
        val result = client(github)
          .open(
            recipe,
            "Add Phone Test Soup",
            "Add Phone Test Soup",
            "Submitted from the contribute page."
          )
          .unsafeRunSync()
        result must beRight(
          "https://github.com/The-Silverwood-Institute/Recibase/pull/4"
        )
        val recorded = github.recorded
        recorded.map(call => call.method + " " + call.path) must beEqualTo(
          List(
            "GET /repos/The-Silverwood-Institute/Recibase/git/ref/heads/master",
            "POST /repos/The-Silverwood-Institute/Recibase/git/refs",
            "PUT /repos/The-Silverwood-Institute/Recibase/contents/src/main/scala/se/reciba/api/recibase/recipes/PhoneTestSoup.scala",
            "POST /repos/The-Silverwood-Institute/Recibase/pulls"
          )
        )
        recorded.foreach { call =>
          call.authorization must beSome("Bearer test-token")
        }
        val file = recorded(2).json
        file.hcursor.get[String]("message") must beRight("Add Phone Test Soup")
        file.hcursor.get[String]("branch") must beRight(
          "recipe/phone-test-soup"
        )
        val encoded = file.hcursor.get[String]("content").toOption.get
        new String(
          Base64.getDecoder.decode(encoded),
          StandardCharsets.UTF_8
        ) must beEqualTo(
          recipe.source
        )
        val pull = recorded(3).json
        pull.hcursor.get[String]("head") must beRight("recipe/phone-test-soup")
        pull.hcursor.get[String]("base") must beRight("master")
        pull.hcursor.get[Boolean]("draft") must beRight(false)
        pull.hcursor.get[String]("body") must beRight(
          "Submitted from the contribute page."
        )
      }
    }

    "returns a conflict when the branch already exists" >> {
      withGithub { github =>
        github.respond("GET", _.contains("/git/ref/heads/master"), 200, sha)
        github.respond(
          "POST",
          _.endsWith("/git/refs"),
          422,
          """{"message":"Reference already exists"}"""
        )
        val result =
          client(github).open(recipe, "Add", "Add", "body").unsafeRunSync()
        result must beEqualTo(Left(BranchAlreadyExists))
        github.recorded.map(_.method) must beEqualTo(List("GET", "POST"))
      }
    }

    "deletes the branch when the file upload fails" >> {
      withGithub { github =>
        github.respond("GET", _.contains("/git/ref/heads/master"), 200, sha)
        github.respond("POST", _.endsWith("/git/refs"), 201, "{}")
        github.respond(
          "PUT",
          _.contains("/contents/"),
          500,
          """{"message":"nope"}"""
        )
        github.respond("DELETE", _.contains("/git/refs/heads/"), 204, "")
        val result =
          client(github).open(recipe, "Add", "Add", "body").unsafeRunSync()
        result must beLeft.like { case GithubRejected(message) =>
          message must contain("500")
        }
        github.recorded.map(_.method) must beEqualTo(
          List("GET", "POST", "PUT", "DELETE")
        )
        github.recorded.last.path must contain("heads/recipe%2Fphone-test-soup")
      }
    }
  }

  private val sha = """{"object":{"sha":"abc123"}}"""

  private val recipe = GeneratedRecipe(
    name = "Phone Test Soup",
    objectName = "PhoneTestSoup",
    permalink = "phone-test-soup",
    branch = "recipe/phone-test-soup",
    path = "src/main/scala/se/reciba/api/recibase/recipes/PhoneTestSoup.scala",
    source = "package se.reciba.api.recipes\n"
  )

  private def client(github: FakeGithub): GithubClient[IO] =
    new GithubClient[IO](settings, github.base)

  private def withGithub[A](use: FakeGithub => A): A = {
    val github = new FakeGithub
    try use(github)
    finally github.close()
  }

  private final class FakeGithub {
    private val server =
      HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0)
    private val pool = Executors.newCachedThreadPool()
    private val rules =
      new ConcurrentLinkedQueue[(String, String => Boolean, Int, String)]()
    private val calls = new ConcurrentLinkedQueue[GithubCall]()

    server.createContext(
      "/",
      (exchange: HttpExchange) => {
        val requestBody = new String(
          exchange.getRequestBody.readAllBytes(),
          StandardCharsets.UTF_8
        )
        val call = GithubCall(
          exchange.getRequestMethod,
          exchange.getRequestURI.getRawPath,
          Option(exchange.getRequestHeaders.getFirst("Authorization")),
          requestBody
        )
        calls.add(call)
        val matched = rules.asScala.find { case (method, path, _, _) =>
          method == call.method && path(call.path)
        }
        val (status, responseBody) = matched match {
          case Some((_, _, status, body)) => (status, body)
          case None => (404, """{"message":"unexpected"}""")
        }
        val bytes = responseBody.getBytes(StandardCharsets.UTF_8)
        exchange.getResponseHeaders.set("Content-Type", "application/json")
        if (status == 204) exchange.sendResponseHeaders(status, -1)
        else {
          exchange.sendResponseHeaders(status, bytes.length.toLong)
          val output = exchange.getResponseBody
          output.write(bytes)
          output.close()
        }
        exchange.close()
      }
    )
    server.setExecutor(pool)
    server.start()

    def base: String = s"http://127.0.0.1:${server.getAddress.getPort}"

    def respond(
        method: String,
        path: String => Boolean,
        status: Int,
        body: String
    ): Unit =
      rules.add((method, path, status, body))

    def recorded: List[GithubCall] = calls.asScala.toList

    def close(): Unit = {
      server.stop(0)
      pool.shutdownNow()
    }
  }
}

private final case class GithubCall(
    method: String,
    path: String,
    authorization: Option[String],
    body: String
) {
  def json: Json = jawn.parse(body).toOption.get
}
