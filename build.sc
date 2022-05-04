import mill._
import scalalib._
import scalafmt._
import publish._

trait CommonModule extends ScalaModule {
  def scalaVersion = "2.13.8"

  override def scalacOptions = Seq(
    "-encoding", "utf8",
    "-Xfatal-warnings",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:reflectiveCalls", // required by SpinalSim
    "-language:postfixOps" // use operator syntax in postfix positions
  )

  val spinalVersion = "1.7.0"
  override def ivyDeps = Agg(
    ivy"com.github.spinalhdl::spinalhdl-core:$spinalVersion",
    ivy"com.github.spinalhdl::spinalhdl-lib:$spinalVersion",
  )
  override def scalacPluginIvyDeps = Agg(ivy"com.github.spinalhdl::spinalhdl-idsl-plugin:$spinalVersion")
}

object mylib extends CommonModule with ScalafmtModule with PublishModule {
  object test extends Tests with TestModule.ScalaTest {
    override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.2.11")

    // A workaround to run ScalaTest with Mill
    def testSim(args: String*) = T.command {
      super.runMain("org.scalatest.run", args: _*)
    }
  }

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
