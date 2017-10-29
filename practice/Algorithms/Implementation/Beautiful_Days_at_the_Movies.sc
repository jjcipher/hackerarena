/**
  * URL: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
  */
def main(args: Array[String]) {
  import scala.io.StdIn
  val Array(i, j, k) = StdIn.readLine().split("\\s+").map(_.toInt)
  println((i to j).filter(isBeautiful(_, k)).size)
}

def isBeautiful(n: Int, k: Int): Boolean = {
  import ha.library.math.arithmetic.reversed
  math.abs(n - reversed(n)) % k == 0
}

// Test Cases
assert ((20 to 23).filter(isBeautiful(_, 6)).size == 2)


