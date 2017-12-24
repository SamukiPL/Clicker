package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import me.samuki.clicker.models.TextModel


interface BaseDataManager {
    val actors: List<Actor?>
    val texts: List<TextModel>
    fun initPrefs()
    fun loadAnimations()
    fun loadActors()
    fun loadTexts()
}