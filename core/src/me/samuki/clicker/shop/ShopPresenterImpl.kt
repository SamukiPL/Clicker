package me.samuki.clicker.shop

import com.badlogic.gdx.scenes.scene2d.EventListener
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.interfaces.IncomeHandler
import me.samuki.clicker.shop.interfaces.ShopDataManager
import me.samuki.clicker.shop.interfaces.ShopListeners
import me.samuki.clicker.shop.interfaces.ShopPresenter
import me.samuki.clicker.shop.interfaces.ShopView


class ShopPresenterImpl : ShopPresenter, ShopListeners {
    private var view: ShopView? = null
    private var dataManager: ShopDataManager = ShopDataManagerImpl(this)
    lateinit var incomeHandler: IncomeHandler

    override fun attachView(view: ShopView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        incomeHandler = IncomeHandlerImpl.getInstance()
        incomeHandler.setAmountTextRefresher(view)
    }

    override fun loadEverything() {

    }

    override fun goBackToMainScreen(): EventListener {
        TODO("Łukasz weź się do roboty!")
    }
}