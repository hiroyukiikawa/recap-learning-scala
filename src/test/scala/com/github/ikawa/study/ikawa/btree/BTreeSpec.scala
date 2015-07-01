package com.github.ikawa.study.ikawa.btree

import org.scalatest.{Matchers, FunSpec}

import scala.math.Ordering.IntOrdering

class BTreeSpec extends FunSpec with Matchers  {

  describe("BTree#size") {
    it("should return the number of elements in the BTree") {
      BTree(Leaf(1)).size shouldBe 1
      BTree(Branch(Leaf(1), 2, Leaf(3))).size shouldBe 3
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).size shouldBe 7
    }
  }

  describe("BTree#max") {
    it("should return the max value in the BTree") {
      BTree(Leaf(1)).max shouldBe 1
      BTree(Branch(Leaf(1), 2, Leaf(3))).max shouldBe 3
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).max shouldBe 7
    }
  }

  describe("BTree#min") {
    it("should return the min value in the BTree") {
      BTree(Leaf(1)).min shouldBe 1
      BTree(Branch(Leaf(1), 2, Leaf(3))).min shouldBe 1
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).min shouldBe 1
    }
  }

  describe("BTree#sum") {
    it("should return the sum of values in the BTree") {
      BTree(Leaf(1)).sum shouldBe 1
      BTree(Branch(Leaf(1), 2, Leaf(3))).sum shouldBe 6
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).sum shouldBe 28
    }
  }

  describe("BTree#avg") {
    it("should return the average of values in the BTree") {
      BTree(Leaf(1)).avg shouldBe 1.0d
      BTree(Branch(Leaf(1), 2, Leaf(3))).avg shouldBe 2.0d
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).avg shouldBe 4.0d
    }
  }

  describe("BTree#find") {
    it("should return a node has the value in the BTree") {
      BTree(Leaf(1)).find(1) shouldBe Some(Leaf(1))
      BTree(Branch(Leaf(1), 2, Leaf(3))).find(1) shouldBe Some(Leaf(1))
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).find(3) shouldBe Some(Leaf(3))
      BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7)))).find(8) shouldBe None
    }
  }

  describe("BTree#apply") {
    it("should return a new BTree from List[Int]") {
      BTree(List(1)) shouldEqual BTree(Leaf(1))
      BTree(List(1, 2, 3)) shouldEqual BTree(Branch(Leaf(1), 2, Leaf(3)))
      BTree(List(1, 2, 3, 4, 5, 6, 7)) shouldEqual BTree(Branch(Branch(Leaf(1), 2, Leaf(3)), 4, Branch(Leaf(5), 6, Leaf(7))))
    }
  }

}