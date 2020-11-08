package dev.pemoeller.rockpaperscissors.game

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


internal class RoundKtTest {

    @ParameterizedTest(name = "{0} & {1} -> {2}")
    @CsvSource(
        "'PAPER',    'PAPER',   'DRAW'",
        "'PAPER',    'ROCK',   'WIN'",
        "'PAPER',    'SCISSORS',   'LOST'",
        "'ROCK',    'ROCK',   'DRAW'",
        "'ROCK',    'SCISSORS',   'WIN'",
        "'ROCK',    'PAPER',   'LOST'",
        "'SCISSORS',    'SCISSORS',   'DRAW'",
        "'SCISSORS',    'PAPER',   'WIN'",
        "'SCISSORS',    'ROCK',   'LOST'"
    )
    fun `returns the result of an round`(playerToken: GameToken, opponentToken: GameToken, expectedResult: Result) {
        val result = play(playerToken, opponentToken)

        assertThat(expectedResult).isEqualTo(result)
    }

    @ParameterizedTest(name = "{0} beats {1}")
    @CsvSource(
        "'PAPER',    'ROCK'",
        "'ROCK',    'SCISSORS'",
        "'SCISSORS',    'PAPER'"

    )
    fun `returns true if token beats the opponents`(token: GameToken, opponentToken: GameToken) {
        assertThat(token.beats(opponentToken)).isTrue()
    }

    @ParameterizedTest(name = "{0} does not beat {1}")
    @CsvSource(
        "'PAPER',    'PAPER'",
        "'PAPER',    'SCISSORS'",
        "'ROCK',    'ROCK'",
        "'ROCK',    'PAPER'",
        "'SCISSORS',    'SCISSORS'",
        "'SCISSORS',    'ROCK'"
    )
    fun `returns false if token does not beat the opponents`(token: GameToken, opponentToken: GameToken) {
        assertThat(token.beats(opponentToken)).isFalse()
    }

    @ParameterizedTest(name = "{0} does not draw {1}")
    @CsvSource(
        "'PAPER',    'ROCK'",
        "'PAPER',    'SCISSORS'",
        "'ROCK',    'SCISSORS'",
        "'ROCK',    'PAPER'",
        "'SCISSORS',    'PAPER'",
        "'SCISSORS',    'ROCK'"
    )
    fun `returns false if token is not the same as opponents`(token: GameToken, opponentToken: GameToken) {
        assertThat(token.draw(opponentToken)).isFalse()
    }

    @ParameterizedTest(name = "{0} draws {1}")
    @CsvSource(
        "'PAPER',    'PAPER'",
        "'ROCK',    'ROCK'",
        "'SCISSORS',    'SCISSORS'"
    )
    fun `returns true if token is the same as opponents`(token: GameToken, opponentToken: GameToken) {
        assertThat(token.draw(opponentToken)).isTrue()
    }

}