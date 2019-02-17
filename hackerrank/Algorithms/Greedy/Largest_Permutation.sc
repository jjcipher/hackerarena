/**
  * URL: https://www.hackerrank.com/challenges/largest-permutation/problem
  */

import scala.annotation.tailrec

/**
  *  Version 1: Failed at test cases #13, #14, #15 due to timeout...
  */
def largestPermutation1(k: Int, arr: Array[Int]): Array[Int] = {
  if (k == 0) arr
  else {
    val sorted = arr.sorted(Ordering[Int].reverse)

    @tailrec
    def swap(k: Int, pos: Int, arr: Array[Int]): Array[Int] = {
      if (k == 0 || arr.deep == sorted.deep)
        arr
      else if (arr(pos) == sorted(pos))
        swap(k, pos + 1, arr)
      else {
        val t = sorted(pos)
        val idx = arr.indexOf(t)
        arr(idx) = arr(pos)
        arr(pos) = t
        swap(k - 1, pos + 1, arr)
      }
    }

    swap(k, 0, arr)
  }
}

/**
  * Version 2: passed all test cases.
  */
def largestPermutation(k: Int, arr: Array[Int]): Array[Int] = {
  if (k == 0) arr
  else {
    val n = arr.size
    // Record the numbers' positions in the pos array.
    val pos = Array.fill(n)(-1)
    for (i <- 0 until n)
      pos(arr(i) - 1) = i

    @tailrec
    def swap(k: Int, i: Int, arr: Array[Int]): Array[Int] = {
      if (k == 0 || i == 0)
        arr
      else {
        val actualPos = pos(i - 1)
        val expectedPos = n - i

        // If the position is not as expected
        if (actualPos != expectedPos) {
          // Swap the values at two positions
          arr(actualPos) = arr(expectedPos)
          arr(expectedPos) = i

          // Update the pos array as well
          pos(arr(actualPos) - 1) = actualPos
          pos(arr(expectedPos) - 1) = expectedPos

          swap(k - 1, i - 1, arr)
        } else {
          swap(k, i - 1, arr)
        }
      }
    }

    swap(k, n, arr)
  }
}



largestPermutation(1, Array(5, 2, 4, 1, 3))
largestPermutation(2, Array(5, 2, 4, 1, 3))
largestPermutation(3, Array(5, 2, 4, 1, 3))
largestPermutation(1, Array(2, 1, 3))
largestPermutation(1, Array(2, 1))
