package com.github.ikawa.study.ikawa.nnp

import scala.annotation.tailrec

/**
 * Created by hiroyuki.ikawa on 2015/06/12.
 */
trait NNP10 {
  // 1
  @tailrec
  final def last(list: List[Int]): Int = {
    //list.last
    list match {
      case head::Nil => head
      case head::tail => last(tail)
      case _ => throw new Exception
    }
  }

  // 2
  @tailrec
  final def penultimate(list: List[Int]): Int = {
    //list.init.last
    list match {
      case head::tail::Nil => head
      case head::tail => penultimate(tail)
      case _ => throw new Exception
    }
  }

  // 3
  def nth(n: Int, list: List[Int]): Int = {
    //list(n)
    @tailrec
    def ini(n: Int, l: List[Int]): List[Int] = {
      if (n == l.size - 1) l else ini(n, l.init)
    }
    ini(n, list).last
  }

  // 4
  def length(list: List[Int]): Int = {
    //list.size
    @tailrec
    def cnt(c: Int, l: List[Int]): Int = {
      l match {
        case head::Nil => c
        case head::tail => cnt(c + 1, tail)
        case _ => throw new Exception
      }
    }
    cnt(1, list)
  }

  // 5
  def reverse(list: List[Int]): List[Int] = {
    //list.reverse
    list match {
      case head::Nil => println("head:"+head);List(head)
      case head::tail => reverse(tail):::head::Nil
      case _ => throw new Exception
    }
  }

  // 6
  def isPalindrome(list: List[Int]): Boolean = {
    list.reverse == list
  }

  // 7
  def flatten(list: List[Any]): List[Int] = {
    List()
  }

  // 総和
  //def sum(n: Int): Int = n + sum(n - 1)
  def sum(n: Int): Int = {
    def plus(a: Int, acc: Int): Int = {
      if (a == 0) {
        acc
      } else {
        plus(a - 1, acc + a)
      }
    }
    plus(n, 0)
  }
}
