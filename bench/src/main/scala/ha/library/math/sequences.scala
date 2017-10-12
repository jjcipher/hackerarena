package ha.library.math

import sequences._
import org.openjdk.jmh.annotations.Benchmark

class SequencesBenchmark {

  @Benchmark
  def factsTest1(): Unit =
    for (i <- 1 to 10000) facts.take(i).last

  @Benchmark
  def factsTest2(): Unit =
    for (i <- 10000 to 1 by -1) facts.take(i).last
}
