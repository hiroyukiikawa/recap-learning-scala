package com.github.ikawa.study.ikawa.future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by hiroyuki.ikawa on 2015/07/24.
 */
object Aggregate extends App {
  def aggregate(id: String): Future[Int] = {
    id match {
      case "rikunavi" => Future(3)
      case "mynavi" => Future(2)
      case "en" => Future(1)
      case _ => Future(0)
    }
  }
  val result = Seq("rikunavi", "mynavi", "en").map(aggregate)
  Future.sequence(result).map(_.sum).map(println)
}
