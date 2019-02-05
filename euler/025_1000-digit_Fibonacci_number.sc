/**
  * URL: https://projecteuler.net/problem=25
  */
import ha.library.math.sequences._

fibs.takeWhile(f => f.toString.size < 1000).size

// Alternative
//import ha.library.math.arithmetic._
//fibs.takeWhile(f => digits(f) < 1000).size
