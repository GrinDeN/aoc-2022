fun main() {

    val part1Map = mapOf<String, Int>(
        "A X" to 1 + 3,
        "B X" to 1 + 0,
        "C X" to 1 + 6,
        "A Y" to 2 + 6,
        "B Y" to 2 + 3,
        "C Y" to 2 + 0,
        "A Z" to 3 + 0,
        "B Z" to 3 + 6,
        "C Z" to 3 + 3
    ).withDefault { 0 }

    fun part1(input: List<String>): Int {
        return input.sumOf { part1Map.getValue(it) }
    }

    val part2Map = mapOf<String, Int>(
        "A X" to 3 + 0,
        "B X" to 1 + 0,
        "C X" to 2 + 0,
        "A Y" to 1 + 3,
        "B Y" to 2 + 3,
        "C Y" to 3 + 3,
        "A Z" to 2 + 6,
        "B Z" to 3 + 6,
        "C Z" to 1 + 6
    ).withDefault { 0 }

    fun part2(input: List<String>): Int {
        return input.sumOf { part2Map.getValue(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day02/Day02")
    println(part1(input))
    println(part2(input))
}
