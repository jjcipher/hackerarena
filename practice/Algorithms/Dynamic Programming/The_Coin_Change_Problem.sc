/**
  * URL: https://www.hackerrank.com/challenges/coin-change
  *
  * You have m types of coins available in infinite quantities where the value of each coin is
  * given in the array C = [c0, c1, ... cm-1]. Can you determine the number of ways of making
  * change for  units using the given types of coins?
  */

def wayToChange(amount: Int, coins: List[Int]): Long = {
  var combinations = new Array[Long](amount + 1)
  combinations(0) = 1
  for {
    c <- coins
    n <- 1 to amount
  } if (n >= c) combinations(n) += combinations(n - c)
  combinations(amount)
}

wayToChange(10, List(2, 5, 3, 6))
