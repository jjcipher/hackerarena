/**
  * URL: https://projecteuler.net/problem=4
  */
object Palindrome {
  def isPalindrome[A](list: List[A]): Boolean = list == list.reverse

  def split(n: Long): List[Int] = {
    if (n == 0) List(0)
    else
      Stream.iterate(n)(_ / 10).takeWhile(_ != 0).map(i => (i % 10).toInt).toList.reverse
  }

  implicit class LongChecker(n: Long) {
    def isPalindrome(): Boolean = Palindrome.isPalindrome(split(n))
  }
}

def maxPalindrome(n: Int): Int = {
  import Palindrome._
  var max = 100000
  for {
    i <- 999 to 100 by -1
    j <- i to 100 by -1
    temp = i * j
    if (temp < n && temp > max)
    if temp.isPalindrome()
  } yield {
    max = temp
  }
  max
}

println(maxPalindrome(1000000)) // 906609
