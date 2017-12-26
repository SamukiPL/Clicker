package me.samuki.clicker.models

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.base.BaseModel
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.enums.ModelTypes


class TextureModel(
        val path: String = Constants.paths.no_image_found,
        val positionX: Float = 0F,
        val positionY: Float = 0F,
        val widht: Float = 0F,
        val height: Float = 0F
) : BaseModel() {
    override var type: ModelTypes = ModelTypes.TEXTURE_MODEL

    val texture: Texture = Texture(path)

    fun drawFromModel(batch: SpriteBatch) {
        batch.draw(texture, positionX, positionY, widht, height)
    }
}