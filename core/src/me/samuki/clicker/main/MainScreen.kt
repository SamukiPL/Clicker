package me.samuki.clicker.main

import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.Actions.run
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import me.samuki.clicker.CoreLauncher
import me.samuki.clicker.base.BaseScreen
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.interfaces.GameCommunicator
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.main.interfaces.MainView


class MainScreen(game: GameCommunicator) : BaseScreen(game), MainView {

    private lateinit var presenter: MainPresenter

    private lateinit var shopShowcase: ScrollPane
    private lateinit var rewardedAdDialog: WidgetGroup

    override fun show() {
        start()
        super.show()
        presenter.loadEverything()
    }

    override fun render(delta: Float) {
        super.render(delta)
    }

    override fun dispose() {
        stop()
        super.dispose()
    }

    override fun start() {
        presenter = MainPresenterImpl()
        presenter.attachView(this)
    }

    override fun stop() {
        presenter.detachView()
    }

    override fun showHideShowcase(button: Button) {
        if (button.isChecked) {
            button.clearActions()
            stage.addActor(shopShowcase)
            button.addAction(Actions.moveTo(0F, 600F, 0.51F))
            shopShowcase.addAction(Actions.moveTo(0F, 0F, 0.5F))
        } else {
            button.clearActions()
            button.addAction(Actions.moveTo(0F, 0F, 0.5F))
            shopShowcase.addAction(Actions.moveTo(0F, -shopShowcase.height - 10, 0.51F))
        }

    }

    override fun addShopShowcase(scrollPane: ScrollPane) {
        this.shopShowcase = scrollPane
    }

    override fun addRewardedAdDialog(widgetGroup: WidgetGroup) {
        this.rewardedAdDialog = widgetGroup
        stage.addActor(rewardedAdDialog)
    }

    override fun showScreenTransmissionAnimation(button: Button) {
        button.addAction(Actions.parallel(
                Actions.moveTo(0F, 0F, 0.2F),
                Actions.sequence(
                        Actions.sizeTo(Constants.numbers.screen_width, Constants.numbers.screen_height, 0.2F),
                        run(Runnable { changeToShopScreen() })
                )
        ))
    }

    private fun changeToShopScreen() {
        game.changeScreen(CoreLauncher.Companion.ScreenTypes.SHOP_SCREEN)
    }

    override fun showRewardedAdDialog() {
        rewardedAdDialog.x = 0F
        rewardedAdDialog.y = Constants.numbers.screen_height - 800F
    }

    override fun hideRewardedAdDialog() {
        rewardedAdDialog.x = -1000F
        rewardedAdDialog.y = -1000F
    }

    override fun showAd() {
        game.androidAdsCommunicator.showAd()
        hideRewardedAdDialog()
    }
}