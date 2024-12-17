package aoc2024

fun String.day5(): Int {
    val (rulesPart, instructionsPart) = this.split("\n\n")
    val ruleMap = rulesPart.lines()
        .map {
            val (first, second) = it.split("|")
            first.toInt() to second.toInt()
        }.groupBy({ it.first }, { it.second })

    return instructionsPart.lines().map {
        it.split(',').map { it.toInt() }
    }.filter { numberList ->
        val mutableList = numberList.toMutableList()
        while (mutableList.isNotEmpty()) {
            val key = mutableList.removeLast()
            val referencedList = ruleMap[key]
            val isOk = referencedList?.let {
                referencedList.none { mutableList.contains(it) }
            }
            if (isOk == false) {
                return@filter false
            }
        }
        true
    }.sumOf {
        it[it.size / 2]
    }
}

fun String.day5Part2(): Int {
    val (rulesPart, instructionsPart) = this.split("\n\n")
    val ruleMap = rulesPart.lines()
        .map {
            val (first, second) = it.split("|")
            first.toInt() to second.toInt()
        }.groupBy({ it.first }, { it.second })

    val faultyLines = instructionsPart.lines().map {
        it.split(',').map { it.toInt() }
    }.filter { numberList ->
        val mutableList = numberList.toMutableList()
        while (mutableList.isNotEmpty()) {
            val key = mutableList.removeLast()
            val referencedList = ruleMap[key]
            val isOk = referencedList?.let {
                referencedList.none { mutableList.contains(it) }
            }
            if (isOk == false) {
                return@filter true
            }
        }
        false
    }

    val sortedLines = faultyLines.map { numberList ->
        numberList.sortedWith({ x, y ->
            when {
                ruleMap[x]?.contains(y) == true -> -1
                ruleMap[y]?.contains(x) == true -> 1
                else -> 0
            }
        })
    }.map { it[it.size / 2] }.sumOf { it }

    return sortedLines
}
