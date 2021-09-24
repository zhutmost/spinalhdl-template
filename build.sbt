ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version      := "0.1.0"
ThisBuild / organization := "%ORGANIZATION%"

val spinalVersion = "1.6.0"
val spinalCore = "com.github.spinalhdl" %% "spinalhdl-core" % spinalVersion
val spinalLib = "com.github.spinalhdl" %% "spinalhdl-lib" % spinalVersion
val spinalIdslPlugin = compilerPlugin("com.github.spinalhdl" %% "spinalhdl-idsl-plugin" % spinalVersion)

lazy val root = (project in file("."))
  .settings(
    name := "%NAME%",

    libraryDependencies ++= Seq(spinalCore, spinalLib, spinalIdslPlugin),

    scalacOptions ++= Seq(
      "-encoding", "utf8",
      "-Xfatal-warnings",
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:reflectiveCalls" // required by SpinalSim
    ),

    // allow to use operator syntax in the postfix position, such as "UInt(8 bits)"
    //scalacOptions ++= Seq("-language:postfixOps"),

    // fork a new JVM for 'run' and 'Test/run'
    fork := true
  )
