package me.samuki.clicker.main

import com.badlogic.gdx.Preferences
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.interfaces.MainDataManager
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel
import java.math.BigInteger


class MainDataManagerImpl(listeners: MainListeners) : MainDataManager {

    private lateinit var prefs: Preferences
    private val creatorHelper: MainCreatorHelper = MainCreatorHelper(listeners)

    init {
        initPrefs()
    }

    override fun initPrefs() {
        prefs = SharedPrefs.getInstance().prefs
    }

    override fun loadAnimations(): MutableList<AnimationModel> {
        return creatorHelper.createAnimations()
    }

    override fun loadActors(): MutableList<ActorModel> {
        return creatorHelper.createActorsModels()
    }

    override fun loadTexts(): MutableList<TextModel> {
        return creatorHelper.createTextModels()
    }

    override fun loadTextures(): MutableList<TextureModel> {
        return creatorHelper.createTexturesModels()
    }

    override fun getClickUpgradeShop(): List<ActorModel> {
        return emptyList()
    }

    override fun getShopShowcase(): ScrollPane {
        return creatorHelper.createShopShowcase()
    }

    override fun getRewardedAdDialog(): WidgetGroup {
        return creatorHelper.createRewardedAdDialog()
    }

    override fun saveThisClick() {
        IncomeHandlerImpl.getInstance().incrementClicksAmount()
    }
}