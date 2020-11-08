package dev.pemoeller.rockpaperscissors.game

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class GameRunnerKtTest {

    @Test
    fun `returns a list with 100 entries`() {
        assertThat(runBatch()).hasSize(100)
    }

    @Test
    fun `returns a list with the results of the players function result`() {
        val result = runBatch(
            player1 = ::onlyRockPlayerTurn,
            player2 = ::onlyRockPlayerTurn
        ).distinct()

        assertThat(result).containsExactly(Result.DRAW)
    }

    @Test
    fun `returns computed game statistics from results`() {
        val gameResults = listOf(Result.WIN, Result.LOST, Result.WIN, Result.DRAW)

        val result = computePlayerStatistic(gameResults)

        with(result) {
            assertThat(wins).isEqualTo(2)
            assertThat(looses).isEqualTo(1)
            assertThat(draws).isEqualTo(1)
        }
    }

    @Test
    fun `returns computed game statistics if results is an empty list`() {
        val result = computePlayerStatistic(emptyList())

        with(result) {
            assertThat(wins).isEqualTo(0)
            assertThat(looses).isEqualTo(0)
            assertThat(draws).isEqualTo(0)
        }
    }
}