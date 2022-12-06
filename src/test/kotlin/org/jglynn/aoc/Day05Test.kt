
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.toURI
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File

@DisplayName("Day 5")
class Day05Test {

    private val testData = "Day05_test.txt"
    private val realData = "Day05_real.txt"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val (crateInput, instructionInput) = File(testData.toURI()).readText().split("\n\n")
            val answer = Day05(crateInput, instructionInput).solvePart1()

            assertThat(answer).isEqualTo("CMZ")
        }

        @Test
        fun `Actual answer`() {

            val (crateInput, instructionInput) = File(realData.toURI()).readText().split("\n\n")
            val answer = Day05(crateInput, instructionInput).solvePart1()

            assertThat(answer).isEqualTo("SHMSDGZVC")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {

            val (crateInput, instructionInput) = File(testData.toURI()).readText().split("\n\n")
            val answer = Day05(crateInput, instructionInput).solvePart2()

            assertThat(answer).isEqualTo("MCD")
        }

        @Test
        fun `Actual answer`() {

            val (crateInput, instructionInput) = File(realData.toURI()).readText().split("\n\n")
            val answer = Day05(crateInput, instructionInput).solvePart2()

            assertThat(answer).isEqualTo("VRZGHDFBQ")
        }
    }

}