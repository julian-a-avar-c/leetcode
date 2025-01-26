package julianaavarc
package leetcode
package problem.`605`

/** You have a long flowerbed in which some of the plots are planted, and some
  * are not. However, flowers cannot be planted in adjacent plots.
  *
  * Given an integer array `flowerbed` containing `0`'s and `1`'s, where `0`
  * means empty and `1` means not empty, and an integer `n`, return `true` if
  * `n` new flowers can be planted in the `flowerbed` without violating the
  * no-adjacent-flowers rule and `false` otherwise.
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

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean
end Solution

object Solution:
  /** First easiest solution I could come up with.
    */
  case object `1` extends Solution:
    import scala.util.boundary, boundary.break
    val solved = true

    extension (array: Array[Int])
      def applyOrOption(index: Int): Option[Int] =
        val intOrNull = array.applyOrElse(index, _ => null)
        Option(intOrNull).asInstanceOf[Option[Int]]

    def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean =
      val lastIndex = flowerbed.length - 1
      var mutN      = n
      inline def fillBedsAt(indices: Int*) =
        for index <- indices do
          flowerbed(index) = 1
          mutN -= 1

      if flowerbed.length == 1 && flowerbed.head == 0
      then fillBedsAt(0)
      else
        for
          Array((a, ai), (b, bi)) <- flowerbed.zipWithIndex.sliding(2)
          if (a, b) == (0, 0)
        do
          boundary {
            inline def continue = break(())

            val prevA = flowerbed.applyOrOption(ai - 1)
            val nextB = flowerbed.applyOrOption(bi + 1)

            // Edges
            if ai == 0
            then fillBedsAt(ai)
            else if bi == lastIndex
            then fillBedsAt(bi)

            // Middle
            else if prevA.isDefined then
              if prevA.get == 0
              then fillBedsAt(ai)
              else continue // [1, 0, 0, ...]
            else if nextB.isDefined then
              if nextB.get == 0
              then fillBedsAt(bi)
              else continue // [0, 0, 1, ...]
            end if
          }
        end for
      end if

      mutN <= 0
    end canPlaceFlowers
  end `1`
end Solution
