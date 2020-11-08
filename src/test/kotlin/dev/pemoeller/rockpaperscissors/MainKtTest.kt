package dev.pemoeller.rockpaperscissors

import assertk.assertThat
import assertk.assertions.isEqualTo
import dev.pemoeller.rockpaperscissors.game.PlayerStatistic
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun `calls given printer with the statistics Strings`() {
        val lines = mutableListOf<String>()
        val statistics = PlayerStatistic(wins = 1, draws = 2, looses = 3)

        printStatistics(statistics, lines::add)

        assertThat(lines).isEqualTo(
            listOf(
                "The results for player are:",
                "wins:  1",
                "draws: 2",
                "losts: 3",
                "The results for the opponent are:",
                "wins:  3",
                "draws: 2",
                "losts: 1",
            )
        )
    }
}