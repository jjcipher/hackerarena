package ha.library.util

object matrix {

  val magicSquare_3x3_1 = Array(Array(4,9,2), Array(3,5,7), Array(8,1,6))
  val magicSquare_3x3_2 = magicSquare_3x3_1.transpose
  val magicSquare_3x3_3 = magicSquare_3x3_2.swapRows()
  val magicSquare_3x3_4 = magicSquare_3x3_3.transpose
  val magicSquare_3x3_5 = magicSquare_3x3_1.swapRows()
  val magicSquare_3x3_6 = magicSquare_3x3_5.transpose
  val magicSquare_3x3_7 = magicSquare_3x3_6.swapRows()
  val magicSquare_3x3_8 = magicSquare_3x3_7.transpose

  val magicSquares_3x3 = List(
    magicSquare_3x3_1,
    magicSquare_3x3_2,
    magicSquare_3x3_3,
    magicSquare_3x3_4,
    magicSquare_3x3_5,
    magicSquare_3x3_6,
    magicSquare_3x3_7,
    magicSquare_3x3_8
  )

  def absDiff(m1: Array[Array[Int]], m2: Array[Array[Int]]): Int = {
    (for {
      i <- 0 to m1.length - 1
      j <- 0 to m1(i).length - 1
    } yield {
      math.abs(m1(i)(j) - m2(i)(j))
    }).sum
  }

  implicit class ArrayHelper[A](arr: Array[Array[A]]) {
    def swapRows(): Array[Array[A]] = {
      val array = arr.clone()
      for (i <- 0 to array.length / 2 - 1) {
        val temp = array(i)
        array(i) = array(array.length - 1 - i)
        array(array.length - 1 -i) = temp
      }
      array
    }

    def rotateLeft(): Array[Array[A]] = {
      arr.transpose.swapRows()
    }

    def rotateRight(): Array[Array[A]] = {
      arr.swapRows().transpose
    }
  }
}
