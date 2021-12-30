import mill._, scalalib._, scalafmt._, publish._

trait CommonModule extends ScalaModule {
  def scalaVersion = "2.13.7"

  override def scalacOptions = Seq(
    "-encoding", "utf8",
    "-Xfatal-warnings",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:reflectiveCalls", // required by SpinalSim
    "-language:postfixOps" // use operator syntax in the postfix position
  )

  override def ivyDeps = Agg(
    ivy"com.github.spinalhdl::spinalhdl-core:1.6.1",
    ivy"com.github.spinalhdl::spinalhdl-lib:1.6.1",
  )
  override def scalacPluginIvyDeps = Agg(ivy"com.github.spinalhdl::spinalhdl-idsl-plugin:1.6.1")
}

object mylib extends CommonModule with ScalafmtModule with PublishModule {
  // object test extends Tests with TestModule.ScalaTest {
  //   override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.2.10")
  // }

  override def publishVersion = "0.0.1-SNAPSHOT"

  override def pomSettings = PomSettings(
    description = "My first SpinalHDL project",
    organization = "%ORGANIZATION%",
    url = "https://github.com/%REPOSITORY%",
    licenses = Seq(License.MIT), // Do NOT forget change it to your license!
    versionControl = VersionControl.github("%ACTOR%", "%NAME%"),
    developers = Seq(
      Developer("%ACTOR%", "%ACTOR%", "https://github.com/%ACTOR%")
    )
  )
}
