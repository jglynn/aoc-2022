package org.jglynn.aoc

class Day06(private val input: String) {

    fun solvePart1() : Int =
        input.toList()
            .windowed(4, 1)
            .indexOfFirst { it.toSet().size == 4 }
            .plus(4)

    fun solvePart2(): Int {
        return 0
    }

}