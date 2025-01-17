package julianaavarc.leetcode

import mainargs.*

@main()
case class Config()

object Main:
  def main(args: Array[String]): Unit =
    val config = ParserForClass[Config].constructOrExit(args)
    println(config)
  end main
end Main
