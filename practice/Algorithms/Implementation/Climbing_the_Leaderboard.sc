/**
  * URL: https://www.hackerrank.com/challenges/climbing-the-leaderboard
  */

/**
  * Version 1. This got timeout on 4 Test Cases (#6 ~ #9)
  */
def main1(args: Array[String]) {
  import scala.io.StdIn
  val n = StdIn.readInt
  val scores = StdIn.readLine.split("\\s+").map(_.toInt)
  val m = StdIn.readInt
  val alice = StdIn.readLine.split("\\s+").map(_.toInt)

  val rs = scores.distinct
  for (i <- 0 until m) {
    val rank = rs.takeWhile(_ > alice(i)).size + 1
    println(rank)
  }
}

/**
  * Version 2. This got timeout on 3 Test Cases (#6 ~ #8)
  * The idea is to reduce the number of scores to compare by dropping the ones that have been
  * compared (passed) already.
  */
def main2(args: Array[String]) {
  import scala.io.StdIn
  val n = StdIn.readInt
  val scores = StdIn.readLine.split("\\s+").map(_.toInt)
  val m = StdIn.readInt
  val alice = StdIn.readLine.split("\\s+").map(_.toInt)

  val rs = scores.distinct.reverse
  var passed = 0
  for (i <- 0 until m) {
    val newPass = rs.drop(passed).takeWhile(_ <= alice(i)).size
    passed += newPass
    val rank = rs.length - passed + 1
    println(rank)
  }
}

/**
  * Version 3. Passed all Test Cases.
  * Same idea as version 2, but just traverse the scores array without using drop() and
  * takeWhile().
  */
def main3(args: Array[String]) {
  import scala.io.StdIn
  val n = StdIn.readInt
  val scores = StdIn.readLine.split("\\s+").map(_.toInt)
  val m = StdIn.readInt
  val alice = StdIn.readLine.split("\\s+").map(_.toInt)

  val rs = scores.distinct.reverse
  var pos = 0
  for (i <- 0 until m) {
    while (pos < rs.length && rs(pos) <= alice(i)) {
      pos += 1
    }
    val rank = rs.length - pos + 1
    println(rank)
  }
}
