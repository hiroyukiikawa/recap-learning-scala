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
    @tailrec
    def r(i: List[Int], l: List[Int]): List[Int] = {
      i match {
        case Nil => l
        case init::last => r(i.init, l:::List(i.last))
      }
    }
    r(list, List())
  }

  // 6
  def isPalindrome(list: List[Int]): Boolean = {
    //list.reverse == list
    @tailrec
    def compare(front: List[Int], back: List[Int]): Boolean = {
      (front, back) match {
        case (Nil, Nil) => true
        case (f: List[Int], b: List[Int]) => {
          if (f.head == b.last) {
            compare(f.tail, b.init)
          } else {
            false
          }
        }
      }
    }
    compare(list, list)
  }

  // 7
  def flatten(list: List[Any]): List[Any] = {
    @tailrec
    def flat(acc: List[Any], rest: List[Any]): List[Any] = {
      rest match {
        case Nil => acc
        case head::tail => head match {
          case Nil => flat(acc, tail)
          case l: List[_] => flat(acc, l.head::l.tail::tail)
          case value: Any => flat(value::acc, rest.tail)
        }
      }
    }
    flat(List(), list).reverse
  }

  // 8
  def compress(list: List[Symbol]): List[Symbol] = {
    @tailrec
    def cmp(acc: List[Symbol], rest: List[Symbol]): List[Symbol] = {
      rest match {
        case Nil => acc
        case head::tail if acc.isEmpty || acc.head != head => cmp(head::acc, tail)
        case head::tail => cmp(acc, tail)
      }
    }
    cmp(List(), list).reverse
  }

  // 9
  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @tailrec
    def pck(acc: List[List[Symbol]], rest: List[Symbol]): List[List[Symbol]] = {
      rest match {
        case Nil => acc
        case head::tail if (acc.isEmpty) => pck(List(head)::acc, tail)
        case head::tail if (acc.head.head == rest.head) => pck(List(head::acc.head):::acc.tail, tail)
        case head::tail if (acc.head.head != rest.head) => pck(List(head)::acc, tail)
      }
    }
    pck(List(), list).reverse
  }

  // 10
  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    @tailrec
    def enc(acc: List[(Int, Symbol)], rest: List[Symbol]): List[(Int, Symbol)] = {
      rest match {
        case Nil => acc
        case head::tail =>
          acc match {
            case Nil => enc((1, head)::acc, tail)
            case (n:Int, s: Symbol)::t =>
              if (s == head) {
                enc((n + 1, head)::acc.tail, tail)
              } else {
                enc((1, head)::acc, tail)
              }
          }
      }
    }
    enc(List(), list).reverse
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
