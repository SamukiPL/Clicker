package me.samuki.clicker.main

import com.badlogic.gdx.Preferences
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.interfaces.MainDataManager
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel


class MainDataManagerImpl : MainDataManager {
    private lateinit var prefs: Preferences
    val creatorHelper: MainCreatorHelper = MainCreatorHelper()
    val animations: List<AnimationModel> = ArrayList()
    val textures: List<ActorModel> = ArrayList()
    val texts: List<TextModel> = ArrayList()

    init {
        initPrefs()
    }

    override fun initPrefs() {
        prefs = SharedPrefs.getInstance().prefs
    }

    override fun loadAnimations() {
        animations.toMutableList().addAll(creatorHelper.createAnimations())
    }

    override fun loadActors() {
        textures.toMutableList().addAll(creatorHelper.createActorsModels())
    }

    override fun loadTexts() {
        texts.toMutableList().addAll(creatorHelper.createTextModels())
    }

    override fun getClickIncomeString(): String {
        return prefs.getString(Constants.prefs.click_income, "0")
    }
}