/**
  * URL: https://www.hackerrank.com/challenges/pascals-triangle
  */
lazy val facts: Stream[Int] = 1 #:: facts.zip(Stream.from(1)).map(n => n._1 * n._2)

def printPascalsTriangle(k: Int): Unit = {
  def row(n: Int) = for(i <- 0 to n) yield facts(n) / (facts(i) * facts(n - i))
  (0 until k).foreach(r => println(row(r).mkString(" ")))
}

printPascalsTriangle(10)
