package me.samuki.clicker.main

import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.sun.corba.se.impl.orbutil.closure.Constant
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.CreatorHelper
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.models.ActorModel.Companion.ActorTypes
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
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
        return actorsList
    }

    fun createTextModels(): MutableList<TextModel> {
        val textsList: MutableList<TextModel> = ArrayList()
        textsList.add(amountText())
        return textsList
    }

    //Animations
    private fun pierdolecAnimation(): AnimationModel {
        val animation:  Animation<TextureRegion> = spriteCutting(Constants.paths.pierdolce,
                Constants.numbers.pierdolce_cols, Constants.numbers.pierdolce_rows, 1F)
        return AnimationModel(animation, 0F, 0F, 12)
    }
    //Actors
    private fun mainClickActor(): ActorModel {
        return ActorModel(ActorTypes.BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture,
                boundX = Constants.numbers.screen_width, boundY = Constants.numbers.screen_height,
                listener = listeners.clickIncomeListener())
    }
    //Texts
    private fun amountText(): TextModel {
        return TextModel(TextModel.TextTypes.AMOUNT_TEXT, "0", 100F, 1200F)
    }
}