package ha.library.util

object palindrome {
  def isPalindrome[A](seq: Seq[A]): Boolean = seq == seq.reverse

  def split(n: Long): List[Int] = {
    if (n == 0) List(0)
    else
      Stream.iterate(n)(_ / 10).takeWhile(_ != 0).map(i => (i % 10).toInt).toList.reverse
  }

  def isPalindrome(n: Long): Boolean = palindrome.isPalindrome(split(n))
}
