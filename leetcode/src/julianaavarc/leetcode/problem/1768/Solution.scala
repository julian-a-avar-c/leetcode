package julianaavarc
package leetcode
package problem.`1768`

/** 1768 - Merge Strings Alternately
  *
  * You are given two strings `word1` and `word2`. Merge the strings by adding
  * letters in alternating order, starting with `word1`. If a string is longer
  * than the other, append the additional letters onto the end of the merged
  * string.
  *
  * Return the merged string.
  */
sealed trait Solution extends leetcode.Solution:
  import leetcode.Solution.*
  val difficulty = Difficulty.Easy
  val topics     = Seq(Topic.`Two Pointers`, Topic.String)
  val companies  = Seq.empty
  val hint       = Seq.empty

  def assert(word1: String, word2: String) =
    Predef.assert { 1 <= word1.length && word2.length <= 100 }
    Predef.assert { word1.forall(_.isLower) && word2.forall(_.isLower) }
  end assert

  def mergeAlternately(word1: String, word2: String): String
end Solution

object Solution:
  /** Easiest solutions I could come up with. Using `view` to hopefully
    */
  case object `1` extends Solution:
    val solved = true
    def mergeAlternately(word1: String, word2: String): String =
      word1.zipAll(word2, "", "").map(_.toArray.mkString).mkString
    end mergeAlternately
  end `1`

  /** Trying to optimize it
    */
  case object `2` extends Solution:
    val solved = true
    def mergeAlternately(word1: String, word2: String): String =
      var result = ""

      for i <- 0 until math.max(word1.length, word2.length)
      do
        if i < word1.size then result += word1(i)
        if i < word2.size then result += word2(i)
      end for

      result
    end mergeAlternately
  end `2`

  /** Fold left!
    */
  case object `3` extends Solution:
    val solved = true
    def mergeAlternately(word1: String, word2: String): String =
      (0 until math.max(word1.length, word2.length)).foldLeft("") { (acc, i) =>
        var r = acc
        if i < word1.size then r += word1(i)
        if i < word2.size then r += word2(i)
        r
      }
    end mergeAlternately
  end `3`
end Solution
