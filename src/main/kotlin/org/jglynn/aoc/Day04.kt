package org.jglynn.aoc


class Day04(input: String) {

    private val ranges: List<Pair<IntRange,IntRange>> =
        Utils.resourceAsListOfString(input).map { it.toRangePair() }

    fun solvePart1() : Int =
        ranges.count { it.isCovered() }

    fun solvePart2(): Int =
        ranges.count { (it.first intersect it.second ).isNotEmpty() }

    private fun String.toRangePair(): Pair<IntRange, IntRange> =
        substringBefore(',').rangeOf() to substringAfter(',').rangeOf()

    private fun Pair<IntRange,IntRange>.isCovered(): Boolean =
        (first subtract second).isEmpty() ||
                (second subtract first).isEmpty()

    private fun String.rangeOf(): IntRange =
        substringBefore('-').toInt() ..substringAfter('-').toInt()

}
