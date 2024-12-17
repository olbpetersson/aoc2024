package aoc2024

fun String.part5(): Int {
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
            if(isOk == false) {
                return@filter false
            }
        }
        true
    }.sumOf {
        it[it.size/2]
    }
}