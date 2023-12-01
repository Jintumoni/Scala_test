package com.jintu

abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def add[B >: A](element: B): MyList[B]
    def isEmpty: Boolean
    def printElements: String
    override def toString: String = "[ " + printElements + "]"
    def ++[B >: A](list: MyList[B]): MyList[B]
    def map[B](transformer: A => B): MyList[B]
    def flatMap[B](transformer: A => MyList[B]): MyList[B]
    def filter(predicate: A => Boolean): MyList[A]
    def foreach(f: A => Unit):Unit
    def sort(compare: (A, A) => Int): MyList[A]
    def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
    def fold[B](start: B, operator: (A, B) => B): B
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def isEmpty: Boolean = true

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = {}

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if(!list.isEmpty) throw new RuntimeException("Length of both the lists is not same !")
    else Empty
  }

  override def fold[B](start: B, operator: (Nothing, B) => B): B = start
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def isEmpty: Boolean = false

  override def printElements: String = {
    if (this.isEmpty) {
      ""
    } else {
      this.head + " " + this.tail.printElements
    }
  }

  override def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons(h, t ++ list)
  }

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, list: MyList[A]): MyList[A] = {
      if(list.isEmpty) new Cons(x, Empty)
      else if(compare(x, list.head) <= 0) new Cons(x, list)
      else new Cons(list.head, insert(x, list.tail))
    }
    val sortedList = t.sort(compare)
    insert(h, sortedList)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Length of both the lists is not same !")
    new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }
  /*
    [1,2,3].fold(0,+)=
    [2,3].fold(1,+)=
    [3].fold(3,+)=
    [].fold(6,+)=
    6
   */
  override def fold[B](start: B, operator: (A, B) => B): B = {
    t.fold(operator(h, start), operator)
  }
}

object ListTest extends App {
  val listInt = new Cons(1, new Cons(2, new Cons(4, new Cons(8, Empty))))
  val listString = new Cons("hello", new Cons("bye", new Cons("hi", new Cons("scala", Empty))))

//  println(listString)
//
//  println(listInt.map((elem: Int) => elem * 4))
//
//  println(listInt.filter((elem: Int) => elem % 2 == 0))
//
//  println(listInt.flatmap((elem: Int) => new Cons(elem, new Cons(elem + 1, Empty))))

  val combinations = for {
    x <- listInt
    y <- listString
  } yield x + "-" + y

  println(combinations.head)

//  listInt.foreach(x => println(x))
//  println(listInt.sort((x: Int, y:Int) => y - x))
//  println(listInt.zipWith(listString, (x: Int, y: String) => x + "-" + y))
//  println(listInt.fold(0, (x: Int, y: Int) => x + y))
}