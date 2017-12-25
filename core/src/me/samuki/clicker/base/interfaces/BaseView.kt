package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel


interface BaseView {
    fun start()
    fun stop()
    fun renderAnimations()
    fun renderTexts()
    fun renderActors()
    fun renderTextures()
    fun addAnimationToRender(animation: AnimationModel)
    fun addAnimationsToRender(animations: List<AnimationModel>)
    fun addActorToStage(actor: Actor?)
    fun addActorsToStage(actors: List<ActorModel>)
    fun addTextToRender(textModel: TextModel)
    fun addTextsToRender(textModelList: List<TextModel>)
    fun addTextureToRender(texture: TextureModel)
    fun addTexturesToRender(textures: List<TextureModel>)
}