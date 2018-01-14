package me.samuki.clicker.main.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import me.samuki.clicker.base.interfaces.BaseView


interface MainView : BaseView {
    fun addShopShowcase(scrollPane: ScrollPane)
    fun showHideShowcase(button: Button)
    fun showScreenTransmissionAnimation(button: Button)
}