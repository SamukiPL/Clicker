package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel


interface BaseDataManager {
    fun initPrefs()
    fun loadAnimations(): List<AnimationModel>
    fun loadActors(): List<ActorModel>
    fun loadTexts(): List<TextModel>
    fun loadTextures(): List<TextureModel>
}