/*
 * This source file was generated by the Gradle 'init' task
 */
package aoc2024

import kotlin.math.abs

fun main1() {
    val exampleInput = """
3   4
4   3
2   5
1   3
3   9
3   3
"""
    val (indexOneList, indexTwoList) = exampleInput.lines().filter { it.isNotBlank() }.map {
        val (first, second) = it.split("   ").map { stringNumber -> stringNumber.toInt() }
        first to second
    }.unzip()

    val sortedIndexOneList = indexOneList.sorted()
    val sortedIndexTwoList = indexTwoList.sorted()

    val distanceList = sortedIndexOneList.mapIndexed { index, indexOneItem ->
       abs(indexOneItem - sortedIndexTwoList[index])
    }
    println("${distanceList.sum()}")
}

fun main() {
    val exampleInput = """
3   4
4   3
2   5
1   3
3   9
3   3
"""

   val (indexOneList, indexTwoList) = exampleInput.lines().filter { it.isNotBlank() }.map {
       val (first, second) = it.split("   ").map { stringNumber -> stringNumber.toInt() }
         first to second
    }.unzip()
    val countMap = indexTwoList.groupingBy { it }.eachCount()
    val similarityScores = indexOneList.map { it -> it * (countMap[it] ?: 0) }

    println("${similarityScores.sum()}")
}
