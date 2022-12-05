package org.jglynn.aoc

import org.jglynn.aoc.Utils.toURI
import java.io.File


class Day05(private val input: String) {


    fun solvePart1() : String {

        val (crateInput, instructionInput) = File(input.toURI()).readText().split("\n\n")

        val crates = crateInput
            .split("\n")
            .reversed()
            .map{ it.padStart(1).chunked(4) { i -> i.clean() }}
            .toList()

        val crateStack = HashMap<Int, ArrayDeque<String>>()

        crates.forEach {
            it.forEachIndexed { index, value ->
                if (value.isNotEmpty()) {
                    crateStack[index + 1] = crateStack.safePush(index + 1, value)
                }
            }
        }

        val instructions = instructionInput
            .split("\n")
            .map { it.split(" ")
                .mapNotNull { i -> i.toIntOrNull() }
            }

        for (instruction in instructions) {
            crateStack.move(instruction[1], instruction[2], instruction[0])
        }

        return crateStack.map { it.value.removeLast() }.joinToString("")

    }

    fun solvePart2(): String =
        "UNKNOWN"

    private fun HashMap<Int, ArrayDeque<String>>.move(source: Int, destination: Int, count: Int) {
        for (i in 1..count) move(source, destination)
    }

    private fun HashMap<Int, ArrayDeque<String>>.move(source: Int, destination: Int) =
        this[source]?.let { this[destination]?.add(it.removeLast()) }

    private fun HashMap<Int, ArrayDeque<String>>.safePush(index: Int, value: String): ArrayDeque<String> {
        val queue = getOrDefault(index, ArrayDeque<String>())
        queue.add(value)
        return queue
    }

    private fun CharSequence.clean(): String =
        trim().replace(("[\\W]").toRegex(), "")
}
