package aoc2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun `part5 one line example`() {
        val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
        """.trimIndent()
        val actual = input.day5()
        assertEquals(61, actual)
    }

    @Test
    fun `should fail`() {
        val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

61,13,29
""".trimIndent()
        val actual = input.day5()
        assertEquals(0, actual)
    }

    @Test
    fun `aoc example`() {
        val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
""".trimIndent()
        val actual = input.day5()
        assertEquals(143, actual)
    }

    @Test
    fun `part5 file example`() {
        assertEquals(5639, "/day5".readFileText().day5())
    }

    @Test
    fun `part5 part 2 file example`() {
        assertEquals(5273, "/day5".readFileText().day5Part2())
    }

    @Test
    fun `should fail but be corrected`(): Unit {
        val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

61,13,29
""".trimIndent()
        val actual = input.day5Part2()
        assertEquals(29, actual)
    }

    @Test
    fun `aoc example p2`() {
        val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
""".trimIndent()
        val actual = input.day5Part2()
        assertEquals(123, actual)
    }

}