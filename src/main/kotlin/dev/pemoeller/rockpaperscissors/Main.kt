package dev.pemoeller.rockpaperscissors

import dev.pemoeller.rockpaperscissors.game.computePlayerStatistic
import dev.pemoeller.rockpaperscissors.game.runBatch

fun main(args: Array<String>) {
    println("running rock paper scissors 100 times....")
    val statistic = computePlayerStatistic(runBatch())
    println(statistic)
}