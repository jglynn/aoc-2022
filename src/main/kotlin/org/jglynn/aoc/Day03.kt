package org.jglynn.aoc

import org.jglynn.aoc.Utils.toURI
import java.io.File

class Day03(private val input: String) {

    private val charMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()

    fun solvePart1() : Int {
        return load(input).sumOf { it.score() }
    }

    fun solvePart2(): Int =
        loadChunked(input).map { it.intersect() }.sumOf { it.score() }

    private fun Char.score(): Int =
        charMap.indexOf(this) + 1

    private fun List<String>.intersect(): Char =
        map { it.toSet() }
            .reduce { left, right -> left.intersect(right) }
            .first()

    private fun loadChunked(name: String): List<List<String>> =
        File(name.toURI()).readLines().chunked(3)

    private fun load(name: String): List<Char> =
        File(name.toURI()).readLines()
            .map { it.chunked(it.length/2 ) }
            .flatMap { it.first().toSet().intersect(it.last().toSet()) }

}
