
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.toURI
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File

@DisplayName("Day 6")
class Day06Test {

    private val realData = File("Day06_real.txt".toURI()).readText()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val answer = Day06("bvwbjplbgvbhsrlpgdmjqwftvncz").solvePart1()
            assertThat(answer).isEqualTo(5)
        }
        @Test
        fun `Matches example 2`() {
            val answer = Day06("nppdvjthqldpwncqszvftbrmjlhg").solvePart1()
            assertThat(answer).isEqualTo(6)
        }
        @Test
        fun `Matches example 3`() {
            val answer = Day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").solvePart1()
            assertThat(answer).isEqualTo(10)
        }
        @Test
        fun `Matches example 4`() {
            val answer = Day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").solvePart1()
            assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day06(realData).solvePart1()
            assertThat(answer).isEqualTo(1766)
        }
    }

}