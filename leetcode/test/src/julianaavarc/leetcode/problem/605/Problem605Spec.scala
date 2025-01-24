package julianaavarc.leetcode
package problem.`605`

import scala.language.experimental.namedTuples

import org.scalatest.*
import flatspec.*
import matchers.should

import org.scalatest.prop.TableDrivenPropertyChecks.*

val examples = Table(
  ("input", "output"),
  ((Array(1, 0, 0, 0, 1), 1), true),
  ((Array(1, 0, 0, 0, 1), 2), false),
  ((Array(0), 1), true),
)

class Problem605Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.canPlaceFlowers.tupled(input)
      actual should equal { expected }
    }
  }
end Problem605Spec
