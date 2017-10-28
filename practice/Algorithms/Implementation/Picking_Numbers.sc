/**
  * URL: https://www.hackerrank.com/challenges/picking-numbers
  */
def solution(array: Array[Int]): Unit = {
  val list = array.groupBy(identity).map { case (a, b) => (a, b.size) }.toList.sortBy(_._1)
  val diffLessThanOneCounts = list.zip((0, 0) :: list).map { case ((a, cnt_a), (b, cnt_b)) => if (a - b <= 1) cnt_a + cnt_b else cnt_a }
  println(diffLessThanOneCounts.max)
}

// Test Cases
solution(Array(4,6,5,3,3,1))
solution(Array(1,2,2,3,1,2))
