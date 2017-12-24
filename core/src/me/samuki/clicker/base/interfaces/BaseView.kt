package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import me.samuki.clicker.models.TextModel


interface BaseView {
    fun start()
    fun stop()
    fun renderTexts()
    fun renderActors()
    fun renderImages()
    fun addActorToStage(actor: Actor?)
    fun addActorsToStage(actors: List<Actor?>)
    fun addTextToRender(textModel: TextModel)
    fun addTextsToRender(textModelList: List<TextModel>)
}