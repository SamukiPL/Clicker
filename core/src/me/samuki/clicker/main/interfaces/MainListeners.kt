package me.samuki.clicker.main.interfaces

import com.badlogic.gdx.scenes.scene2d.EventListener
import me.samuki.clicker.models.ClickUpgradeModel


interface MainListeners {
    fun clickIncomeListener(): EventListener
    fun showHideShowcaseListener(): EventListener
    fun buyClickUpgrade(clickUpgradeModel: ClickUpgradeModel): EventListener
    fun showShopScreen(): EventListener
    fun rewardIconClickListener(): EventListener
    fun showAd(): EventListener
    fun cancelDialog(): EventListener
}