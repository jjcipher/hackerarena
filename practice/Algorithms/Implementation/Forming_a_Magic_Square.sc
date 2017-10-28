/**
  * URL: https://www.hackerrank.com/challenges/magic-square-forming
  */
val ms1 = Array(Array(4,9,2), Array(3,5,7), Array(8,1,6))
val ms2 = ms1.transpose
val ms3 = ms2.swapRows()
val ms4 = ms3.transpose
val ms5 = ms1.swapRows()
val ms6 = ms5.transpose
val ms7 = ms6.swapRows()
val ms8 = ms7.transpose

val msVariants = List(ms1, ms2, ms3, ms4, ms5, ms6, ms7, ms8)

def minCost(s: Array[Array[Int]]): Int = {
  msVariants.map(absDiff(_, s)).min
}

def absDiff(m1: Array[Array[Int]], m2: Array[Array[Int]]): Int = {
  (for {
    i <- 0 to m1.length - 1
    j <- 0 to m1(i).length - 1
  } yield {
    math.abs(m1(i)(j) - m2(i)(j))
  }).sum
}

implicit class MatrixHelper[A](arr: Array[Array[A]]) {
  def swapRows(): Array[Array[A]] = {
    val array = arr.clone()
    for (i <- 0 to array.length / 2 - 1) {
      val temp = array(i)
      array(i) = array(array.length - 1 - i)
      array(array.length - 1 -i) = temp
    }
    array
  }
}

// Test Cases
val s1 = Array(Array(4,8,2), Array(4,5,7), Array(6,1,6))
minCost(s1)

val s2 = Array(Array(4,9,2), Array(3,5,7), Array(8,1,5))
minCost(s2)

val s3 = Array(Array(6,1,2), Array(7,2,6), Array(5,6,2))
minCost(s3)

