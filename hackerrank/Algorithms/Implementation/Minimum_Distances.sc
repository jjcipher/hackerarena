/**
  * URL: https://www.hackerrank.com/challenges/minimum-distances/problem
  */
def minimumDistances(a: Array[Int]): Int = {
  val m = (for (i <- 0 until a.size) yield (a(i), i))
    .groupBy(_._1).filter(_._2.size > 1)

  if (m.isEmpty) -1
  else m.map{ case (k,v) => v.map(_._2) }.map(v => v.sliding(2)
    .map{ case Seq(a, b) => (b - a)}.min).min
}

minimumDistances(Array(1, 2, 3, 4, 10))
minimumDistances(Array(7, 1, 3, 4, 1, 7))
