import scala.annotation.tailrec

object ListFunctions {
  @tailrec
  def size[A](l: List[A], acc: Int = 0): Int = {
    if (l.isEmpty) acc else size(l.tail, acc + 1)
  }

  // f is the function for the filter i.e. the condition that each element should meet to be returned
  @tailrec
  def filter[A](l: List[A], acc: List[A] = Nil)(f: A => Boolean): List[A] = {
    // whenever we get items from the list we take them from the left and prepend them to a new list - meaning that
    // they are in the reverse order. We could append them, but this is not as efficient (quadratic complexity)
    if (l.isEmpty) acc.reverse
    // here we can assume that the first element exists. If it matches the condition provided by f, prepend the
    // element to the accumulating list, and pass the rest of the list, the accumulated result, and the filter
    // function on
    else if (f(l.head)) filter(l.tail, l.head :: acc)(f)
    // otherwise, as the element has not met the filter condition, we can "remove" this from the list as we continue
    // NB: Doesn't "remove" - immutable. Instead .tail returns a new list containing all but the first element of the
    // original target list
    else filter(l.tail, acc)(f)
  }

  @tailrec
  def map[A, B](l: List[A], acc: List[B] = Nil)(f: A => B): List[B] = {
    if (l.isEmpty) acc.reverse
    else map(l.tail, f(l.head) :: acc)(f)
  }

  // Now the above, but using foldRight so that we don't need recursion
  def mapWithFold[A, B](l: List[A])(f: A => B): List[B] = {
    l.foldRight(List.empty[B]) {
      (x, l) => f(x) :: l
    }
  }

  def filterWithFold[A](l: List[A])(f: A => Boolean): List[A] = {
    l.foldRight(List.empty[A]) {
      (x, l) => if (f(x)) x :: l else l
    }
  }

  def even(i: Int): Boolean = i % 2 == 0
}

// Define functions inline
println(ListFunctions.filter(List(1, 2, 3, 4)){x => x % 2 == 0})
// Or pass predefined
println(ListFunctions.filter(List(1, 2, 3, 4)){ListFunctions.even})

println(ListFunctions.map(List(1, 2, 3, 4)){x => "a" * x})

println(ListFunctions.filterWithFold(List(1, 2, 3, 4)){ListFunctions.even})