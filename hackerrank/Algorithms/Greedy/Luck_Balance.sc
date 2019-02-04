/**
  * URL: https://www.hackerrank.com/challenges/luck-balance/problem
  */
object Solution {

  import scala.io.StdIn

  def main(args: Array[String]) {
    val Array(n, k) = StdIn.readLine.split("\\s+").map(_.toInt)

    val arr: Array[(Int, Int)] = new Array[(Int, Int)](n)

    for (i <- 0 until n) arr(i) = StdIn.readLine.split("\\s+") match {case Array(x, y) => (x.toInt, y.toInt)}

    // Separate the important and non-important contests
    val (imp, nonImp): (Array[(Int, Int)], Array[(Int, Int)]) = arr.partition(_._2 > 0)

    // Among all important contests, choose k contests with higher luck
    val (lostImp, wonImp): (Array[Int], Array[Int]) = imp.map(_._1).sortBy(-_).splitAt(k)

    // sum up all non-important and the k important with high luck, minus the important but with
    // lower luck.
    println(nonImp.map(_._1).sum + lostImp.sum - wonImp.sum)
  }
}
