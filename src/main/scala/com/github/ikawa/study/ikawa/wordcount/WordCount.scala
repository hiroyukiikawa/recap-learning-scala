package com.github.ikawa.study.ikawa.wordcount

/**
 * Created by hiroyuki.ikawa on 2015/06/04.
 */
class WordCount {
  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    lines.flatMap(_.split(" ")).groupBy(w => w).mapValues(_.size)
  }
}
