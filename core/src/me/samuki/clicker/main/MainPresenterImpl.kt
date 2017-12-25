package me.samuki.clicker.main

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.interfaces.IncomeHandler
import me.samuki.clicker.main.interfaces.MainDataManager
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.main.interfaces.MainView
import java.math.BigInteger


class MainPresenterImpl : MainPresenter, MainListeners {
    private var view: MainView? = null
    private var dataManager: MainDataManager = MainDataManagerImpl(this)
    lateinit var incomeHandler: IncomeHandler

    override fun attachView(view: MainView) {
        this.view = view
        incomeHandler = IncomeHandlerImpl.getInstance()
    }

    override fun detachView() {
        view = null
    }

    override fun loadEverything() {
        view?.addAnimationsToRender(dataManager.loadAnimations())
        view?.addActorsToStage(dataManager.loadActors())
        view?.addTextsToRender(dataManager.loadTexts())
    }

    override fun clickIncomeListener(): EventListener {
        return object: ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                incomeHandler.addClickIncome()
                view?.refreshAmount(incomeHandler.getAmountString())
            }
        }
    }
}