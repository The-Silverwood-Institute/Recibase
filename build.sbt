val Http4sVersion = "1.0.0-M38"
val Specs2Version = "4.23.0"
val LogbackVersion = "1.5.29"
val EnumeratumVersion = "1.9.5"

lazy val root = (project in file("."))
  .settings(
    organization := "The Silverwood Institute",
    name := "Recibase",
    version := "0.2",
    scalaVersion := "2.13.18",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-generic" % "0.14.15",
      "io.circe" %% "circe-generic-extras" % "0.14.4",
      "com.beachape" %% "enumeratum" % EnumeratumVersion,
      "com.beachape" %% "enumeratum-circe" % "1.9.5",
      "org.apache.commons" % "commons-lang3" % "3.20.0",
      "org.reflections" % "reflections" % "0.10.2",
      "org.apache.commons" % "commons-csv" % "1.14.1",
      "org.specs2" %% "specs2-core" % Specs2Version % "test",
      "org.specs2" %% "specs2-matcher-extra" % Specs2Version % "test",
      "ch.qos.logback" % "logback-classic" % LogbackVersion
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  )

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

Docker / version := "latest"
dockerBaseImage := "eclipse-temurin:17"
dockerExposedPorts := Seq(8081)

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
