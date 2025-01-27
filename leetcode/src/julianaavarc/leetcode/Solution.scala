package julianaavarc.leetcode

trait Solution:
  val solved: Boolean
  val difficulty: Solution.Difficulty
  val topics: Seq[Solution.Topic]
  val companies: Seq[String]
  val hint: Seq[String]

object Solution:
  enum Difficulty:
    case Easy, Medium
  enum Topic:
    case `Two Pointers`, String, Array, Math
