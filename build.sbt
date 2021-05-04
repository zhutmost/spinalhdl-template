ThisBuild / scalaVersion := "2.12.13"
ThisBuild / version      := "0.1.0"
ThisBuild / organization := "%ORGANIZATION%"

val spinalVersion = "1.4.3"

lazy val root = (project in file("."))
  .settings(
    name := "%NAME%",

    libraryDependencies ++= Seq(
      "com.github.spinalhdl" %% "spinalhdl-core" % spinalVersion,
      "com.github.spinalhdl" %% "spinalhdl-lib" % spinalVersion
    ),

    scalacOptions ++= Seq(
      "-encoding", "utf8",
      "-Xfatal-warnings",
      "-deprecation",
      "-unchecked",
    ),

    // allow to use operator syntax in the postfix position, such as "UInt(8 bits)"
    //scalacOptions ++= Seq("-language:postfixOps"),

    // fork a new JVM for 'run' and 'Test/run'
    fork := true
  )

addCompilerPlugin("com.github.spinalhdl" %% "spinalhdl-idsl-plugin" % spinalVersion)
