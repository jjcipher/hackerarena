/**
  * URL: https://www.hackerrank.com/challenges/sherlock-and-valid-string
  */
import scala.io.StdIn
def main(args: Array[String]) {
  val s = StdIn.readLine
  if (check(s)) println("YES") else println("NO")
}

def check(s: String): Boolean = {
  val freqMap = s.groupBy(identity).map{case(a,b)=>(a,b.size)}
  val distinctFreq = freqMap.map(_._2).toList.distinct.size
  val maxFreq = freqMap.maxBy(_._2)._2
  val minFreq = freqMap.minBy(_._2)._2
  val isValid = distinctFreq match {
    case 1 => true
    case 2 if (maxFreq - minFreq == 1 && (freqMap.filter(_._2 == maxFreq).size == 1 || freqMap.filter(_._2 == minFreq).size == 1)) => true
    case 2 if (minFreq == 1 && freqMap.filter(_._2 == minFreq).size == 1) => true
    case _ => false
  }
  isValid
}

// Test Cases
check("aabbccc")
check("aabbc")
check("abcccc")
check("aabbcd")


