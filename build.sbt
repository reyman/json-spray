name := "json-test"

version := "1.0"

scalaVersion := "2.10.1"

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= Seq("io.spray" %%  "spray-json" % "1.2.5")
