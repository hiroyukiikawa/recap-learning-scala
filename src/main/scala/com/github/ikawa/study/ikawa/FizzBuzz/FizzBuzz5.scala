package com.github.ikawa.study.ikawa.FizzBuzz

/**
 * Created by hiroyuki.ikawa on 2015/06/10.
 */
object FizzBuzz5 extends App {
  val fizzbuzz = (1 to 100).map { n =>
    (n % 3, n % 5) match {
      case (0,0) => "FizzBuzz"
      case (0,_) => "Fizz"
      case (_,0) => "Buzz"
      case _ => n
    }
  }
  val result = fizzbuzz.filter(_.isInstanceOf[Int]).map(_.toString.toInt).sum
  println(result)
}
