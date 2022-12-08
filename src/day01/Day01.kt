package day01

import readInput
import splitWhen

fun main() {
    fun part1(input: List<String>): Int {
        val values = input.splitWhen { it == "" }
        println(values)
        val calories = values.stream().map { it -> it.sumOf { el -> el.toInt() } }.toList()
        println(calories)
        return calories.max()
    }

    fun part2(input: List<String>): Int {
        val values = input.splitWhen { it == "" }
        println(values)
        val calories = values.stream().map { it -> it.sumOf { el -> el.toInt() } }.toList().sortedDescending()
        println(calories)
        return calories.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
