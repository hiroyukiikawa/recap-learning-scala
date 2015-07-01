package com.github.ikawa.study.ikawa.btree

/**
 * Created by hiroyuki.ikawa on 2015/06/25.
 */
trait Node {
  val value: Int
  val size: Int
  val max: Int
  val min: Int
  val sum: Int
  val avg: Double
  def find(needle: Int): Option[Node]
}

case class Branch(l: Node, n: Int, r: Node) extends Node {
  val value = n
  val size = l.size + 1 + r.size
  val max = r.max
  val min = l.min
  val sum = l.sum + n + r.sum
  val avg = n.toDouble
  def find(needle: Int): Option[Node] = {
    if (needle == n) {
      Some(this)
    } else if (needle < n) {
      l.find(needle)
    } else {
      r.find(needle)
    }
  }
}

case class Leaf(i: Int) extends Node {
  val value = i
  val size = 1
  val max = i
  val min = i
  val sum = i
  val avg = i.toDouble
  def find(needle: Int): Option[Leaf] = if (needle == value) Some(this) else None
}

case class BTree(node: Node) {
  def size: Int = node.size
  def max: Int = node.max
  def min: Int = node.min
  def sum: Int = node.sum
  def avg: Double = node.avg
  def find(needle: Int) = node.find(needle)
}

object BTree {
  def apply(list: List[Int]): BTree = {
    list match {
      case head::Nil => BTree(Leaf(head))
      case List(l,c,r) => BTree(Branch(Leaf(l), c, Leaf(r)))
      case _ => BTree(Leaf(1))
    }
  }
  private def toBranch(l: Int, c: Int, r: Int) = {
    Branch
  }
}
