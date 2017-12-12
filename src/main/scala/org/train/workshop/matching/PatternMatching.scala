import org.train.workshop.Person

import scala.annotation.tailrec

object PatternMatching {

  // NB: For matching, the code will check against each case in turn. When it find a match it will auto break
  def matching(a: Any): Unit ={
    a match {
      case 1 => println(1) // hard coded constant
      case i: Int => println("Got some int: " + i) // variable
      case Person(name, 0) => println("Got person named " + name) // can match on complex object, and by combining this
                                                                  // with the previous variable approach we can add
                                                                  // information to the scope of the case
      case List(1) => //sequence
      case List(1, _*) => // match exactly on first element, but otherwise allow any number of arbitrary entries after
      case l: List[Int] if l.sum == 6 => // guard using if condition
                                         // Note: This won't work in this context. If a List[String] was passed, for
                                         // example then it would blow up on this line. Strongly type where you can
                                         // to protect against this. This is provided instead as an example of how
                                         // a guard condition can be used within a match
      case (2, List(Person(name, _))) => // tuple
      case _ => println("default") // wildcard
    }
  }

  @tailrec
  def filter[A](l: List[A], acc: List[A] = Nil)(f: A => Boolean): List[A] = {
    l match {
      case x :: xs if f(x) => filter(xs, x :: acc)(f)
      case x :: xs => filter(xs, acc)(f)
      case Nil => acc.reverse
    }
  }

  @tailrec
  def map[A, B](l: List[A], acc: List[B] = Nil)(f: A => B): List[B] = {
    l match {
      case x :: xs => map(xs, f(x) :: acc)(f)
      case Nil => acc
    }
  }
}

println(PatternMatching.map(List(1, 2, 3, 4)){x => "a" * x})
println(PatternMatching.filter(List(1, 2, 3, 4)){x => x % 2 == 0})
