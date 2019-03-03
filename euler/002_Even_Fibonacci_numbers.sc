/**
  * URL: https://projecteuler.net/problem=2
  */
import scala.math.BigInt
import scala.language.postfixOps

lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{n => n._1 + n._2}

def solve(n: Int): BigInt = fibs.takeWhile(_ < n).filter(_ % 2 == 0).sum

println(solve(4000000)) // 4613732
