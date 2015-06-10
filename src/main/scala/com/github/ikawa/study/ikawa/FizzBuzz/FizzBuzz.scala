package com.github.ikawa.study.ikawa.FizzBuzz

/**
 * Created by hiroyuki.ikawa on 2015/06/10.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    (1 to 100).foreach { n =>
      (n % 3, n % 5) match {
        case (0,0) => println("FizzBuzz")
        case (0,_) => println("Fizz")
        case (_,0) => println("Buzz")
        case _ => println(n)
      }
    }
  }
}
