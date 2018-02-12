package me.samuki.clicker

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.communication.AndroidCommunicator
import me.samuki.clicker.base.interfaces.communication.InGameListener
import me.samuki.clicker.main.MainScreen
import me.samuki.clicker.shop.ShopScreen

class CoreLauncher(override val androidCommunicator: AndroidCommunicator) : Game(), GameCommunicator, InGameListener {

    override var isAdReady: Boolean = false
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
        gatherBackgroundIncome()
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

    override fun playerWasRewarded() {
        IncomeHandlerImpl.getInstance().doubleTheAmount()
    }

    override fun adIsReady(ready: Boolean) {
        isAdReady = ready
    }

    private fun gatherBackgroundIncome() {
        var timeInMillis = (System.currentTimeMillis() - SharedPrefs.getInstance().prefs.getLong(Constants.prefs.last_time, 0) / Constants.numbers.background_penalty)
        if (timeInMillis > Constants.numbers.max_background_multilayer)
            timeInMillis = Constants.numbers.max_background_multilayer
        IncomeHandlerImpl.getInstance().gatherBackgroundIncome(timeInMillis.toString())
    }
}
