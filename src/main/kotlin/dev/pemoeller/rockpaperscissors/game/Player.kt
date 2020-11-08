package dev.pemoeller.rockpaperscissors.game

import dev.pemoeller.rockpaperscissors.game.GameToken.ROCK

fun onlyRockPlayerTurn() = ROCK

fun randomPlayerTurn(): GameToken {
    return GameToken.values().asList().random()
}