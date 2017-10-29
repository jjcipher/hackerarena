/**
  * URL: https://www.hackerrank.com/challenges/append-and-delete
  */
object Solution {

  def main(args: Array[String]) {
    import scala.io.StdIn
    val s = StdIn.readLine()
    val t = StdIn.readLine()
    val k = StdIn.readInt
    if (changeInSteps(s, t, k)) println("Yes") else println("No")
  }

  /**
    * Checks if the t string can be converted to the s string within k steps
    */
  def changeInSteps(s: String, t: String, k: Int): Boolean = {
    // We will be able to do that as long as the total length of both s and t strings is less than k
    if (s.length + t.length <= k) true
    else {
      // Find the length of the common prefix
      val common = s.zip(t).takeWhile{case (a, b) => a == b}.length

      // The number of steps required to convert t to s
      val steps = (t.length - common) + (s.length - common)

      // K needs to be larger than or equal to the steps and k minus the steps needs to be a
      // multiple of 2 (for appending a dummy char and then delete it).
      k >= steps && ((k - steps) % 2 == 0)
    }
  }

  // Test Cases
  assert (changeInSteps("hackerhappy", "hackerrank", 9) == true)
  assert (changeInSteps("aba", "aba", 7) == true)
  assert (changeInSteps("y", "yu", 2) == false)

}
