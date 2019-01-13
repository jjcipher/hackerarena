import scala.annotation.tailrec

/**
  * URL: https://www.hackerrank.com/challenges/alternating-characters
  */
/**
  * Go through each character in the strings and count the character that
  * is same as the previous character.
  */
def minSteps(str: String): Int = {
  @tailrec
  def count(c: Char, s: String, acc: Int): Int =
    if (s.nonEmpty) {
      if (c == s.head) count(c, s.tail, acc + 1)
      else count(s.head, s.tail, acc)
    } else acc

  count(str.head, str.tail, 0)
}
// Test Cases
assert(minSteps("AAAA") == 3)
assert(minSteps("BBBBB") == 4)
assert(minSteps("ABABABAB") == 0)
assert(minSteps("BABABA") == 0)
assert(minSteps("AAABBB") == 4)
