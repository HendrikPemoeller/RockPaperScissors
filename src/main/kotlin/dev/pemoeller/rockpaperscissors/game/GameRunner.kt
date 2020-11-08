package dev.pemoeller.rockpaperscissors.game

fun runBatch(
    player1: () -> GameToken = ::onlyRockPlayerTurn,
    player2: () -> GameToken = ::randomPlayerTurn
): List<Result> {
    return (0..99)
        .map { play(player1(), player2()) }
}

fun computePlayerStatistic(
    results: List<Result>
): PlayerStatistic {
    return PlayerStatistic(
        wins = results.filter { it == Result.WIN }.size,
        looses = results.filter { it == Result.LOST }.size,
        draws = results.filter { it == Result.DRAW }.size
    )
}

data class PlayerStatistic(val wins: Int, val looses: Int, val draws: Int)
