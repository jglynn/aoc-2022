
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    private val testData = "Day05_test.txt"
    private val realData = "Day05_real.txt"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day05(testData).solvePart1()

            assertThat(answer).isEqualTo("CMZ")
        }

        @Test
        fun `Actual answer`() {

            val answer = Day05(realData).solvePart1()

            assertThat(answer).isEqualTo("SHMSDGZVC")
        }
    }

}