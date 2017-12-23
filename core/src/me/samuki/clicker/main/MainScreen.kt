package me.samuki.clicker.main

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.FitViewport
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.SoundsManager
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.SoundsPlayer
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.main.interfaces.MainView


class MainScreen(val game: GameCommunicator) : Screen, MainView {
    lateinit var presenter: MainPresenter
    lateinit var stage: Stage
    lateinit var viewport: FitViewport
    lateinit var sounds: SoundsPlayer

    private var batch: SpriteBatch = game.batch

    init {
        start()
        initViewport()
        initStage()
        initSounds()

    }

    private fun initViewport() {
        viewport = FitViewport(Constants.numbers.screen_width, Constants.numbers.screen_height, game.camera)
        viewport.scaling = Scaling.stretch
    }

    private fun initStage() {
        stage = Stage(viewport, batch)
        Gdx.input.inputProcessor = stage
    }

    private fun initSounds() {
        sounds = SoundsManager.getInstance()
    }

    override fun hide() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(delta: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dispose() {
        stop()
    }

    override fun start() {
        presenter = MainPresenterImpl()
        presenter.attachView(this)
    }

    override fun stop() {
        presenter.detachView()
    }

    override fun refreshAmount(amountString: String) {
        TODO("Łukasz weź się do roboty!")
    }
}