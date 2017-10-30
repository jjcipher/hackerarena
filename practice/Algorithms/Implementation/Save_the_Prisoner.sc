/**
  * URL: https://www.hackerrank.com/challenges/save-the-prisoner
  */
import scala.io.StdIn

def main(args: Array[String]) {
  val t = StdIn.readInt
  for (i <- 0 until 10) {
    val Array(n, m, s) = StdIn.readLine.split("\\s+").map(_.toInt)
    val id = (s + m - 1) % n
    if (id == 0) println(n) else println(id)
  }
}
