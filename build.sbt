ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.7"

val MAJOR = 1
val MINOR = 0
val projectVersion = s"$MAJOR.$MINOR"

lazy val buildSettings = Seq(
  organization := "com.jintu",
  version := projectVersion,
  scalaVersion := "2.11.7"
)

lazy val app = (project in file(".")).
  settings(buildSettings: _*).
  settings(
    name := "scala-test"
  ).
  enablePlugins(AssemblyPlugin)

lazy val root = (project in file("."))
  .settings(
    name := "ScalaTest"
  )

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

libraryDependencies ++= testDependencies

