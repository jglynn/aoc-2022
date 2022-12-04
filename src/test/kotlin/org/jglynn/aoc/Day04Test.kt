
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {

    private val testData = "Day04_test.txt"
    private val realData = "Day04_real.txt"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day04(testData).solvePart1()

            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day04(realData).solvePart1()

            assertThat(answer).isEqualTo(413)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {

            val answer = Day04(testData).solvePart2()

            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day04(realData).solvePart2()

            assertThat(answer).isEqualTo(806)
        }
    }



}