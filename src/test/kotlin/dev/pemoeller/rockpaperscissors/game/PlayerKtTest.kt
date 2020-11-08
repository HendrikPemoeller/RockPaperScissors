package dev.pemoeller.rockpaperscissors.game

import assertk.assertThat
import assertk.assertions.isEqualTo
import dev.pemoeller.rockpaperscissors.game.GameToken.ROCK
import org.junit.jupiter.api.Test

internal class PlayerKtTest {

    @Test
    fun `returns always rock`() {
        assertThat(onlyRockPlayerTurn()).isEqualTo(ROCK)
    }

    @Test
    fun `returns random GameTokens`() {
        val allGameToken = GameToken.values().asList().sorted()

        val result = (0..99).map {
            randomPlayerTurn()
        }.distinct()
            .sorted()

        assertThat(result.sorted())
            .isEqualTo(allGameToken)
    }
}