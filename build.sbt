ThisBuild / name := "1"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.5"

libraryDependencies := Seq(
  "org.typelevel" %% "cats-core" % "2.3.0",
  "org.typelevel" %% "simulacrum" % "1.0.0"
)

scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-Ymacro-annotations",
  "-Ymacro-debug-lite"
)
