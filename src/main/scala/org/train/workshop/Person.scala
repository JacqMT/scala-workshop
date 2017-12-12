package org.train.workshop

// Traits: https://docs.scala-lang.org/tour/traits.html - useful to combine several aspects into a single class,
//                                                        as a class can only extend a single abstract class but can
//                                                        use several Traits, allowing for mixin class composition
// Case Classes: https://docs.scala-lang.org/tour/case-classes.html - Same as regular classes, but can be used for
//                                                                    pattern matching
// Sealed: http://www.scala-lang.org/old/node/123 - Class cannot be extended, and all implementations exist in
//                                                  current file
case class Person(var name: String, var age: Int)
