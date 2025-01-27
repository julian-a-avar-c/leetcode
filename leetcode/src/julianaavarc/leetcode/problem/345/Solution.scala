package julianaavarc
package leetcode
package problem.`345`

import scala.compiletime.ops.double

/** Given a string `s`, reverse only all the vowels in the string and return it.
  *
  * The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in
  * both lower and upper cases, more than once.
  */
sealed trait Solution extends leetcode.Solution:
  import leetcode.Solution.*
  val difficulty = Difficulty.Easy
  val topics     = Seq(Topic.`Two Pointers`, Topic.String)
  val companies  = Seq.empty
  val hint       = Seq.empty

  import java.nio.charset.StandardCharsets
  def assert(s: String) =
    Predef.assert { 1 <= s.length() && s.length() <= 3e5 }
    Predef.assert {
      def canEncodeASCII(string: CharSequence) =
        StandardCharsets.US_ASCII.newEncoder.canEncode(string)
      canEncodeASCII(s)
    }
  end assert

  def reverseVowels(s: String): String
end Solution

object Solution:
  /** Easiest solutions I could come up with.
    */
  case object `1` extends Solution:
    val solved = true
    // val vowels = "AEIOUaeiou".toSet
    val vowels = "AEIOUaeiou".toSet
    def reverseVowels(s: String): String =
      val mutS = StringBuilder(s)

      var (ai, bi)     = (0, s.length - 1)
      inline def nextA = ai += 1
      inline def nextB = bi -= 1
      while ai < bi do // Pointers don't overlap
        val (a, b)   = (s(ai), s(bi))
        val aIsVowel = vowels contains a
        val bIsVowel = vowels contains b
        if !aIsVowel then nextA
        if !bIsVowel then nextB

        if aIsVowel && bIsVowel then
          mutS(ai) = b
          mutS(bi) = a
          nextA; nextB
      end while

      mutS.toString
    end reverseVowels
  end `1`
end Solution
