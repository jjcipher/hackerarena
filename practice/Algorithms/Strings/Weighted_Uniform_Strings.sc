/**
  * URL: https://www.hackerrank.com/challenges/weighted-uniform-string
  */
/**
  * Returns a list of the uniform substrings of the given string.
  * @param str the input string
  * @return a list of the uniform substrings of the input string.
  */
def uniformSubstrings(str: String): List[String] = {
  @annotation.tailrec
  def loop(s: String, uniformSubstrings: List[String]): List[String] = s match {
    case "" => uniformSubstrings
    case _ =>
      if (s.length > 1) {
        var i = 0
        val char = s.charAt(0)
        while (i < s.length && s.charAt(i) == char) i += 1
        val us = s.substring(0, i)
        loop(s.substring(i), us :: uniformSubstrings)
      } else s :: uniformSubstrings
  }

  loop(str, Nil).reverse
}

/**
  * Weighting the input list of uniform substrings.
  * @param us the input list of uniform substrings
  * @return weighted uniform substring list, each uniform substring is presented by a tuple, the
  *         first item is the weight of the Char of the uniform string; the second item is the
  *         length of the uniform string.
  */
def weighting(us: List[String]): List[(Int, Int)] = {
  us.map(s => (s.head - 'a' + 1, s.length))
}

/**
  * Checks if the given value match weights of the uniform strings
  * @param list the weighted uniform strings
  * @param value the value to check
  * @return
  */
def matchWeight(list: List[(Int, Int)], value: Int): Boolean = {
  list.foreach(p => {
    if ((value % p._1) == 0 && (value / p._1) <= p._2) return true
  })
  false
}


// Test Cases
val us = uniformSubstrings("abccddda") // List(a, b, cc, ddd, a)
val usv = weighting(us) // List((1,1), (2,1), (3,2), (4,3), (1,1))

List(1,3,12,5,9,10).map(matchWeight(usv, _))
