package julianaavarc
package leetcode
package problem.`151`

/** Given an input string s, reverse the order of the words.
  *
  * A word is defined as a sequence of non-space characters. The words in s will
  * be separated by at least one space.
  *
  * Return a string of the words in reverse order concatenated by a single
  * space.
  *
  * Note that s may contain leading or trailing spaces or multiple spaces
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
    Predef.assert { 1 <= s.length && s.length <= 10e4 }
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

    // 1 <= s.length <= 104
    // s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    // There is at least one word in s.
  end assert

  def reverseWords(s: String): String
end Solution

object Solution:
  /** Easiest solutions I could come up with.
    */
  case object `1` extends Solution:
    val solved = false
    def reverseWords(s: String): String =
      ???
    end reverseWords
  end `1`
end Solution
