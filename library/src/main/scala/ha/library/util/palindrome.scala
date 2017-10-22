package ha.library.util

object palindrome {
  def isPalindrome[A](list: List[A]): Boolean = list == list.reverse

  def split(n: Long): List[Int] = {
    if (n == 0) List(0)
    else
      Stream.iterate(n)(_ / 10).takeWhile(_ != 0).map(i => (i % 10).toInt).toList.reverse
  }

  implicit class StringChecker(s: String) {
    def isPalindrome: Boolean = palindrome.isPalindrome(s.toList)
  }

  implicit class LongChecker(n: Long) {
    def isPalindrome: Boolean = palindrome.isPalindrome(split(n))
  }

}
