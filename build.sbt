name := "Recibase"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.3"
libraryDependencies += "org.specs2" %% "specs2-core" % "4.0.2" % "test"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.3"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.7.2"

scalacOptions in Test ++= Seq("-Yrangepos")
