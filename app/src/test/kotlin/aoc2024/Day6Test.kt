package aoc2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

    @Test
    fun `part6 their example`() {
        val input = """
    ....#.....
    .........#
    ..........
    ..#.......
    .......#..
    ..........
    .#..^.....
    ........#.
    #.........
    ......#...
    """.trimIndent()

        val actual = input.day6()
        assertEquals(41, actual)
    }

    @Test
    fun `part6 one line example`() {
        val input = """
           #.
           ..
           ^.
       """.trimIndent()

        val actual = input.day6()
        assertEquals(3, actual)
    }

    @Test
    fun `part6 one file`() {
        val actual = "/day6".readFileText().day6()
        assertEquals(5461, actual)
    }

}