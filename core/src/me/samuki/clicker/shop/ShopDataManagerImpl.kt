package me.samuki.clicker.shop

import com.badlogic.gdx.Preferences
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.MainCreatorHelper
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel
import me.samuki.clicker.models.TextureModel
import me.samuki.clicker.shop.interfaces.ShopDataManager
import me.samuki.clicker.shop.interfaces.ShopListeners


class ShopDataManagerImpl(listeners: ShopListeners) : ShopDataManager {

    private lateinit var prefs: Preferences
    private val creatorHelper: ShopCreatorHelper = ShopCreatorHelper(listeners)

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

    override fun loadBoughtItems() {
        TODO("Łukasz weź się do roboty!")
    }
}