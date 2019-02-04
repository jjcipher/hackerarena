/**
  * URL: https://projecteuler.net/problem=41
  */
import ha.library.math.arithmetic._

/*
// Find the max 7-digit pandigital prime
"1234567".permutations.filter(p => p.last % 2 != 0 && p.last != 5).map(_.toInt).filter(isPrime).max
*/

(for {
  digits <- 9 to 2 by -1
  primes = (1 to digits).permutations.filter(p => p.last % 2 != 0 && p.last != 5).map(_.mkString
    .toInt).filter(isPrime)
  if primes.nonEmpty
} yield {
  primes.max
}).max
