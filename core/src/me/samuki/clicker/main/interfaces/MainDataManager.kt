package me.samuki.clicker.main.interfaces

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.Widget
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import me.samuki.clicker.base.interfaces.BaseDataManager
import me.samuki.clicker.models.ActorModel


interface MainDataManager : BaseDataManager {
    fun getClickUpgradeShop(): List<ActorModel>
    fun loadShopShowcase(): ScrollPane
    fun loadRewardedAdDialog(): WidgetGroup
    fun saveThisClick()
}