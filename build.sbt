name := "MachineLearning"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "octalmind maven" at "http://dl.bintray.com/guillaumebreton/maven"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental" % "1.0-RC3",
  "com.typesafe.play" %% "play-json" % "2.4.0",
  "octalmind" % "play-json-support_2.11" % "0.2.0",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)