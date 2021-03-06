package ha.library.math

object arithmetic {
  def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a % b)

  def gcd(nums: Iterable[BigInt]): BigInt = nums.reduce(gcd)

  def lcm(a: BigInt, b: BigInt): BigInt = if (a == 0 || b == 0) 0 else a * b / gcd(a, b)

  def lcm(nums: Iterable[BigInt]): BigInt = nums.reduce(lcm)

  /**
    * List the factors of the given integer, sorted in ascending order.
    * ref: http://louisbotterill.blogspot.com/2009/03/prime-factorization-comparison-between.html
    *
    * @return a List of the prime factors of the given integer.
    */
  def factors(n: Int): Seq[Int] = {
    def divides(d: Int, n: Int) = (n % d) == 0

    def ld(n: Int): Int =  ldf(2, n)

    def ldf(k: Int, n: Int): Int = {
      if (divides(k, n)) k
      else if ((k * k) > n) n
      else ldf((k + 1), n)
    }

    n match {
      case 1 => Nil
      case _ => val p = ld(n); p +: factors(n / p)
    }
  }

  /**
    * List the divisors of the given integer, sorted in ascending order.
    *
    * alternative:
    *   def divisors(n: Int): Seq[Int] = for (i <- 1 to n / 2; if (n % i == 0)) yield i
    */
  def divisors(x: Int): Seq[Int] = (1 to scala.math.sqrt(x).toInt)
    .filter(x % _ == 0).flatMap(n => List(n, x/n).distinct).sorted

  /**
    * Reverses the input Int. For example, reversed(123) => 321; reversed(120) => 21
    */
  def reversed(n: Int): Int = {
    var num = n
    var result = 0
    while (num > 0) {
      val r = num % 10
      result = result * 10 + r
      num = num / 10
    }
    result
  }

  /**
    * Find how many digits of the given number.
    */
  def digits(number: Long): Int = {
    var length: Int = 0
    var temp: Long = 1L
    while ( temp <= number) {
      length += 1
      temp *= 10
    }
    length
  }

  def digits(number: BigInt): Int = number.toString.size

  /**
    * Find the sum of the digits of the given number.
    */
  def digitSum(number: BigInt): BigInt = {
    var n = number
    var result: BigInt = 0
    while (n > 0) {
      result += n % 10
      n = n / 10
    }
    result
  }

  /**
    * Concatenate the two input numbers.
    */
  def concat(n1: Int, n2: Int): Int = s"$n1$n2".toInt
  def concat(n1: BigInt, n2: BigInt): BigInt = n1 * BigInt(10).pow(digits(n2)) + n2

  def sqrt(number: BigInt): BigInt = {
    def next(n: BigInt, i: BigInt): BigInt = (n + i / n) >> 1
    val one = BigInt(1)
    val n = one
    val n1 = next(n, number)
    def sqrtHelper(n: BigInt, n1: BigInt): BigInt = if ((n1 - n).abs <= one) List(n1,n).max else sqrtHelper(n1, next(n1, number))
    sqrtHelper(n, n1)
  }

  def isPrime(n: Int): Boolean = (2 to math.sqrt(n).toInt) forall (x => n % x != 0)

  //def isPrime(n: BigInt): Boolean = (2 to sqrt(n).toInt) forall (x => n % x != 0)

  def memoizedIsPrime: Int => Boolean = {
    val cache = collection.mutable.Map.empty[Int, Boolean]
    num =>
      cache.getOrElse(num, {
        cache update(num, isPrime(num))
        cache(num)
      })
  }
}
