package me.samuki.clicker.main.interfaces

import com.badlogic.gdx.scenes.scene2d.Actor
import me.samuki.clicker.base.interfaces.BasePresenter


interface MainPresenter : BasePresenter<MainView> {
    fun setClickIncomeListener(actor: Actor)
}