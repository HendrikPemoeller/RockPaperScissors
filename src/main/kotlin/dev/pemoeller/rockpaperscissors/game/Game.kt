package dev.pemoeller.rockpaperscissors.game

fun play(tokenPlayer: GameToken, tokenOpponent: GameToken): Result {
    return when {
        tokenPlayer.draw(tokenOpponent) -> {
            Result.DRAW
        }
        tokenPlayer.beats(tokenOpponent) -> {
            return Result.WIN
        }
        else -> {
            Result.LOST
        }
    }
}

enum class GameToken {
    ROCK {
        override fun beats(other: GameToken): Boolean {
            return other == SCISSORS
        }
    },
    PAPER {
        override fun beats(other: GameToken): Boolean {
            return other == ROCK
        }
    },
    SCISSORS {
        override fun beats(other: GameToken): Boolean {
            return other == PAPER
        }
    };

    abstract fun beats(other: GameToken): Boolean

    fun draw(other: GameToken): Boolean = this == other
}

enum class Result {
    WIN,
    LOST,
    DRAW
}
