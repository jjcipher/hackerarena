/**
  * URL: https://www.hackerrank.com/challenges/permutation-equation/
  */
import scala.io.StdIn

def main(args: Array[String]) {
  val n = StdIn.readInt
  val p = StdIn.readLine.split("\\s+").map(_.toInt)
  val q = (1 to n).zip(p).sortBy(_._2).map{case (a, b) => a}
  q.map(i => q(i - 1)).foreach(println)
}
