
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.loadAsListOfInt
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    // Arrange
    private val input = resourceAsListOfString("Day01_test.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day01(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(14)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day01(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(14)
        }
    }

}