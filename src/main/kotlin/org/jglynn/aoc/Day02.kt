package org.jglynn.aoc

class Day02(private val input: List<Pair<String,String>>) {

    fun solvePart1() : Int {
        return input.sumOf { score(handFrom(it.first), handFrom(it.second)) }
    }

    fun solvePart2(): Int {
        return input.sumOf { score(handFrom(it.first), Result.valueOf(it.second)) }
    }

    private fun score(hand1 : Hand, hand2 : Hand) : Int {
        if ( hand2.beats(hand1) ) return 6 + hand2.score()
        if ( hand2.ties(hand1) ) return 3 + hand2.score()
        return hand2.score()
    }

    private fun score(hand : Hand, result : Result) : Int =
        when (result) {
            Result.X -> 0 + hand.beats().score()
            Result.Y -> 3 + hand.score()
            Result.Z -> 6 + hand.losesTo().score()
        }

    enum class Result(val value: Int) {
        X(0),  // LOSE
        Y(3),  // DRAW
        Z(6)   // WIN
    }

    private fun handFrom(value: String): Hand {
        return when (value) {
            "A", "X" -> Rock()
            "B", "Y" -> Paper()
            "C", "Z" -> Scissors()
            else -> throw IllegalArgumentException("value $value is not a valid Hand")
        }
    }

    abstract class Hand {
        abstract fun score(): Int
        abstract fun losesTo(): Hand
        abstract fun beats(): Hand
        fun beats(hand: Hand): Boolean = this.beats() == hand
        fun ties(hand: Hand): Boolean = this == hand
    }

    data class Rock(private var score: Int = 1): Hand() {
        override fun score() = score
        override fun losesTo() = Paper()
        override fun beats() = Scissors()
    }

    data class Paper(private var score: Int = 2): Hand() {
        override fun score() = score
        override fun losesTo() = Scissors()
        override fun beats() = Rock()
    }

    data class Scissors(private var score: Int = 3): Hand() {
        override fun score() = score
        override fun losesTo() = Rock()
        override fun beats() = Paper()
    }

}
