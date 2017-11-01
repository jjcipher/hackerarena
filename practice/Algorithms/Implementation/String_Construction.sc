/**
  * URL: https://www.hackerrank.com/challenges/string-construction/problem
  */

/**
  * Version 1. This got timeout on 4 Test Cases (#8 ~ #11)
  */
def stringConstruction(s: String): Int =  {
  (for (
    i <- 1 to s.length - 1
    if (!s.substring(0, i).contains(s.charAt(i)))
  ) yield {
    1
  }).sum + 1
}

/**
  * Version 2.
  */
def stringConstruction2(s: String): Int =  {
  val p = new StringBuilder()
  var result = 0
  for (i <- 0 to s.length - 1) {
    val ch = s.charAt(i)
    if (!p.contains(ch)) {
      p.append(ch)
      result += 1
    }
  }
  result
}
