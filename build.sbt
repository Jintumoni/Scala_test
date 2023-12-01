val MAJOR = 1
val MINOR = 0
val projectVersion = s"$MAJOR.$MINOR"

ThisBuild / version := projectVersion

ThisBuild / scalaVersion := "2.11.7"


lazy val app = (project in file("."))
  .settings(
    assembly / assemblyJarName := s"scala-test.jar"
  )

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

libraryDependencies ++= testDependencies

