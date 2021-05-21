name := "RestApi"

version := "0.1"

scalaVersion := "2.12.6"

val Version = new {
  val akka = "2.5.19"
  val akkaHttp = "10.1.8"
}

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % Version.akka,
  "com.typesafe.akka" %% "akka-http" % Version.akkaHttp,
  "com.typesafe.akka" %% "akka-http-testkit" % Version.akkaHttp % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % Version.akka % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.softwaremill.sttp" %% "core" % "1.5.12" % Test
)

enablePlugins(JavaAppPackaging)