/**
  * URL: https://projecteuler.net/problem=14
  */
def collatzChainLength(start: Int): Int = {
  def collatz(n: Long): Long = {
    if (n % 2 == 0) n / 2
    else 3 * n + 1
  }

  def count(x: Long, acc: Int): Int = x match {
    case 1 => acc
    case _ => count(collatz(x), acc + 1)
  }

  count(start, 1)
}

def memoizedCollatzChainLength: Int => Int = {
  val cache = collection.mutable.Map.empty[Int, Int]
  start => {
    cache.getOrElse(start, {
      cache update(start, collatzChainLength(start))
      cache(start)
    })
  }
}

def longestChain(limit: Int): Int = {
  var maxLength = 0
  var result = 0
  var n = 1
  while (n < limit) {
    val l = collatzChainLength(n)
    if (l > maxLength) {
      maxLength = l
      result = n
    }
    n = n + 1
  }
  result
}

/**
  * Find length of the longest collatz chain by using
  * memorizedCollatzChainLength. Actually this doesn't
  * help.
  */
def longestChain2(limit: Int): Int = {
  var maxLength = 0
  var result = 0
  var n = 1
  val length = memoizedCollatzChainLength
  while (n < limit) {
    val l = length(n)
    if (l > maxLength) {
      maxLength = l
      result = n
    }
    n = n + 1
  }
  result
}

val a = System.currentTimeMillis()
longestChain(1000000)
val b = System.currentTimeMillis()
longestChain2(1000000)
val c = System.currentTimeMillis()
println("without cache: " + (b - a))
println("with cache: " + (c - b))
