package org.jglynn.aoc

class Day02(private val input: List<Pair<String,String>>) {

    fun solvePart1() : Int {
        return input.sumOf { score(it.first, it.second) }
    }

    private fun score(first : String, second : String) : Int {
        val h1 = Hand1.valueOf(first)
        val h2 = Hand2.valueOf(second)
        return calc ( h1, h2)
    }

    private fun calc(h1: Day02.Hand1, h2: Day02.Hand2): Int {
        if (    h1 == Hand1.A && h2 == Hand2.Y ||
                h1 == Hand1.B && h2 == Hand2.Z ||
                h1 == Hand1.C && h2 == Hand2.X ) {
            return 6 + h2.value;
        }
        if (    h1 == Hand1.A && h2 == Hand2.X ||
                h1 == Hand1.B && h2 == Hand2.Y ||
                h1 == Hand1.C && h2 == Hand2.Z ) {
            return 3 + h2.value;
        }
        return 0 + h2.value;
    }

    fun solvePart2(): Int =
        input.size

    enum class Hand1(val value: Int) {
        A(1),  // ROCK
        B(2),  // PAPER
        C(3)   // SCISSORS
    }

    enum class Hand2(val value: Int) {
        X(1),  // ROCK
        Y(2),  // PAPER
        Z(3)   // SCISSORS
    }
}
