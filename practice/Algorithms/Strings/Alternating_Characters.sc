/**
  * URL: https://www.hackerrank.com/challenges/alternating-characters
  */
/**
  * Go through each character in the strings and count the character that
  * is same as the previous character.
  */
def minSteps(str: String): Int = {
  var cnt = 0
  for (i <- 1 until str.length) {
    if (str.charAt(i) == str.charAt(i - 1)) cnt += 1
  }
  cnt
}

// Test Cases
minSteps("AAAA")
minSteps("BBBBB")
minSteps("ABABABAB")
minSteps("BABABA")
minSteps("AAABBB")
