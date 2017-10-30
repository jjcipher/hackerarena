/**
  * URL: https://www.hackerrank.com/challenges/strange-advertising
  */
object Solution {
  import scala.io.StdIn
  def main(args: Array[String]) {
    val n = StdIn.readInt
    print((1 to n).map(newLike).sum)
  }

  def newLike(d: Int): Int = {
    val init = 5
    val newLikeMem = Array.fill(51)(-1)
    newLikeMem(1) = math.floor(5 / 2).toInt
    if (newLikeMem(d) == -1) newLikeMem(d) = math.floor(newLike(d - 1) * 3 / 2).toInt
    newLikeMem(d)
  }


  // Test Case
  assert ((1 to 50).map(newLike).sum == 2068789129)
}

