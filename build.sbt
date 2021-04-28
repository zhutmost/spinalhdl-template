ThisBuild / scalaVersion := "2.12.13"
ThisBuild / version      := "0.1.0"
ThisBuild / organization := "%ORGANIZATION%"

val spinalVersion = "1.4.3"

lazy val root = (project in file("."))
  .settings(
    name := "%NAME%",
    libraryDependencies ++= Seq(
      "com.github.spinalhdl" % "spinalhdl-core_2.12" % spinalVersion,
      "com.github.spinalhdl" % "spinalhdl-lib_2.12" % spinalVersion
    ),
    addCompilerPlugin("com.github.spinalhdl" % "spinalhdl-idsl-plugin_2.12" % spinalVersion),
    fork := true
  )
