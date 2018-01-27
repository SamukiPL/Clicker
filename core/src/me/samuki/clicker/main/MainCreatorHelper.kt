package me.samuki.clicker.main

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import com.badlogic.gdx.utils.Align
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.CreatorHelper
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.models.*
import me.samuki.clicker.models.ActorModel.Companion.ActorTypes


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
        actorsList.add(shopIcon())
        actorsList.add(rewardIcon())
        return actorsList
    }

    fun createTextModels(): MutableList<TextModel> {
        val textsList: MutableList<TextModel> = ArrayList()
        textsList.add(amountText())
        return textsList
    }

    fun createTexturesModels(): MutableList<TextureModel> {
        val texturesList: MutableList<TextureModel> = ArrayList()
        texturesList.add(background())
        return texturesList
    }

    fun createShopShowcase(): ScrollPane {
        var table = Table()
        var x = 0
        while (x < Constants.upgrades_info.size) {
            val group = ClickUpgradeModel(x, listeners).getUpgradeWidgetGroup()
            table.add(group).size(Constants.numbers.screen_width, 200F)
            table.row()
            x++
        }

        val scrollPane = ScrollPane(table)
        scrollPane.style.background = Image(Texture(Constants.paths.shop_showcase_background)).drawable
        scrollPane.setScrollingDisabled(true, false)
        scrollPane.width = Constants.numbers.screen_width
        scrollPane.height = 600F
        scrollPane.setFadeScrollBars(false)
        scrollPane.setPosition(0F, -scrollPane.height)
        return scrollPane
    }

    fun createRewardedAdDialog(): WidgetGroup {
        val group = WidgetGroup()
        group.addActor(dialogBackground().getActorFromModel())
        group.addActor(dialogYesButton().getActorFromModel())
        group.addActor(dialogNoButton().getActorFromModel())
        group.setBounds(0F, 0F, 400F, 450F)
        group.x = -1000F
        group.y = -1000F
        return group
    }

    //Animations
    private fun pierdolecAnimation(): AnimationModel {
        val animation:  Animation<TextureRegion> = spriteCutting(Constants.paths.pierdolce,
                Constants.numbers.pierdolce_cols, Constants.numbers.pierdolce_rows, 1F)
        val animationModel: AnimationModel = AnimationModel(animation, 0F, 50F, 13)
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
                boundX = Constants.numbers.screen_width, boundY = 50F, positionX = 0F, positionY = 0F,
                listener = listeners.showHideShowcaseListener())
    }
    private fun shopIcon(): ActorModel {
        return ActorModel(ActorTypes.BUTTON_TYPE, Constants.paths.shop_icon,
                boundX = 75F, boundY = 75F, positionX = Constants.numbers.screen_width - 100F, positionY = Constants.numbers.screen_height - 100F,
                listener = listeners.showShopScreen())
    }
    private fun rewardIcon(): ActorModel {
        return ActorModel(ActorTypes.BUTTON_TYPE, Constants.paths.shop_icon,
                boundX = 75F, boundY = 75F, positionX = 25F, positionY = Constants.numbers.screen_height - 100F,
                listener = listeners.rewardIconClickListener())
    }
    private fun dialogBackground(): ActorModel {
        return ActorModel(ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.rewarded_dialog_background,
                boundX = Constants.numbers.screen_width - 100F, boundY = 450F, buttonText = Constants.texts.ad_explanation_text,
                positionX = 50F, textScale = 0.4F, textAlign = Align.top)
    }
    private fun dialogYesButton(): ActorModel {
        return ActorModel(ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.invisible_background,
                positionX = Constants.numbers.screen_width - 150F, positionY = 50F,
                buttonText = Constants.texts.ad_yes_text, textScale = 0.5F, textAlign = Align.right, textColor = Color.GREEN,
                listener = listeners.showAd())
    }
    private fun dialogNoButton(): ActorModel {
        return ActorModel(ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.invisible_background,
                positionX = Constants.numbers.screen_width - 325F, positionY = 50F,
                buttonText = Constants.texts.ad_no_text, textScale = 0.5F, textAlign = Align.right, textColor = Color.RED,
                listener = listeners.cancelDialog())
    }
    //Texts
    private fun amountText(): TextModel {
        return TextModel(TextModel.TextTypes.AMOUNT_TEXT, SharedPrefs.getInstance().prefs.getString(Constants.prefs.amount, "0"), 100F, 1200F)
    }
    //Textures
    private fun background(): TextureModel {
        return TextureModel(Constants.paths.main_background, 0F, 0F, Constants.numbers.screen_width, Constants.numbers.screen_height)
    }
}