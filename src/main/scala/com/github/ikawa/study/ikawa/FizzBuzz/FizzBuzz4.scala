package com.github.ikawa.study.ikawa.FizzBuzz

/**
 * Created by hiroyuki.ikawa on 2015/06/10.
 */
object FizzBuzz4 extends App {
  // カンマ区切りで1行で出力する
  val s = (1 to 100).map { n =>
    (n % 3, n % 5) match {
      case (0,0) => "FizzBuzz"
      case (0,_) => "Fizz"
      case (_,0) => "Buzz"
      case _ => n
    }
  }.mkString(",")
  println(s)
}
