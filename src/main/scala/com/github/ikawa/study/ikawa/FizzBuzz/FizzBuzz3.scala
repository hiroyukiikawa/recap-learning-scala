package com.github.ikawa.study.ikawa.FizzBuzz

/**
 * Created by hiroyuki.ikawa on 2015/06/10.
 */
object FizzBuzz3 {
  def main(args: Array[String]) = {
    // 2の倍数は除外する
    (1 to 100).withFilter(_ % 2 == 1).map { n =>
      (n % 3, n % 5) match {
        case (0,0) => "FizzBuzz"
        case (0,_) => "Fizz"
        case (_,0) => "Buzz"
        case _ => n
      }
    }.foreach(println)
  }
}
