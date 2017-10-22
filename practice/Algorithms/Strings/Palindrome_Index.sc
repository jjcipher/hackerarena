/**
  * URL: https://www.hackerrank.com/challenges/palindrome-index
  */

//def isPalindrome[A](list: List[A]): Boolean = list == list.reverse
import ha.library.util.palindrome._
import ha.library.util.string._

/**
  * Version 1. This got timeout at Test Cases #5 ~ #8, #10, #12 ~ #14
  */
def palindromeIndex(str: String): Int = {
  if (str.isPalindrome) -1
  else {
    for (i <- 0 until str.length) {
      if (str.deleteAt(i).isPalindrome) return i
    }
    -2 // cannot find answer!!
  }
}

/**
  * Version 2. We can check at only those characters are different.
  */
def plaindromeIndex2(str: String): Int = {
  if (str.isPalindrome) -1
  else {
    val idx = str.zip(str.reverse).take(str.length / 2).indexWhere {
      case (a, b) => a != b
    }
    if (str.deleteAt(idx).isPalindrome) idx else (str.length - idx - 1)
  }
}

// Test Cases
palindromeIndex("aaab")
palindromeIndex("baa")
palindromeIndex("aaa")
