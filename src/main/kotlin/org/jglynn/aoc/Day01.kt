package org.jglynn.aoc

class Day01(private val input: List<Int>) {

    fun solvePart1() : Int =
        sortedCalories(input).first()

    fun solvePart2(): Int =
        sortedCalories(input).take(3).sum()

    private fun sortedCalories(calories: List<Int>): List<Int>  {
        val splitList = calories.split { it < 0 }
        return splitList
            .map{ it.reduce { acc, i -> acc + i } }
            .sortedDescending()
    }

    private fun <T> List<T>.split(predicate: (T) -> Boolean): List<List<T>> =
        fold(mutableListOf(mutableListOf<T>())) { acc, t ->
            if (predicate(t)) acc.add(mutableListOf())
            else acc.last().add(t)
            acc
        }.filterNot { it.isEmpty() }
}
