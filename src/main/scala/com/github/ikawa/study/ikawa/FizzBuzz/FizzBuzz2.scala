package com.github.ikawa.study.ikawa.FizzBuzz

/**
 * Created by hiroyuki.ikawa on 2015/06/10.
 */
object FizzBuzz2 extends App {
    // 1行でFizzBuzz
    (1 to 100).map { n => if(n%3<1 && n%5<1) "FizzBuzz" else if(n%3<1) "Fizz" else if(n%5<1) "Buzz" else n }.foreach(println)
}
