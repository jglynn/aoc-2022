package org.jglynn.aoc


class Day04(private val input: String) {


    fun solvePart1() : Int =
        Utils.resourceAsListOfString(input)
            .map { it.toRangePair() }
            .count { it.isCovered() }

    fun solvePart2(): Int =
        Utils.resourceAsListOfString(input)
            .map { it.toRangePair() }
            .count { (it.first intersect it.second ).isNotEmpty() }

    private fun String.toRangePair(): Pair<IntRange, IntRange> {
        val (elf1, elf2) = split(',')
        return Pair(elf1.rangeOf(), elf2.rangeOf())
    }

    private fun Pair<IntRange,IntRange>.isCovered(): Boolean =
        (first subtract second).isEmpty() ||
                (second subtract first).isEmpty()

    private fun String.rangeOf(): IntRange =
        substringBefore('-').toInt().rangeTo(
            substringAfter('-').toInt()
        )

}
