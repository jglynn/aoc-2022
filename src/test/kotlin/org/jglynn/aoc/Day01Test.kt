
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.loadAsListOfInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    // Arrange
    private val testPart1 = loadAsListOfInt("Day01_test.txt")
    private val realPart1 = loadAsListOfInt("Day01_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day01(testPart1).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(24000)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day01(realPart1).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(69883)
        }
    }

}