package me.samuki.clicker.shop.interfaces

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import me.samuki.clicker.base.interfaces.BaseDataManager


interface ShopDataManager: BaseDataManager {
    fun loadShopList(): ScrollPane
}