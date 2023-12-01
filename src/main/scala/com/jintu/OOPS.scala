package com.jintu

object OOPS extends App {
  val author = new Writer("James", "Clear", 1996)
  val imposter = new Writer("James", "Clear", 1996)
  println(author.fullName())
  val novel = new Novel("Hello", 2020, author)
  println(novel.isWrittenBy(imposter))
  println(novel.authorAge())


  val counter = new Counter
  counter.inc.inc.inc.print
  counter.inc(1).print
}

class Writer(firstName: String, lastName: String, val yearOfBirth: Int) {
  def fullName(): String = {
    firstName + " " + lastName
  }
}

class Novel(name: String, yearOfRelase: Int, author: Writer) {
  def authorAge(): Int = yearOfRelase - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(year: Int): Novel = new Novel(name, year, author)
}

class Counter(val count: Int = 0) {
  def inc: Counter = {
    println("Incrementing by 1")
    new Counter(count + 1)
  }

  def dec: Counter = {
    println("Decrementing by 1")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print: Unit = println(count)
}