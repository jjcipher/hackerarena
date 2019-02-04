/**
  * URL: https://www.hackerrank.com/challenges/making-anagrams/problem
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val s1 = StdIn.readLine
  val s2 = StdIn.readLine
  val answer = if (s1 == s2) 0 else {
    val common = s1.intersect(s2)
    s1.length + s2.length - 2 * common.length
  }
  println(answer)
}
