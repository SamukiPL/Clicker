package me.samuki.clicker.shop

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.FitViewport
import me.samuki.clicker.CoreLauncher
import me.samuki.clicker.base.BaseScreen
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.SoundsManager
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.SoundsPlayer
import me.samuki.clicker.main.MainScreen
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel
import me.samuki.clicker.shop.interfaces.ShopPresenter
import me.samuki.clicker.shop.interfaces.ShopView


class ShopScreen(game: GameCommunicator) : BaseScreen(game), ShopView {

    private lateinit var presenter: ShopPresenter

    override fun show() {
        start()
        super.show()
        presenter.loadEverything()
    }

    override fun render(delta: Float) {
        super.render(delta)
    }

    override fun dispose() {
        stop()
        super.dispose()
    }

    override fun start() {
        presenter = ShopPresenterImpl()
        presenter.attachView(this)
    }

    override fun stop() {
        presenter.detachView()
    }

    override fun changeToMainScreen() {
        game.changeScreen(CoreLauncher.Companion.ScreenTypes.MAIN_SCREEN)
    }
}
