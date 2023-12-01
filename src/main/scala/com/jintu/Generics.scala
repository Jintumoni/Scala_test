package com.jintu

object Generics extends App {
  class Mylist[+A] {
    def add[B >: A](element: B): Mylist[B] = ???
    // A = Cat
    // B = Dog = Animal
  }

  object Mylist {
    def empty[A]: Mylist[A] = ???
  }

  val emptyIntlist = new Mylist[Int]

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // VARIANCE PROBLEM
  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? -> HARD QUESTION

  // 2. No = INVARIANCE
  class InvariantList[A]
  val animalInvarintList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. HELL NO, CONTRAVARIANCE
  class ContravariantList[-A]
  val animalContravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types (lower bounded)
  class Cage[A <: Animal](animal: A) // class cage only accepts type paramters A which are subtypes of type Animal
  val cage = new Cage(new Dog)

  // bounded types (upper bounded)
  class Cage2[A >: Animal](animal: A)



}





