package me.samuki.clicker.main

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.CreatorHelper
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.main.interfaces.MainListeners
import me.samuki.clicker.models.ActorModel.Companion.ActorTypes
import me.samuki.clicker.models.ActorModel
import me.samuki.clicker.models.AnimationModel
import me.samuki.clicker.models.TextModel


class MainCreatorHelper(val listeners: MainListeners) : CreatorHelper() {

    fun createAnimations(): List<AnimationModel> {
        val animationsList: List<AnimationModel> = ArrayList()
        return animationsList
    }

    fun createActorsModels(): List<Actor?> {
        val actorsList: MutableList<Actor?> = ArrayList()
        actorsList.add(mainClickActor().getActorFromModel())
        return actorsList
    }

    fun createTextModels(): List<TextModel> {
        val textsList: List<TextModel> = ArrayList()
        return textsList
    }

    //Animations
    //Actors
    private fun mainClickActor(): ActorModel {
        return ActorModel(ModelTypes.ACTOR_MODEL, ActorTypes.BUTTON_TYPE, "badlogic.jpg", "badlogic.jpg", "badlogic.jpg",
                boundX = Constants.numbers.screen_width, boundY = Constants.numbers.screen_height,
                listener = listeners.clickIncomeListener())
    }
    //Texts
}