package com.github.ikawa.study.ikawa.q

/**
 * Created by hiroyuki.ikawa on 2015/08/19.
 */
object refact extends App {
  def q1(nameOpt: Option[String]) = {
//    if (nameOpt.isDefined) {
//      val name = nameOpt.get
//      val id = findByName(name)
//    }
    val id = nameOpt.map{ name =>
      findByName(name)
    }
  }
  def findByName(name: String) = {

  }
}
