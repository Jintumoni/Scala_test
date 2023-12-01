package com.jintu

import scala.language.postfixOps

object SyntacticSugar extends App {
  class Person(val name: String, val age: Int, favouriteMovie: String) {
    def +(nickname: String): Person = new Person(name + s" ($nickname)", age, favouriteMovie)
    def unary_+ : Person = new Person(name, age + 1, favouriteMovie)
    def learns(newSkill: String) : String = s"$name learns $newSkill"
    def learnsScala : String = learns("Scala")
    def apply(x : Int) = s"$name watched $favouriteMovie $x times"
  }

  val John = new Person("John", 22, "Inception")
  println((John + "the rockstar").name)
  val oldJohn = +John
  println(oldJohn.name, oldJohn.age)
  println(John learns "C++")
  println(John learnsScala)
  println(John(4))

  val Max = new Person("Max", 23, "Tenet")

}
