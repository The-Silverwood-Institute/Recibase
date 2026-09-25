val Http4sVersion = "1.0.0-M48"
val Specs2Version = "4.23.0"
val LogbackVersion = "1.6.4"
val EnumeratumVersion = "1.9.8"

lazy val root = (project in file("."))
  .settings(
    organization := "The Silverwood Institute",
    name := "Recibase",
    version := "0.2",
    scalaVersion := "2.13.18",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-generic" % "0.14.16",
      "io.circe" %% "circe-generic-extras" % "0.14.4",
      "com.beachape" %% "enumeratum" % EnumeratumVersion,
      "com.beachape" %% "enumeratum-circe" % "1.9.8",
      "org.apache.commons" % "commons-lang3" % "3.20.0",
      "org.reflections" % "reflections" % "0.10.2",
      "org.apache.commons" % "commons-csv" % "1.14.1",
      "org.specs2" %% "specs2-core" % Specs2Version % "test",
      "org.specs2" %% "specs2-matcher-extra" % Specs2Version % "test",
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "org.typelevel" %% "log4cats-slf4j" % "2.8.0"
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  )

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

import com.typesafe.sbt.packager.docker._
import scala.sys.process._
import scala.util.Try

def gitCommitForDocker: String = {
  val fromEnv = Seq("GITHUB_SHA", "GIT_COMMIT")
    .flatMap(k => sys.env.get(k).map(_.trim))
    .find(_.matches("[0-9a-fA-F]{7,40}"))
  fromEnv
    .orElse(
      Try("git rev-parse HEAD".!!.trim).toOption
        .filter(_.matches("[0-9a-fA-F]{7,40}"))
    )
    .getOrElse("latest")
}

Docker / version := "latest"
dockerBaseImage := "eclipse-temurin:25"
dockerExposedPorts := Seq(8081)
dockerEnvVars += "GIT_COMMIT" -> gitCommitForDocker
dockerCommands ++= Seq(
  Cmd(
    "HEALTHCHECK",
    "--interval=10s --timeout=5s --start-period=60s --retries=5 CMD bash -c \"exec 3<>/dev/tcp/127.0.0.1/8081 && printf 'GET /health HTTP/1.1\\r\\nHost: localhost\\r\\nConnection: close\\r\\n\\r\\n' >&3 && grep -q '200' <&3\""
  )
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Xfatal-warnings",
  "-Ymacro-annotations"
)
