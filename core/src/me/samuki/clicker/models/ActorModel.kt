package me.samuki.clicker.models

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.base.BaseModel


class ActorModel(
        val actorType: ActorTypes = ActorTypes.ACTOR_TYPE,
        var texturePathUp: String = Constants.paths.no_image_found,
        var texturePathDown: String = Constants.paths.no_image_found,
        var texturePathChecked: String = "",
        var buttonText: String = "",
        var boundX: Float = 0F,
        var boundY: Float = 0F,
        var positionX: Float = 0F,
        var positionY: Float = 0F,
        var listener: EventListener? = null
) : BaseModel() {
    companion object {
        enum class ActorTypes {
            ACTOR_TYPE,
            BUTTON_TYPE,
            IMAGE_BUTTON_TYPE,
            TEXT_BUTTON_TYPE
        }
    }
    override var type: ModelTypes = ModelTypes.ACTOR_MODEL

    var skin: Skin = Skin()

    init {
        skin.add(Constants.strings.actor_up, Texture(texturePathUp))
        skin.add(Constants.strings.actor_down, Texture(texturePathDown))
        if (!texturePathChecked.isEmpty())
            skin.add(Constants.strings.actor_checked, Texture(texturePathChecked))
        else
            skin.add(Constants.strings.actor_checked, Texture(texturePathUp))
    }

    fun getActorFromModel(): Actor? {
        var actor: Actor? = null
        when (this.actorType) {
            ActorTypes.BUTTON_TYPE -> {
                actor = Button(skin.getDrawable(Constants.strings.actor_up),
                        skin.getDrawable(Constants.strings.actor_down),
                        skin.getDrawable(Constants.strings.actor_checked))
            }
            ActorTypes.IMAGE_BUTTON_TYPE -> {}
            ActorTypes.TEXT_BUTTON_TYPE -> {}
            else -> {
                actor = Actor()
            }
        }
        actor?.setBounds(0F, 0F, boundX, boundY)
        actor?.setPosition(positionX, positionY)
        if (listener != null)
            actor?.addListener(listener)
        return actor
    }
}