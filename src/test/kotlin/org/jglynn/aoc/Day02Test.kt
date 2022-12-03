
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    // Arrange
    private val testData = Utils.loadAsListOfPairs("Day02_test.txt")
    private val realData = Utils.loadAsListOfPairs("Day02_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day02(testData).solvePart1()

            assertThat(answer).isEqualTo(15)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day02(realData).solvePart1()

            assertThat(answer).isEqualTo(13268)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {

            val answer = Day02(testData).solvePart2()

            assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day02(realData).solvePart2()

            assertThat(answer).isEqualTo(15508)
        }
    }


}