/**
  * URL: https://projecteuler.net/problem=686
  */

def len(x: Int, i: Int = 1): Int = 
  if (x < 10) i 
  else len(x / 10, i + 1)

def first3digits(x: Long): Long = 
  if (x < 1000) x
  else first3digits(x / 10L)

def solutions(n: Int, p: Long, target: Int, cnt: Int): (Int, Long, Int) =
  if (p > 4611686018427387903L) {
    solutions(n, p / 10L, target, cnt)
  } else {
    if (n < target) {
      if (first3digits(p * 2) == 123L) 
        solutions(n + 1, p * 2, target, cnt+1)
      else
        solutions(n, p * 2, target, cnt+1)
    } else (n, p, cnt)
  }

// scala> solutions(0,1L,678910,0)
// res9: (Int, Long, Int) = (678910,1237591285451085544,193060223)

