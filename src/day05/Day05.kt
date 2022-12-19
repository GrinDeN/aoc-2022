fun main() {

    fun parseMovements(input: List<String>): List<Triple<Int, Int, Int>> {
        return input
            .map { it.split(" ") }
            .map { Triple(it[1].toInt(), it[3].toInt(), it[5].toInt()) }
    }

    fun singleMove(stacks: List<ArrayDeque<Char>>, from: Int, to: Int, numberOfCrates: Int) {
        for (i in 1..numberOfCrates) {
            val crate = stacks[from - 1].removeFirst()
            stacks[to - 1].addFirst(crate)
        }
    }

    fun stackMove(stacks: List<ArrayDeque<Char>>, from: Int, to: Int, numberOfCrates: Int) {
        val middleStack = ArrayDeque<Char>()
        for (i in 1..numberOfCrates) {
            val crate = stacks[from - 1].removeFirst()
            middleStack.addLast(crate)
        }
        stacks[to - 1].addAll(0, middleStack)

    }

    fun stacks(): List<ArrayDeque<Char>> {
        return listOf(
            ArrayDeque(listOf('V', 'C', 'W', 'L', 'R', 'M', 'F', 'Q')),
            ArrayDeque(listOf('L', 'Q', 'D')),
            ArrayDeque(listOf('B', 'N', 'C', 'W', 'G', 'R', 'S', 'P')),
            ArrayDeque(listOf('G', 'Q', 'B', 'H', 'D', 'C', 'L')),
            ArrayDeque(listOf('S', 'Z', 'F', 'L', 'G', 'V')),
            ArrayDeque(listOf('P', 'N', 'G', 'D')),
            ArrayDeque(listOf('W', 'C', 'F', 'V', 'P', 'Z', 'D')),
            ArrayDeque(listOf('S', 'M', 'D', 'P', 'C')),
            ArrayDeque(listOf('C', 'P', 'M', 'V', 'T', 'W', 'N', 'Z'))
        )
    }

    fun part1(input: List<String>): String {
        val stacks = stacks()
        val instructions = parseMovements(input)
        instructions
            .forEach { singleMove(stacks, it.second, it.third, it.first) }
        return stacks
            .map { it.first() }
            .joinToString("")
    }

    fun part2(input: List<String>): String {
        val stacks = stacks()
        val instructions = parseMovements(input)
        instructions
            .forEach { stackMove(stacks, it.second, it.third, it.first) }
        return stacks
            .map { it.first() }
            .joinToString("")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day05/Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInput("day05/Day05")
    println(part1(input))
    println(part2(input))
}
