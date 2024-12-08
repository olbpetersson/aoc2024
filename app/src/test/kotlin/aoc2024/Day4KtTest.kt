package aoc2024

import aoc2024.Day4.Companion.steppingFunctions
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4KtTest {

    @Test
    fun `horizontal`() {
        val expected = Day4().solve("XMAS", steppingFunctions = listOf({ x, y -> x + 1 to y }))
        assertEquals(1, expected)
    }

    @Test
    fun `horizontal reverse`() {
        val expected = Day4().solve("SAMX", steppingFunctions = listOf({ x, y -> x - 1 to y }))
        assertEquals(1, expected)
    }

   @Test
   fun `diagonally`() {
       val input = """
       .X...
       ..M..
       ...A.
       ....S
       """.trimIndent()
       val steppingFunctions = listOf<(Int, Int) -> Pair<Int, Int>>(
           { x, y -> x + 1 to y + 1 }
       )
       val expected = Day4().solve(input, steppingFunctions = steppingFunctions)
       assertEquals(1, expected)
   }

    @Test
    fun `diagonally reverse`() {
        val input = """
       .S...
       ..A..
       ...M.
       ....X
       """.trimIndent()
        val steppingFunctions = listOf<(Int, Int) -> Pair<Int, Int>>(
            { x, y -> x - 1 to y - 1 }
        )
        val expected = Day4().solve(input, steppingFunctions = steppingFunctions)
        assertEquals(1, expected)
    }

    @Test
    fun `vertical`() {
        val input = """
       .X...
       .M...
       .A...
       .S...
       """.trimIndent()
        val steppingFunctions = listOf<(Int, Int) -> Pair<Int, Int>>(
            { x, y -> x to y + 1 }
        )
        val expected = Day4().solve(input, steppingFunctions = steppingFunctions)
        assertEquals(1, expected)
    }

    @Test
    fun `vertical reverse`() {
        val input = """
       .S...
       .A...
       .M...
       .X...
       """.trimIndent()
        val steppingFunctions = listOf<(Int, Int) -> Pair<Int, Int>>(
            { x, y -> x to y - 1 }
        )
        val expected = Day4().solve(input, steppingFunctions = steppingFunctions)
        assertEquals(1, expected)
    }

    @Test
    fun `mini example`() {
        val input = """
        ..X...
        .SAMX.
        .A..A.
        XMAS.S
        .X....
       """.trimIndent()
        val expected = Day4().solve(input)
        assertEquals(4, expected)
    }

    @Test
    fun `example aoc`() {
        val input = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX     
       """.trimIndent()
        val expected = Day4().solve(input)
        assertEquals(18, expected)
    }

    @Test
    fun `example 123`() {
        val input = """
        ..A.A.MS.X
        XMASAMX.MM
        X.....XA.A
        S.S.S.S.SS
       """.trimIndent()
        val expected = Day4().solve(input)
        assertEquals(4, expected)
    }

    @Test
    fun `day4 test`() {
        val expected = Day4().solve()
        assertEquals(4, expected)
    }

}
