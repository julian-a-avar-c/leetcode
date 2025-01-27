package julianaavarc.leetcode
package problem.`151`

import scala.language.experimental.namedTuples

import org.scalatest.*
import flatspec.*
import matchers.should

import org.scalatest.prop.TableDrivenPropertyChecks.*

val examples = Table(
  ("input", "output"),
  ("the sky is blue", "blue is sky the"),
  ("  hello world  ", "world hello"),
  ("a good   example", "example good a"),
)

class Problem151Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" ignore {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.reverseWords(input)
      actual should equal { expected }
    }
  }
end Problem151Spec
