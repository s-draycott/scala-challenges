package com.sdraycott.scalachallenges

/*
CURRYING - a function that does not take all of its arguments upfront
This part of the signature  Int => Seq[Int] means that the function returns a function that takes an Int and returns a Seq[Int]
(multiplier: Int) => ... is an anonymous function that takes multiplier as input.
arr.map(x => x * multiplier) produces a new sequence by multiplying each element x by multiplier.
 */

object Main extends App {
  /*
  CHALLENGE 1
  CURRYING - a function that does not take all of its arguments upfront
  This part of the signature  Int => Seq[Int] means that the function returns a function that takes an Int and returns a Seq[Int]
  (multiplier: Int) => ... is an anonymous function that takes multiplier as input.
  arr.map(x => x * multiplier) produces a new sequence by multiplying each element x by multiplier.
   */
  def multiplyAll(intArr: Seq[Int]): Int => Seq[Int] = {
    (multiplier: Int) => intArr.map(x => x * multiplier)
  }

  val multiplyBy = multiplyAll(Seq(1,2,3))
  val result = multiplyBy(2)
  println(result)

  /*
  CHALLENGE 2

   */

  def oddOrEven(xs: Seq[Int]) : String = {
    if xs.sum % 2 == 0 then "even" else "odd"
  }
  println(oddOrEven(Seq()))


}
