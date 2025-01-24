package julianaavarc.leetcode
package problem.`1768`

import scala.language.experimental.namedTuples

import org.scalatest.*
import flatspec.*
import matchers.should

import org.scalatest.prop.TableDrivenPropertyChecks.*

val examples = Table(
  ("input", "output"),
  ((word1 = "abc", word2 = "pqr"), "apbqcr"),
  ((word1 = "ab", word2 = "pqrs"), "apbqrs"),
  ((word1 = "abcd", word2 = "pq"), "apbqcd"),
)

class Problem1768Spec extends AnyFlatSpec with should.Matchers:
  "Solution 1" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`1`.mergeAlternately.tupled(input)
      actual should equal { expected }
    }
  }
  "Solution 2" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`2`.mergeAlternately.tupled(input)
      actual should equal { expected }
    }
  }
  "Solution 3" should "match examples" in {
    forAll(examples) { (input, expected) =>
      val actual = Solution.`3`.mergeAlternately.tupled(input)
      actual should equal { expected }
    }
  }
end Problem1768Spec
