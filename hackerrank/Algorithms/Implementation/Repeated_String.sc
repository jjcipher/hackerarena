/**
  * URL: https://www.hackerrank.com/challenges/repeated-string/problem
  */
import java.io._

object Solution {

  def repeatedString(s: String, n: Long): Long = n / s.length * s.filter(_ == 'a').length +
    s.substring(0, (n % s.length).toInt).filter(_ == 'a').length

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val s = stdin.readLine
    val n = stdin.readLine.trim.toLong
    val result = repeatedString(s, n)

    printWriter.println(result)
    printWriter.close()
  }
}
