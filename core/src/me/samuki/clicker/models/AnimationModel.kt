package me.samuki.clicker.models

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.base.BaseModel


class AnimationModel(
        private val animation:  Animation<TextureRegion>,
        val positionX: Float = 0F,
        val positionY: Float = 0F,
        val scale: Int = 0
) : BaseModel() {
    override var type: ModelTypes = ModelTypes.ANIMATION_MODEL
    lateinit var textureRegion: TextureRegion

    fun getCurrentFrame(stateTime: Float):TextureRegion {
        textureRegion = animation.getKeyFrame(stateTime, true)
        return textureRegion
    }

    fun getWidthAfterScale(): Float {
        return (textureRegion.regionWidth * scale).toFloat()
    }

    fun getHeightAfterScale(): Float {
        return (textureRegion.regionHeight * scale).toFloat()
    }
}