package aoc2024

fun String.day6(): Int {
    val visited = mutableSetOf<Pair<Int, Int>>()
    /*
           #.
           ..
           ^.
     */
    lateinit var current: Pair<Int, Int>
    var direction =  0 to -1
    val matrix = this.lines().mapIndexed { index, it ->
        it.map { char ->
            if(char == '^') {
                current = it.indexOf(char) to index
                visited.add(current)
            }
            char
        }
    }
    while(true) {
        val nextPosition = current.first + direction.first to current.second + direction.second
        if(nextPosition.first < 0 || nextPosition.first > matrix[0].size-1 || nextPosition.second < 0 || nextPosition.second > matrix.size-1) {
            break
        } else if(matrix[nextPosition.second][nextPosition.first] == '#') {
            direction = -direction.second to direction.first
        } else {
            visited.add(nextPosition)
            current = nextPosition
        }
    }
    return visited.size
}