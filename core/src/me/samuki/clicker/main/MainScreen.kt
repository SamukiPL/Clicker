package me.samuki.clicker.main

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.Actions.run
import com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.FitViewport
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.SoundsManager
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.SoundsPlayer
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.main.interfaces.MainView
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel
import com.badlogic.gdx.scenes.scene2d.ui.Table
import me.samuki.clicker.CoreLauncher


class MainScreen(val game: GameCommunicator) : Screen, MainView {
    companion object {
        lateinit var font: BitmapFont
    }

    private lateinit var presenter: MainPresenter
    private lateinit var stage: Stage
    private lateinit var viewport: FitViewport
    private lateinit var sounds: SoundsPlayer

    private val animationsToRender: MutableList<AnimationModel> = ArrayList()
    private val textsToRender: MutableList<TextModel> = ArrayList()
    private val texturesToRender: MutableList<TextureModel> = ArrayList()

    private var batch: SpriteBatch = game.batch

    private var stateTime: Float = 0F

    private lateinit var shopShowcase: ScrollPane

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

    private fun initFont() {
        font = BitmapFont(Gdx.files.internal(Constants.paths.basic_font), false)
    }

    override fun hide() {

    }

    override fun show() {
        start()
        initViewport()
        initStage()
        initSounds()
        initFont()
        presenter.loadEverything()
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stateTime += Gdx.graphics.deltaTime

        batch.begin()
        renderTextures()
        renderAnimations()
        renderTexts()
        batch.end()

        stage.act(Math.min(Gdx.graphics.deltaTime, 1/30f))
        stage.draw()
    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun resize(width: Int, height: Int) {
        game.camera.update()
        viewport.update(width, height)
    }

    override fun dispose() {
        stop()
        font.dispose()
    }

    override fun start() {
        presenter = MainPresenterImpl()
        presenter.attachView(this)
    }

    override fun stop() {
        presenter.detachView()
    }

    override fun refreshAmount(amountString: String) {
        textsToRender[0].text = amountString
    }

    override fun showHideShowcase(button: Button) {
        if (button.isChecked) {
            button.clearActions()
            stage.addActor(shopShowcase)
            button.addAction(Actions.moveTo(0F, 600F, 0.51F))
            shopShowcase.addAction(Actions.moveTo(0F, 0F, 0.5F))
        } else {
            button.clearActions()
            button.addAction(Actions.moveTo(0F, 0F, 0.5F))
            shopShowcase.addAction(Actions.moveTo(0F, -shopShowcase.height - 10, 0.51F))
        }

    }

    override fun addShopShowcase(scrollPane: ScrollPane) {
        this.shopShowcase = scrollPane
    }

    override fun showScreenTransmissionAnimation(button: Button) {
        button.addAction(Actions.parallel(
                Actions.moveTo(0F, 0F, 0.2F),
                Actions.sequence(
                        Actions.sizeTo(Constants.numbers.screen_width, Constants.numbers.screen_height, 0.2F),
                        run(Runnable { changeToShopScreen() })
                )
        ))
    }

    private fun changeToShopScreen() {
        game.changeScreen(CoreLauncher.Companion.ScreenTypes.SHOP_SCREEN)
    }

    override fun renderAnimations() {
        for (animation: AnimationModel in animationsToRender) {
            batch.draw(animation.getCurrentFrame(stateTime), animation.positionX, animation.positionY,
                    animation.getWidthAfterScale(), animation.getHeightAfterScale())
        }
    }

    override fun renderTexts() {
        for (textModel in textsToRender) {
            font.data.setScale(textModel.scale)
            font.color = textModel.color
            font.draw(batch, textModel.text, textModel.getPositionXWithOffset(font), textModel.positionY)
        }
    }

    override fun renderActors() {
        TODO("Łukasz weź się do roboty!")
    }

    override fun renderTextures() {
        for (textureModel in texturesToRender) {
            textureModel.drawFromModel(batch)
        }
    }

    override fun addAnimationToRender(animation: AnimationModel) {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addAnimationsToRender(animations: List<AnimationModel>) {
        animationsToRender.addAll(animations)
    }

    override fun addActorToStage(actor: Actor?) {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addActorsToStage(actors: List<ActorModel>) {
        for (actorModel in actors) {
            stage.addActor(actorModel.getActorFromModel())
        }
    }

    override fun addTextToRender(textModel: TextModel) {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addTextsToRender(textModelList: List<TextModel>) {
        textsToRender.addAll(textModelList)
    }

    override fun addTextureToRender(texture: TextureModel) {
        TODO("Łukasz weź się do roboty!")
    }

    override fun addTexturesToRender(textures: List<TextureModel>) {
        texturesToRender.addAll(textures)
    }
}