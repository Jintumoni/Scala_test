package com.jintu

import scala.annotation.tailrec

object Hello {
  def checkCall(x: Long): Unit = {
    println(x)
    println(x)
  }

  def checkCallName(x: => Long): Unit = {
    println(x)
    println(x)
  }

  def main(args: Array[String]):Unit={
    val Col = Seq(
      "Hello", "Bye", "ho"
    )
//    checkCall(System.nanoTime())
//    checkCallName(System.nanoTime())
//    greeting("Jintu", 22)
//    println(factorial(50000, 1))
//    println(concat("hello", 100000))
//    println(checkPrime(100))
//    println(fib(9))
    val str = "hello world"
    println(str.split(" ").toList)
  }

  def greeting(name: String, age: Int): Unit = {
    println(s"Hi, my name is ${name} and I'm ${age} years old")
  }

  def factorial(i: Int, accumulate: BigInt) : BigInt = {
    if (i == 1) accumulate
    else factorial(i - 1, i * accumulate)
  }

  def concat(originalString: String, times: Int): String = {
    @tailrec
    def concatHelper(accumulate: String, originalString: String, times: Int): String = {
      if (times <= 0) accumulate
      else concatHelper(accumulate + originalString, originalString, times - 1)
    }
    concatHelper("", originalString, times)
  }

  def checkPrime(number: Int): Boolean = {
    @tailrec
    def checkPrimeHelper(until: Int, stillPrime: Boolean): Boolean = {
      if (!stillPrime) false
      if (until <= 1) true
      else checkPrimeHelper(until - 1, number % until != 0 && stillPrime)
    }
    checkPrimeHelper(number / 2, true)
  }
  // 1 1 2 3 5 8 13 21 34
  def fib(n: Int): Int = {
    def fibHelper(n: Int, acc1: Int, acc2: Int) : Int = {
      if (n <= 2) acc2
      else fibHelper(n - 1, acc2, acc1 + acc2)
    }
    fibHelper(n, 1, 1)
  }
}