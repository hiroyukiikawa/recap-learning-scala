package com.github.ikawa.study.ikawa.func

/**
 * Created by hiroyuki.ikawa on 2015/08/12.
 */
object Area extends App {
  def area = (pi: Double) => {
    (r: Int) => r * r * pi
  }
  val f1 = area(3.14)
  println(f1(10))
  val f2 = area(3.0)
  println(f2(10))
}
