val Http4sVersion = "1.0.0-M23"
val CirceVersion = "0.14.1"
val Specs2Version = "4.12.3"
val LogbackVersion = "1.2.4"

lazy val root = (project in file("."))
  .settings(
    organization := "The Silverwood Institute",
    name := "Recibase",
    version := "0.2",
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-generic" % CirceVersion,
      "org.specs2" %% "specs2-core" % Specs2Version % "test",
      "ch.qos.logback" % "logback-classic" % LogbackVersion
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  )

enablePlugins(JavaAppPackaging)

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
