package com.github.ikawa.study.ikawa.future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by hiroyuki.ikawa on 2015/07/28.
 */
object Activate extends App {
  val cluster1 = Seq("server1", "server2")
  val cluster2 = Seq("server3", "server4")

  restoreAndActivate(cluster1).foreach(f => println("cluster1 success"))
  restoreAndActivate(cluster2).foreach(f => println("cluster2 success"))

  def restoreAndActivate(cluster: Seq[String]): Future[Seq[Either[Throwable, String]]] = {
    for {
      restore <- Future.sequence(cluster.map(server => MockDispatch.post(s"http://$server/restore")))
      print <- Future(println(s"restore cluster: $cluster"))
      activate <- Future.sequence(cluster.map(server => MockDispatch.post(s"http://$server/activate")))
      print <- Future(println(s"activate cluster: $cluster"))
    } yield activate
  }
}

object MockDispatch {
  import scala.util.Random
  def post(endpoint: String): Future[Either[Throwable, String]] = {
    val restore = "^(.*restore)$".r
    val activate = "(.*activate)$".r
    endpoint match {
      case restore(endpoint) => {
        Thread.sleep(Random.nextInt(3000))
        println(s"restore: $endpoint")
        Future(Right(s"$endpoint: restore ok"))
      }
      case activate(endpoint) => {
        Thread.sleep(Random.nextInt(3000))
        println(s"activate: $endpoint")
        Future(Right(s"$endpoint: activate ok"))
      }
      case _ => {
        Future(Left(new IllegalArgumentException))
      }
    }
  }
}
