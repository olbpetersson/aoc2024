package aoc2024


class Day4 {

    companion object {
        val steppingFunctions = listOf<(Int, Int) -> Pair<Int, Int>>(
            { x, y -> x + 1 to y },
            { x, y -> x to y + 1 },
            { x, y -> x - 1 to y },
            { x, y -> x to y - 1 },
            { x, y -> x - 1 to y - 1 },
            { x, y -> x + 1 to y + 1 },
            { x, y -> x + 1 to y - 1 },
            { x, y -> x - 1 to y + 1 }
        )
    }


    fun solve(
        exampleInput: String? = null,
        steppingFunctions: List<(Int, Int) -> Pair<Int, Int>> = Day4.steppingFunctions
    ): Int {
        val input = "/day4".readFileText(exampleInput)
        val matrix = input.lines().map { it.toList() }
        var count = 0
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                val charValue = matrix[y][x]
                if (charValue == 'X') {
                    count += steppingFunctions.sumOf {
                        findXmas(x, y, matrix, it)
                    }
                }
            }
        }
        return count
    }

    private fun findXmas(x: Int, y: Int, matrix: List<List<Char>>, stepFunction: (Int, Int) -> Pair<Int, Int>): Int {
        var (x2, y2) = (x to y)
        val masSequence = "MAS".toMutableList()
        var index = 0
        while (masSequence.size > 0 && index < matrix.size) { // this check is obv wrong and hardcoded
            val nextUp = masSequence.removeAt(0)
            val (nextX, nextY) = stepFunction(x2, y2)
            if(nextX < 0 || nextY < 0 || nextX >= matrix[y2].size || nextY >= matrix.size) {
                return 0
            }
            x2 = nextX
            y2 = nextY
            // add if case to not go too low or too high on list
            val valueRetrieved = matrix[y2][x2]
            if (valueRetrieved != nextUp) {
                return 0
            }
            index++
        }
        return 1
    }

    fun solve2(
        exampleInput: String? = null,
    ): Int {
        val input = "/day4".readFileText(exampleInput)
        val matrix = input.lines().map { it.toList() }

        var count = 0
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                val charValue = matrix[y][x]
                if (charValue == 'M' || charValue == 'S') {
                    val primary: (Int, Int) -> Pair<Int, Int> = { x: Int, y: Int -> x + 1 to y + 1}
                    val letters = getLetters(matrix, x, y, primary)
                    if(letters == "MAS" || letters == "SAM") {
                        val otherLetters = getLetters(matrix, x+2, y, { x2: Int, y2: Int -> x2 - 1 to y2 + 1})
                        if(otherLetters == "MAS" || otherLetters == "SAM") {
                            count++
                        }
                    }
                }
            }
        }
        return count
    }

    fun getLetters(
        matrix: List<List<Char>>,
        initialX: Int,
        initialY: Int,
        steppingFunction: (Int, Int) -> Pair<Int, Int>
    ): String {
        var returnString = "";
        var x = initialX;
        var y = initialY
        repeat(3) {
            returnString += matrix[y][x]
            val (newX, newY) = steppingFunction(x, y)
            if (newX < 0 || newY < 0 || newX >= matrix[0].size || newY >= matrix.size) {
                return returnString
            }
            x = newX
            y = newY
        }
        return returnString
    }
}