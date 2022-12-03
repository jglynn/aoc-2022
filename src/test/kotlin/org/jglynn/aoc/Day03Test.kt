
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {

    private val testData = "Day03_test.txt"
    private val realData = "Day03_real.txt"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day03(testData).solvePart1()

            assertThat(answer).isEqualTo(157)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day03(realData).solvePart1()

            assertThat(answer).isEqualTo(7845)
        }
    }


}