package julianaavarc
package leetcode
package problem.`605`

/** Description
  */
sealed trait Solution extends leetcode.Solution:
  import leetcode.Solution.*
  val difficulty = Difficulty.Easy
  val topics     = Seq()
  val companies  = Seq.empty
  val hint       = Seq.empty

  def assert(arg1: Boolean, arg2: Boolean) =
    Predef.assert { arg1 && arg2 == true }
  end assert

  def method(arg1: Boolean, arg2: Boolean): Boolean
end Solution

object Solution:
  /** Easiest solutions I could come up with.
    */
  case object `1` extends Solution:
    val solved                                        = false
    def method(arg1: Boolean, arg2: Boolean): Boolean = arg1 && arg2
  end `1`
end Solution
