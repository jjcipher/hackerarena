/**
  * URL: https://www.hackerrank.com/challenges/funny-string
  *
  * Suppose you have a String, S, of length N that is indexed from 0 to N-1.
  * You also have some String, R, that is the reverse of String S. S is funny if the condition
  * |S(i) - S(i-1)| = |R(i) - R(i-1)| is true for every
  * character from 1 to N-1.
  */
// Version 1
// Timeout at the Test Case #9
def isFunny(str: String): Boolean = {
  val ls = str.toList
  val lr = ls.reverse

  def eval(list: List[Char]): List[Int] = {
    (for (
      i <- 1 until list.length
    ) yield {
      math.abs(list(i) - list(i - 1))
    }).toList
  }

  eval(ls).sameElements(eval(lr))
}

// Version 2
def isFunny2(str: String): Boolean = {
  val ls = str.toList

  def eval(list: List[Char]): Boolean = {
    val length = list.length
    for (i <- 1 until length - 1) {
      val a = math.abs(list(i) - list(i - 1))
      val b = math.abs(list(length - i) - list(length - i - 1))
      if (a != b) return false
    }
    return true
  }

  eval(ls)
}

// Test Cases
isFunny2("acxz") // true
isFunny2("bcxz") // false
