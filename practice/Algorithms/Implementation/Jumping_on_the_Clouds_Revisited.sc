/**
  * URL: https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val Array(n, k) = StdIn.readLine.split("\\s+").map(_.toInt)
  val c = StdIn.readLine.split("\\s+").map(_.toInt)
  var pos = 0
  var cost = 0
  do {
    pos += k
    cost += c(pos % n) * 2 + 1
  } while (pos % n != 0)
  println(100 - cost)
}
