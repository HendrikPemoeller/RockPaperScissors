package dev.pemoeller.rockpaperscissors

import dev.pemoeller.rockpaperscissors.game.PlayerStatistic
import dev.pemoeller.rockpaperscissors.game.computePlayerStatistic
import dev.pemoeller.rockpaperscissors.game.runBatch

fun main(args: Array<String>) {
    println("running rock paper scissors 100 times....")
    val statistic = computePlayerStatistic(runBatch())
    printStatistics(statistic)
}

fun printStatistics(
    playerStatistics: PlayerStatistic,
    printer: (String) -> Unit = ::println
) {
    printer("The results for player are:")
    printer("wins:  ${playerStatistics.wins}")
    printer("draws: ${playerStatistics.draws}")
    printer("losts: ${playerStatistics.looses}")
    printer("The results for the opponent are:")
    printer("wins:  ${playerStatistics.looses}")
    printer("draws: ${playerStatistics.draws}")
    printer("losts: ${playerStatistics.wins}")
}