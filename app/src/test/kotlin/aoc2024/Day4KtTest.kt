package aoc2024

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
    fun `diagonal MAS`() {
        val input = """
            M.S
            .A.
            M.S
       """.trimIndent()
        val primary: (Int, Int) -> Pair<Int, Int> = { x: Int, y: Int -> x + 1 to y + 1}
        val matrix = input.lines().map { it.toList() }
        val expected = Day4().getLetters(matrix, 0, 0, primary)

        assertEquals("MAS", expected)
    }

    @Test
    fun `decreasing diagonal SAM`() {
        val input = """
            M.S
            .A.
            M.S
       """.trimIndent()
        val primary: (Int, Int) -> Pair<Int, Int> = { x: Int, y: Int -> x - 1 to y + 1}
        val matrix = input.lines().map { it.toList() }
        val expected = Day4().getLetters(matrix, 2, 0, primary)
        assertEquals("SAM", expected)

        val solved = Day4().solve2(input)
        assertEquals(1, solved)
    }

    @Test
    fun `out of bounds`() {
        val input = """
            MS
            MS
       """.trimIndent()
        val primary: (Int, Int) -> Pair<Int, Int> = { x: Int, y: Int -> x + 1 to y + 1}
        val matrix = input.lines().map { it.toList() }
        val expected = Day4().getLetters(matrix, 1, 1, primary)
        assertEquals("S", expected)
    }

    @Test
    fun `aoc example p2`() {
        val input = """
        .M.S......
        ..A..MSMS.
        .M.S.MAA..
        ..A.ASMSM.
        .M.S.M....
        ..........
        S.S.S.S.S.
        .A.A.A.A..
        M.M.M.M.M.
        ..........
        """.trimIndent()
        val expected = Day4().solve2(input)
        assertEquals(9, expected)
    }

    @Test
    fun `aoc example p2 input file`() {
        val expected = Day4().solve2()
        assertEquals(1941, expected)
    }
}
