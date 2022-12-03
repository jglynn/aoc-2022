package org.jglynn.aoc

import org.jglynn.aoc.Utils.toURI
import java.io.File

class Day03(private val input: String) {

    private val charMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()

    fun solvePart1() : Int {
        return load(input).sumOf { charMap.indexOf(it) + 1 }
    }

    fun solvePart2(): Int {
        return 0
    }

    private fun load(name: String): List<Char> =
        File(name.toURI()).readLines()
            .map { it.chunked(it.length/2 ) }
            .flatMap { it.first().toSet().intersect(it.last().toSet()) }

}
