package me.samuki.clicker.main

import com.badlogic.gdx.Preferences
import com.badlogic.gdx.scenes.scene2d.Actor
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.interfaces.MainDataManager
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel


class MainDataManagerImpl(listeners: MainListeners) : MainDataManager {

    private lateinit var prefs: Preferences
    private val creatorHelper: MainCreatorHelper = MainCreatorHelper(listeners)
    val animations: MutableList<AnimationModel> = ArrayList()
    override val actors: MutableList<Actor?> = ArrayList()
    override val texts: MutableList<TextModel> = ArrayList()

    init {
        initPrefs()
    }

    override fun initPrefs() {
        prefs = SharedPrefs.getInstance().prefs
    }

    override fun loadAnimations() {
        animations.addAll(creatorHelper.createAnimations())
    }

    override fun loadActors() {
        actors.addAll(creatorHelper.createActorsModels())
    }

    override fun loadTexts() {
        texts.addAll(creatorHelper.createTextModels())
    }

    override fun getClickUpgradeShop(): List<ActorModel> {
        return emptyList()
    }
}