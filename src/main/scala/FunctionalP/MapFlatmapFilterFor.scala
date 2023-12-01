package FunctionalP


abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(f: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  override def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  override def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  override def map[B](f: T => B): Maybe[B] = Just(f(value))

  override def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

  override def filter(p: T => Boolean): Maybe[T] = {
    if (p(value)) Just(value)
    else MaybeNot
  }
}

object MapFlatmapFilterFor extends App {
//  val list1 = List(1, 2, 3)
//  val list2 = List('a', 'b', 'c')
//  println(list1.map(x => list2.map(y => x + "-" + y)))
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 4))
  println(just3.filter(x => x % 2 == 0))
  println(just3.flatMap(x => Just(x + 1)))


}
