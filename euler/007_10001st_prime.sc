/**
  * URL: https://projecteuler.net/problem=7
  */
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(
  i => primes.takeWhile(j => j * j <= i).forall(j => i % j > 0)
)

def solve(n: Int): Int = primes.take(n).last

println(solve(10001)) // 104743


