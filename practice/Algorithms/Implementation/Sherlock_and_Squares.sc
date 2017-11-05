/**
  * URL: https://www.hackerrank.com/challenges/sherlock-and-squares/problem
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val t = StdIn.readInt
  for (i <- 0 until t) {
    val Array(a, b) = StdIn.readLine.split("\\s+").map(_.toInt)
    val ra = math.sqrt(a)
    val rb = math.sqrt(b)
    val answer = (a, b) match {
      case (a, b) if (a == b && ra == ra.toInt) => 1
      case (a, b) if (a == b) => 0
      case _ => rb.floor - ra.ceil + 1
    }
    println(answer.toInt)
  }
}
