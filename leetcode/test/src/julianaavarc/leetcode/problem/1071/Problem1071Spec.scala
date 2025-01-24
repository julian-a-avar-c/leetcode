package julianaavarc.leetcode
package problem.`1071`

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
    ((str1 = "ABCABC", str2 = "ABC"), "ABC"),
    ((str1 = "ABABAB", str2 = "ABAB"), "AB"),
    ((str1 = "LEET", str2 = "CODE"), ""),
  )
end examples

class Problem1071Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.gcdOfStrings.tupled(input)
      actual should equal { expected }
    }
  }
end Problem1071Spec
