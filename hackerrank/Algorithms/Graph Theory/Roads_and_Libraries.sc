/**
  * URL: https://www.hackerrank.com/challenges/torque-and-development
  *
  * HackerLand has n cities numbered from 1 to n. The cities are connected by m bidirectional roads.
  * A citizen has access to a library if:
  *
  * 1. Their city contains a library.
  * 2. They can travel by road from their city to a city containing a library.
  *
  * The cost of repairing any road is c-r dollars, and the cost to build a library in any city is
  * c-l dollars.
  *
  * You are given q queries, where each query consists of a map of HackerLand and value of c-r and
  * c-l.
  *
  * For each query, find the minimum cost of making libraries accessible to all the citizens
  * and print it on a new line.
  */

import scala.collection.mutable.{HashMap, ListBuffer}

def cost(n: Int, cl: Long, cr: Long, map: HashMap[Int, ListBuffer[Int]]): Long = {
  if (cl <= cr) n * cl
  else {
    var cost: Long = 0L
    for (list <- map.values) {
      val size = list.size
      if (size > 0) {
        cost += cl
        cost += (size - 1) * cr
        //list.foreach(map -= _)
        list.clear
      }
    }
    cost
  }
}

// load test cases
val inputs = """2
               |3 3 2 1
               |1 2
               |3 1
               |2 3
               |6 6 2 5
               |1 3
               |3 4
               |2 4
               |1 2
               |2 3
               |5 6""".stripMargin.split("\n")

val lines = inputs.toIterator
val q = lines.next().toInt

for (i <- 1 to q) {
  val args = lines.next().split(" ").toList
  val n = args(0).toInt
  val m = args(1).toInt
  val cl = args(2).toLong
  val cr = args(3).toLong

  val cityMap = new HashMap[Int, ListBuffer[Int]]()
    (1 to n).map(i => (i -> ListBuffer(i))).foreach(cityMap += _)

  for (i <- 1 to m) {
    val cities = lines.next().split(" ").toList
    val city_0 = cities(0).toInt
    val city_1 = cities(1).toInt
    val l0: ListBuffer[Int] = cityMap.get(city_0).get
    val l1: ListBuffer[Int] = cityMap.get(city_1).get
    if (l0 != l1) {
      l0 ++= l1
      cityMap += (city_0 -> l0)
      l1.foreach(i => cityMap += (i -> l0))
    }
  }

  println(cost(n, cl, cr, cityMap))
}



