package com.github.ikawa.study.ikawa.impl

import org.joda.time.DateTime

/**
 * Created by hiroyuki.ikawa on 2015/07/31.
 */
object Sample extends App {
  implicit class RichString2(val string: String) {
    def hoge(): String = {
      string + " hoge"
    }
  }
  "aa".hoge()

  implicit class RichDateInt(val d: Int) {
    def day: Long = {
      d * 24 * 60 * 60 * 1000
    }
  }
  implicit class RichDateTime(val a: DateTime) {
    def +(b: Long): DateTime = {
      a.plus(b)
    }
  }

  val now = new DateTime
  val tomorrow = now + 1.day
  println(now)
  println(tomorrow)
}

