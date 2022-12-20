package day06

import readInput

fun main() {

    fun detectSignal(input: List<String>, windowSize: Int): Int {
        val buffer = input[0]
        var result = 0
        for (i in 0..buffer.length-windowSize) {
            val window = buffer.substring(i, i+windowSize)
            if (window.chars().distinct().count() == windowSize.toLong()) {
                result = i+windowSize
                break
            }
        }
        return result
    }

    fun part1(input: List<String>): Int {
        val windowSize = 4
        return detectSignal(input, windowSize)
    }

    fun part2(input: List<String>): Int {
        val windowSize = 14
        return detectSignal(input, windowSize)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06/Day06_test")
    check(part1(testInput) == 7)

    val input = readInput("day06/Day06")
    println(part1(input))
    println(part2(input))
}
