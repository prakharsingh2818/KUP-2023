package com.knoldus.training

import scala.annotation.unused

case class User(id: String)

class Person(val name: String, val age: Int, val gender: String)

object Person {
  /*def apply(name: String): Person = new Person(name, 10)
  def apply(name: String, age: Int): Person = new Person(name, age)*/

  def unapply(person: Person): Option[(String, Int, String)] = {
    Some(person.name, person.age, person.gender)
  }
}

object Extractors extends App {
  // val prakhar = new Person("Prakhar", 10)

  // val john = Person("John")
  private val mike = new Person("Mike", 23, "M")
  private val rose = new Person("Rose", 23, "F")
  @unused
  val employee = User("1723")

  private val result = mike match {
    case Person(n, a, g) =>
      if (g.equals("M")) s"Person with name $n and age $a is a Male"
      else s"Person with name $n and age $a is a Female"
    case _ => "No person could be extracted"
  }

  private val resultWithIfGuard = rose match {
    case Person(n, a, g) if g.equals("M") => s"IfGuard: Person with name $n and age $a is a Male"
    case Person(n, a, g) if g.equals("F") => s"IfGuard: Person with name $n and age $a is a Female"
    case Person(n, a, _) => s"IfGuard: Could not determine gender for person with name $n and age $a"
  }


  println(result)
  println(resultWithIfGuard)
}
