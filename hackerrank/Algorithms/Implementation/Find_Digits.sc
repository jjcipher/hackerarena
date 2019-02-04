/**
  * URL: https://www.hackerrank.com/challenges/find-digits/problem
  */
object Solution {
  import scala.io.StdIn
  def main(args: Array[String]) {
    val t = StdIn.readInt
    for (i <- 0 until t) {
      val n = StdIn.readLine
      val answer = n.toList.filter(_ != '0').groupBy(identity).map {
        case (i, list) => if (n.toInt % (i.toInt - '0') == 0) list.size else 0
      }.sum
      println(answer)
    }
  }
}

