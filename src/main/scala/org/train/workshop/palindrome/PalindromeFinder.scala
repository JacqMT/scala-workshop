object PalindromeFinder {
  def findPalindromes(chars: String): Unit = {
    for (i <- 0 to chars.length;
         j <- i to chars.length;
         sub = if (j - i > 1) chars.substring(i, j) else "";
         if !sub.isEmpty() && sub == sub.reverse)
      println(sub)
  }

  def anotherPalindromeSolution(input: String): Unit = {
    val pallys = for (i <- input.inits;
                      t <- i.tails if t.length > 1 && t == t.reverse) yield t
    pallys foreach println
  }
}
PalindromeFinder.findPalindromes("redivider")

println("\nPalindrome hidden: ")
PalindromeFinder.findPalindromes("dsbvdividwefnl")

println("\nOther: ")
PalindromeFinder.anotherPalindromeSolution("redivider")