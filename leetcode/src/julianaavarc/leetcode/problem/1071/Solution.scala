package julianaavarc
package leetcode
package problem.`1071`

import scala.language.experimental.namedTuples
import scala.util.boundary, boundary.break

/** 1071. Greatest Common Divisor of Strings
  *
  * For two strings `s` and `t`, we say "`t` divides `s`" if and only if s = t +
  * t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
  *
  * Given two strings `str1` and `str2`, return the largest string `x` such that
  * `x` divides both `str1` and `str2`.
  */
sealed trait Solution extends leetcode.Solution:
  import leetcode.Solution.*
  val difficulty = Difficulty.Easy
  val topics     = Seq(Topic.Math, Topic.String)
  val companies  = Seq.empty
  val hint       = Seq.empty

  def assert(str1: String, str2: String) =
    val englishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    Predef.assert { 1 <= str1.length && str2.length <= 1000 }
    Predef.assert {
      str1.forall(englishLetters.contains) &&
      str2.forall(englishLetters.contains)
    }
  end assert

  def gcdOfStrings(str1: String, str2: String): String
end Solution

object Solution:
  /** Easiest solutions I could come up with.
    */
  case object `1` extends Solution:
    val solved = false
    def gcdOfStrings(str1: String, str2: String): String =
      boundary {
        var acc  = ""
        var rest = ""

        for i <- 0 until math.max(str1.length, str2.length) do
          if str1.isDefinedAt(i) && str2.isDefinedAt(i)
          // Looping through both `str1` and `str2`
          then
            val (ch1, ch2) = (str1(i), str2(i))

            if ch1 == ch2
            // Still equal, so we can continue.
            then acc += ch1
            // Any difference between `ch1` and `ch2` would mean `str1` and `str2` are not equal.
            else break { "" }
          // `str1` and `str2` have different lengths.
          // Save the rest to a variable.
          else
            // `math.max` guarantees either `str1` or `str2` is defined at `i`.
            val ch = str1.applyOrElse(i, str2)
            rest += ch
          end if
        end for

        if rest.isEmpty
        // At this point, if rest is empty, that would mean that `str1 == str2`, so we can just return that.
        then acc
        // Otherwise, we can try getting the GCD between acc, and rest.
        else gcdOfStrings(acc, rest)
      }
    end gcdOfStrings
  end `1`
end Solution
