/**
  * URL: https://www.hackerrank.com/challenges/two-strings/problem
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val p = StdIn.readInt
  for (i <- 1 to p) {
    val a = StdIn.readLine
    val b = StdIn.readLine
    if (a.intersect(b).length > 0) println("YES") else println("NO")
  }
}
