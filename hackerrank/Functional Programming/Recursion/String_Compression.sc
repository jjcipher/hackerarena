/**
  * URL: https://www.hackerrank.com/challenges/string-compression
  */
def compress(msg: String): String = {
  var results = new StringBuilder
  @annotation.tailrec
  def loop(s: String, sb: StringBuilder): StringBuilder = s match {
    case "" => sb
    case _ => {
        var i = 1
        val char = s.charAt(0)
        while (i < s.length && s.charAt(i) == char) i += 1
        if (i > 1) loop(s.substring(i), sb.append(char).append(i))
        else loop(s.substring(i), sb.append(char))
      }
  }

  loop(msg, results).toString
}

// Test Cases
compress("abcaaabbb")
compress("abcd")
compress("aaabaaaaccaaaaba")
