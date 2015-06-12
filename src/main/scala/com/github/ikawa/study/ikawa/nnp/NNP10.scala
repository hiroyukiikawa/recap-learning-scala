package com.github.ikawa.study.ikawa.nnp

/**
 * Created by hiroyuki.ikawa on 2015/06/12.
 */
trait NNP10 {
  // 1
  def last(list: List[Int]): Int = {
    list.last
  }

  // 2
  def penultimate(list: List[Int]): Int = {
    list.init.last
  }

  // 3
  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  // 4
  def length(list: List[Int]): Int = {
    list.size
  }

  // 5
  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }
}
