package me.samuki.clicker.models

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.base.BaseModel
import me.samuki.clicker.base.Constants


class TextModel(
        val textType: TextTypes = TextTypes.DEFAULT_TEXT,
        var text: String = "",
        var positionX: Float = 0F,
        var positionY: Float = 0F,
        var scale: Float = 1F,
        var color: Color = Color(0F, 0F, 0F, 1F)
) : BaseModel() {
    enum class TextTypes {
        AMOUNT_TEXT,
        DEFAULT_TEXT
    }

    override var type: ModelTypes = ModelTypes.TEXT_MODEL

    fun getPositionXWithOffset(bitmapFont: BitmapFont): Float {
        when (textType) {
            TextTypes.DEFAULT_TEXT -> return positionX
            TextTypes.AMOUNT_TEXT -> {
                var glyphLayout: GlyphLayout = GlyphLayout()
                glyphLayout.setText(bitmapFont, text)
                return (Constants.numbers.screen_width / 2) - (glyphLayout.width / 2)
            }
        }
    }

}