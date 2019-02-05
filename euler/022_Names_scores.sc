/**
  * URL: https://projecteuler.net/problem=22
  */
import scala.io.Source

val filename = "euler/p022_names.txt"

val lines = Source.fromFile(filename).getLines

val names = lines.toList(0).replace("\"","").split(",").sorted

val result = {for (i <- 1 to names.length) yield { names(i - 1).toList.map(c => c.toInt - 'A'
  .toInt + 1).sum * i}}.sum
