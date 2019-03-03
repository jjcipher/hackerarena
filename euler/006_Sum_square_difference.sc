/**
  * URL: https://projecteuler.net/problem=6
  */
def square(n: Long): Long = n * n

def solve(n: Int): Long = {
  val squareOfSums: Long = square((1 to n).sum.toLong)
  // the sum of the squares of the first n natural numbers
  val sumOfSquares: Long = (n * (n + 1) * (2 * n + 1).toLong / 6)
  squareOfSums - sumOfSquares
}

println(solve(100)) // 25164150


