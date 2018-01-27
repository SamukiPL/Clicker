package me.samuki.clicker.shop.interfaces

import com.badlogic.gdx.scenes.scene2d.EventListener
import me.samuki.clicker.models.MoneyMakerModel


interface ShopListeners {
    fun goBackToMainScreen(): EventListener
    fun buyMoneyMaker(moneyMakerModel: MoneyMakerModel): EventListener
}