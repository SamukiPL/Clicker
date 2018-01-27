package me.samuki.clicker.main.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import me.samuki.clicker.base.interfaces.BaseView


interface MainView : BaseView {
    fun addShopShowcase(scrollPane: ScrollPane)
    fun addRewardedAdDialog(widgetGroup: WidgetGroup)
    fun showHideShowcase(button: Button)
    fun showScreenTransmissionAnimation(button: Button)
    fun showRewardedAdDialog()
    fun hideRewardedAdDialog()
    fun showAd()
}