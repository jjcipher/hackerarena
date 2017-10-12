package ha.library.math

import scala.language.postfixOps
import scala.math.BigInt

object sequences {
  /**
    * Factorial numbers
    */
  lazy val facts: Stream[BigInt] = BigInt(1) #:: facts.zip(Stream.from(1)).map(n => n._1 * n._2)

  /**
    * Fibonacci numbers
    */
  lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{n => n._1 + n._2}

  /**
    * The n-th Triangle numbers
    *
    * alternative:
    *   private lazy val series: Stream[Int] = 0 #::
    *     series.zip(Stream.from(1)).map(n => n._1 + n._2)
    *   lazy val triangles: Stream[Int] = series.drop(1)
    */
  def triangleNumbers(n: Int): Int = n * (n + 1) / 2


}
