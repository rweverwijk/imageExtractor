name := "imageExtractor"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.tika" % "tika-core" % "1.11",
  "org.apache.tika" % "tika-parsers" % "1.11",
  "org.scalatest" % "scalatest_2.10" % "latest.integration" % "test"
)