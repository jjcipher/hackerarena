/**
  * URL: https://www.hackerrank.com/challenges/gem-stones
  */

/**
  * A character is called gemstone if occurs at least once in every strings.
  * So the idea is to go through the input strings and retain only the characters
  * that are present in all previous strings. We could use foldLeft for that, and use
  * a string containing a - z characters as the initial values.
  */
def findGemstones(lists: List[String]): List[Char] = {
  val labels = "abcdefghijklmnopqrstuvwxyz".toList
  lists.foldLeft((labels))((a,b) => b.toList.distinct.filter(a.contains(_)))
}

/**
  * Version 2
  */
def findGemstones2(lists: List[String]): String = {
  lists.reduce(_ intersect _)
}

// Test Cases
val l1 = List("abcdde", "baccd", "eeabg")
findGemstones(l1) // List(a, b)
findGemstones2(l1) // "ab"
