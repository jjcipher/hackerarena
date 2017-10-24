/**
  * URL: https://www.hackerrank.com/challenges/insertionsort1
  * URL: https://www.hackerrank.com/challenges/insertionsort2
  */

import scala.io.StdIn
import scala.collection.mutable.ListBuffer

def main(args: Array[String]) {
  val size = StdIn.readLine().toInt
  val list = StdIn.readLine().split("\\s+").map(_.toInt).to[ListBuffer]
  //insertionSort1(size, list)
  insertionSort2(list)
}

def insertionSort1(size: Int, list: ListBuffer[Int]): Unit = {
  val e: Int = list(size - 1)
  var done = false
  var pos = size - 1
  while (!done) {
    if (pos == 0 || e > list(pos - 1)) {
      list(pos) = e
      done = true
    } else list(pos) = list(pos - 1)
    //println(list.mkString(" "))
    pos -= 1
  }
}

def insertionSort2(list: ListBuffer[Int]): Unit = {
  for (i <- 2 to list.length) {
    insertionSort1(i, list)
    println(list.mkString(" "))
  }
}


// Test Cases
def test(line1: String, line2: String): Unit = {
  val size = line1.toInt
  val list = line2.split("\\s+").map(_.toInt).to[ListBuffer]
  //insertionSort1(size, list)
  insertionSort2(list)
}

val line1 = "5"
val line2 = "2 4 6 8 3"
test(line1, line2)

val line3 = "6"
val line4 = "1 4 3 5 6 2"
test(line3, line4)



