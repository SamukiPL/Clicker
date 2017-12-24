package me.samuki.clicker.main

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.FitViewport
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.SoundsManager
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.SoundsPlayer
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.main.interfaces.MainView
import me.samuki.clicker.models.TextModel


class MainScreen(val game: GameCommunicator) : Screen, MainView {
    private lateinit var presenter: MainPresenter
    private lateinit var stage: Stage
    private lateinit var viewport: FitViewport
    private lateinit var sounds: SoundsPlayer
    private lateinit var font: BitmapFont

    private val textsToRender: List<TextModel> = ArrayList()

    private var batch: SpriteBatch = game.batch

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
        start()
        initViewport()
        initStage()
        initSounds()
        presenter.loadEverything()
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0.5F, 0.5F, 0.5F, 1F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        batch.end()

        stage.act(Math.min(Gdx.graphics.deltaTime, 1/30f))
        stage.draw()
    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun resize(width: Int, height: Int) {

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

    override fun renderTexts() {
        for (textModel in textsToRender) {
            font.data.setScale(textModel.scale)
            font.color = textModel.color
            font.draw(batch, textModel.text, textModel.positionX, textModel.positionY)
        }
    }

    override fun renderActors() {
        TODO("Łukasz weź się do roboty!")
    }

    override fun renderImages() {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addActorToStage(actor: Actor?) {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addActorsToStage(actors: List<Actor?>) {
        for (actor in actors) {
            stage.addActor(actor)
        }
    }

    override fun addTextToRender(textModel: TextModel) {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addTextsToRender(textModelList: List<TextModel>) {
        textsToRender.toMutableList().addAll(textModelList)
    }
}