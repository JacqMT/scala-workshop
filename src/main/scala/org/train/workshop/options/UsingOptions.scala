object UsingOptions {
  // Replace match expressions with functions
  // option match {
  //    case None => {}
  //    case Some(x) => foo(x)
  // }

  // 1. In order for this match to make sense, the return type must be Unit
  // 2. Look for methods on Option that allows for this sort of operation -> 'foreach'


  // option match {
  //    case None => false
  //    case Some(_) => true
  // }

  // 1. Contains and Exists both match the return type of Boolean, but require parameters
  // 2. Looking at the functions available on Option that return Boolean but don't use the element, it is likely that
  // this would be 'isDefined'


  // option match {
  //    case None => None
  //    case Some(x) => foo(x)
  // }

  // 1. Signature tells us this is flatMap


  // option match {
  //    case None => None
  //    case Some(x) => x
  // }

  // 1. This tells us that the value of option could be a nested option, so if we're just returning x this is 'flatten'


  // option match {
  //    case None => None
  //    case Some(x) => Some(foo(x))
  // }

  // 1. Return type of foo can be anything and it'll still be an option, so this is 'map'

  // Similar exercises can be done to understand how 'exists', 'forall', 'filter' and 'getOrElse' etc work under the
  // hood
}
