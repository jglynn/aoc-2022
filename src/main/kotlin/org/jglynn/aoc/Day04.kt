package org.jglynn.aoc


class Day04(private val input: String) {


    fun solvePart1() : Int =
        Utils.resourceAsListOfString(input)
            .map {
                val (elf1, elf2) = it.split(',')
                Pair(elf1.rangeOf(), elf2.rangeOf())
            }.count {
                (it.first subtract it.second).isEmpty()
                        || (it.second subtract it.first).isEmpty()
            }

    fun solvePart2(): Int {
        return 0
    }

    private fun String.rangeOf(): IntRange =
        substringBefore('-').toInt().rangeTo(
            substringAfter('-').toInt()
        )

}
