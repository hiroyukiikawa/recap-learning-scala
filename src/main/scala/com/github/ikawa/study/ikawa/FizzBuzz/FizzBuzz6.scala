package com.github.ikawa.study.ikawa.FizzBuzz

/**
 * Created by hiroyuki.ikawa on 2015/06/10.
 */
object FizzBuzz6 extends App {
  // (1 to 100)でListを作らない
  st(1).take(100).foreach(n => println(fizzbuzz(n)))
  def st(n: Int): Stream[Int] = Stream.cons(n, st(n + 1))
  def fizzbuzz(n: Int) = {
    (n % 3, n % 5) match {
      case (0,0) => "FizzBuzz"
      case (0,_) => "Fizz"
      case (_,0) => "Buzz"
      case _ => n
    }
  }
}
