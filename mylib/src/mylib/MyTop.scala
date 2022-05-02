package mylib

import spinal.core._
import spinal.lib._

/** Hardware definition */
class MyTop extends Component {
  val io = new Bundle {
    val cond0 = in Bool ()
    val cond1 = in Bool ()
    val flag  = out Bool ()
    val state = out UInt (8 bits)
  }
  val counter = Reg(UInt(8 bits)) init 0

  when(io.cond0) {
    counter := counter + 1
  }

  io.state := counter
  io.flag  := (counter === 0) | io.cond1
}

/** Define a custom SpinalHDL configuration with synchronous reset instead of the default
  * asynchronous one. This configuration can be reused everywhere
  */
object MySpinalConfig
    extends SpinalConfig(
      targetDirectory = "generate",
      defaultConfigForClockDomains = ClockDomainConfig(resetKind = SYNC)
    )

/** Generate the MyTop's Verilog using the above custom configuration. */
object MyTopRtlEmitter extends App {
  MySpinalConfig.generateVerilog(new MyTop)
}
