/**
  * URL: https://projecteuler.net/problem=60
  */
import ha.library.math.arithmetic._
import ha.library.math.sequences._

val knownPrimes = List(3, 7, 109, 673)

def isPair(n1: Int, n2: Int) =
  isPrime(concat(n1, n2)) && isPrime(concat(n2, n1))

def isSolution(n: Int, ns: List[Int]) =
  ns.forall(isPair(n, _)) // assumes ns was already checked

def solutions(n: Int, primes: List[Int]): List[List[Int]] =
  if(n == 1)
    primes.map(List(_))
  else for {
    p <- primes
    filtered = primes.dropWhile(_ <= p).filter(isPair(p, _))
    soln <- solutions(n - 1, filtered)
  } yield p :: soln

//val list = solutions(4, primes.takeWhile(p => p < 10000).toList).minBy(_.sum)
//val answer = list.sum

val list = solutions(5, primes.takeWhile(p => p < 10000).toList).minBy(_.sum)
val answer = list.sum



