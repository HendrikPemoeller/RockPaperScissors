package dev.pemoeller.rockpaperscissors.game

import dev.pemoeller.rockpaperscissors.game.GameToken.*

fun onlyRockPlayerTurn() = ROCK

fun randomPlayerTurn(): GameToken {
    return GameToken.values().asList().random()
}