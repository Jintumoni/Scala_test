package FunctionalP

object Function extends App {
//  val concat = (s1: String, s2: String) => s1 + s2
//
//  println(concat("hello", "world"))
//  val concat2 = new ((String, String) => String) {
//    override def apply(v1: String, v2: String): String = v1 + " " +  v2
//  }
//
//  println(concat2("hello", "world"))
//
//  val adder: Int => (Int => Int) = (x:Int) => (y:Int) => x + y
//  print(adder(2)(4))
//  def nTimes(f: Int => Int, n: Int, x: Int):Int = {
//    if (n <= 0) x
//    else nTimes(f, n - 1, f(x))
//  }
//
//  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
//    if (n <= 0) (x: Int) => x
//    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
//  }
//  val plusOne = (x: Int) => x + 1
//  val increment10 = nTimesBetter(plusOne, 10)
//  println(increment10(5))

//  def adder(x: Int)(y: Int): Int = x + y
//  println(adder(20)(10))
//  val adder10: (Int => Int) = adder(10)
//  println(adder10(20))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    x => y => f(x, y)
  }

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }

  def compose[A, B, C](f: A => B, g: C => A): C => B = {
    x => f(g(x))
  }

  def andThen[A, B, C](f: A => B, g: B => C): A => C = {
    x => g(f(x))
  }

  val add2 = (x: Int) => x + 2
  val multiply3 = (x: Int) => x * 3
  val fn = compose(add2, multiply3)
  val ordered = andThen(add2, multiply3)
  println(fn(2))
  println(ordered(4))


  val adder = (x: Int, y: Int) => x + y
  val curriedAdder = toCurry(adder)
  val bb = fromCurry(curriedAdder)
  println(bb(3, 4))

}
