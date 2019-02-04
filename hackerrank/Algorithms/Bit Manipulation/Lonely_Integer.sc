/**
  * URL: https://www.hackerrank.com/challenges/lonely-integer
  */
def lonelyinteger(a: Array[Int]): Int =  {
  // Wrapping in a method is too much trouble...
  a.reduce(_^_)
}

val a = Array(0, 0, 1, 2, 1)
lonelyinteger(a)
