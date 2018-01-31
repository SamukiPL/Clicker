package me.samuki.clicker.shop

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import me.samuki.clicker.base.BasicMethods
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.interfaces.IncomeHandler
import me.samuki.clicker.models.MoneyMakerModel
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
        incomeHandler = IncomeHandlerImpl.getInstance()
        incomeHandler.setAmountTextRefresher(view)
    }

    override fun detachView() {
        view = null
    }

    override fun loadEverything() {
        view?.addAnimationsToRender(dataManager.loadAnimations())
        view?.addActorsToStage(dataManager.loadActors())
        view?.addTextsToRender(dataManager.loadTexts())
        view?.addTexturesToRender(dataManager.loadTextures())
        view?.addActorToStage(dataManager.loadShopList())
    }

    override fun goBackToMainScreen(): EventListener {return object: ChangeListener() {
        override fun changed(event: ChangeEvent?, actor: Actor?) {
            view?.changeToMainScreen()
        }
    }
    }

    override fun buyMoneyMaker(moneyMakerModel: MoneyMakerModel): EventListener {
        return object: ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                if (BasicMethods.compareAmountWithPrice(incomeHandler.getAmountBigInteger(), moneyMakerModel.price)) {
                    incomeHandler.subtractPriceFromAmount(moneyMakerModel.price)
                    moneyMakerModel.handelBuying()
                    view?.refreshAmount(incomeHandler.getAmountString())
                }
            }
        }
    }
}