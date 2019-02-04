/**
  * URL: https://www.hackerrank.com/challenges/anagram/problem
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val t = StdIn.readInt
  for (i <- 1 to t) {
    val s = StdIn.readLine
    val answer = if (s.length % 2 == 0) {
      val s1 = s.substring(0, s.length / 2)
      val s2 = s.substring(s.length / 2)
      if (s1 == s2) 0 else (s1.length - s1.intersect(s2).length)
    } else -1
    println(answer)
  }
}
