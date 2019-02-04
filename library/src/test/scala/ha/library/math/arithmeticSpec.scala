package ha.library.math

import org.scalatest.{BeforeAndAfter, GivenWhenThen, WordSpec}
import ha.library.math.arithmetic._

class arithmeticSpec extends WordSpec with GivenWhenThen with BeforeAndAfter {

  def provide = afterWord("provide")

  "object arithmetic" should provide {
    "gcd(BigInt, BigInt) " in {
      assert(gcd(13, 169) == 13)
    }

    "gcd(Iterable[BigInt])" in {
      val array = Array(18, 24, 30, 64).map(BigInt(_))
      assert(gcd(array) == BigInt(2))
    }

    "lcm(BigInt, BigInt) " in {
      assert(lcm(13, 26) == 26)
      assert(lcm(13, 27) == 351)
    }

    "lcm(Iterable[BigInt])" in {
      val array = "597 322 187 734 498 215 176 451 114 204".split(" ").map(BigInt(_))
      assert(lcm(array) == BigInt("1467174839068147440"))
    }

    "factors(Int)" in {
      assert(factors(72) == Seq(2,2,2,3,3))
    }

    "divisors(Int)" in {
      assert(divisors(72) == Seq(1, 2, 3, 4, 6, 8, 9, 12, 18, 24, 36, 72))
    }

    "reserved(Int)" in {
      assert(reversed(1234) == 4321)
      assert(reversed(1230) == 321)
    }

    "isPrime(Int)" in {
      assert(isPrime(1297) == true)
      assert(isPrime(1299) == false)
    }
  }
}

