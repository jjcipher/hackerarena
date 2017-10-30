/**
  * URL: https://www.hackerrank.com/challenges/circular-array-rotation
  */
def main(args: Array[String]) {
  import scala.io.StdIn
  val Array(n, k, q) = StdIn.readLine.split("\\s+").map(_.toInt)
  val a = StdIn.readLine.split("\\s+").map(_.toInt)
  for (i <- 0 until q) {
    val m = StdIn.readInt
    println(a(shift(m)))
  }

  // To map the new index after k times right circular rotation to the original index
  def shift(id: Int) = {
    if (k % n == 0) id
    else (id + n - k % n) % n
  }
}
