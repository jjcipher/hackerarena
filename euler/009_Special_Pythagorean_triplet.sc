/**
  * URL: https://projecteuler.net/problem=9
  */
val cachedPythagoreans: List[Int] = {
  val n = 3000
  val cache = Array.fill[Int](n + 1)(-1)
  for {
    a <- 1 until n / 3
    b <- a + 1 until (n - a) / 2
    c2 = a * a + b * b
    c = math.sqrt(c2).toInt
    if (c * c == c2)
    sum = a + b + c
    if (sum <= n)
    prod = a * b * c
  } yield {
    if (cache(sum) < prod)
      cache(sum) = prod
  }
  cache.toList
}

def solve(n: Int): Int = cachedPythagoreans(n)

println(solve(1000)) // 31875000



