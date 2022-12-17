fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.split(',') }
            .map { Pair(it[0], it[1]) }
            .map { Pair(
                Pair(it.first.split('-')[0], it.first.split('-')[1]),
                Pair(it.second.split('-')[0], it.second.split('-')[1])) }
            .map { Pair(
                IntRange(it.first.first.toInt(), it.first.second.toInt()),
                IntRange(it.second.first.toInt(), it.second.second.toInt())) }
            .count {(it.first.contains(it.second.first) && it.first.contains(it.second.last)) ||
                    (it.second.contains(it.first.first) && it.second.contains(it.first.last)) }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split(',') }
            .map { Pair(it[0], it[1]) }
            .map { Pair(
                Pair(it.first.split('-')[0], it.first.split('-')[1]),
                Pair(it.second.split('-')[0], it.second.split('-')[1])) }
            .map { Pair(
                IntRange(it.first.first.toInt(), it.first.second.toInt()),
                IntRange(it.second.first.toInt(), it.second.second.toInt())) }
            .count {(it.first.contains(it.second.first) || it.first.contains(it.second.last)) ||
                    (it.second.contains(it.first.first) || it.second.contains(it.first.last)) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("day04/Day04")
    println(part1(input))
    println(part2(input))
}
