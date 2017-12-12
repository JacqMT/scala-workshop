object FunctionWrapping {
  // Note: "def" creates a wrapper for the function that can be invoked
  def even(i: Int): Boolean = i % 2 == 0

  // If you want to define a function in such a way that you can manipulate it i.e. have a variable with type Function
  // The first option here is the "syntactic sugar" version, however FunctionN can also be used (shorthand)
  val evenFunction: (Int) => Boolean = even
  val evenFunction2: Function[Int, Boolean] = even

  // FunctionN defines a function for N-1 arguments and the return type. i.e. for further arguments:
  def sum(a: Int, b: Int) = a + b

  val sumFunc: (Int, Int) => Int = sum
  val sumFunc2: Function2[Int, Int, Int] = sum
}

println(FunctionWrapping.sumFunc2.apply(1, 2))