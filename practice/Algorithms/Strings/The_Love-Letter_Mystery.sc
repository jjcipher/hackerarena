/**
  * URL: https://www.hackerrank.com/challenges/the-love-letter-mystery
  */

/**
  * The final string is a palindrome, that means the character C(0) == C(length - 1),
  * and C(i) == C(length - i - 1).
  * To find out the minimum operations to convert the input string to a palindrome, we can
  * calculate the diff between C(i) & C(length - i - 1) and sum up till the (length / 2)-th
  * character.
  */
def minSteps(str: String): Int =
  str.zip(str.reverse).take(str.length/2).map{case (a, b) => math.abs(a - b)}.sum

// Test Cases
minSteps("abc")
minSteps("abcba")
minSteps("abcd")
minSteps("cba")
