package me.samuki.clicker.shop

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Align
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.CreatorHelper
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.models.*
import me.samuki.clicker.shop.interfaces.ShopListeners


class ShopCreatorHelper(val listeners: ShopListeners) : CreatorHelper() {

    fun createAnimations(): MutableList<AnimationModel> {
        val animationsList: MutableList<AnimationModel> = ArrayList()
        return animationsList
    }

    fun createActorsModels(): MutableList<ActorModel> {
        val actorsList: MutableList<ActorModel> = ArrayList()
        actorsList.add(closeShopIcon())
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

    fun createShopList(): ScrollPane {
        val table = Table()
        var x = 0
        while (x < Constants.money_makers.size) {
            val group = MoneyMakerModel(x, listeners).getMoneyMakerGroup()
            table.add(group).size(Constants.numbers.screen_width, 1300F)
            table.row()
            x++
        }

        val scrollPane = ScrollPane(table)
        scrollPane.style.background = Image(Texture(Constants.paths.shop_list_background)).drawable
        scrollPane.setScrollingDisabled(true, false)
        scrollPane.width = Constants.numbers.screen_width
        scrollPane.height = Constants.numbers.screen_height - 200F
        scrollPane.setFadeScrollBars(false)
        scrollPane.setPosition(0F, 0F)
        return scrollPane
    }

    //Animations

    //Actors
    private fun closeShopIcon(): ActorModel {
        return ActorModel(ActorModel.Companion.ActorTypes.BUTTON_TYPE, Constants.paths.close_shop_icon,
                boundX = 75F, boundY = 75F, positionX = Constants.numbers.screen_width - 100F, positionY = 1250F,
                listener = listeners.goBackToMainScreen())
    }
    //Texts
    private fun amountText(): TextModel {
        return TextModel(TextModel.TextTypes.AMOUNT_TEXT, SharedPrefs.getInstance().prefs.getString(Constants.prefs.amount, "0"), 100F, 1327F)
    }
    //Textures
    fun background(): TextureModel {
        return TextureModel(Constants.paths.shop_background, 0F, 0F, Constants.numbers.screen_width, Constants.numbers.screen_height)
    }
}