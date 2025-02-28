package julianaavarc
package leetcode
package problem.`151`

/** Given an input string `s`, reverse the order of the words.
  *
  * A word is defined as a sequence of non-space characters. The words in `s`
  * will be separated by at least one space.
  *
  * Return a string of the words in reverse order concatenated by a single
  * space.
  *
  * Note that `s` may contain leading or trailing spaces or multiple spaces
  * between two words. The returned string should only have a single space
  * separating the words. Do not include any extra spaces.
  */
sealed trait Solution extends leetcode.Solution:
  import leetcode.Solution.*
  val difficulty = Difficulty.Medium
  val topics     = Seq(Topic.`Two Pointers`, Topic.String)
  val companies  = Seq.empty
  val hint       = Seq.empty

  def assert(s: String) =
    // Predef.assert { arg1 && arg2 == true }
    ???
    // 1 <= s.length <= 104
    Predef.assert { 1 <= s.length && s.length <= 10e4 }
    // s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    Predef.assert {
      val englishLetters = {
        val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        upper ++ upper.map(_.toLower)
      }.toSet
      val digits = "1234567890".toSet
      val others = " ".toSet
      val all    = englishLetters ++ digits ++ others

      s.forall(c => all.contains(c))
    }
    // There is at least one word in s.
    Predef.assert { s.length >= 1 }
  end assert

  def reverseWords(s: String): String
end Solution

object Solution:
  /** Easiest solutions I could come up with.
    */
  case object `1` extends Solution:
    val solved = false
    def reverseWords(s: String): String =
      s.split(" ").filter(_.nonEmpty).reverse.mkString(" ")
    end reverseWords
  end `1`

  /** Same as 1, but using `reverseIterator` and regex
    *
    * [[String.split(regex:String)]] takes in a string in the form of a regular
    * expression, so by trimming the input string, one can split over multiple
    * spaces. Then instead of reversing it and returning a value which will then
    * have to be iterated over, we can return the iterator instead.
    */
  case object `2` extends Solution:
    val solved = false
    def reverseWords(s: String): String =
      s.trim.split(" +").reverseIterator.mkString(" ")
    end reverseWords
  end `2`
end Solution
