
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.loadAsListOfInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    // Arrange
    private val testData = loadAsListOfInt("Day01_test.txt")
    private val realData = loadAsListOfInt("Day01_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day01(testData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(24000)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day01(realData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(69883)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {

            val answer = Day01(testData).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(45000)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day01(realData).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(207576)
        }
    }


}