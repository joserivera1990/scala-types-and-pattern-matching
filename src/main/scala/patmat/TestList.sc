import scala.annotation.tailrec

object TestList {

  //Lists

  val chars = "abcdefgh" toList

  val char = 'i' :: chars

  chars.length

  chars.init

  chars take 10

  chars drop 5

  chars(2)

  val newChars = "ijklmnop" toList

  chars ++ newChars

  chars.reverse

  chars updated (2, 'z')

  chars indexOf 'd'

  chars contains 'd'

  chars.drop(1)

  chars filterNot (x => x =='a')

  chars filter (x => x =='a')

  //Pair between filterNot and filter
  chars partition (x=> x == 'a')

  chars takeWhile (x => x !='a')

  val numbers = List(1,-4,2,3,-1)

  // stop evaluation immediately after condition is not met.
  numbers takeWhile (x => x > 0)

  //Another values different to takewhile
  numbers dropWhile (x => x > 0)

  //Pair between takeWhile and dropWhile
  numbers span (x => x > 0)

  var letters = List("a", "a", "a", "b", "c", "c", "a")

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }

  pack(letters)

  def encode[T](xs: List[T]):  List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))

  encode(letters)

  def sum(xs:List[Int]) = (0 :: xs) reduceLeft (_ + _)

  val numberslist = List(1,2,3,4)

  sum(numberslist)

  numberslist.foldLeft(0)(_ + _)

}