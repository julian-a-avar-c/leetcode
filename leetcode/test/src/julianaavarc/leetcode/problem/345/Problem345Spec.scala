package julianaavarc.leetcode
package problem.`345`

import scala.language.experimental.namedTuples

import org.scalatest.*
import flatspec.*
import matchers.should

import org.scalatest.prop.TableDrivenPropertyChecks.*

val examples = Table(
  ("input", "output"),
  ("IceCreAm", "AceCreIm"),
  ("leetcode", "leotcede"),
)

class Problem345Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.reverseVowels(input)
      actual should equal { expected }
    }
  }
end Problem345Spec
