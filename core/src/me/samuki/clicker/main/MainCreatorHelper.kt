package me.samuki.clicker.main

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.CreatorHelper
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.models.ActorModel.Companion.ActorTypes
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.ClickUpgradeModel
import me.samuki.clicker.models.TextModel


class MainCreatorHelper(val listeners: MainListeners) : CreatorHelper() {

    fun createAnimations(): MutableList<AnimationModel> {
        val animationsList: MutableList<AnimationModel> = ArrayList()
        animationsList.add(pierdolecAnimation())
        return animationsList
    }

    fun createActorsModels(): MutableList<ActorModel> {
        val actorsList: MutableList<ActorModel> = ArrayList()
        actorsList.add(mainClickActor())
        actorsList.add(upgradeShopShowcaseButton())
        return actorsList
    }

    fun createTextModels(): MutableList<TextModel> {
        val textsList: MutableList<TextModel> = ArrayList()
        textsList.add(amountText())
        return textsList
    }

    fun createShopShowcase(): ScrollPane {
        var table = Table()
        var x = 0
        while (x < Constants.upgrades_info.size) {
            val group = ClickUpgradeModel(x, listeners).getUpgradeWidgetGroup()
            table.add(group).size(300F, 200F)
            table.row()
            x++
        }

        val scrollPane = ScrollPane(table)
        scrollPane.style.background = Image(Texture(Constants.paths.shop_showcase_background)).drawable
        scrollPane.setScrollingDisabled(true, false)
        scrollPane.width = Constants.numbers.screen_width
        scrollPane.height = 600F
        scrollPane.setPosition(0F, -scrollPane.height)
        return scrollPane
    }

    //Animations
    private fun pierdolecAnimation(): AnimationModel {
        val animation:  Animation<TextureRegion> = spriteCutting(Constants.paths.pierdolce,
                Constants.numbers.pierdolce_cols, Constants.numbers.pierdolce_rows, 1F)
        val animationModel: AnimationModel = AnimationModel(animation, 0F, 0F, 13)
        animationModel.centerPositionX()
        return animationModel
    }
    //Actors
    private fun mainClickActor(): ActorModel {
        return ActorModel(ActorTypes.BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture,
                boundX = Constants.numbers.screen_width, boundY = Constants.numbers.screen_height,
                listener = listeners.clickIncomeListener())
    }
    private fun upgradeShopShowcaseButton(): ActorModel {
        return ActorModel(ActorTypes.BUTTON_TYPE, Constants.paths.show_shop_showcase,
                Constants.paths.show_shop_showcase, Constants.paths.hide_shop_showcase,
                boundX = 100F, boundY = 100F, positionX = 0F, positionY = 0F,
                listener = listeners.showHideShowcaseListener())
    }
    //Texts
    private fun amountText(): TextModel {
        return TextModel(TextModel.TextTypes.AMOUNT_TEXT, "0", 100F, 1200F)
    }
}