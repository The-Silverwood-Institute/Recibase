val Http4sVersion = "1.0.0-M36"
val Specs2Version = "4.18.0"
val LogbackVersion = "1.4.4"
val EnumeratumVersion = "1.7.0"

lazy val root = (project in file("."))
  .settings(
    organization := "The Silverwood Institute",
    name := "Recibase",
    version := "0.2",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-generic" % "0.14.3",
      "io.circe" %% "circe-generic-extras" % "0.14.3",
      "com.beachape" %% "enumeratum" % EnumeratumVersion,
      "com.beachape" %% "enumeratum-circe" % EnumeratumVersion,
      "org.apache.commons" % "commons-lang3" % "3.12.0",
      "org.reflections" % "reflections" % "0.10.2",
      "org.specs2" %% "specs2-core" % Specs2Version % "test",
      "org.specs2" %% "specs2-matcher-extra" % Specs2Version % "test",
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
