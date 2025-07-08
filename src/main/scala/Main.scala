package com.sdraycott.scalachallenges

/*
CURRYING - a function that does not take all of its arguments upfront
This part of the signature  Int => Seq[Int] means that the function returns a function that takes an Int and returns a Seq[Int]
(multiplier: Int) => ... is an anonymous function that takes multiplier as input.
arr.map(x => x * multiplier) produces a new sequence by multiplying each element x by multiplier.
 */

object Main extends App {
  /*
CHALLENGE 1 - Currying functions: multiply all elements in an array
    CURRYING - a function that does not take all of its arguments upfront
    This part of the signature  Int => Seq[Int] means that the function returns a function that takes an Int and returns a Seq[Int]
    (multiplier: Int) => ... is an anonymous function that takes multiplier as input.
    arr.map(x => x * multiplier) produces a new sequence by multiplying each element x by multiplier.
*/
  def multiplyAll(intArr: Seq[Int]): Int => Seq[Int] = {
    (multiplier: Int) => intArr.map(x => x * multiplier)
  }

  val multiplyBy = multiplyAll(Seq(1, 2, 3))
  val result = multiplyBy(2)
  println(result)

  /*
CHALLENGE 2 - Odd or Even?
*/

  def oddOrEven(xs: Seq[Int]): String = {
    if xs.sum % 2 == 0 then "even" else "odd"
  }

  println(oddOrEven(Seq()))

  /*
CHALLENGE 3 - Find the odd Int
  .groupBy(identity) groups elements based on their value - the result is Map[Int, Seq[Int]] where each key is a value from the list
  and each value is a list of the occurrences of that value e.g.:
    Seq(1, 1, 2, 3, 3, 3)
    .groupBy(identity) returns a map
      // => Map(1 -> List(1, 1), 2 -> List(2), 3 -> List(3, 3, 3))
    .map { case (k, v) => (k, v.size) }
      this transforms the previous map into a map of counts v.size is the size of the list i.e. how many times it appears
    .find(odd => odd._2 % 2 != 0)
      this finds the second element of the pair which in this case is the value (v.size) and sees if it's odd
    if it is odd .get gets the first element (i.e. the value of the number that appears an odd amount of times)
*/

  def findOdd(xs: Seq[Int]): Int = {
    xs.groupBy(identity).map { case (k, v) => (k, v.size) }.find(odd => odd._2 % 2 != 0).get._1
  }

  val sequence = Seq(1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5)
  println(findOdd(sequence))

  /*
CHALLENGE 4 - Descending order
  Didn't need to split it - could have just gone straight for sorted
 */

  def descendingOrder(num: Int): Int = {
    num.toString.split("").sorted.reverse.mkString("").toInt
  }

  println(descendingOrder(46523))


/*
Challenge 5 - Your order, please
 */
  def order(str: String): String = {
    if (str.length == 0) "" else {
      str.split(" ").sortBy(word => word.find(_.isDigit).get.asDigit).mkString(" ")
    }
  }

  println(order("4of Fo1r pe6ople g3ood th5e the2"))

  /*
  Challenge 6 - String Repeat
  Write a function that accepts a non-negative integer n and a string s as parameters,
  and returns a string of s repeated exactly n times.
  Here I could have just done str * times
 */
  def repeatStr(times: Int, str: String): String = List.fill(times)(str).mkString("")
  def repeatStrAnswer(times: Int, str: String): String = str * times
  println(repeatStrAnswer(9,"Sally"))

  /*
  Challenge 7 - Create a function that accepts a string and a single character, and returns an integer of the
  count of occurrences the 2nd argument is found in the first one.
  If no occurrences can be found, a count of 0 should be returned.
   */
  def strCount(s: String, c: Char): Int = s.toCharArray.count(char => char.equals(c))
//def strCount(s: String, c: Char): Int = s.count(_ == c) this seems to be a shorthand way of doing this 
  println(strCount("hello", 'l'))

}




