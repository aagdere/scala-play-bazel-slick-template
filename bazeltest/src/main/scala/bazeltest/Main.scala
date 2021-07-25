package bazeltest

import othermodule.Worker
import org.joda.time.DateTime

object Main extends App {
  println("IN MAIN now: "+DateTime.now().plusYears(11))
  val worker = new Worker
  worker.doSomething()


  def status(): String = "OK"
}
