package julianaavarc
package leetcode
package problem.`1431`

/** 1431. Kids With the Greatest Number of Candies
  *
  * There are `n` kids with candies. You are given an integer array candies,
  * where each `candies[i]` represents the number of candies the `i`th kid has,
  * and an integer `extraCandies`, denoting the number of extra candies that you
  * have.
  *
  * Return a boolean array result of length `n`, where `result[i]` is `true` if,
  * after giving the ith kid all the `extraCandies`, they will have the greatest
  * number of candies among all the kids, or `false` otherwise.
  *
  * Note that multiple kids can have the greatest number of candies.
  */
sealed trait Solution extends leetcode.Solution:
  import leetcode.Solution.*
  val difficulty = Difficulty.Easy
  val topics     = Seq(Topic.Array)
  val companies  = Seq.empty
  val hint       = Seq.empty

  def assert(candies: Array[Int], extraCandies: Int) =
    Predef.assert { 2 <= candies.length && candies.length <= 100 }
    Predef.assert { candies.forall(n => 1 <= n && n <= 100) }
    Predef.assert { 1 <= extraCandies && extraCandies <= 50 }
  end assert

  def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean]
end Solution

object Solution:
  /** Easiest solutions I could come up with.
    */
  case object `1` extends Solution:
    val solved = true
    def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] =
      val max = candies.max
      candies.map(_ + extraCandies >= max).toList
    end kidsWithCandies
  end `1`

  /** [[Array.max]] loops around once, before the transformation happens.
    * Instead we could do a running transformation
    */
  case object `2` extends Solution:
    val solved = false
    def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] =
      import scala.collection.mutable

      var maxOption = Option.empty[Int]
      val result    = mutable.ListBuffer.empty[Boolean]

      for childsCandyCount <- candies do
        maxOption match
          case None =>
            maxOption = Some(childsCandyCount)
          case Some(max) =>
            if childsCandyCount > max
            then maxOption = Some(childsCandyCount)
            
            result += childsCandyCount + extraCandies >= max

      result.toList
    end kidsWithCandies
  end `2`
end Solution
