package me.samuki.clicker

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.main.MainScreen

class CoreLauncher(
        override val batch: SpriteBatch = SpriteBatch(),
        override val camera: OrthographicCamera = OrthographicCamera()
) : Game(), GameCommunicator {

    override fun create() {
        camera.setToOrtho(false, Constants.numbers.screen_width, Constants.numbers.screen_height)
        startIncome()

        this.setScreen(MainScreen(this))
    }

    override fun dispose() {
        batch.dispose()
    }

    private fun startIncome() {
        IncomeHandlerImpl
    }
}
