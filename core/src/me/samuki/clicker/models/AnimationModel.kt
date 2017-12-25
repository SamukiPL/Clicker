package me.samuki.clicker.models

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.base.BaseModel
import me.samuki.clicker.base.Constants


class AnimationModel(
        private val animation:  Animation<TextureRegion>,
        var positionX: Float = 0F,
        var positionY: Float = 0F,
        private val scale: Int = 0
) : BaseModel() {
    override var type: ModelTypes = ModelTypes.ANIMATION_MODEL
    lateinit var textureRegion: TextureRegion

    init {
        textureRegion = animation.getKeyFrame(0F, true)
    }

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

    fun centerPositionX() {
        positionX = (Constants.numbers.screen_width / 2) - ((textureRegion.regionWidth * scale) / 2)
    }

    fun centerPositionY() {
        positionY = (Constants.numbers.screen_height / 2) - ((textureRegion.regionHeight * scale) / 2)
    }
}