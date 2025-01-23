package julianaavarc.leetcode
package problem.`605`

import scala.language.experimental.namedTuples

import org.scalatest.*
import flatspec.*
import matchers.should

import org.scalatest.prop.TableDrivenPropertyChecks.*

val examples = Table(
  ("input", "output"),
  ((true, true), true),
  ((true, true), true),
  ((true, true), true)
)

class Problem605Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" ignore {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.method.tupled(input)
      actual should equal { expected }
    }
  }
end Problem605Spec
