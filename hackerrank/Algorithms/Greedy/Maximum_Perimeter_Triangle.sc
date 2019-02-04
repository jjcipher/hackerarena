/**
  * URL: https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
  */
import scala.io.StdIn

def main(args: Array[String]): Unit = {
  val n = StdIn.readInt()
  val l = StdIn.readLine().split("\\s+").map(_.toInt)
  val triangles = l.combinations(3).map(new Triangle(_)).filter(_.nonDegenerate)
  if (triangles.isEmpty) println(-1) else println(triangles.max)
}

class Triangle(edges: Seq[Int]) extends Ordered[Triangle] {
  assert(edges.length == 3)
  val Seq(min, mid, max) = edges.sorted
  val nonDegenerate: Boolean = min + mid > max

  override def toString: String = s"$min $mid $max"

  import scala.math.Ordered.orderingToOrdered
  override def compare(that: Triangle) = (this.max, this.min) compare (that.max, that.min)
}
