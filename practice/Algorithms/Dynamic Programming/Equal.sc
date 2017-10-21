/**
  * URL: https://www.hackerrank.com/challenges/equal
  *
  * Christy is interning at HackerRank. One day she has to distribute some chocolates to her
  * colleagues. She is biased towards her friends and may have distributed the chocolates
  * unequally. One of the program managers gets to know this and orders Christy to make sure
  * everyone gets equal number of chocolates.
  *
  * But to make things difficult for the intern, she is ordered to equalize the number of
  * chocolates for every colleague in the following manner,
  *
  * For every operation, she can choose one of her colleagues and can do one of the three things.
  *
  * 1. She can give one chocolate to every colleague other than chosen one.
  * 2. She can give two chocolates to every colleague other than chosen one.
  * 3. She can give five chocolates to every colleague other than chosen one.
  *
  * Calculate minimum number of such operations needed to ensure that every colleague has the
  * same number of chocolates.
  */
val decrements: Seq[Int] = Seq(5, 2, 1)

def reduceCount(amount: Int): Int = {
  @annotation.tailrec
  def loop(remainder: Int, decIdx: Int, count: Int): Int = {
    if (decIdx >= decrements.length) count
    else {
      val denom = decrements(decIdx)
      loop(remainder % denom, decIdx + 1, count + remainder / denom)
    }
  }
  loop(amount, 0, 0)
}

val ar = List(2,5 ,5 ,5 ,5 ,5)

val minCount = (for (i <- 0 until decrements.max) yield {
  val target = ar.min - i
  ar.map(e => reduceCount(e - target)).sum
}).min

println(minCount)
