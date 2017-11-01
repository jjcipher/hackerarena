/**
  * URL: https://www.hackerrank.com/challenges/game-of-thrones/problem
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val s = StdIn.readLine
  val isPalindrome = if (s.length % 2 == 0) {
    s.groupBy(identity).values.forall(_.length % 2 == 0)
  } else {
    s.groupBy(identity).values.filter(_.length % 2 != 0).size == 1
  }
  if (isPalindrome) println("YES") else println("NO")
}
