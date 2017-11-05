/**
  * URL: https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
  */
/**
  * Version 1. Timeout on 2 Test Cases (#2, #3)
  */
def minimumAbsoluteDifference(n: Int, arr: Array[Int]): Int =  {
  var min = Int.MaxValue
  for {
    i <- 0 until n - 1
    j <- i + 1 until n
  } {
    val t = math.abs(arr(i) - arr(j))
    if (t < min) min = t
  }
  min
}

/**
  * Version 2. Timeout on 2 Test Cases (#2, #3)
  */
def minimumAbsoluteDifference2(n: Int, arr: Array[Int]): Int =  {
  val sortedArr = arr.sorted
  var min = Int.MaxValue
  for (i <- 0 until n - 1) {
    val t = math.abs(sortedArr(i) - sortedArr(i + 1))
    if (t < min) min = t
  }
  min
}
