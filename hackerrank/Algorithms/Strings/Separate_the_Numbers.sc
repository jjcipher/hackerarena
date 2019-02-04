/**
  * URL: https://www.hackerrank.com/challenges/weighted-uniform-string
  *
  * A numeric string, s, is beautiful if it can be split into a sequence of two or more positive
  * integers, a1, a2, ..., an, satisfying the following conditions:
  *
  * 1. a(i) -a(i-1) for any 1 < i <= n (i.e., each element in the sequence is 1 more than the
  * previous element).
  *
  * 2. No a(i) contains a leading zero. For example, we can split "10203" into the sequence {1,
  * 02, 03}, but it is not beautiful because 02 and 03 have leading zeroes.
  *
  * 3. The contents of the sequence cannot be rearranged. For example, we can split "312" into the
  * sequence {3, 1, 2}, but it is not beautiful because it breaks our first constraint (i.e., 1 -
  * 3 != 1).
  */
def findBeautiful(str: String): Long = {
  @annotation.tailrec
  def check(str: String, i: Long): Boolean = {
    val s = i.toString
    if (str.length < s.length) false
    else if (str.substring(0, s.length) == s) {
      if (s.length == str.length) true
      else check(str.substring(s.length), i + 1)
    } else false
  }

  if (str.startsWith("0")) -1L
  else {
    for (i <- 1 to str.length / 2) {
      val beauty = str.substring(0, i).toLong
      if (check(str.substring(i), beauty + 1)) return beauty
    }
    -1L
  }
}

// Test Cases
findBeautiful("1234") // 1
findBeautiful("91011") // 9
findBeautiful("91011") // 9
findBeautiful("101103") // -1

findBeautiful("22222222222222222222222222222222") // -1
findBeautiful("10001001100210031004100510061007") // 1000
findBeautiful("90071992547409929007199254740993") // 9007199254740992
findBeautiful("562949953421312562949953421313") // 562949953421312
