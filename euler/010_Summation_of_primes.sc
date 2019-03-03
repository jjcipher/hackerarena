/**
  * URL: https://projecteuler.net/problem=10
  */
import ha.library.math.sequences._

def solve(n: Int): BigInt = primes.takeWhile(p => p <= n).map(BigInt(_)).sum

println(solve(2000000)) // 142913828922



