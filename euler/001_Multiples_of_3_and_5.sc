/**
  * URL: https://projecteuler.net/problem=1
  */
def sumOfMultiples(n: Int, m: Int): Long = {
  (m - m%n) * ((m - m%n)/n + 1).toLong >> 1
}

def solve(n: Int): Long = sumOfMultiples(3, n - 1) + sumOfMultiples(5, n - 1) - sumOfMultiples(15, n - 1)

println(solve(1000)) // 233168
