/**
  * URL: https://projecteuler.net/problem=5
  */
import ha.library.math.arithmetic._

def solve(n: Int): BigInt = (BigInt(2) to n).reduce(lcm)

println(solve(20)) // 232792560
