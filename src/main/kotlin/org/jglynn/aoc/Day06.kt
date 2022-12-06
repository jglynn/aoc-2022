package org.jglynn.aoc

class Day06(private val input: String) {

    fun solvePart1() : Int =
        input.indexOfFirstUnique(4)

    fun solvePart2(): Int =
        input.indexOfFirstUnique(14)

   private fun String.indexOfFirstUnique(count: Int): Int =
       windowed(count, 1)
           .indexOfFirst { it.toSet().size == count }
           .plus(count)
}