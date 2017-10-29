package ha.library.math

import org.scalatest.{BeforeAndAfter, GivenWhenThen, WordSpec}
import ha.library.util.palindrome._

class palindromeSpec extends WordSpec with GivenWhenThen with BeforeAndAfter {

  def provide = afterWord("provide")

  "object palindrome" should provide {
    "isPalindrome[A](Seq[A]) " in {
      assert(isPalindrome(Seq(1)) == true)
      assert(isPalindrome(Seq(1,2,3,2,1)) == true)
      assert(isPalindrome(Seq(1,2,3,3,2,1)) == true)
      assert(isPalindrome(Seq(1,2,3,4,2,1)) == false)
      assert(isPalindrome(Seq('a')) == true)
      assert(isPalindrome(Seq('a','b','c','b','a')) == true)
      assert(isPalindrome(Seq('a','b','c','c','b','a')) == true)
      assert(isPalindrome(Seq('a','b','c','d','b','a')) == false)
    }

    "isPalindrome(Long) " in {
      assert(isPalindrome(1) == true)
      assert(isPalindrome(1234567890987654321L) == true)
      assert(isPalindrome(1234321) == true)
      assert(isPalindrome(12345321) == false)
    }
  }
}

