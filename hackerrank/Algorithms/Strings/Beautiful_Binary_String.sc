/**
  * URL: https://www.hackerrank.com/challenges/beautiful-binary-string
  */
/**
  * The problem is to find the minimum number of steps needed to make the string beautiful,
  * that is to change a 0 to a 1 (or vice versa) so that the string does not contain "010".
  * It is actually same as to find out how many "010" can be extracted from the input string.
  */
def minStep = extract("010") _

/**
  * Returns the number of times that the given substring can be extracted from the input string.
  * @param sub the substring to match
  * @param str the string to be checked
  * @return the number of times that the substring can be extracted
  */
def extract(sub: String)(str: String): Int = {
  var result, pos, idx = 0
  while (idx >= 0) {
    idx = str.indexOf(sub, pos)
    if (idx >= 0) {
      result += 1
      pos = idx + sub.length
    }
  }
  result
}

// Test Cases
minStep("0101010")
minStep("01100")
minStep("010010010")
