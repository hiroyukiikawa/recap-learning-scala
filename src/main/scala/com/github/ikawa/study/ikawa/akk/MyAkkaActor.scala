package com.github.ikawa.study.ikawa.akk

import akka.pattern.ask
import akka.actor.{Props, ActorSystem, Actor, ActorLogging}
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by hiroyuki.ikawa on 2015/08/25.
 */

object ActorTest extends App {
  val myAkkaActorSystem = ActorSystem()
  val myAkkaActor = myAkkaActorSystem.actorOf(Props(classOf[MyAkkaActor]), name = "MyAkkaActor")
  class MyAkkaActor extends Actor with ActorLogging{
    override def receive = {
      case i: Int => log.info("Int=" + i)
      case msg: String => {
        Thread.sleep(1000L)
        log.info(msg + " by MyAkkaActor")
        sender().!(s"Hello, ${msg.toString}")(context.parent)
      }
    }
  }
  myAkkaActor ! 1
  myAkkaActor ! "hello!"

  implicit val timeout = Timeout(30 seconds)

  val resultOption = myAkkaActor ? "taro"
  resultOption.onComplete {
    case Success(s) => println(s"result=$s")
    case Failure(ex) => println(s"onComplete failure $ex")
  }
}
