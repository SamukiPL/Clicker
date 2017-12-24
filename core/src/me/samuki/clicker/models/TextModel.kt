package me.samuki.clicker.models

import com.badlogic.gdx.graphics.Color
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.base.interfaces.BaseModel


class TextModel(
        override var type: ModelTypes,
        var text: String = "",
        var positionX: Float = 0F,
        var positionY: Float = 0F,
        var scale: Float = 0F,
        var color: Color = Color(0F, 0F, 0F, 1F)
) : BaseModel()