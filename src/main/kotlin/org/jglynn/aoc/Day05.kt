package org.jglynn.aoc

typealias CrateStack = HashMap<Int, ArrayDeque<String>>

class Day05(private val crateInput: String, private val instructionInput: String) {


    fun solvePart1() : String {

        val crateStack = buildCrates(crateInput)

        val instructions = parseInstructions(instructionInput)

        for (instruction in instructions) {
            crateStack.move(instruction.source, instruction.destination, instruction.count)
        }

        return crateStack.map { it.value.removeLast() }.joinToString("")

    }

    fun solvePart2(): String {

        val crateStack = buildCrates(crateInput)

        val instructions: List<Instruction> = parseInstructions(instructionInput)

        for (instruction in instructions) {
            crateStack.moveMany(instruction.source, instruction.destination, instruction.count)
        }

        return crateStack.map { it.value.removeLast() }.joinToString("")

    }

    private data class Instruction (val source: Int, val destination: Int, val count: Int)

    private fun parseInstructions(instructionInput: String): List<Instruction> {
        return instructionInput
            .split("\n")
            .map { it.split(" ")
                .mapNotNull { i -> i.toIntOrNull() }
            }.map{ Instruction(count = it[0], source = it[1], destination = it[2])}
    }

    private fun buildCrates(crateInput: String): CrateStack {

        val crates = crateInput
            .split("\n")
            .reversed()
            .map{ it.padStart(1).chunked(4) { i -> i.clean() }}
            .toList()

        val crateStack = CrateStack()

        crates.forEach {
            it.forEachIndexed { index, value ->
                if (value.isNotEmpty()) {
                    crateStack[index + 1] = crateStack.safePush(index + 1, value)
                }
            }
        }

        return crateStack
    }

    private fun CrateStack.move(source: Int, destination: Int, count: Int) {
        for (i in 1..count) move(source, destination)
    }

    private fun CrateStack.move(source: Int, destination: Int) =
        this[source]?.let { this[destination]?.add(it.removeLast()) }

    private fun CrateStack.moveMany(source: Int, destination: Int, count: Int) =
        this[source]?.let {this[destination]?.addAll(it.removeLast(count))}

    private fun ArrayDeque<String>.removeLast(count: Int): List<String> {
        return ( 1..count)
            .map { removeLast() }
            .toList()
            .reversed()
    }

    private fun CrateStack.safePush(index: Int, value: String): ArrayDeque<String> {
        val queue = getOrDefault(index, ArrayDeque<String>())
        queue.add(value)
        return queue
    }

    private fun CharSequence.clean(): String =
        trim().replace(("[\\W]").toRegex(), "")
}
