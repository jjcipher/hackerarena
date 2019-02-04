/**
  * URL: https://www.hackerrank.com/challenges/marcs-cakewalk/problem
  */
object Solution {
  import scala.io.StdIn
  def main(args: Array[String]) {
    val n = StdIn.readInt
    val calories = StdIn.readLine.split("\\s+").map(_.toInt)
    println(calories.sortBy(-_).zip(0 to n - 1).map(c => (c._1.toLong << c._2)).sum)
  }
}
