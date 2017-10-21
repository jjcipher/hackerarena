/**
  * URL: https://www.hackerrank.com/challenges/sherlock-and-cost
  */
def findAnswer(array: Array[Int]): Int = {
  if (array.length > 1) {
    val endAtLowM = Array.fill(array.length)(-1)
    val endAtHighM = Array.fill(array.length)(-1)

    def endAtLow(i: Int): Int = {
      if (endAtLowM(i) == -1) {
        endAtLowM(i) = {
          if (i == 1) array(0) - 1
          else math.max(
            endAtLow(i - 1),
            endAtHigh(i - 1) + array(i - 1) - 1)
        }
        //println(s"endAtLow(${i}) == ${endAtLowM(i)}")
      }
      endAtLowM(i)
    }

    def endAtHigh(i: Int): Int = {
      if (endAtHighM(i) == -1) {
        endAtHighM(i) = {
          if (i == 1) math.max(array(1) - 1, math.abs(array(1) - array(0)))
          else math.max(
            endAtLow(i - 1) + array(i) - 1,
            endAtHigh(i - 1) + math.abs(array(i) - array(i - 1)))
        }
        //println(s"endAtHigh(${i}) == ${endAtHighM(i)}")
      }
      endAtHighM(i)
    }

    val endIdx = array.length - 1
    math.max(endAtLow(endIdx), endAtHigh(endIdx))
  } else 0
}

val ar = Array(100, 2, 100, 2, 100)
findAnswer(ar)
