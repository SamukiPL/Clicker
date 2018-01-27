package me.samuki.clicker.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.FitViewport
import me.samuki.clicker.base.interfaces.BaseView
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.base.interfaces.SoundsPlayer
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel


abstract class BaseScreen(val game: GameCommunicator): Screen, BaseView {
    companion object {
        lateinit var font: BitmapFont
    }

    protected lateinit var stage: Stage
    protected lateinit var viewport: FitViewport
    protected lateinit var sounds: SoundsPlayer

    protected val animationsToRender: MutableList<AnimationModel> = ArrayList()
    protected val textsToRender: MutableList<TextModel> = ArrayList()
    protected val texturesToRender: MutableList<TextureModel> = ArrayList()

    protected var batch: SpriteBatch = game.batch

    protected var stateTime: Float = 0F

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

    override fun show() {
        initViewport()
        initStage()
        initSounds()
        initFont()
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

    override fun hide() {

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
        font.dispose()
        stage.dispose()
        for (model: TextureModel in texturesToRender) {
            model.texture.dispose()
        }
    }

    abstract override fun start()

    abstract override fun stop()

    override fun refreshAmount(amountString: String) {
        if (textsToRender.size > 0)
            textsToRender[0].text = amountString
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

    }

    override fun renderTextures() {
        for (textureModel in texturesToRender) {
            textureModel.drawFromModel(batch)
        }
    }

    override fun addAnimationToRender(animation: AnimationModel) {
        animationsToRender.add(animation)
    }

    override fun addAnimationsToRender(animations: List<AnimationModel>) {
        animationsToRender.addAll(animations)
    }

    override fun addActorToStage(actor: Actor?) {
        stage.addActor(actor)
    }

    override fun addActorsToStage(actors: List<ActorModel>) {
        for (actorModel in actors) {
            stage.addActor(actorModel.getActorFromModel())
        }
    }

    override fun addTextToRender(textModel: TextModel) {
        textsToRender.add(textModel)
    }

    override fun addTextsToRender(textModelList: List<TextModel>) {
        textsToRender.addAll(textModelList)
    }

    override fun addTextureToRender(texture: TextureModel) {
        texturesToRender.add(texture)
    }

    override fun addTexturesToRender(textures: List<TextureModel>) {
        texturesToRender.addAll(textures)
    }
}