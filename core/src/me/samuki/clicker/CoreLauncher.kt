package me.samuki.clicker

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.base.BasicMethods
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.communication.SaveListener
import me.samuki.clicker.main.MainScreen
import me.samuki.clicker.shop.ShopScreen

class CoreLauncher() : Game(), GameCommunicator {
    override lateinit var batch: SpriteBatch
    override lateinit var camera: OrthographicCamera

    companion object {
        enum class ScreenTypes {
            MAIN_SCREEN,
            SHOP_SCREEN
        }
    }

    override fun create() {
        batch = SpriteBatch()
        camera = OrthographicCamera()
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

    override fun changeScreen(screenType: ScreenTypes) {
        when(screenType) {
            ScreenTypes.MAIN_SCREEN -> {
                this.setScreen(MainScreen(this))
            }
            ScreenTypes.SHOP_SCREEN -> {
                this.setScreen(ShopScreen(this))
            }
        }
    }
}
