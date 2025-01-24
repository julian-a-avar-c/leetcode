package julianaavarc.leetcode
package problem.`1431`

import scala.language.experimental.namedTuples

import org.scalatest.*
import flatspec.*
import matchers.should

import org.scalatest.prop.TableDrivenPropertyChecks.*

val examples =
  Table(
    (
      "input",
      "output",
    ),
    (
      (candies = Array(2, 3, 5, 1, 3), extraCandies = 3),
      List(true, true, true, false, true),
    ),
    (
      (candies = Array(4, 2, 1, 1, 2), extraCandies = 1),
      List(true, false, false, false, false),
    ),
    (
      (candies = Array(12, 1, 12), extraCandies = 10),
      List(true, false, true),
    ),
  )
end examples

class Problem1431Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.kidsWithCandies.tupled(input)
      actual should equal { expected }
    }
  }
  "Solution 2" should "match examples" ignore {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`2`.kidsWithCandies.tupled(input)
      actual should equal { expected }
    }
  }
end Problem1431Spec
