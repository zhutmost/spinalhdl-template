package mylib

import org.scalatest._
import org.scalatest.flatspec._
import spinal.core.sim._

import scala.util.Random

/** MyTop's testbench, based on ScalaTest */
class MyTopSimSpec extends FixtureAnyFlatSpec with fixture.TestDataFixture {
  val clockPeriod = 10 // No less than 2
  val compiled = SimConfig
    .withConfig(MySpinalConfig)
    .allOptimisation
    .compile(new MyTop)

  "a MyTop component" should "count continuously 0 to 255" in { td =>
    compiled.doSim(td.name) { dut =>
      dut.clockDomain.forkStimulus(clockPeriod)

      var modelState = 0
      for (_ <- 0 to 99) {
        // Drive the dut inputs with random values
        dut.io.cond0 #= Random.nextBoolean()
        dut.io.cond1 #= Random.nextBoolean()

        // Wait a rising edge on the clock
        dut.clockDomain.waitSampling()

        // Check that the dut values match with the reference model ones
        val modelFlag = modelState == 0 || dut.io.cond1.toBoolean
        assert(dut.io.state.toInt == modelState)
        assert(dut.io.flag.toBoolean == modelFlag)

        // Update the reference model value
        if (dut.io.cond0.toBoolean) {
          modelState = (modelState + 1) & 0xff
        }
      }
    }
  }
}
