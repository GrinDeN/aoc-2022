fun main() {

    fun findSharedCharacter(pair: Pair<String, String>): Char {
        return pair.first.toCharArray()
            .filter { pair.second.contains(it) }
            .toSet()
            .toList()[0]
    }

    fun findSharedCharacter(triple: Triple<String, String, String>): Char {
        return triple.first.toCharArray()
            .filter { triple.second.contains(it) && triple.third.contains(it) }
            .toSet()
            .toList()[0]
    }

    fun part1(input: List<String>): Int {
        val racksackPairs = input.map { Pair(it.substring(0, it.length/2), it.substring(it.length/2)) }
        return racksackPairs
            .map { findSharedCharacter(it) }
            .sumOf { if (it.isLowerCase()) it.code - 96 else it.code - 38 }
    }

    fun part2(input: List<String>): Int {
        val tripleRacksacks = input.windowed(3, 3).map { Triple(it[0], it[1], it[2]) }
        return tripleRacksacks
            .map { findSharedCharacter(it) }
            .sumOf { if (it.isLowerCase()) it.code - 96 else it.code - 38 }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("day03/Day03")
    println(part1(input))
    println(part2(input))

}
