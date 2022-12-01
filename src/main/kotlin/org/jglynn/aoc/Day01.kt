package org.jglynn.aoc

class Day01(private val input: List<Int>) {

    fun solvePart1(): Int {
        val splitList = input.split { it < 0 }
        return splitList.maxOf { it.reduce { acc, i -> acc + i } }
    }

    fun solvePart2(): Int =
        input.size


    fun <T> List<T>.split(predicate: (T) -> Boolean): List<List<T>> =
        fold(mutableListOf(mutableListOf<T>())) { acc, t ->
            if (predicate(t)) acc.add(mutableListOf())
            else acc.last().add(t)
            acc
        }.filterNot { it.isEmpty() }
}
