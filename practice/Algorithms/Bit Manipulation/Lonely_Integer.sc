/**
  * URL: https://www.hackerrank.com/challenges/lonely-integer
  *
  * Consider an array of  integers, , where all but one of the integers occur in pairs.
  * Given , find and print the unique element.
  */
def lonelyinteger(a: Array[Int]): Int =  {
  //a.groupBy(identity).toList.filter(_._2.size != 2).head._1
  a.reduce(_^_)
}

val a = Array(0, 0, 1, 2, 1)
lonelyinteger(a)
