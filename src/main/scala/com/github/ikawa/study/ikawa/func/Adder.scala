package com.github.ikawa.study.ikawa.func

/**
 * Created by hiroyuki.ikawa on 2015/08/12.
 */
object Adder extends App {
  def createAdder(n: Int): Function1[Int, Int] = {
    (n: Int) => 5 + n
  }
  val adder3: Function1[Int, Int] = createAdder(3)
  println(adder3(3))

  val adder5 = createAdder(5)
  println(adder5(5))
}
